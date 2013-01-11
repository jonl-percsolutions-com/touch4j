/**************************************************************************
 * TextClearIconTapHandler.java is part of Touch4j 3.0. Copyright 2012 Emitrom
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
package com.emitrom.gwt4.touch.client.core.handlers.field.text;

import com.emitrom.gwt4.touch.client.core.EventObject;
import com.emitrom.gwt4.touch.client.core.handlers.AbstractHandler;
import com.emitrom.gwt4.touch.client.ui.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class TextClearIconTapHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(TextClearIconTapHandler listener) /*-{
		return function(source, event, eOpts) {
			var textField = @com.emitrom.gwt4.touch.client.ui.Text::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var eventObject = @com.emitrom.gwt4.touch.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			listener.@com.emitrom.gwt4.touch.client.core.handlers.field.text.TextClearIconTapHandler::fireOnEvent(Lcom/emitrom/gwt4/touch/client/ui/Text;Lcom/emitrom/gwt4/touch/client/core/EventObject;Ljava/lang/Object;)(textField, eventObject, eOpts);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Text<String> text, EventObject event, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(text, event, eOpts, handler);
        } else {
            onClearIconTap(text, event, eOpts);
        }
    }

    private void fireOnEventAndCatch(Text<String> text, EventObject event, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onClearIconTap(text, event, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onClearIconTap(Text<String> text, EventObject event, Object eOpts);

}
