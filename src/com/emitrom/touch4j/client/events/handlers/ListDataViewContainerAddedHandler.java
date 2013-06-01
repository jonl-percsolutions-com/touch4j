package com.emitrom.touch4j.client.events.handlers;

import com.emitrom.touch4j.client.events.ListDataViewContainerAddEvent;
import com.google.gwt.event.shared.EventHandler;

public interface ListDataViewContainerAddedHandler extends EventHandler {
    public void onContainerAdded(ListDataViewContainerAddEvent event);
}
