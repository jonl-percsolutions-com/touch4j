/**************************************************************************
 * TabItem.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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

import java.util.Iterator;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.Ext;
import com.emitrom.touch4j.client.core.Icons;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.emitrom.touch4j.client.layout.AbstractLayout;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * A basic implemetation for a TabItem to be used with {@link TabPanel}
 */
public class TabItem extends Composite implements HasWidgets {

    private Widget widget;
    private final JavaScriptObject jsObj;
    private String id;
    private TabPanel parent;
    private int index;

    protected TabItem(JavaScriptObject jso) {
        jsObj = jso;
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public TabItem() {
        jsObj = JavaScriptObject.createObject();
        id = Ext.generateId("ext-container-");
        JsoHelper.setAttribute(jsObj, Attribute.ID.getValue(), id);
        initWidget(new Container());
        setLayout(new FitLayout());
    }

    public TabItem(String title) {
        this();
        setTitle(title);
    }

    public void setTitle(String title) {
        JsoHelper.setAttribute(jsObj, Attribute.TITLE.getValue(), title);
    }

    public void setIconCls(Icons iconCls) {
        JsoHelper.setAttribute(jsObj, Attribute.ICON_CLS.getValue(), iconCls.getValue());
    }

    public void setIconCls(String iconCls) {
        JsoHelper.setAttribute(jsObj, Attribute.ICON_CLS.getValue(), iconCls);
    }

    public void setHtml(String html) {
        JsoHelper.setAttribute(jsObj, Attribute.HTML.getValue(), html);
    }

    public void setCls(String cls) {
        JsoHelper.setAttribute(jsObj, Attribute.CLS.getValue(), cls);
    }

    public void setStyle(String cls) {
        JsoHelper.setAttribute(jsObj, Attribute.STYLE.getValue(), cls);
    }

    public String getTitle() {
        return JsoHelper.getAttribute(jsObj, Attribute.TITLE.getValue());
    }

    public String getIconCls() {
        return JsoHelper.getAttribute(jsObj, Attribute.ICON_CLS.getValue());
    }

    public String getHtml() {
        return JsoHelper.getAttribute(jsObj, Attribute.HTML.getValue());
    }

    public void setLayout(AbstractLayout layout) {
        JsoHelper.setAttribute(jsObj, Attribute.LAYOUT.getValue(), layout.getJSO());
    }

    public void setBadgeText(String badgeText) {
        if (this.parent == null) {
            JsoHelper.setAttribute(jsObj, Attribute.BADGE_TEXT.getValue(), badgeText);
        } else {
            this.parent.updateBadget(this.index, badgeText);
        }
    }

    public void add(Component component) {
        if (getWidget() != null) {
            throw new IllegalStateException("TabItem can only contain one child widget");
        }
        JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
        _setItems(componentJS);
        widget = component;
    }

    /**
     * @return the widget
     */
    public Widget getWidget() {
        return widget;
    }

    /**
     * @param widget
     *            the widget to set
     */
    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    private void _setItems(JavaScriptObject component) {
        JsoHelper.setAttribute(jsObj, Attribute.ITEMS.getValue(), component);
    }

    @Override
    public void add(Widget w) {
        if (!(w instanceof Component)) {
            throw new IllegalStateException(
                            "TabItem can only contain a child of typecom.emitrom.gwt4.touch.client.core.Component ");
        }
        add((Component) w);
    }

    @Override
    public void clear() {
    }

    @Override
    public Iterator<Widget> iterator() {
        return null;
    }

    @Override
    public boolean remove(Widget w) {
        return false;
    }

    public void setParent(TabPanel parent) {
        if (this.parent != null) {
            throw new IllegalStateException(
                            "TabItem can only be added to one parent. Have you already added this TabItem to a container ?");
        }
        this.parent = parent;
        this.index = parent.getNextChildIndex();
    }

    /**
     * Returns the position at which this TabItem was added to his parent
     * 
     * @return
     */
    public int getIndex() {
        return this.index;
    }

}
