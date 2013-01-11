/**************************************************************************
   ChartItem.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import java.util.ArrayList;
import java.util.List;

import com.emitrom.platform.util.client.core.BaseModel;
import com.emitrom.platform.util.client.core.JsObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;

public class ChartItem extends JsObject {

    ChartItem(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native BaseModel getStoreItem()/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		var item = jso.storeItem;
		var toReturn = @com.emitrom.platform.util.client.core.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
		return toReturn;
    }-*/;

    public native JsArrayMixed getValue()/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		return jso.value;
    }-*/;

    static List<ChartItem> fromJsArray(JsArray<JavaScriptObject> array) {
        List<ChartItem> items = new ArrayList<ChartItem>();
        for (int i = 0; i < array.length(); i++) {
            items.add(new ChartItem(array.get(i)));
        }
        return items;
    }
}
