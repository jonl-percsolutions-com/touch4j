/**************************************************************************
 * SubmitFormHandler.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core.handlers.form;

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.FormPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class SubmitFormHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(SubmitFormHandler listener) /*-{
		return function(source, result, event, eOpts) {
			var form = @com.emitrom.touch4j.client.ui.FormPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.form.SubmitFormHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/FormPanel;Ljava/lang/Object;Lcom/emitrom/touch4j/client/core/EventObject;Ljava/lang/Object;)(form, result, event, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(FormPanel panel, Object result, EventObject event, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(panel, result, event, eOpts, handler);
        } else {
            onSubmit(panel, result, event, eOpts);
        }
    }

    private void fireOnEventAndCatch(FormPanel panel, Object result, EventObject event, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onSubmit(panel, result, event, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onSubmit(FormPanel panel, Object result, EventObject e, Object eOpts);

}
