/**************************************************************************
   LeftChangeHandler.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.client.core.handlers.component;

import com.emitrom.gwt4.touch.client.core.Component;
import com.emitrom.gwt4.touch.client.core.handlers.AbstractHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class LeftChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(LeftChangeHandler listener) /*-{
		return function(component, existingValue, newValue, eOpts) {
			var comp = @com.emitrom.gwt4.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
			listener.@com.emitrom.gwt4.touch.client.core.handlers.component.LeftChangeHandler::onLeftChange(Lcom/emitrom/gwt4/touch/client/core/Component;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)(comp, existingValue, newValue, eOpts);
		};
    }-*/;

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    // Called from JSNI
    private final void fireOnEvent(Component component, Object existingValue, Object newValue, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(component, existingValue, newValue, eOpts, handler);
        } else {
            onLeftChange(component, existingValue, newValue, eOpts);
        }
    }

    private void fireOnEventAndCatch(Component component, Object existingValue, Object newValue, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onLeftChange(component, existingValue, newValue, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    public abstract void onLeftChange(Component component, Object existingValue, Object newValue, Object eOpts);

}
