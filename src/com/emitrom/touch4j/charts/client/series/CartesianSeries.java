/************************************************************************
  CartesianSeries.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.charts.client.series;

import com.emitrom.touch4j.charts.client.handlers.ValueHandler;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.laf.Alignment;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

/**
 * base class for all the stacked cartesian series including area series and bar
 * series.
 * 
 */
public abstract class CartesianSeries extends BaseSeries {

    public void setAxis(Alignment align) {
        this.setAxis(align.getValue());
    }

    public void setAxis(Alignment... alignements) {
        JsArrayString strings = JsArrayString.createArray().cast();
        for (Alignment alignement : alignements) {
            strings.push(alignement.getValue());
        }
        this.setAxis(strings);
    }

    private native void setAxis(String value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.axis = value;
    }-*/;

    private native void setAxis(JsArrayString value)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.axis = value;
    }-*/;

    public native void eachYValue(ValueHandler callback)/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series
				.eachYValue(
						function(model) {
							var modelObject = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
							callback.@com.emitrom.touch4j.charts.client.handlers.ValueHandler::execute(Lcom/emitrom/touch4j/client/data/BaseModel;)(modelObject);
						}, this);
    }-*/;

    public native JsArrayNumber getMinMaxXValues()/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return series.getMinMaxXValues();
    }-*/;

    public native JsArrayNumber getMinMaxYValues()/*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return series.getMinMaxYValues();
    }-*/;

    public void setXField(String value) {
        JsoHelper.setAttribute(jsObj, "xField", value);
    }

    public void setYField(String value) {
        JsoHelper.setAttribute(jsObj, "yField", value);
    }

    public void setXField(String... values) {
        JsArrayString strings = JsArray.createArray().cast();
        for (String s : values) {
            strings.push(s);
        }
        setXField(strings);
    }

    public void setXField(JsArrayString value) {
        JsoHelper.setAttribute(jsObj, "xField", value);
    }

    public void setYField(JsArrayString value) {
        JsoHelper.setAttribute(jsObj, "yField", value);
    }

    public void setYField(String... values) {
        JsArrayString strings = JsArray.createArray().cast();
        for (String s : values) {
            strings.push(s);
        }
        setYField(strings);
    }

}
