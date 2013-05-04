package com.emitrom.touch4j.client.events.handlers;

import com.emitrom.touch4j.client.events.TapEvent;
import com.google.gwt.event.shared.EventHandler;

public interface TapHandler extends EventHandler {
    public void onTap(TapEvent event);
}
