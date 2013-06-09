/************************************************************************
  SlideNavigation.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
**************************************************************************/
package com.emitrom.touch4j.ux.slidenavigation.client;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.IsComponent;

/**
 * This is a component that provides a sliding main view with an underlying
 * navigation list. The concept was inspired by Facebook's mobile app.
 * 
 * 
 */
public class SlideNavigation implements IsComponent {

    private SlideNavigationContainer uiObject;
    private SlideNavigationConfig config;
    private boolean setItemsWasCalled;
    private List<SlideNavigationItem> items;
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    /**
     * Creates a SlideNavigation Note that the widget is not yet created. You
     * muss add some SlideNavigationItems first.
     */
    public SlideNavigation() {
        config = new SlideNavigationConfig();
        setSlideButtonDefaultComponent("toolbar");
        setSlideSelector("x-toolbar");
        items = new ArrayList<SlideNavigationItem>();
    }

    public SlideNavigation(SlideNavigationItem... items) {
        this();
        setItems(items);
    }

    /**
     * Change this to 'right' to dock the navigation list to the right.
     */
    public void setListPosition(String value) {
        config.setListPosition(value);
    }

    /**
     * 
     * Whether or not to automatically close the container when an uiObject in
     * the list is selected. Default is true.
     * <p>
     * Defaults to: true
     */
    public void setCloseOnSelect(boolean value) {
        config.setCloseOnSelect(value);
    }

    public void setItemMask(boolean value) {
        config.setItemMask(value);
    }

    /**
     * Define the default slide button config. Any uiObject that has a
     * `slideButton` value that is either `true` or a button config will use
     * these values at the default.
     */
    public void setSlideButtonDefaultComponent(String value) {
        config.setSlideButtonDefaultComponent(value);
    }

    /**
     * An array of items to put into the navigation list. The items can either
     * be Ext components or special objects with a "handler" key, which should
     * be a function to execute when selected. Additionally, you can define the
     * order of the items by defining an 'order' parameter.
     * <p>
     * Defaults to: []
     * 
     * @param items
     */
    public void setItems(SlideNavigationItem... items) {
        config.setItems(items);
    }

    /**
     * Configuration for the navigation list
     * <p>
     * Defaults to: {width: 250, maxDrag: null, itemTpl: '{title}', grouped:
     * true, items: [{xtype: 'toolbar', docked: 'top', ui: 'light'}]}
     * 
     * @param list
     */
    public void setList(SlideNavigationList list) {
        config.setList(list);
    }

    /**
     * Number of miliseconds to animate the sliding of the container when list
     * uiObject is selected (if closeOnSelect = true). The default value here of
     * 300 gives a much nicer feel. By default the animation is disable on
     * Android.
     * 
     * @param value
     */
    public void setSelectSlideDuration(int value) {
        config.setSlideDuration(value);
    }

    /**
     * CSS to use for styling the shadow when the container is open. This should
     * be a valid CSS 'box-shadow' argument. Set to false to disable it.
     * <p>
     * Defaults to: '0 0 4px 1px #999'
     * 
     * @param value
     */
    public void setShadowStyle(String value) {
        config.setShadowStyle(value);
    }

    /**
     * Number of miliseconds to animate the sliding of the container when
     * "flicked". By default the animation is disable on Android.
     * 
     * @param value
     */
    public void setSlideDuration(int value) {
        config.setSlideDuration(value);
    }

    /**
     * Class selector of object (or parent) of which dragging should be allowed.
     * Defaults to the entire container. For example, this could be set to
     * something like 'x-toolbar' to restrict dragging only to a toolbar.
     * <p>
     * Defaults to: ''
     * 
     * @param value
     */
    public void setSlideSelector(String value) {
        config.setSlideSelector(value);
    }

    public void setFullScreen(boolean value) {
        config.setFullScreen(value);
    }

    public SlideNavigationContainer getMenu() {
        return (SlideNavigationContainer) this.asComponent();
    }

    public void addItem(SlideNavigationItem item) {
        this.items.add(item);
    }

    @Override
    public Component asComponent() {
        if (!setItemsWasCalled) {
            int size = this.items.size();
            SlideNavigationItem[] elements = new SlideNavigationItem[size];
            for (int i = 0; i < size; i++) {
                elements[i] = this.items.get(i);
            }
            this.setItems(elements);
            this.uiObject = SlideNavigationContainer.create(config);
            this.setItemsWasCalled = true;
        }
        return this.uiObject;
    }

}
