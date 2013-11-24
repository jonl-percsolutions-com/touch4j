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
package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.BaseConfig;
import com.emitrom.touch4j.client.laf.Color;

public class SpriteConfig extends BaseConfig {

    public SpriteConfig() {

    }

    public void setFill(Color color) {
        _setFill(color.getValue());
    }

    private void _setFill(String value) {
        JsoHelper.setAttribute(jsObj, "fill", value);
    }

    public void setX(int value) {
        JsoHelper.setAttribute(jsObj, "x", value);
    }

    public void setStroke(Color color) {
        _setStroke(color.getValue());
    }

    private void _setStroke(String value) {
        JsoHelper.setAttribute(jsObj, "stroke", value);
    }

    public void setStrokeWidth(double value) {
        JsoHelper.setAttribute(jsObj, "stroke-width", value);
    }

    public void setOpacity(double value) {
        JsoHelper.setAttribute(jsObj, "opacity", value);
    }

}
