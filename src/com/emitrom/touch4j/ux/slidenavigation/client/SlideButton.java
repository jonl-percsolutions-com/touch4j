/**************************************************************************
 * SlideButton.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 **************************************************************************/
package com.emitrom.touch4j.ux.slidenavigation.client;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.laf.UI;

/**
 * Represents a slide button on a slide menu
 * 
 * 
 */
public class SlideButton extends JsObject {

    public SlideButton() {
        jsObj = JsoHelper.createObject();
    }

    public SlideButton(String text) {
        this();
        setText(text);
    }

    public SlideButton(String text, UI ui) {
        this(text);
        setUi(ui);
    }

    public void setText(String value) {
        JsoHelper.setAttribute(jsObj, "text", value);
    }

    public void setSelector(String value) {
        JsoHelper.setAttribute(jsObj, "selector", value);
    }

    public void setUi(UI ui) {
        _setUi(ui.getValue());
    }

    private void _setUi(String value) {
        JsoHelper.setAttribute(jsObj, "ui", value);
    }

    public void setIconCls(String value) {
        JsoHelper.setAttribute(jsObj, "iconCls", value);
    }

    public void setIconsMask(boolean value) {
        JsoHelper.setAttribute(jsObj, "iconMask", value);
    }

}
