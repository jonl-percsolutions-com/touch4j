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

import com.emitrom.touch4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Url field creates an HTML5 url input and is usually created inside a
 * form. Because it creates an HTML url input field, most browsers will show a
 * specialized virtual keyboard for web address input. Aside from that, the url
 * field is just a normal text field.
 */
public class Url extends Text<String> {
    
    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Url();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.URL_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Url(config);
    }-*/;

    public Url() {
    }

    protected Url(JavaScriptObject jso) {
        super(jso);
    }

}
