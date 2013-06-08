package com.emitrom.touch4j.client.core;

import com.emitrom.pilot.core.formfactor.client.JsLoadCallback;
import com.emitrom.pilot.core.formfactor.client.ResourceInjector;

/**
 * Utility class to inject Touch4j resources. This class should ve used while
 * developing for different devices with the goal to provide a different UI for
 * each device.
 * 
 */
public class Touch4jInjector extends ResourceInjector {

    public Touch4jInjector(String touchCSSLink, String touchJsLink) {
        super(touchCSSLink, touchJsLink);
    }

    public void inject(final InitHandler handler) {
        this.setJsLoadCallback(new JsLoadCallback() {
            @Override
            public void onJsLoaded() {
                Touch.init(handler);
            }
        }).inject();
    }

    public void inject(final TouchConfig config) {
        this.setJsLoadCallback(new JsLoadCallback() {
            @Override
            public void onJsLoaded() {
                Touch.init(config);
            }
        }).inject();
    }
}
