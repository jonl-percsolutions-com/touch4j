package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Ellipse Sprite.Ellipse requires x, y, radiusX and radiusY attributes.
 */
public class Ellipse extends Sprite {

    public Ellipse() {
        jsObj = JsoHelper.createObject();
        setType("ellipse");
    }

    public Ellipse(JavaScriptObject object) {
        super(object);
    }

}
