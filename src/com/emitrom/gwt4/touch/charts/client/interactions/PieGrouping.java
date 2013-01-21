/**************************************************************************
   PieGrouping.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client.interactions;

import com.emitrom.gwt4.touch.charts.client.handlers.SelectionChangeHandler;
import com.emitrom.gwt4.touch.client.core.Function;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class PieGrouping extends AbstractInteraction {

    public PieGrouping() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.PIE_GROUPING);
    }

    PieGrouping(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native void onSelectionChange(Function callback)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		jso.onSelectionChange($entry(function() {
			callback.@com.emitrom.gwt4.touch.client.core.Function::execute()();
		}));
    }-*/;

    public native void setOutSet(double value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		jso.outSet = value;
    }-*/;

    public native void setSnapWhileDragging(boolean value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		jso.snapWhileDragging = value;
    }-*/;

    public native void addSelectionChangeHandler(SelectionChangeHandler handler)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		jso
				.addChartListener(
						"selectionchange",
						$entry(function(pie, items) {
							pieGrouping = @com.emitrom.gwt4.touch.charts.client.interactions.PieGrouping::new(Lcom/google/gwt/core/client/JavaScriptObject;)(pie);
							var chartItems = @com.emitrom.gwt4.touch.charts.client.interactions.ChartItem::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(items);
							handler.@com.emitrom.gwt4.touch.charts.client.handlers.SelectionChangeHandler::onSelectionChange(Lcom/emitrom/gwt4/touch/charts/client/interactions/PieGrouping;Ljava/util/List;)(pie, chartItems);
						}));
    }-*/;

}
