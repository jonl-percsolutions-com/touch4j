package com.emitrom.touch4j.ux.slidenavigation.client;

import com.emitrom.touch4j.client.ui.Container;

public interface SlideNavigationSelectHandler {
    public void onEvent(SlideNavigationContainer slideContainer, Container container, int index);
}
