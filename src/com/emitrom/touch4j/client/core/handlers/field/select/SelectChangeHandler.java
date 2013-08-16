/************************************************************************
  SelectChangeHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core.handlers.field.select;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.Select;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class SelectChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(SelectChangeHandler listener) /*-{
		return function(source, newValue, oldValue, eOpts) {
			var select = @com.emitrom.touch4j.client.ui.Select::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.field.select.SelectChangeHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/Select;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)(select, newValue, oldValue, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Select<String> select, Object newValue, Object oldValue, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(select, newValue, oldValue, eOpts, handler);
        } else {
            onChange(select, newValue, oldValue, eOpts);
        }
    }

    private void fireOnEventAndCatch(Select<String> select, Object newValue, Object oldValue, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onChange(select, newValue, oldValue, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onChange(Select<String> select, Object newValue, Object oldValue, Object eOpts);

}
