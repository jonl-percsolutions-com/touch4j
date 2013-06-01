/**************************************************************************
 * DataViewItemTouchStartHandler.java is part of Touch4j 4.0. Copyright 2012
 * Emitrom LLC
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
package com.emitrom.touch4j.client.core.handlers.dataview;

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.data.BaseModel;
import com.emitrom.touch4j.client.dataview.SimpleListItem;
import com.emitrom.touch4j.client.ui.DataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class DataViewItemTouchStartHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(DataViewItemTouchStartHandler listener) /*-{
		return function(source, index, element, record, eventObject) {
			var dataView = @com.emitrom.touch4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var event = @com.emitrom.touch4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(eventObject);
			var item = @com.emitrom.touch4j.client.dataview.SimpleListItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(element);
			var rec = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			listener.@com.emitrom.touch4j.client.core.handlers.dataview.DataViewItemTouchStartHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/DataView;ILcom/emitrom/touch4j/client/dataview/SimpleListItem;Lcom/emitrom/touch4j/client/data/BaseModel;Lcom/emitrom/touch4j/client/core/EventObject;)(dataView,index,item,rec,event);
		}
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(DataView dataView, int index, SimpleListItem element, BaseModel record,
                    EventObject eventObject) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(dataView, index, element, record, eventObject, handler);
        } else {
            onItemTouchStart(dataView, index, element, record, eventObject);
        }
    }

    private void fireOnEventAndCatch(DataView dataView, int index, SimpleListItem element, BaseModel record,
                    EventObject eventObject, UncaughtExceptionHandler handler) {
        try {
            onItemTouchStart(dataView, index, element, record, eventObject);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onItemTouchStart(DataView dataView, int index, SimpleListItem element, BaseModel record,
                    EventObject eventObject);

}
