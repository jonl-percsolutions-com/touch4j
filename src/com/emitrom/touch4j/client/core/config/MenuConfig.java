package com.emitrom.touch4j.client.core.config;

import com.emitrom.touch4j.client.core.JsoHelper;

/**
 * Config option to control the display of a menu
 */
public class MenuConfig extends BaseConfig {

    public MenuConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setCover(boolean value) {
        JsoHelper.setAttribute(jsObj, "cover", value);
    }

    public void setReveal(boolean value) {
        JsoHelper.setAttribute(jsObj, "reveal", value);
    }

    public void setSide(MenuSide side) {
        JsoHelper.setAttribute(jsObj, "side", side.getValue());
    }
}
