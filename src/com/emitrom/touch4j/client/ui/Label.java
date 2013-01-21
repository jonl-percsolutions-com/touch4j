/**************************************************************************
   Label.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
import com.emitrom.touch4j.client.core.HasHtml;
import com.emitrom.touch4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple label component which allows you to insert content using html
 * configuration.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Label>Ext.Label</a>
 */
public class Label extends Component  implements HasHtml {

    private Label(JavaScriptObject config) {
        super(config);
    }

    protected native void init()/*-{
		var c = new $wnd.Ext.Label();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    public String getXType() {
        return XType.LABEL.getValue();
    }

    /**
     * Create a new Label.
     */
    public Label() {
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Label(config);
    }-*/;

    /**
     * The label of this component
     */
    public native void setHtml(String value) /*-{
        var label = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
        label.setHtml(value);
    }-*/;

}
