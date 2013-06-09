/************************************************************************
  RenderChangeHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.Container;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class RenderChangeHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(RenderChangeHandler listener) /*-{
                                                                                    return function(source, item, rendered, eOpts) {
                                                                                    var container = @com.emitrom.touch4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
                                                                                    listener.@com.emitrom.touch4j.client.core.handlers.component.RenderChangeHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/Container;Ljava/lang/Object;ZLjava/lang/Object;)(container, item, rendered, eOpts);
                                                                                    };
                                                                                    }-*/;

    // Called from JSNI
    private final void fireOnEvent(Container container, Object item, boolean rendered, Object eOpts) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(container, item, rendered, eOpts, handler);
        } else {
            onRenderChange(container, item, rendered, eOpts);
        }
    }

    private void fireOnEventAndCatch(Container container, Object item, boolean rendered, Object eOpts,
                    UncaughtExceptionHandler handler) {
        try {
            onRenderChange(container, item, rendered, eOpts);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onRenderChange(Container container, Object item, boolean rendered, Object eOpts);

}
