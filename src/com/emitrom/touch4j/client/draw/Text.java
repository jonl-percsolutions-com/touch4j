package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Text Sprite Text require the text attribute.
 */
public class Text extends Sprite {

    public Text() {
        jsObj = JsoHelper.createObject();
        setType("text");
    }

    public Text(JavaScriptObject object) {
        super(object);
    }

}
