/**************************************************************************
 * NestedListBeforeSelectHandler.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.ListDataView;
import com.emitrom.touch4j.client.ui.NestedListDataView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public abstract class NestedListBeforeSelectHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(NestedListBeforeSelectHandler listener) /*-{
		return function(source, list, node, selections, eOpts) {
			var nestedList = @com.emitrom.touch4j.client.ui.NestedListDataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.nestedlist.NestedListBeforeSelectHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/NestedListDataView;Lcom/emitrom/touch4j/client/ui/ListDataView;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/Object;)(nestedList,list, node, selections, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(NestedListDataView nestedList, ListDataView list, Element node,
                    JavaScriptObject selections, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(nestedList, list, node, selections, eOpts, handler);
        } else {
            onBeforeSelect(nestedList, list, node, selections, eOpts);
        }
    }

    private void fireOnEventAndCatch(NestedListDataView nestedList, ListDataView list, Element node,
                    JavaScriptObject selections, Object eOpts, UncaughtExceptionHandler handler) {
        try {
            onBeforeSelect(nestedList, list, node, selections, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onBeforeSelect(NestedListDataView nestedList, ListDataView list, Element node,
                    JavaScriptObject selections, Object eOpts);

}
