/************************************************************************
 * Touch4jInjector.java is part of Touch4j 4.2.2.1 Copyright 2013 Emitrom LLC
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
package com.emitrom.touch4j.client.core;

import com.emitrom.pilot.core.formfactor.client.JsLoadCallback;
import com.emitrom.pilot.core.formfactor.client.ResourceInjector;

/**
 * Utility class to inject Touch4j resources. This class should be used while
 * developing for different devices and form factors. The class will help you
 * inject Touch4j on demand
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
