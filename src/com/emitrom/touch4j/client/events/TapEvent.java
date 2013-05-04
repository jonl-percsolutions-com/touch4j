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
