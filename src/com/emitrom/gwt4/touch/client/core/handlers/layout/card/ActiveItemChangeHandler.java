/**************************************************************************
 * ActiveItemChangeHandler.java is part of Touch4j 3.0. Copyright 2012 Emitrom
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
package com.emitrom.gwt4.touch.client.core.handlers.layout.card;

import com.emitrom.gwt4.touch.client.core.handlers.AbstractHandler;
import com.emitrom.gwt4.touch.client.ui.Container;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ActiveItemChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(ActiveItemChangeHandler listener) /*-{
		return function(source, value, oldValue, eOpts) {
			var container = @com.emitrom.gwt4.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var newTab = @com.emitrom.gwt4.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
			var oldTab = @com.emitrom.gwt4.touch.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(oldValue);
			listener.@com.emitrom.gwt4.touch.client.core.handlers.layout.card.ActiveItemChangeHandler::fireOnEvent(Lcom/emitrom/gwt4/touch/client/ui/Container;Lcom/emitrom/gwt4/touch/client/ui/Container;Lcom/emitrom/gwt4/touch/client/ui/Container;Ljava/lang/Object;)(container, newTab, oldTab, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Container container, Container value, Container oldValue, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(container, value, oldValue, eOpts, handler);
        } else {
            onActiveItemChange(container, value, oldValue, eOpts);
        }
    }

    private void fireOnEventAndCatch(Container container, Container value, Container oldValue, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onActiveItemChange(container, value, oldValue, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onActiveItemChange(Container container, Container newTab, Container oldTab, Object eOpts);

}
