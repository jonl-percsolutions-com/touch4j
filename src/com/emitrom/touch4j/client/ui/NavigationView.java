/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.emitrom.touch4j.client.ui;

import com.emitrom.touch4j.client.core.config.Event;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.core.handlers.CallbackRegistration;
import com.emitrom.touch4j.client.core.handlers.navigation.NavigationViewEventHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * NavigationView is basically a {@link Container} with a card layout, so only
 * one view can be visible at a time. However, NavigationView also adds extra
 * functionality on top of this to allow you to push and pop views at any time.
 * When you do this, your NavigationView will automatically animate between your
 * current active view, and the new view you want to push, or the previous view
 * you want to pop.
 * 
 */
public class NavigationView extends Container {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.NavigationView();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.NavigationView(config);
    }-*/;

    protected NavigationView(JavaScriptObject jso) {
        super(jso);
    }

    @Override
    public String getXType() {
        return XType.NAVIGATION_VIEW.getValue();
    }

    public NavigationView() {
    }

    /**
     * Returns the value of defaultBackButtonText.
     * 
     * @return
     */
    public native String getDefaultBackButtonText() /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			return view.getDefaultBackButtonText();
		}
    }-*/;

    /**
     * Returns the value of navigationBar.
     * 
     * @param <T>
     * @return
     */
    public native NavigationBar getNavigationBar() /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			var obj = view.getNavigationBar();
			return @com.emitrom.touch4j.client.ui.NavigationBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
    }-*/;

    /**
     * Returns the previous item, if one exists.
     * 
     * @param <T>
     * @return
     */
    public native Container getPreviousItem() /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			var obj = view.getPreviousItem();
			return @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
    }-*/;

    /**
     * Returns the value of useTitleForBackButtonText.
     * 
     * @return
     */
    public native boolean getUseTitleForBackButtonText() /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			return view.getUseTitleForBackButtonText();
		}
    }-*/;

    /**
     * Removes the current active view from the stack and animates to the
     * previous view.
     */
    public native void pop() /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.pop();
		}
    }-*/;

    /**
     * Removes the view at the given index from the stack and animates to the
     * previous view.
     */
    public native void pop(int index) /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.pop(index);
		}
    }-*/;

    /**
     * Pushes a new view into this navigation view. Convience method for
     * setActiveItem
     * 
     * @param view
     */

    public native void push(Container element) /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var component = element.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.push(component);
		}
    }-*/;

    /**
     * Resets the view by removing all items between the first and last item
     */
    public native void reset() /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.reset();
		}
    }-*/;

    /**
     * Sets the value of defaultBackButtonText.
     * 
     * @param value
     */
    public native void setDefaultBackButtonText(String value) /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.setDefaultBackButtonText(value);
		}
    }-*/;

    /**
     * Sets the value of defaultBackButtonText.
     * 
     * @param bar
     */
    public native void setNavigationBar(boolean bar) /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.setNavigationBar(bar);
		}
    }-*/;

    /**
     * Sets the value of useTitleForBackButtonText.
     * 
     * @param value
     */
    public native void setUseTitleForBackButtonText(boolean value) /*-{
		var view = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (view != null) {
			view.setUseTitleForBackButtonText(value);
		}
    }-*/;

    /**
     * Add a button to the navigation bar of this navigation view with the given
     * alignment
     * 
     * @param align
     *            , the button alignment
     * @return,the button added to the navigation view
     */
    public Button addNavButton(ButtonAlignement alignment) {
        if (alignment.equals(ButtonAlignement.RIGHT)) {
            RightButton r = new RightButton("");
            this.getNavigationBar().add(r);
            return r;
        } else if (alignment.equals(ButtonAlignement.LEFT)) {
            LeftButton l = new LeftButton("");
            this.getNavigationBar().add(l);
            return l;
        }

        return null;

    }

    /**
     * Add a button to the navigation bar of this navigation view with the given
     * alignment and text
     * 
     * @param text
     *            , the text to display on the button
     * @param align
     *            , the button alignment
     * @return,the button added to the navigation view
     */
    public Button addNavButton(String text, ButtonAlignement align) {
        Button leftButton = addNavButton(align);
        leftButton.setText(text);
        return leftButton;

    }

    /**
     * Add a button to the the navigation bar of this navigation view. The
     * button will be right align
     * 
     * @param text
     *            , the text to display on the button
     * @return,the button added to the navigation view
     */
    public Button addNavButton(String text) {
        Button leftButton = addNavButton(text, ButtonAlignement.RIGHT);
        return leftButton;

    }

    /**
     * Fires when a view is popped from this navigation view
     * 
     * @param handler
     */
    public CallbackRegistration addPopHandler(NavigationViewEventHandler handler) {
        return this.addWidgetListener(Event.POP.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires when a view is pushed into this navigation view
     * 
     * @param handler
     */
    public CallbackRegistration addPushHandler(NavigationViewEventHandler handler) {
        return this.addWidgetListener(Event.PUSH.getValue(), handler.getJsoPeer());
    }

    /**
     * Fires when the back button in the navigation view was tapped.
     * 
     * @param handler
     */
    public CallbackRegistration addBackHandler(NavigationViewEventHandler handler) {
        return this.addWidgetListener(Event.BACK.getValue(), handler.getJsoPeer());
    }

}
