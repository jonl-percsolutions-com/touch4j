/**************************************************************************
   EnableHandler.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

public abstract class EnableHandler extends AbstractHandler {

  final JavaScriptObject jsoPeer = createPeer(this);

  private static native JavaScriptObject createPeer(EnableHandler listener) /*-{
		return function(c) {
			var comp = @com.emitrom.gwt4.touch.client.core.Component::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			listener.@com.emitrom.gwt4.touch.client.core.handlers.component.EnableHandler::fireOnEvent(Lcom/emitrom/gwt4/touch/client/core/Component;)(comp);
		};
  }-*/;

  // Called from JSNI
  private final void fireOnEvent(Component comp) {
    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
    if (handler != null) {
      fireOnEventAndCatch(comp, handler);
    } else {
      onEnable(comp);
    }
  }

  private void fireOnEventAndCatch(Component comp, UncaughtExceptionHandler handler) {
    try {
      onEnable(comp);
    } catch (Throwable e) {
      handler.onUncaughtException(e);
    }
  }

  @Override
  public JavaScriptObject getJsoPeer() {
    return jsoPeer;
  }

  public abstract void onEnable(Component comp);
}
