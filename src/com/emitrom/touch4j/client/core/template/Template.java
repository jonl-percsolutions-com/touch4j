/************************************************************************
  Template.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core.template;

import com.emitrom.touch4j.client.core.ExtElement;
import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.NameValuePair;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents an HTML fragment template. Templates can be precompiled for
 * greater performance.
 * <p/>
 */
public class Template extends JsObject {

    protected String html;

    /**
     * Create a new Template.
     * 
     * @param html the HTML fragment
     */
    public Template(String html) {
        jsObj = create(html.replaceAll("'", "\""));
        this.html = html;
    }

    protected Template(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Template.
     * 
     * @param htmlfrags the HTML fragments
     */

    public Template(String... htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        html = htmlfrag.replaceAll("'", "\"");
        jsObj = create(html);
    }

    public String getHtml() {
        return html;
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement append(String target, JsObject value) {
        return append(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement append(ExtElement target, JsObject value) {
        return append(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement append(String target, NameValuePair[] values) {
        return append(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement append(ExtElement target, NameValuePair[] values) {
        return append(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement insertAfter(String target, JsObject value) {
        return insertAfter(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement insertAfter(ExtElement target, JsObject value) {
        return insertAfter(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement insertAfter(String target, NameValuePair[] values) {
        return insertAfter(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement insertAfter(ExtElement target, NameValuePair[] values) {
        return insertAfter(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement insertBefore(String target, JsObject value) {
        return insertBefore(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement insertBefore(ExtElement target, JsObject value) {
        return insertBefore(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement insertBefore(String target, NameValuePair[] values) {
        return insertBefore(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement insertBefore(ExtElement target, NameValuePair[] values) {
        return insertBefore(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement insertFirst(String target, JsObject value) {
        return insertFirst(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement insertFirst(ExtElement target, JsObject value) {
        return insertFirst(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement insertFirst(String target, NameValuePair[] values) {
        return insertFirst(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement insertFirst(ExtElement target, NameValuePair[] values) {
        return insertFirst(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement overwrite(String target, JsObject value) {
        return overwrite(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param value, the value to append
     * @return
     */
    public ExtElement overwrite(ExtElement target, JsObject value) {
        return overwrite(target, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement overwrite(String target, NameValuePair[] values) {
        return overwrite(target, NameValuePair.getJsObj(values));
    }

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     * 
     * @param target, the node to append the value to
     * @param values, the value to append
     * @return
     */
    public ExtElement overwrite(ExtElement target, NameValuePair[] values) {
        return overwrite(target, NameValuePair.getJsObj(values));
    }

    /**
     * Returns an HTML fragment of this template with the specified values
     * applied. Use this method when the params are numeric (i.e. {0})
     * 
     * @param values the param values
     * @return the html fragment
     */
    public String applyTemplate(String[] values) {
        return applyTemplate(JsoHelper.convertToJavaScriptArray(values));
    }

    /**
     * Returns an HTML fragment of this template with the specified values
     * applied. Use this method when the params are named (i.e. {foo})
     * 
     * @param values the param values
     * @return the html fragment
     */
    public String applyTemplate(NameValuePair[] values) {
        return applyTemplate(NameValuePair.getJsObj(values));
    }

    /**
     * Compiles the template into an internal function, eliminating the RegEx
     * overhead.
     */
    public native void compile() /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		template.compile();
    }-*/;

    /**
     * Sets the HTML used as the template.
     */
    public native Template set(String html) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		template.set(html);
		return this;
    }-*/;

    /**
     * Sets the HTML used as the template and compiles it
     */
    public native Template set(String html, boolean compile) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		template.set(html, compile);
		return this;
    }-*/;

    /**
     * true in this class to identify an object as an instantiated Template, or
     * subclass thereof.
     */
    public native boolean isTemplate() /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return template.isTemplate;
    }-*/;

    protected native String applyTemplate(JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return template.applyTemplate(values);
    }-*/;

    protected native ExtElement append(String target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.append(target, values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement append(ExtElement target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.append(target
				.@com.emitrom.touch4j.client.core.JsObject::getJsObj(),
				values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement insertAfter(String target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.insertAfter(target, values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement insertAfter(ExtElement target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.insertAfter(target
				.@com.emitrom.touch4j.client.core.JsObject::getJsObj(),
				values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement insertBefore(String target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.insertBefore(target, values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement insertBefore(ExtElement target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.insertBefore(target
				.@com.emitrom.touch4j.client.core.JsObject::getJsObj(),
				values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement insertFirst(String target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.insertFirst(target, values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement insertFirst(ExtElement target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.insertFirst(target
				.@com.emitrom.touch4j.client.core.JsObject::getJsObj(),
				values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement overwrite(String target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.overwrite(target, values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected native ExtElement overwrite(ExtElement target, JavaScriptObject values) /*-{
		var template = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = template.overwrite(target
				.@com.emitrom.touch4j.client.core.JsObject::getJsObj(),
				values);
		var toReturn = @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    private static Template instance(JavaScriptObject jsObj) {
        return new Template(jsObj);
    }

    private native JavaScriptObject create(String html) /*-{
		return new $wnd.Ext.Template(html);
    }-*/;

    private native JavaScriptObject create(String html, JavaScriptObject config) /*-{
		return new $wnd.Ext.Template(html, config);
    }-*/;
}
