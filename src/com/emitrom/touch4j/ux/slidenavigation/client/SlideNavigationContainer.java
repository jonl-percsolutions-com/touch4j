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
package com.emitrom.touch4j.ux.slidenavigation.client;

import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.core.handlers.ContainerCallbackRegistration;
import com.emitrom.touch4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;

public class SlideNavigationContainer extends Container {

    protected SlideNavigationContainer(JavaScriptObject config) {
        super(config);
    }

    public static SlideNavigationContainer create(SlideNavigationConfig config) {
        return new SlideNavigationContainer(_init(config));
    }

    protected static native JavaScriptObject _init(SlideNavigationConfig navConfig)/*-{
		var peer = navConfig.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.define(
				"com.emitrom.touch4j.ux.client.SlideNavigationComponent", {
					extend : 'Ext.ux.slidenavigation.View',
					config : peer
				});
		return $wnd.Ext
				.create("com.emitrom.touch4j.ux.client.SlideNavigationComponent");
    }-*/;

    @Override
    protected native void init()/*-{
		//var c = new $wnd.Ext.ux.slidenavigation.View();
		//this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.CONTAINER.getValue();

    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		$wnd.Ext.define("com.emitrom.touch4j.ux.client.SlideNavigationBase", {
			extend : 'Ext.ux.slidenavigation.View',
			config : {
				items : []
			}
		});
		return $wnd.Ext
				.create('com.emitrom.touch4j.ux.client.SlideNavigationBase');
    }-*/;

    public native SlideNavigationItem getCurrentItem()/*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.getActiveItem();
		return @com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Fires after the container is fully closed.
     */
    public ContainerCallbackRegistration addClosedHandler(SlideNavigationHandler handler) {
        return _addListener("closed", handler);
    }

    /**
     * Fires whenever the user has started sliding the container. This is fired
     * once the animation is complete.
     */
    public ContainerCallbackRegistration addSlideStartHandler(SlideNavigationHandler handler) {
        return _addListener("slidestart", handler);
    }

    /**
     * Fires whenever the user has ended sliding the container. This is fired
     * once the animation is complete.
     */
    public ContainerCallbackRegistration addSlideEndHandler(SlideNavigationHandler handler) {
        return _addListener("slideend", handler);
    }

    /**
     * Fires after the container is fully opened.
     */
    public ContainerCallbackRegistration addOpendHandler(SlideNavigationHandler handler) {
        return _addListener("opened", handler);
    }

    /**
     * Fires whenever an item in the menu is selected
     */
    public native ContainerCallbackRegistration addSelectHandler(SlideNavigationSelectHandler handler) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, i, index) {
			var comp = @com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var ct = @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(i);
			handler.@com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationSelectHandler::onEvent(Lcom/emitrom/touch4j/ux/slidenavigation/client/SlideNavigationContainer;Lcom/emitrom/touch4j/client/ui/Container;I)(comp,ct,index);
		};
		component.addListener("select", fn);
		var listener = fn;
		var toReturn = @com.emitrom.touch4j.client.core.handlers.ContainerCallbackRegistration::new(Lcom/emitrom/touch4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,event,listener);
		return toReturn;
    }-*/;

    /**
     * 
     * Fires whenever the container is opened
     */
    public ContainerCallbackRegistration addOpenHandler(SlideNavigationStateHandler handler) {
        return _addStateChangeListener("open", handler);
    }

    /**
     * 
     * Fires whenever the container is closed
     */
    public ContainerCallbackRegistration addCloseHandler(SlideNavigationStateHandler handler) {
        return _addStateChangeListener("close", handler);
    }

    private native ContainerCallbackRegistration _addListener(String event, SlideNavigationHandler handler) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v) {
			var comp = @com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			handler.@com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationHandler::onEvent(Lcom/emitrom/touch4j/ux/slidenavigation/client/SlideNavigationContainer;)(comp);
		};
		component.addListener(event, fn);
		var listener = fn;

		var toReturn = @com.emitrom.touch4j.client.core.handlers.ContainerCallbackRegistration::new(Lcom/emitrom/touch4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,event,listener);
		return toReturn;
    }-*/;

    private native ContainerCallbackRegistration _addStateChangeListener(String event,
                    SlideNavigationStateHandler handler) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, x, y) {
			var comp = @com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			handler.@com.emitrom.touch4j.ux.slidenavigation.client.SlideNavigationStateHandler::onEvent(Lcom/emitrom/touch4j/ux/slidenavigation/client/SlideNavigationContainer;DD)(comp,x,y);
		};
		component.addListener(event, fn);
		var listener = fn;
		var toReturn = @com.emitrom.touch4j.client.core.handlers.ContainerCallbackRegistration::new(Lcom/emitrom/touch4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,event,listener);
		return toReturn;
    }-*/;
}
