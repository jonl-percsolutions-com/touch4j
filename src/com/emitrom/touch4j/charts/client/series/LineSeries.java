/************************************************************************
  LineSeries.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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

import com.emitrom.touch4j.charts.client.marker.MarkerConfig;
import com.emitrom.touch4j.client.core.JsoHelper;

public class LineSeries extends CartesianSeries {

    public LineSeries() {
        jsObj = JsoHelper.createObject();
        this.setType("line");
    }

    public LineSeries(MarkerConfig markerConfig) {
        this();
        JsoHelper.setAttribute(jsObj, "markerConfig", markerConfig.getJsObj());

    }

    public native void showMarkers(boolean value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.showMarkers = value;
    }-*/;

    public native void setFill(boolean value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.fill = value;
    }-*/;

    public native void setSelectionTolerance(double value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.selectionTolerance = value;
    }-*/;

    public native void setSmooth(double value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.smooth = value;
    }-*/;

}
