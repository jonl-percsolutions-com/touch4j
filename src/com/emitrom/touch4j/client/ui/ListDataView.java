/**************************************************************************
 * ListDataView.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 **************************************************************************/
package com.emitrom.touch4j.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.DOMHelper;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.Ext;
import com.emitrom.touch4j.client.core.ExtElement;
import com.emitrom.touch4j.client.core.Function;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.core.handlers.ElementEventHandler;
import com.emitrom.touch4j.client.core.handlers.dataview.DataViewItemTapHandler;
import com.emitrom.touch4j.client.core.handlers.dataview.DataViewItemTouchStartHandler;
import com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler;
import com.emitrom.touch4j.client.core.template.Template;
import com.emitrom.touch4j.client.data.BaseModel;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.dataview.ListItemComponentRenderer;
import com.emitrom.touch4j.client.dataview.SimpleListItem;
import com.emitrom.touch4j.client.events.ListDataViewContainerAddEvent;
import com.emitrom.touch4j.client.events.handlers.ListDataViewContainerAddedHandler;
import com.emitrom.touch4j.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

/**
 * ListDataView is a custom styled DataView which allows Grouping, Indexing,
 * Icons, and a Disclosure.
 */
public class ListDataView extends DataView implements ListElement, ListDataViewContainerAddedHandler {

    private String containerCls = "touch-list-comp-container";
    private final static EventBus eventBus = new SimpleEventBus();
    List<Container> containerList;
    List<List<Component>> componentList;
    private boolean componentContainersCreated = false;
    private ListItemComponentRenderer itemComponentRender;

    protected ListDataView(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.dataview.List();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.dataview.List(config);
    }-*/;

    @Override
    public String getXType() {
        return XType.LIST.getValue();
    }

    /**
     * Create a new ListDataView.
     */
    public ListDataView() {
        eventBus.addHandler(ListDataViewContainerAddEvent.TYPE, this);
        this.addListener("painted", new Function() {
            @Override
            public void execute() {
                if (componentContainersCreated == false) {
                    SimpleListItem item;
                    containerList = new ArrayList<Container>();
                    int size = store.getCount();

                    for (int i = 0; i < size; i++) {
                        item = ListDataView.this.getItemAt(i);
                        DOMHelper.append(item.getEl(), "<div class='touch-list-comp-container'></div>");
                        final Container container = new Container();
                        container.setRenderTo(item.getEl().down("." + containerCls));
                        container.setLayout(Layout.HBOX);
                        container.addListener("painted", new Function() {
                            @Override
                            public void execute() {
                                container.getEl().on("tap", new ElementEventHandler() {
                                    @Override
                                    public void onEvent(EventObject event) {
                                        event.stopEvent();
                                    }
                                });
                            }

                        });

                        container.setRight(15);
                        container.setTop(5);
                        container.show();
                        containerList.add(container);

                    }
                    componentContainersCreated = true;
                    eventBus.fireEvent(new ListDataViewContainerAddEvent());
                }
            }
        });
        this.addItemTapHandler(new DataViewItemTapHandler() {
            @Override
            public void onItemTap(DataView dataView, int index, Element element, BaseModel record,
                            EventObject eventObject, Object eOpts) {
                ExtElement item = Ext.get(eventObject.getTarget());
                if (!item.hasClass("x-innerhtml")) {
                    eventObject.stopEvent();
                    Window.alert("stoped");
                }

            }
        });
        this.addItemTouchStartHandler(new DataViewItemTouchStartHandler() {
            @Override
            public void onItemTouchStart(DataView dataView, int index, SimpleListItem element, BaseModel record,
                            EventObject eventObject) {
                ExtElement item = Ext.get(eventObject.getTarget());
                if (!item.hasClass("x-innerhtml")) {
                    eventObject.stopEvent();
                }

            }
        });
    }

    public ListDataView(Store store) {
        this();
        setStore(store);
    }

    public ListDataView(String itemTemplate, Store store) {
        this();
        setStore(store);
        setItemTpl(itemTemplate);
    }

    public ListDataView(String itemTemplate) {
        setItemTpl(itemTemplate);
    }

    public ListDataView(Template itemTemplate, Store store) {
        setStore(store);
        setItemTpl(itemTemplate);
    }

    public ListDataView(Template itemTemplate) {
        setItemTpl(itemTemplate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#isGrouped()
     */
    @Override
    public native boolean isGrouped()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getGrouped();
    }-*/;

    /**
     * Returns the value of pinHeaders
     * 
     * @return
     */
    public native boolean getPinHeaders()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getPinHeaders();
    }-*/;

    /**
     * Returns the value of preventSelectionOnDisclose
     * 
     * @return
     */
    public native boolean getPreventSelectionOnDisclose()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getPreventSelectionOnDisclose();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#setGrouped(boolean)
     */
    @Override
    public native void setGrouped(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setGrouped(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#hasIndexBar()
     */
    @Override
    public native boolean hasIndexBar()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getIndexBar();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#setIndexBar(boolean)
     */
    @Override
    public native void setIndexBar(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setIndexBar(value);
    }-*/;

    public native void setInLine(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setInline(value);
    }-*/;

    public native void setInLine(boolean value, boolean wrapped)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setInline({
			wrap : wrapped
		});
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.dataview.ListElement#setPinHeaders(boolean)
     */
    @Override
    public native void setPinHeaders(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setPinHeaders(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#
     * setPreventSelectionOnDisclose(boolean)
     */
    @Override
    public native void setPreventSelectionOnDisclose(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setPreventSelectionOnDisclose(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.ui.ListElement#setOnItemDisclosure
     * (com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler)
     */
    @Override
    public native void setOnItemDisclosure(ItemDisclosureHandler handler)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list
				.setOnItemDisclosure(function(record, node, index) {
					var model = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
					handler.@com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler::onItemDisclosure(Lcom/emitrom/touch4j/client/data/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;I)(model,node,index);
				});
    }-*/;

    public static enum ListStyle {

        NORMAL("normal"), ROUND("round");

        private String value;

        private ListStyle(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

    }

    /**
     * 
     * The style of this list. Available options are normal and round.
     * 
     * Defaults to: "normal".
     */
    public void setListStyle(ListStyle listStyle) {
        _setListStyle(listStyle.getValue());
    }

    private native void _setListStyle(String listStyle) /*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setUi(listStyle);
    }-*/;

    public void addItemComponent(int itemIndex, Component component) {
        List<Component> list;
        int size = this.getStore().getCount();
        if (componentList == null) {
            componentList = new ArrayList<List<Component>>(this.getStore().getCount());
            for (int i = 0; i < size; i++) {
                componentList.add(new ArrayList<Component>());
            }
        }
        list = componentList.get(itemIndex);
        component.setListItemIndex(itemIndex);
        list.add(component);
    }

    @Override
    public void onContainerAdded(ListDataViewContainerAddEvent event) {
        if (this.itemComponentRender != null) {
            for (int i = 0; i < containerList.size(); i++) {
                Container c = containerList.get(i);
                List<Component> components = itemComponentRender.getComponents();
                if (components != null) {
                    for (Component component : components) {
                        component.setListItemIndex(i);
                        component.setMargin(2);
                        c.add(component);
                    }

                }
            }
        }

    }

    public void setItemComponentRenderer(ListItemComponentRenderer itemCompomentRenderer) {
        this.itemComponentRender = itemCompomentRenderer;
    }
}
