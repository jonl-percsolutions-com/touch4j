/************************************************************************
  InitHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class InitHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(InitHandler listener) /*-{
		return function() {
			listener.@com.emitrom.touch4j.client.core.InitHandler::onInit()();
		};
    }-*/;

    protected abstract void onInit();

    // Called from JSNI
    private final void fireOnEvent() {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(handler);
        } else {
            onInit();
        }
    }

    private void fireOnEventAndCatch(UncaughtExceptionHandler handler) {
        try {
            onInit();
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

}
