/**************************************************************************
 * NestedListItemDoubleTapHandler.java is part of Touch4j 3.0. Copyright 2012
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
package com.emitrom.touch4j.client.core.handlers.nestedlist;

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.ListDataView;
import com.emitrom.touch4j.client.ui.NestedListDataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class NestedListItemDoubleTapHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(NestedListItemDoubleTapHandler listener) /*-{
		return function(source, listView, index, item, event, eOpts) {
			var nestedList = @com.emitrom.touch4j.client.ui.NestedListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var listViewObject = @com.emitrom.touch4j.client.ui.ListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(listView);
			var e = @com.emitrom.touch4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			listener.@com.emitrom.touch4j.client.core.handlers.nestedlist.NestedListItemDoubleTapHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/NestedListDataView;Lcom/emitrom/touch4j/client/ui/ListDataView;ILjava/lang/Object;Lcom/emitrom/touch4j/client/core/EventObject;Ljava/lang/Object;)(nestedList, listViewObject, index, item, e, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(NestedListDataView nestedListView, ListDataView listView, int index, Object item,
                    EventObject event, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(nestedListView, listView, index, item, event, eOpts, handler);
        } else {
            onItemDoubleTap(nestedListView, listView, index, item, event, eOpts);
        }
    }

    private void fireOnEventAndCatch(NestedListDataView nestedListView, ListDataView listView, int index, Object item,
                    EventObject event, Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onItemDoubleTap(nestedListView, listView, index, item, event, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onItemDoubleTap(NestedListDataView nestedListView, ListDataView listView, int index,
                    Object item, EventObject event, Object eOpts);

}
