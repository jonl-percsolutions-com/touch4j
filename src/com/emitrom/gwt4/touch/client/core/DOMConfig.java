/**************************************************************************
   DOMConfig.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

package com.emitrom.gwt4.touch.client.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.emitrom.gwt4.touch.client.core.config.Attribute;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The DOM object spec. Can be configured with specs of children too. If no tag
 * is specified then a div will be automatically generated with the specified
 * attributes.
 * 
 * @see DOMHelper#append(String, DOMConfig)
 * @see ExtElement#createChild(DOMConfig)
 */
public class DOMConfig {

    private String tag;
    private String id;
    private String cls;
    private String style;
    private String html;
    @SuppressWarnings("rawtypes")
    private List children;

    @SuppressWarnings("rawtypes")
    private Map otherConfig = new HashMap();

    /**
     * Create a new DomConfig using a "div" tag.
     */
    public DOMConfig() {
        this.tag = "div";
    }

    /**
     * Create a new DomConfig.
     * 
     * @param tag
     *            the tag name
     */
    public DOMConfig(String tag) {
        this.tag = tag;
    }

    /**
     * Constructor.
     * 
     * @param tag
     *            the element tag name
     * @param id
     *            the element id
     */
    public DOMConfig(String tag, String id) {
        this.tag = tag;
        this.id = id;
    }

    /**
     * Constructor.
     * 
     * @param tag
     *            the element tag name
     * @param id
     *            the element id
     * @param cls
     *            the element CSS class name
     */
    public DOMConfig(String tag, String id, String cls) {
        this.tag = tag;
        this.id = id;
        this.cls = cls;
    }

    /**
     * Constructor.
     * 
     * @param tag
     *            the element tag name
     * @param id
     *            the element id
     * @param cls
     *            the element CSS class name
     * @param html
     *            the innerHTML for the element.
     */
    public DOMConfig(String tag, String id, String cls, String html) {
        this.tag = tag;
        this.id = id;
        this.cls = cls;
        this.html = html;
    }

    /**
     * Set the CSS style.
     * 
     * @param style
     *            the CSS style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Add a child element.
     * 
     * @param child
     *            the child element config
     * @return this
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DOMConfig addChild(DOMConfig child) {
        if (html != null) {
            throw new IllegalArgumentException("Dom spec cannot have inner html and child elelents");
        }
        if (children == null)
            children = new ArrayList();
        children.add(child);
        return this;
    }

    @SuppressWarnings("unchecked")
    public void addAttribute(String name, String value) {
        otherConfig.put(name, value);
    }

    @SuppressWarnings("rawtypes")
    public JavaScriptObject getJsObject() {
        JavaScriptObject jsObj = JsoHelper.createObject();
        if (tag != null)
            JsoHelper.setAttribute(jsObj, Attribute.TAG.getValue(), tag);
        if (id != null)
            JsoHelper.setAttribute(jsObj, Attribute.ID.getValue(), id);
        if (cls != null)
            JsoHelper.setAttribute(jsObj, Attribute.CLS.getValue(), cls);
        if (style != null)
            JsoHelper.setAttribute(jsObj, Attribute.STYLE.getValue(), style);
        if (html != null)
            JsoHelper.setAttribute(jsObj, Attribute.HTML.getValue(), html);

        for (Iterator iterator = otherConfig.keySet().iterator(); iterator.hasNext();) {
            String attribute = (String) iterator.next();
            String value = (String) otherConfig.get(attribute);
            JsoHelper.setAttribute(jsObj, attribute, value);
        }

        if (children != null) {
            JavaScriptObject[] childrenJS = new JavaScriptObject[children.size()];
            int i = 0;
            for (Iterator it = children.iterator(); it.hasNext(); i++) {
                DOMConfig config = (DOMConfig) it.next();
                childrenJS[i] = config.getJsObject();
            }
            JsoHelper.setAttribute(jsObj, Attribute.CHILDREN.getValue(), childrenJS);
        }
        return jsObj;
    }
}
