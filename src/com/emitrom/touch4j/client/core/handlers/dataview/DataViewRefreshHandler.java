/**************************************************************************
 * DataViewRefreshHandler.java is part of Touch4j 3.0. Copyright 2012 Emitrom
 * LLC
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

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.DataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class DataViewRefreshHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(DataViewRefreshHandler listener) /*-{
		return function(source, eOpts) {
			var dataView = @com.emitrom.touch4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.dataview.DataViewRefreshHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/DataView;Ljava/lang/Object;)(dataView, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(DataView dataView, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(dataView, eOpts, handler);
        } else {
            onRefresh(dataView, eOpts);
        }
    }

    private void fireOnEventAndCatch(DataView dataView, Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onRefresh(dataView, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onRefresh(DataView dataView, Object eOpts);

}
