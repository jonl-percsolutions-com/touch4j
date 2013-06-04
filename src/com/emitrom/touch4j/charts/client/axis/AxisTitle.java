package com.emitrom.touch4j.charts.client.axis;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.BaseConfig;

public class AxisTitle extends BaseConfig {

    public AxisTitle() {
        jsObj = JsoHelper.createObject();
    }

    public AxisTitle(String text, int fontSize) {
        this();
        setText(text);
        setFontSize(fontSize);
    }

    public AxisTitle(String text, int fontSize, String fontFamily) {
        this(text, fontSize);
        this.setFontFamily(fontFamily);
    }

    public void setText(String value) {
        JsoHelper.setAttribute(jsObj, "text", value);
    }

    public void setFontSize(int value) {
        JsoHelper.setAttribute(jsObj, "fontSize", value);
    }

    public void setFontFamily(String value) {
        JsoHelper.setAttribute(jsObj, "fontFamily", value);
    }

}
