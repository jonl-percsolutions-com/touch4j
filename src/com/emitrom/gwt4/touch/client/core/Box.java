/**************************************************************************
   Box.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 **************************************************************************/
package com.emitrom.gwt4.touch.client.core;

import com.emitrom.gwt4.touch.client.core.config.Attribute;
import com.emitrom.gwt4.touch.client.core.JsObject;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents an Element's Box.
 * 
 * @see com.emitrom.gwt4.touch.client.core.ExtElement#setBox(Box)
 * @see com.emitrom.gwt4.touch.client.core.ExtElement#setBox(Box, boolean,
 *      boolean)
 * @see com.emitrom.gwt4.touch.client.core.ExtElement#setBox(Box, boolean,
 *      AnimationConfig)
 */
public class Box extends JsObject {

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructor
     * 
     * @param x
     *            x-position
     * @param y
     *            y-position
     * @param width
     *            the box width
     * @param height
     *            the box height
     */
    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, Attribute.X.getValue(), x);
        JsoHelper.setAttribute(jsObj, Attribute.Y.getValue(), y);
        JsoHelper.setAttribute(jsObj, Attribute.WIDTH.getValue(), width);
        JsoHelper.setAttribute(jsObj, Attribute.HEIGHT.getValue(), height);
    }

    protected Box(JavaScriptObject jsObj) {
        this(JsoHelper.getAttributeAsInt(jsObj, Attribute.X.getValue()), JsoHelper.getAttributeAsInt(jsObj,
                        Attribute.Y.getValue()), JsoHelper.getAttributeAsInt(jsObj, Attribute.WIDTH.getValue()),
                        JsoHelper.getAttributeAsInt(jsObj, Attribute.HEIGHT.getValue()));
    }

    /**
     * Get the x position value.
     * 
     * @return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y position value.
     * 
     * @return the y position
     */
    public int getY() {
        return y;
    }

    /**
     * Get the box width.
     * 
     * @return the box width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the box height.
     * 
     * @return the box height
     */
    public int getHeight() {
        return height;
    }
}
