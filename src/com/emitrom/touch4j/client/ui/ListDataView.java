/**************************************************************************
 * ListDataView.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
import com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler;
import com.emitrom.touch4j.client.core.template.Template;
import com.emitrom.touch4j.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * ListDataView is a custom styled DataView which allows Grouping, Indexing,
 * Icons, and a Disclosure.
 */
public class ListDataView extends DataView implements ListElement {

    protected ListDataView(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.dataview.List();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.dataview.List(config);
    }-*/;

    @Override
    public String getXType() {
        return XType.LIST.getValue();
    }

    /**
     * Create a new ListDataView.
     */
    public ListDataView() {
    }

    public ListDataView(Store store) {
        setStore(store);
    }

    public ListDataView(String itemTemplate, Store store) {
        setStore(store);
        setItemTpl(itemTemplate);
    }

    public ListDataView(String itemTemplate) {
        setItemTpl(itemTemplate);
    }

    public ListDataView(Template itemTemplate, Store store) {
        setStore(store);
        setItemTpl(itemTemplate);
    }

    public ListDataView(Template itemTemplate) {
        setItemTpl(itemTemplate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#isGrouped()
     */
    @Override
    public native boolean isGrouped()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getGrouped();
    }-*/;

    /**
     * Returns the value of pinHeaders
     * 
     * @return
     */
    public native boolean getPinHeaders()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getPinHeaders();
    }-*/;

    /**
     * Returns the value of preventSelectionOnDisclose
     * 
     * @return
     */
    public native boolean getPreventSelectionOnDisclose()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getPreventSelectionOnDisclose();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#setGrouped(boolean)
     */
    @Override
    public native void setGrouped(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setGrouped(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#hasIndexBar()
     */
    @Override
    public native boolean hasIndexBar()/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return list.getIndexBar();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#setIndexBar(boolean)
     */
    @Override
    public native void setIndexBar(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setIndexBar(value);
    }-*/;

    public native void setInLine(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setInline(value);
    }-*/;

    public native void setInLine(boolean value, boolean wrapped)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setInline({
			wrap : wrapped
		});
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.dataview.ListElement#setPinHeaders(boolean)
     */
    @Override
    public native void setPinHeaders(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setPinHeaders(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.dataview.ListElement#
     * setPreventSelectionOnDisclose(boolean)
     */
    @Override
    public native void setPreventSelectionOnDisclose(boolean value)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setPreventSelectionOnDisclose(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.ui.ListElement#setOnItemDisclosure
     * (com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler)
     */
    @Override
    public native void setOnItemDisclosure(ItemDisclosureHandler handler)/*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list
				.setOnItemDisclosure(function(record, node, index) {
					var model = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
					handler.@com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler::onItemDisclosure(Lcom/emitrom/touch4j/client/data/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;I)(model,node,index);
				});
    }-*/;

    public static enum ListStyle {

        NORMAL("normal"), ROUND("round");

        private String value;

        private ListStyle(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

    }

    /**
     * 
     * The style of this list. Available options are normal and round.
     * 
     * Defaults to: "normal".
     */
    public void setListStyle(ListStyle listStyle) {
        _setListStyle(listStyle.getValue());
    }

    private native void _setListStyle(String listStyle) /*-{
		var list = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		list.setUi(listStyle);
    }-*/;

}
