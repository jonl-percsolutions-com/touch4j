/************************************************************************
  TapEvent.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.events;

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.events.handlers.TapHandler;
import com.emitrom.touch4j.client.ui.Button;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Fired when a button is taped
 */
public class TapEvent extends EventObject {

    public static String EVENT_NAME = "tap";
    private Button source;

    /**
     * UiBinder implementations
     */
    private static Type<TapHandler> TYPE = new Type<TapHandler>(EVENT_NAME, null);

    public static Type<TapHandler> getType() {
        return TYPE;
    }

    public static Type<TapHandler> getAssociatedType() {
        return TYPE;
    }

    protected TapEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected TapEvent(Button source, JavaScriptObject event) {
        super(event);
        this.source = source;
    }

    /**
     * Gets the button that fired this event
     * 
     * @return the button that fired this event
     */
    public Button getSource() {
        return this.source;
    }

}
