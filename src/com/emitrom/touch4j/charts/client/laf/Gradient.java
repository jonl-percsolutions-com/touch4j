/**************************************************************************
 * Gradient.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.charts.client.laf;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.laf.Color;
import com.emitrom.touch4j.client.laf.RGB;
import com.google.gwt.core.client.JavaScriptObject;

public class Gradient extends Color {

    public Gradient() {
        jsObj = JsoHelper.createObject();
    }

    public Gradient(String id, int angle) {
        this();
        setId(id);
        setAngle(angle);
    }

    @Override
    public void setId(String id) {
        JsoHelper.setAttribute(jsObj, "id", id);
    }

    @Override
    public String getId() {
        return JsoHelper.getAttribute(jsObj, "id");
    }

    public void setAngle(int value) {
        JsoHelper.setAttribute(jsObj, "angle", value);
    }

    public void setStops(RGB rgbColorFrom, RGB rgbColorTo) {
        _setStops(rgbColorFrom.getRawValue(), rgbColorTo.getRawValue());
    }

    private void _setStops(String rgbColorFrom, String rgbColorTo) {
        JsoHelper.setAttribute(jsObj, "stops", createStops(rgbColorFrom, rgbColorTo));
    }

    public void setFont(String value) {
        JsoHelper.setAttribute(jsObj, "font", value);
    }

    private native JavaScriptObject createStops(String rgbColorFrom, String rgbColorTo)/*-{
		return {
			0 : {
				color : rgbColorFrom
			},
			100 : {
				color : rgbColorTo
			}
		}
    }-*/;

}
