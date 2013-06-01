/**
 * This plugin adds pull to refresh functionality to the List.
 *
 * ## Example
 *
 *     @example
 *     var store = Ext.create('Ext.data.Store', {
 *         fields: ['name', 'img', 'text'],
 *         data: [
 *             {
 *                 name: 'rdougan',
 *                 img: 'http://a0.twimg.com/profile_images/1261180556/171265_10150129602722922_727937921_7778997_8387690_o_reasonably_small.jpg',
 *                 text: 'JavaScript development'
 *             }
 *         ]
 *     });
 *
 *     Ext.create('Ext.dataview.List', {
 *         fullscreen: true,
 *
 *         store: store,
 *
 *         plugins: [
 *             {
 *                 xclass: 'Ext.plugin.PullRefresh',
 *                 pullRefreshText: 'Pull down for more new Tweets!'
 *             }
 *         ],
 *
 *         itemTpl: [
 *             '<img src="{img}" alt="{name} photo" />',
 *             '<div class="tweet"><b>{name}:</b> {text}</div>'
 *         ]
 *     });
 */
Ext.define('Ext.plugin.PullRefresh', {
    extend: 'Ext.Component',
    alias: 'plugin.pullrefresh',
   
    config: {
        /**
         * @cfg {Ext.dataview.List} list
         * The list to which this PullRefresh plugin is connected.
         * This will usually by set automatically when configuring the list with this plugin.
         * @accessor
         */
        list: null,

        /**
         * @cfg {String} pullRefreshText The text that will be shown while you are pulling down.
         * @accessor
         */
        pullRefreshText: 'Pull down to refresh...',

        /**
         * @cfg {String} releaseRefreshText The text that will be shown after you have pulled down enough to show the release message.
         * @accessor
         */
        releaseRefreshText: 'Release to refresh...',

        /**
         * @cfg {String} lastUpdatedText The text to be shown in front of the last updated time.
         * @accessor
         */
        lastUpdatedText: 'Last Updated:',

        /**
         * @cfg {String} lastUpdatedDateFormat The format to be used on the last updated date.
         */
        lastUpdatedDateFormat: 'm/d/Y h:iA',

        /**
         * @cfg {String} loadingText The text that will be shown while the list is refreshing.
         * @accessor
         */
        loadingText: 'Loading...',

        /**
         * @cfg {String} loadedText The text that will be when data has been loaded.
         * @accessor
         */
        loadedText: 'Loaded.',

        /**
         * @cfg {Boolean} autoSnapBack Determines whether the pulldown should automatically snap back after data has been loaded.
         * If false call {@link #snapBack}() to manually snap the pulldown back.
         */
        autoSnapBack: true,
        /**
         * @cfg {Number} snappingAnimationDuration The duration for snapping back animation after the data has been refreshed
         * @accessor
         */
        snappingAnimationDuration: 300,

        /**
         * @cfg {Number} overpullSnapBackDuration The duration for snapping back when pulldown has been lowered further then its height.
         */
        overpullSnapBackDuration: 300,

        /**
         * @cfg {Ext.XTemplate/String/Array} pullTpl The template being used for the pull to refresh markup.
         * @accessor
         */
        pullTpl: [
            '<div class="x-list-pullrefresh">',
                '<div class="x-list-pullrefresh-arrow"></div>',
                '<div class="x-loading-spinner">',
                    '<span class="x-loading-top"></span>',
                    '<span class="x-loading-right"></span>',
                    '<span class="x-loading-bottom"></span>',
                    '<span class="x-loading-left"></span>',
                '</div>',
                '<div class="x-list-pullrefresh-wrap">',
                    '<h3 class="x-list-pullrefresh-message"></h3>',
                    '<div class="x-list-pullrefresh-updated"></div>',
                '</div>',
            '</div>'
        ].join(''),

        translatable: true
    },

    /**
     * @event latestfetched
     * Fires when the latest data has been fetched
     */

    isRefreshing: false,
    currentViewState: '',

    initialize: function() {
        this.callParent();

        this.on({
            painted: 'onPainted',
            scope: this
        });
    },

    init: function(list) {
        var me = this;

        me.setList(list);
        me.initScrollable();
    },

    initScrollable: function() {
        var me = this,
            list = me.getList(),
            store = list.getStore(),
            pullTpl = me.getPullTpl(),
            element = me.element,
            scrollable = list.getScrollable(),
            scroller;

        if (!scrollable) {
            return;
        }

        scroller = scrollable.getScroller();
        scroller.setAutoRefresh(false);

        me.lastUpdated = new Date();

        list.insert(0, me);

        // We provide our own load mask so if the Store is autoLoading already disable the List's mask straight away,
        // otherwise if the Store loads later allow the mask to show once then remove it thereafter
        if (store) {
            if (store.isAutoLoading()) {
                list.setLoadingText(null);
            } else {
                store.on({
                    load: {
                        single: true,
                        fn: function() {
                            list.setLoadingText(null);
                        }
                    }
                });
            }
        }

        pullTpl.overwrite(element, []);

        me.loadingElement = element.getFirstChild();
        me.messageEl = element.down('.x-list-pullrefresh-message');
        me.updatedEl = element.down('.x-list-pullrefresh-updated');

        me.maxScroller = scroller.getMaxPosition();

        scroller.on({
            maxpositionchange: me.setMaxScroller,
            scroll: me.onScrollChange,
            scope: me
        });

        me.resetRefreshState();
    },

    onScrollableChange: function() {
        this.initScrollable();
    },

    updateList: function(newList, oldList) {
        var me = this;

        if (newList && newList != oldList) {
            newList.on({
                order: 'after',
                scrollablechange: me.onScrollableChange,
                scope: me
            });
        } else if (oldList) {
            oldList.un({
                order: 'after',
                scrollablechange: me.onScrollableChange,
                scope: me
            });
        }
    },

    /**
     * @private
     * Attempts to load the newest posts via the attached List's Store's Proxy
     */
    fetchLatest: function() {
        var store = this.getList().getStore(),
            proxy = store.getProxy(),
            operation;

        operation = Ext.create('Ext.data.Operation', {
            page: 1,
            start: 0,
            model: store.getModel(),
            limit: store.getPageSize(),
            action: 'read',
            sorters: store.getSorters(),
            filters: store.getRemoteFilter() ? store.getFilters() : []
        });

        proxy.read(operation, this.onLatestFetched, this);
    },

    /**
     * @private
     * Called after fetchLatest has finished grabbing data. Matches any returned records against what is already in the
     * Store. If there is an overlap, updates the existing records with the new data and inserts the new items at the
     * front of the Store. If there is no overlap, insert the new records anyway and record that there's a break in the
     * timeline between the new and the old records.
     */
    onLatestFetched: function(operation) {
        var store      = this.getList().getStore(),
            list       = this.getList(),
            scroller   = list.getScrollable().getScroller(),
            scrollerOffsetX = scroller.position.x,
            scrollerOffsetY = scroller.position.y,
            oldRecords = store.getData(),
            newRecords = operation.getRecords(),
            length     = newRecords.length,
            toInsert   = [],
            newRecord, oldRecord, i;

        for (i = 0; i < length; i++) {
            newRecord = newRecords[i];
            oldRecord = oldRecords.getByKey(newRecord.getId());

            if (oldRecord) {
                oldRecord.set(newRecord.getData());
            } else {
                toInsert.push(newRecord);
            }

            oldRecord = undefined;
        }

       // store.insert(0, toInsert);
        scroller.scrollTo(scrollerOffsetX, scrollerOffsetY);

        this.setViewState('loaded');
        this.fireEvent('latestfetched');
        if (this.getAutoSnapBack()) {
            this.snapBack();
        }
    },

    snapBack: function() {
        var me = this,
            list = me.getList(),
            scroller = list.getScrollable().getScroller();

        scroller.on({
            scrollend: function() {
                this.resetRefreshState();
            },
            single: true,
            scope: me
        });

        if (scroller.position.y < 0) {
            scroller.minPosition.y = 0;
            scroller.scrollTo(null, 0, {duration: scroller.isTouching ? 0 : me.getSnappingAnimationDuration()});
        }
    },

    onPainted: function() {
        this.pullHeight = this.loadingElement.getHeight();
    },

    setMaxScroller: function(scroller, position) {
        this.maxScroller = position;
    },

    onScrollChange: function(scroller, x, y) {
        if (y <= 0) {
            this.onBounceTop(y);
        }
        if (y > this.maxScroller.y) {
            this.onBounceBottom(y);
        }
    },

    /**
     * @private
     */
    applyPullTpl: function(config) {
        return (Ext.isObject(config) && config.isTemplate) ? config : new Ext.XTemplate(config);
    },

    onBounceTop: function(y) {
        var me = this,
            pullHeight = me.pullHeight,
            list = me.getList(),
            scroller = list.getScrollable().getScroller();

        if (!me.isReleased) {
            if (!pullHeight) {
                me.onPainted();
                pullHeight = me.pullHeight;
            }
            if (!me.isRefreshing && -y >= pullHeight + 10) {
                me.isRefreshing = true;

                me.setViewState('release');

                scroller.getContainer().onBefore({
                    dragend: 'onScrollerDragEnd',
                    single: true,
                    scope: me
                });
            }
            else if (me.isRefreshing && -y < pullHeight + 10) {
                me.isRefreshing = false;
                me.setViewState('pull');
            }
        }

        me.getTranslatable().translate(0, -y);
    },

    onScrollerDragEnd: function() {
        var me = this;

        if (me.isRefreshing) {
            var list = me.getList(),
                scroller = list.getScrollable().getScroller(),
                translateable = scroller.getTranslatable();

            translateable.setEasingY({duration:this.getOverpullSnapBackDuration()});
            scroller.minPosition.y = -me.pullHeight;
            scroller.on({
                scrollend: 'loadStore',
                single: true,
                scope: me
            });

            me.isReleased = true;
        }
    },

    loadStore: function() {
        var me = this;

        me.setViewState('loading');
        me.isReleased = false;
       me.fetchLatest();
    },

    onBounceBottom: Ext.emptyFn,

    setViewState: function(state) {
        var me = this,
            prefix = Ext.baseCSSPrefix,
            messageEl = me.messageEl,
            loadingElement = me.loadingElement;

        if (state === me.currentViewState) {
            return me;
        }
        me.currentViewState = state;

        if (messageEl && loadingElement) {
            switch (state) {
                case 'pull':
                    messageEl.setHtml(me.getPullRefreshText());
                    loadingElement.removeCls([prefix + 'list-pullrefresh-release', prefix + 'list-pullrefresh-loading']);
                break;

                case 'release':
                    messageEl.setHtml(me.getReleaseRefreshText());
                    loadingElement.addCls(prefix + 'list-pullrefresh-release');
                break;

                case 'loading':
                    messageEl.setHtml(me.getLoadingText());
                    loadingElement.addCls(prefix + 'list-pullrefresh-loading');
                break;

                case 'loaded':
                    messageEl.setHtml(me.getLoadedText());
                    loadingElement.addCls(prefix + 'list-pullrefresh-loaded');
                    break;
            }
        }

        return me;
    },

    resetRefreshState: function() {
        var me = this;

        me.isRefreshing = false;
        me.lastUpdated = new Date();

        me.setViewState('pull');
        me.updatedEl.setHtml(this.getLastUpdatedText() + '&nbsp;' + Ext.util.Format.date(me.lastUpdated, me.getLastUpdatedDateFormat()));
    }
});
