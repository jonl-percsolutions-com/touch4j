/**************************************************************************
 * BeforeSubmitFormHandler.java is part of Touch4j 3.0. Copyright 2012 Emitrom
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
package com.emitrom.gwt4.touch.client.core.handlers.form;

import com.emitrom.gwt4.touch.client.core.handlers.AbstractHandler;
import com.emitrom.gwt4.touch.client.ui.FormPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class BeforeSubmitFormHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(BeforeSubmitFormHandler listener) /*-{
		return function(source, values, options, eOpts) {
			var form = @com.emitrom.gwt4.touch.client.ui.FormPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.gwt4.touch.client.core.handlers.form.BeforeSubmitFormHandler::fireOnEvent(Lcom/emitrom/gwt4/touch/client/ui/FormPanel;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)(form, values, options, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(FormPanel panel, Object values, Object options, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(panel, values, options, eOpts, handler);
        } else {
            onBeforeSubmit(panel, values, options, eOpts);
        }
    }

    private void fireOnEventAndCatch(FormPanel panel, Object values, Object options, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onBeforeSubmit(panel, values, options, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onBeforeSubmit(FormPanel panel, Object values, Object options, Object eOpts);

}
