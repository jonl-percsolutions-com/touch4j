/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.emitrom.touch4j.client.core;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents the size of an element.
 * 
 * @see ExtElement#getSize()
 */
public class Size {

    private int height;
    private int width;

    public Size() {
    }

    /**
     * Create a new instance.
     * 
     * @param width element width
     * @param height element height
     */
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected Size(JavaScriptObject jsObj) {
        this(JsoHelper.getAttributeAsInt(jsObj, Attribute.WIDTH.getValue()), JsoHelper.getAttributeAsInt(jsObj, Attribute.HEIGHT.getValue()));
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }
}
