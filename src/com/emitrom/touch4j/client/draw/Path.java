package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Path Sprite.Path requires the path attribute.
 */
public class Path extends Sprite {

    public Path() {
        jsObj = JsoHelper.createObject();
        setType("path");
    }

    public Path(JavaScriptObject object) {
        super(object);
    }

}
