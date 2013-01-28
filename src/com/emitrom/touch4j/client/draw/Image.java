package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Image Sprite.
 * <p>
 * Image requires width, height and src
 */
public class Image extends Sprite {

    public Image() {
        jsObj = JsoHelper.createObject();
        setType("image");
    }

    public Image(JavaScriptObject object) {
        super(object);
    }

}
