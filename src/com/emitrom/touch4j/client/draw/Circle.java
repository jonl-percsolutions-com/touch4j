package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Circle Sprite. Circle requires x, y and radius attributes.
 */
public class Circle extends Sprite {

    public Circle() {
        jsObj = JsoHelper.createObject();
        setType("circle");
    }

    public Circle(JavaScriptObject object) {
        super(object);
    }

}
