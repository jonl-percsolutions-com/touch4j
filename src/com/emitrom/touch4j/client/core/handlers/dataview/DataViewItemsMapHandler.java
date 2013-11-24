/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.emitrom.touch4j.client.core.handlers.dataview;

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.DataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public abstract class DataViewItemsMapHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(DataViewItemsMapHandler listener) /*-{
		return function(source, index, element, eventObject, eOpts) {
			var dataView = @com.emitrom.touch4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.dataview.DataViewItemsMapHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/DataView;DLcom/google/gwt/dom/client/Element;Lcom/emitrom/touch4j/client/core/EventObject;Ljava/lang/Object;)(dataView, index, element, eventObject, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(DataView dataView, double index, Element element, EventObject eventObject,
                    Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(dataView, index, element, eventObject, eOpts, handler);
        } else {
            onItemsMap(dataView, index, element, eventObject, eOpts);
        }
    }

    private void fireOnEventAndCatch(DataView dataView, double index, Element element, EventObject eventObject,
                    Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onItemsMap(dataView, index, element, eventObject, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onItemsMap(DataView dataView, double index, Element element, EventObject eventObject,
                    Object eOpts);

}
