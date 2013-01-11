/**************************************************************************
 * ViewPort.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.gwt4.touch.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.touch.client.core.Component;
import com.emitrom.gwt4.touch.client.core.config.Event;
import com.emitrom.gwt4.touch.client.core.handlers.component.OrientationChangeHandler;
import com.emitrom.gwt4.touch.client.fx.layout.card.Animation;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Viewport is class instance created when Touch4j is loaded. Because Viewport
 * extends from com.emitrom.gwt4.touch.client.core.Container, it has as layout
 * (which defaults to CardLayout). This means you can add items to it at any
 * time, from anywhere in your code. The Viewport fullscreen atrribute is true
 * by default, so it will take up your whole screen.
 * 
 * Adding a AcceptsOneWidget interface with an empty setWidget overriden method
 * to fake the operation and allow for a pure GWT Activty And Place
 * implementation.
 * 
 */
public class ViewPort extends Container implements AcceptsOneWidget {

    private final static ViewPort viewPort = initViewPort();
    private Component widget;
    private Animation animation;
    private List<Component> items = new ArrayList<Component>();

    private ViewPort() {

    }

    private ViewPort(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static ViewPort get() {
        return viewPort;
    }

    public native void attach() /*-{
		@com.emitrom.gwt4.touch.client.ui.ViewPort::viewPort.@com.google.gwt.user.client.ui.Widget::onAttach()();
    }-*/;

    private native static ViewPort initViewPort() /*-{
		var viewport = $wnd.Ext.Viewport;
		var container = @com.emitrom.gwt4.touch.client.ui.ViewPort::new(Lcom/google/gwt/core/client/JavaScriptObject;)(viewport);
		return container;
    }-*/;

    @Override
    public void setWidget(IsWidget w) {
        setWidget(asWidgetOrNull(w));
    }

    public void setWidget(final Widget w) {

        // Validate
        if (w == widget || w == null) {
            return;
        }

        if (w != null) {
            if (animation == null) {
                if (widget != null) {
                    widget.hide();
                }
            }

            if (items.indexOf((Component) w) < 0) {
                items.add((Component) w);
                // Physical attach.
                add(w);
            }
            ((Component) w).show();
            if (animation != null) {
                animateActiveItem(((Component) w), animation);
                animation = null;
            } else {
                setActiveItem((Container) w);
            }
            // Logical add
            widget = (Component) w;
        }

    }

    /**
     * @param animation
     *            the animation to set
     */
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    /**
     * Whether or not to always automatically maximize the viewport on first
     * load and all subsequent orientation changes.
     * 
     * This is set to false by default for a number of reasons:
     * 
     * <ul>
     * <li>Orientation change performance is drastically reduced when this is
     * enabled, on all devices.</li>
     * <li>On some devices (mostly Android) this can sometimes cause issues when
     * the default browser zoom setting is changed.</li>
     * <li>When wrapping your phone in a native shell, you may get a blank
     * screen.</li>
     * </ul>
     * 
     * @param value
     */
    public native void setAutoMaximize(boolean value)/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		viewPort.setAutoMaximize(value);
    }-*/;

    /**
     * Returns the current orientation. portrait or landscape
     * 
     * @return
     */
    public native String getOrientation()/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getOrientation();
    }-*/;

    /**
     * true if the viewport prevents panning
     * 
     * @return
     */
    public native boolean preventPanning()/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getPreventPanning();
    }-*/;

    /**
     * true if the viewport prevents zooming
     * 
     * @return
     */
    public native boolean preventZooming()/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getPreventZooming();
    }-*/;

    /**
     * Retrieves the document height.
     * 
     * @return
     */
    public native double getWindowHeight()/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getWindowHeight();
    }-*/;

    /**
     * Retrieves the document height.
     * 
     * @return
     */
    public native double getWindowWidth()/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.getWindowWidth();
    }-*/;

    /**
     * true to prevent panning on the viewport
     * 
     * @return
     */
    public native void setPreventPanning(boolean value)/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.setPreventPanning(value);
    }-*/;

    /**
     * true to prevent zooming on the viewport
     * 
     * @return
     */
    public native void setPreventZooming(boolean value)/*-{
		var viewPort = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		return viewPort.setPreventZooming(value);
    }-*/;

    /**
     * Fires when the Viewport orientation has changed
     * 
     * @param handler
     */
    public void addOrientationChangeHandler(OrientationChangeHandler handler) {
        viewPort.addWidgetListener(Event.ORIENTATION_CHANGE.getValue(), handler.getJsoPeer());
    }

}
