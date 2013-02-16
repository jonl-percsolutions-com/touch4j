/**************************************************************************
 * SlideNavigationItem.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.ux.slidenavigation.client;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.Function;
import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.emitrom.touch4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Implements an item in the SlideNavigationContainer
 * 
 */
public class SlideNavigationItem extends JsObject {

    SlideNavigationItem(JavaScriptObject obj) {
        jsObj = obj;
    }

    public SlideNavigationItem() {
        jsObj = JsoHelper.createObject();
    }

    public SlideNavigationItem(String title) {
        this();
        setTitle(title);
    }

    public SlideNavigationItem(String title, Container item) {
        this(title);
        setContainer(item);
    }

    public SlideNavigationItem(Container item) {
        this();
        setContainer(item);
    }

    public SlideNavigationItem(String title, String group) {
        this(title);
        setGroup(group);
    }

    public SlideNavigationItem(String title, String group, Container item) {
        this(title, group);
        setContainer(item);
    }

    public void setTitle(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.TITLE.getValue(), value);
    }

    public void setGroup(String value) {
        JsoHelper.setAttribute(jsObj, "group", value);
    }

    public void setSlideButton(boolean value) {
        JsoHelper.setAttribute(jsObj, "slideButton", value);
    }

    public void setSlideButton(SlideButton value) {
        JsoHelper.setAttribute(jsObj, "slideButton", value.getJsObj());
    }

    public void setContainer(Container... item) {
        JsoHelper.setAttribute(jsObj, "items", fromArray(item));
    }

    public void setHandler(Function fn) {
        JsoHelper.setAttribute(jsObj, "handler", getHandler(fn));
    }

    private static JavaScriptObject fromArray(Component[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < 1; i++) {
            JavaScriptObject c = components[i].getOrCreateJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

    static JavaScriptObject fromArray(SlideNavigationItem[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < components.length; i++) {
            JavaScriptObject c = components[i].getJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

    private native JavaScriptObject getHandler(Function fn)/*-{
		return function() {
			fn.@com.emitrom.touch4j.client.core.Function::execute()();
		};
    }-*/;

    public native Container getContainer()/*-{
		var item = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()()
		var c = item.raw.items[0];
		return @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
    }-*/;

    public native String getTitle()/*-{
		var item = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()()
		var c = item.raw.title;
		return @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
    }-*/;

    public native int getIndex()/*-{
		var item = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()()
		var c = item.raw.index;
		return @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
    }-*/;

    public native String getGroup()/*-{
		var item = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()()
		var c = item.raw.group;
		return @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
    }-*/;

    public native int getOrder()/*-{
		var item = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()()
		var c = item.data.order;
		return @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
    }-*/;

}
