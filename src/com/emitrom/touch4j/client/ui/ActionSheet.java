/**************************************************************************
 * ActionSheet.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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

import com.emitrom.touch4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A button {@link Sheet} class designed to popup or slide/anchor a series of
 * {@link Button}.
 * 
 * @see <a href=http://docs.sencha.com/touch/2-0/#!/api/Ext.ActionSheet>Ext.
 *      ActionSheet</a>
 */
public class ActionSheet extends Sheet {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.ActionSheet();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    /**
     * Create a new ActionSheet.
     */
    public ActionSheet() {
    }

    protected ActionSheet(JavaScriptObject jsObj) {
        super(jsObj);
    }

    @Override
    public String getXType() {
        return XType.ACTONSHEET.getValue();
    }

    /**
     * Show this component.
     */
    @Override
    public void show() {
        showRendered();
    }

    private native void showRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.show();
    }-*/;

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var component = new $wnd.Ext.ActionSheet(config);
		return component;
    }-*/;

}
