/************************************************************************
  BeforeTapHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core.handlers.button;

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class BeforeTapHandler extends AbstractHandler {

  final JavaScriptObject jsoPeer = createPeer(this);

  private static native JavaScriptObject createPeer(BeforeTapHandler listener) /*-{
		return function(source, event) {
			var btn = @com.emitrom.touch4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var e = (event === undefined || event == null) ? null
					: @com.emitrom.touch4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			listener.@com.emitrom.touch4j.client.core.handlers.button.BeforeTapHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/Button;Lcom/emitrom/touch4j/client/core/EventObject;)(btn,e);
		};
  }-*/;

  // Called from JSNI
  private final void fireOnEvent(Button btn, EventObject event) {
    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
    if (handler != null) {
      fireOnEventAndCatch(btn, event, handler);
    } else {
      onBeforeTap(btn, event);
    }
  }

  private void fireOnEventAndCatch(Button btn, EventObject event, UncaughtExceptionHandler handler) {
    try {
      onBeforeTap(btn, event);
    } catch (Throwable e) {
      handler.onUncaughtException(e);
    }
  }

  @Override
  public JavaScriptObject getJsoPeer() {
    return jsoPeer;
  }

  public abstract void onBeforeTap(Button button, EventObject event);
}
