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
package com.emitrom.touch4j.client.core.template;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A template class that supports advanced functionality like autofilling
 * arrays, conditional processing with basic comparison operators,
 * sub-templates, basic math function support, special built-in template
 * variables, inline code execution and more. XTemplate also provides the
 * templating mechanism built into
 * {@link com.emitrom.touch4j.client.ui.DataView}.
 * 
 */
public class XTemplate extends Template {

    /**
     * Create a new Template.
     * 
     * @param html the HTML fragment
     */
    public XTemplate(String html) {
        jsObj = create(html.replaceAll("'", "\""));
        this.html = html;
    }

    protected XTemplate(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Template.
     * 
     * @param htmlfrags the HTML fragments
     */

    public XTemplate(String... htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        html = htmlfrag.replaceAll("'", "\"");
        jsObj = create(html);
    }

    private static XTemplate instance(JavaScriptObject jsObj) {
        return new XTemplate(jsObj);
    }

    private native JavaScriptObject create(String html) /*-{
		return new $wnd.Ext.XTemplate(html);
    }-*/;

    private native JavaScriptObject create(String html, JavaScriptObject config) /*-{
		return new $wnd.Ext.XTemplate(html, config);
    }-*/;

}
