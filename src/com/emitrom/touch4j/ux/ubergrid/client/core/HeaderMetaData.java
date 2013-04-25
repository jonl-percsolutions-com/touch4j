package com.emitrom.touch4j.ux.ubergrid.client.core;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.BaseConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An object that can be used for styling of the header cell.
 * 
 * 
 */
public class HeaderMetaData extends BaseConfig {

    protected HeaderMetaData(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * 
     * A CSS style definition in addition to headerStyle. Can be a string or an
     * object, which keys will correspond to CSS propertis and values - to
     * values of properties.
     */
    public void setHeaderStyle(String value) {
        JsoHelper.setAttribute(jsObj, "headerStyle", value);
    }

    /**
     * 
     A CSS class declaration in addition to headerCls. Can be a single class
     * or several classes, separated with space.
     */
    public void setHeaderCls(String value) {
        JsoHelper.setAttribute(jsObj, "headerCls", value);
    }

    /**
     * 
     * Additional attributes for the header DOM element. Can be a string of
     * HTML-like format or an object. In the latter case keys will correspond to
     * attribute names and values - to values.
     */
    public void setHeaderAttr(BaseConfig value) {
        JsoHelper.setAttribute(jsObj, "headerAttr", value.getJsObj());
    }
}
