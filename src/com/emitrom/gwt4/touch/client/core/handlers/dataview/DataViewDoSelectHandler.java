/**************************************************************************
 * DataViewDoSelectHandler.java is part of Touch4j 3.0. Copyright 2012 Emitrom
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
package com.emitrom.gwt4.touch.client.core.handlers.dataview;

import com.emitrom.gwt4.touch.client.core.handlers.AbstractHandler;
import com.emitrom.gwt4.touch.client.data.BaseModel;
import com.emitrom.gwt4.touch.client.ui.DataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class DataViewDoSelectHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(DataViewDoSelectHandler listener) /*-{
		return function(source, record, supressed, eOpts) {
			var dataView = @com.emitrom.gwt4.touch.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var model = @com.emitrom.gwt4.touch.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			listener.@com.emitrom.gwt4.touch.client.core.handlers.dataview.DataViewDoSelectHandler::fireOnEvent(Lcom/emitrom/gwt4/touch/client/ui/DataView;Lcom/emitrom/gwt4/touch/client/data/BaseModel;Ljava/lang/Boolean;Ljava/lang/Object;)(dataView,model, supressed, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(DataView dataView, BaseModel record, Boolean supressed, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(dataView, record, supressed, eOpts, handler);
        } else {
            onDoSelect(dataView, record, supressed, eOpts);
        }
    }

    private void fireOnEventAndCatch(DataView dataView, BaseModel record, Boolean supressed, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onDoSelect(dataView, record, supressed, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onDoSelect(DataView dataView, BaseModel record, Boolean supressed, Object eOpts);

}
