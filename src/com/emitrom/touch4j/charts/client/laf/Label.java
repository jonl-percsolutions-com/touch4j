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
package com.emitrom.touch4j.charts.client.laf;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.laf.Color;
import com.google.gwt.core.client.JavaScriptObject;

public class Label extends JsObject {

    public Label() {
        jsObj = JsoHelper.createObject();
    }

    public void setField(String field) {
        JsoHelper.setAttribute(jsObj, "field", field);
    }

    public void setTextAnchor(String field) {
        JsoHelper.setAttribute(jsObj, "text-anchor", field);
    }

    public void setOrientation(String field) {
        JsoHelper.setAttribute(jsObj, "orientation", field);
    }

    public void setFill(String field) {
        JsoHelper.setAttribute(jsObj, "fill", field);
    }

    public void setDisplay(String value) {
        JsoHelper.setAttribute(jsObj, "display", value);
    }

    public void setDisplay(boolean value) {
        JsoHelper.setAttribute(jsObj, "display", value);
    }

    public void setContrast(boolean value) {
        JsoHelper.setAttribute(jsObj, "contrast", value);
    }

    public void setFont(String value) {
        JsoHelper.setAttribute(jsObj, "font", value);
    }

    public void setColor(String value) {
        JsoHelper.setAttribute(jsObj, "color", value);
    }

    public void setColor(Color color) {
        setColor(color.getValue());
    }

    public void setRenderer(JavaScriptObject renderer) {
        JsoHelper.setAttribute(jsObj, "renderer", renderer);
    }
}
