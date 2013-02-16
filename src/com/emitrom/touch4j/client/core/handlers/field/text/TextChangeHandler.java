/**************************************************************************
 * TextChangeHandler.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core.handlers.field.text;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class TextChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(TextChangeHandler listener) /*-{
		return function(source, oldValue, newValue, eOpts) {
			var textField = @com.emitrom.touch4j.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			listener.@com.emitrom.touch4j.client.core.handlers.field.text.TextChangeHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/Text;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)(textField,oldValue, newValue, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Text<String> text, Object oldValue, Object newValue, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(text, oldValue, newValue, eOpts, handler);
        } else {
            onChange(text, oldValue, newValue, eOpts);
        }
    }

    private void fireOnEventAndCatch(Text<String> text, Object oldValue, Object newValue, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onChange(text, oldValue, newValue, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onChange(Text<String> text, Object oldValue, Object newValue, Object eOpts);

}
