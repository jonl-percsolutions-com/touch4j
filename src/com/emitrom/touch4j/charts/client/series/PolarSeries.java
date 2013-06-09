/************************************************************************
 * PolarSeries.java is part of Touch4j 4.2.2.1 Copyright 2013 Emitrom LLC
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

public abstract class PolarSeries extends AbstractSeries {

    public native void setOffsetX(double value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.offsetX = value;
    }-*/;

    public native void setOffsetY(boolean value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.offsetY = value;
    }-*/;

    public native void setRadius(double value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.radius = value;
    }-*/;

    public native void setRotation(double value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.rotation = value;
    }-*/;

    public native void setShowInLegend(boolean value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.showInLegend = value;
    }-*/;

    public native void setXField(String value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.xField = value;
    }-*/;

    public native void setYField(String value) /*-{
		var series = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		series.yField = value;
    }-*/;

}
