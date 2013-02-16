/**************************************************************************
 * GaugeSeries.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.charts.client.series;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.laf.Color;
import com.google.gwt.core.client.JsArrayString;

/**
 * Creates a Gauge AbstractChart. Gauge Charts are used to show progress in a
 * certain variable. There are two ways of using the Gauge chart. One is setting
 * a store element into the Gauge and selecting the field to be used from that
 * store. Another one is instantiating the visualization and using the setValue
 * method to adjust the value you want.
 * 
 */
public class GaugeSeries extends BaseSeries {

    public GaugeSeries() {
        jsObj = JsoHelper.createObject();
        setType("Gauge");

    }

    public native void setDonut(boolean value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.donut = value;
    }-*/;

    public native void setDonut(double value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.donut = value;
    }-*/;

    public native void setNeedle(boolean value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.needle = value;
    }-*/;

    public native void showInLegend(boolean value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.showInLegend = value;
    }-*/;

    public native void setMaximum(double value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.maximum = value;
    }-*/;

    public native void setMinimum(double value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.minimum = value;
    }-*/;

    public void setColorSet(Color... colors) {
        JsArrayString values = JsArrayString.createArray().cast();
        for (Color c : colors) {
            values.push(c.getValue());
        }
        _setColorSet(values);
    }

    private native void _setColorSet(JsArrayString colorSet)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.colorSet = colorSet;
    }-*/;

    public void setField(String value) {
        JsoHelper.setAttribute(jsObj, "field", value);
    }

    public native void setNeedleLengthRatio(double value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.needleLengthRatio = value;
    }-*/;

    public native void setValue(double value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.value = value;
    }-*/;

    public native void setWholeDisk(boolean value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.wholeDisk = value;
    }-*/;

}
