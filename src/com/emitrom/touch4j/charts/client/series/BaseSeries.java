/**************************************************************************
   BaseSeries.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.touch4j.charts.client.ToolTip;
import com.emitrom.touch4j.charts.client.handlers.RecordHandler;
import com.emitrom.touch4j.charts.client.handlers.TitleChangeHandler;
import com.emitrom.touch4j.charts.client.interactions.ChartItem;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class BaseSeries extends AbstractSeries {

    BaseSeries() {

    }

    BaseSeries(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native void setHighlight(boolean value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.highlight = value;
    }-*/;

    public native void setType(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.type = value;
    }-*/;

    public native void setShadowAttributes(JavaScriptObject value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.shadowAttributes = value;
    }-*/;

    public native void setShowInLegend(boolean value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.showInLegend = value;
    }-*/;

    public native void setTip(ToolTip value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.tip = value.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
    }-*/;

    public native void setTitle(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.title = value;
    }-*/;

    public native void clearCombination()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.clearCombination();
    }-*/;

    public native void combine(int index1, int index2)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.combine(index1, index2);
    }-*/;

    public native void drawSeries()/*-{
		jso.drawSeries();
    }-*/;

    public native void eachRecord(RecordHandler callback)/*-{
		var jso = jso.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso
				.eachRecord(
						function(record) {
							var model = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
							callback.@com.emitrom.touch4j.charts.client.handlers.RecordHandler::execute(Lcom/emitrom/touch4j/client/data/BaseModel;)(model);
						}, jso);
    }-*/;

    public native ChartItem getItemForPoint(double x, double y)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = jso.getItemForPoint(x, y);
		var toReturn = @com.emitrom.touch4j.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    private native <T> T getLegendColor(Object value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return jso.getLegendColor(value);
    }-*/;

    private native <T> T getLegendLabels()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return jso.getLegendLabels();
    }-*/;

    public native int getRecordCount()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return jso.getRecordCount();
    }-*/;

    public native void hideAll()/*-{
		jso.hideAll();
    }-*/;

    public native boolean isExcluded(int index)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return jso.isExcluded(index);
    }-*/;

    public native void reset()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.reset();
    }-*/;

    public native void setTitle(int index, String title)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.setTitle(index, title);
    }-*/;

    public native void shawAll()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.shawAll();
    }-*/;

    public native void addTitleChangeHandler(TitleChangeHandler handler)/*-{
		jso
				.addListener(
						'titlechange',
						$entry(function(title, index) {
							handler.@com.emitrom.touch4j.charts.client.handlers.TitleChangeHandler::onTitleChange(Ljava/lang/String;I)(title, index);
						}));
    }-*/;

    public void setTips(ToolTip tip) {
        _setTips(tip.getJsObj());
    }

    private native void _setTips(JavaScriptObject value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.tips = value;
    }-*/;

    public native void setHightlight(boolean value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.hightlight = value;
    }-*/;
}
