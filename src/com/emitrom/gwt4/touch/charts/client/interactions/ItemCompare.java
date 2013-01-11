/**************************************************************************
   ItemCompare.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.gwt4.touch.charts.client.handlers.ItemCompareInteractionHandler;
import com.emitrom.gwt4.touch.client.draw.Sprite;
import com.emitrom.platform.util.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class ItemCompare extends AbstractInteraction {

    public ItemCompare() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.ITEM_COMPARE);
    }

    ItemCompare(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native void setArrow(Sprite value)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.arrow = value.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
    }-*/;

    public native void setCircle(Sprite value)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.circle = value.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		;
    }-*/;

    public native void setLine(Sprite value)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.line = value.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
    }-*/;

    public native void setOffset(OffsetValue value)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.offset = value.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
    }-*/;

    public native ChartItem getFirtsItem()/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		var obj = jso.item1;
		var toReturn = @com.emitrom.gwt4.touch.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native ChartItem getSecondItem()/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		var obj = jso.item2;
		var toReturn = @com.emitrom.gwt4.touch.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native void reset()/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.reset();
    }-*/;

    public native void addInteractionHandler(ItemCompareInteractionHandler handler)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.listeners = {
			show : function(itemcompare) {
				var itemCompareObject = @com.emitrom.gwt4.touch.charts.client.interactions.ItemCompare::new(Lcom/google/gwt/core/client/JavaScriptObject;)(itemcompare);
				handler.@com.emitrom.gwt4.touch.charts.client.handlers.ItemCompareInteractionHandler::onShow(Lcom/emitrom/gwt4/touch/charts/client/interactions/ItemCompare;)(itemCompareObject);
			},
			hide : function() {
				handler.@com.emitrom.gwt4.touch.charts.client.handlers.ItemCompareInteractionHandler::onHide()();
			}
		};
    }-*/;

}
