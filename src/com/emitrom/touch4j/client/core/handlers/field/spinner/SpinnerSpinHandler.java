/************************************************************************
  SpinnerSpinHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core.handlers.field.spinner;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.Spinner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class SpinnerSpinHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(SpinnerSpinHandler listener) /*-{
		return function(source, value, direction, eOpts) {
			var spinner = @com.emitrom.touch4j.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.field.spinner.SpinnerSpinHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/Spinner;DLjava/lang/String;Ljava/lang/Object;)(spinner, value, direction, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Spinner<Double> spinner, double value, String direction, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(spinner, value, direction, eOpts, handler);
        } else {
            onSpin(spinner, value, direction, eOpts);
        }
    }

    private void fireOnEventAndCatch(Spinner<Double> spinner, double value, String direction, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onSpin(spinner, value, direction, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onSpin(Spinner<Double> spinner, double value, String direction, Object eOpts);

}
