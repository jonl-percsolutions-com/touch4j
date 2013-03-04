/**************************************************************************
 * UbergridColumn.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.ux.ubergrid.client.core;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Represents a Column in the Gridwidget
 */
public class UbergridColumn extends JsObject {

    public UbergridColumn() {
        jsObj = JsoHelper.createObject();
    }

    public UbergridColumn(String header, String dataIndex) {
        this();
        setHeader(header);
        setDataIndex(dataIndex);
    }

    UbergridColumn(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The header of the gridcolumn
     * 
     * @param value
     */
    public void setHeader(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.GRID_HEADER.getValue(), value);
    }

    /**
     * The header of the gridcolumn
     * 
     * @param value
     */
    public String getHeader() {
        return JsoHelper.getAttribute(jsObj, Attribute.GRID_HEADER.getValue());
    }

    /**
     * A CSS class to be added to the data cell DOM elements for this column.
     * Can be a single class or several classes, separated with spaces.
     * 
     * @param value
     */
    public void setCellCls(String value) {
        JsoHelper.setAttribute(jsObj, "cellCls", value);
    }

    /**
     * A CSS class to be added to the data cell DOM elements for this column.
     * Can be a single class or several classes, separated with spaces.
     * 
     * @param value
     */
    public String getCellCls() {
        return JsoHelper.getAttribute(jsObj, "cellCls");
    }

    public void setFlex(double value) {
        JsoHelper.setAttribute(jsObj, Attribute.FLEX.getValue(), value);
    }

    /**
     * The dataIndex of the gridcolumn
     * 
     * @param value
     */
    public void setDataIndex(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.DATAINDEX.getValue(), value);
    }

    /**
     * The dataIndex of the gridcolumn
     * 
     * @param value
     */
    public String getDataIndex() {
        return JsoHelper.getAttribute(jsObj, Attribute.DATAINDEX.getValue());
    }

    /**
     * The CSS Class of the gridcolumn
     * 
     * @param value
     */
    public void setCls(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.CLS.getValue(), value);
    }

    /**
     * The CSS Class of the gridcolumn
     * 
     * @param value
     */
    public String getCls() {
        return JsoHelper.getAttribute(jsObj, Attribute.CLS.getValue());
    }

    /**
     * The css style of the gridcolumn
     * 
     * @param value
     */
    public void setStyle(String value) {
        JsoHelper.setAttribute(jsObj, "style", value);
    }

    /**
     * The css style of the gridcolumn
     * 
     * @param value
     */
    public String getStyle() {
        return JsoHelper.getAttribute(jsObj, Attribute.STYLE.getValue());
    }

    /**
     * The css height of the gridcolumn
     * 
     * @param value
     */
    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, Attribute.HEIGHT.getValue(), value);
    }

    /**
     * The css height of the gridcolumn
     * 
     * @param value
     */
    public double getHeight() {
        return JsoHelper.getAttributeAsFloat(jsObj, Attribute.HEIGHT.getValue());
    }

    /**
     * The css width of the gridcolumn
     * 
     * @param value
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, Attribute.WIDTH.getValue(), value);
    }

    /**
     * The hidden attribut of the gridcolumn
     * 
     * @param value
     */
    public void setHidden(boolean value) {
        JsoHelper.setAttribute(jsObj, Attribute.HIDDEN.getValue(), value);
    }

    /**
     * The hidden attribut of the gridcolumn
     * 
     * @param value
     */
    public boolean isHidden() {
        return JsoHelper.getAttributeAsBoolean(jsObj, Attribute.HIDDEN.getValue());
    }

    /**
     * The sortable attribut of the gridcolumn
     * 
     * @param value
     */
    public void setSortable(boolean value) {
        JsoHelper.setAttribute(jsObj, Attribute.SORTABLE.getValue(), value);
    }

    /**
     * The hidden attribut of the gridcolumn
     * 
     * @param value
     */
    public boolean isSortable() {
        return JsoHelper.getAttributeAsBoolean(jsObj, Attribute.SORTABLE.getValue());
    }

    /**
     * The css width of the gridcolumn
     * 
     * @param value
     */
    public double getWidth() {
        return JsoHelper.getAttributeAsFloat(jsObj, Attribute.WIDTH.getValue());
    }

    static JsArray<JavaScriptObject> fromList(List<UbergridColumn> columns) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (UbergridColumn column : columns) {
            values.push(column.getJsObj());
        }
        return values;
    }

    static JsArray<JavaScriptObject> fromValues(List<UbergridColumn> columns) {
        ArrayList<UbergridColumn> cols = new ArrayList<UbergridColumn>();
        for (UbergridColumn column : columns) {
            cols.add(column);
        }
        return fromList(cols);
    }

    static ArrayList<UbergridColumn> fromJsArray(JsArray<JavaScriptObject> values) {
        ArrayList<UbergridColumn> columns = new ArrayList<UbergridColumn>();
        for (int i = 0; i < values.length(); i++) {
            columns.add(new UbergridColumn(values.get(i)));
        }
        return columns;
    }

}
