/**************************************************************************
 * WidthChangeHandler.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core.handlers.component;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class WidthChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(WidthChangeHandler listener) /*-{
		return function(component, existingValue, newValue, eOpts) {
			var comp = @com.emitrom.touch4j.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
			listener.@com.emitrom.touch4j.client.core.handlers.component.WidthChangeHandler::onWidthChange(Lcom/emitrom/touch4j/client/core/Component;DDD)(comp, existingValue, newValue, eOpts);
		};
    }-*/;

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    // Called from JSNI
    private final void fireOnEvent(Component component, double existingValue, double newValue, double eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(component, existingValue, newValue, eOpts, handler);
        } else {
            onWidthChange(component, existingValue, newValue, eOpts);
        }
    }

    private void fireOnEventAndCatch(Component component, double existingValue, double newValue, double eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onWidthChange(component, existingValue, newValue, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    public abstract void onWidthChange(Component component, double existingValue, double newValue, double eOpts);

}
