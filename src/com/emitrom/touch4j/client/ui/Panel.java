/************************************************************************
  Panel.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.ui;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.Floatable;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.layout.AbstractLayout;
import com.emitrom.touch4j.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * Panel is a container that has specific functionality and structural
 * components that make it the perfect building block for application-oriented
 * user interfaces.
 * <p>
 * Panels are, by virtue of their inheritance from
 * com.emitrom.touch4j.client.core.Container, capable of being configured with a
 * layout, and containing child Components.
 * <p>
 * When either specifying child items of a Panel, or dynamically adding
 * Components to a Panel, remember to consider how you wish the Panel to arrange
 * those child elements, and whether those child elements need to be sized using
 * one of Gwt4Touch's built-in **layout** schemes.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Panel>Ext.Panel</a>
 */
public class Panel extends Container implements Floatable {

    @Override
    public String getXType() {
        return XType.PANEL.getValue();
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Panel();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    protected static Panel instance(JavaScriptObject jsObj) {
        return new Panel(jsObj);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Panel(config);
    }-*/;

    /**
     * Create a new Panel.
     */
    public Panel() {

    }

    public Panel(boolean fullScreen) {
        setFullScreen(fullScreen);
    }

    public Panel(AbstractLayout layout) {
        setLayout(layout);
    }

    public Panel(Layout layout) {
        setLayout(layout);
    }

    protected Panel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Panel to an existing element.
     * 
     * @param element
     *            the element
     */
    public Panel(Element element) {
        super(element);
    }

    public static Panel cast(Component c) {
        return new Panel(c.getOrCreateJsObj());
    }

}
