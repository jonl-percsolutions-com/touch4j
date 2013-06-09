/************************************************************************
  CenteredChangeHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core.handlers.component;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class CenteredChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(CenteredChangeHandler listener) /*-{
		return function(component, existingValue, newValue, eOpts) {
			var comp = @com.emitrom.touch4j.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
			listener.@com.emitrom.touch4j.client.core.handlers.component.CenteredChangeHandler::onCenteredChange(Lcom/emitrom/touch4j/client/core/Component;ZZLjava/lang/Object;)(component, existingValue, newValue, eOpts);
		};
    }-*/;

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onCenteredChange(Component component, boolean existingValue, boolean newValue, Object eOpts);

    // Called from JSNI
    private final void fireOnEvent(Component component, boolean existingValue, boolean newValue, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(component, existingValue, newValue, eOpts, handler);
        } else {
            onCenteredChange(component, existingValue, newValue, eOpts);
        }
    }

    private void fireOnEventAndCatch(Component component, boolean existingValue, boolean newValue, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onCenteredChange(component, existingValue, newValue, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

}
