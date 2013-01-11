/**************************************************************************
   BarSeries.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client.series;

import com.emitrom.platform.util.client.core.JsoHelper;

public class BarSeries extends CartesianSeries {

    public BarSeries() {
        jsObj = JsoHelper.createObject();
        setType("bar");
    }

    public native void setGroupGutter(double value)/*-{
		var series = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		series.groupGutter = value;
    }-*/;

    public native void setGutter(double value)/*-{
		var series = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		series.gutter = value;
    }-*/;

    public native void setStyle(Object value)/*-{
		var series = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		series.style = value;
    }-*/;

    public native void setXPadding(double value)/*-{
		var series = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		series.xPadding = value;
    }-*/;

    public native void setYPadding(double value)/*-{
		var series = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		series.yPadding = value;
    }-*/;

    public native <T> T getLegendColor()/*-{
		var series = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		return series.getLegendColor();
    }-*/;

}
