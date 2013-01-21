/**************************************************************************
 * ToggleHandler.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core.handlers.segmentedbutton;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.SegmentedButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class ToggleHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(ToggleHandler listener) /*-{
		return function(segmentedBtn, button, pressed) {
			var element = @com.emitrom.touch4j.client.ui.SegmentedButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(segmentedBtn);
			var buttonObject = @com.emitrom.touch4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(button);
			listener.@com.emitrom.touch4j.client.core.handlers.segmentedbutton.ToggleHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/SegmentedButton;Lcom/emitrom/touch4j/client/ui/Button;Z)(element,buttonObject, pressed);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(SegmentedButton segmentedButton, Button button, boolean pressed) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(segmentedButton, button, pressed, handler);
        } else {
            onToggle(segmentedButton, button, pressed);
        }
    }

    private void fireOnEventAndCatch(SegmentedButton segmentedButton, Button button, boolean pressed,
                    UncaughtExceptionHandler handler) {
        try {
            onToggle(segmentedButton, button, pressed);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onToggle(SegmentedButton segmentedButton, Button button, boolean pressed);
}
