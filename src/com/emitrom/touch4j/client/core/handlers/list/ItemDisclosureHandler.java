/**************************************************************************
 * ItemDisclosureHandler.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core.handlers.list;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ItemDisclosureHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(ItemDisclosureHandler listener) /*-{
		return function(record, node, index) {
			var model = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			listener.@com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler::fireOnEvent(Lcom/emitrom/touch4j/client/data/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;I)(model, node, index);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(BaseModel record, JavaScriptObject node, int index) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(record, node, index, handler);
        } else {
            onItemDisclosure(record, node, index);
        }
    }

    private void fireOnEventAndCatch(BaseModel record, JavaScriptObject node, int index,
                    UncaughtExceptionHandler handler) {
        try {
            onItemDisclosure(record, node, index);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onItemDisclosure(BaseModel record, JavaScriptObject node, int index);
}
