/**************************************************************************
 * Spacer.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Spacer component is generally used to put space between items in
 * com.emitrom.touch4j.client.containers.Toolbar components.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Spacer>Ext.Spacer</a>
 */
public class Spacer extends Component {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Spacer();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;
    
    protected Spacer(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Spacer(config);
    }-*/;

    @Override
    public String getXType() {
        return XType.SPACER.getValue();
    }

    /**
     * Create a new Sheet.
     */
    public Spacer() {
    }
    
    /**
     * Returns the value of flex. Defaults to 1
     * 
     * @return
     */
    public native int getFlex() /*-{
        var spacer = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
        return spacer.getFlex();
    }-*/;
    
    /**
     * Returns the value of width
     */
    public native int getWidth() /*-{
        var spacer = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
        return spacer.getWidth();
    }-*/;
    
    /**
     * Sets the value of flex. Defaults to 1.
     */
    public native void setFlex(int flex) /*-{
        var spacer = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
        spacer.setFlex(flex);
    }-*/;

    /**
     * Sets the value of width
     */
    public native void setWidth(int width) /*-{
        var spacer = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
        spacer.setWidth(width);
    }-*/;

}
