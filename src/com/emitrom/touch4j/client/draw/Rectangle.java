package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Rectangle Sprite
 */
public class Rectangle extends Sprite {

    public Rectangle() {
        jsObj = JsoHelper.createObject();
        setType("rect");
    }

    public Rectangle(JavaScriptObject object) {
        super(object);
    }

}
