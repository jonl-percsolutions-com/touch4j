/**************************************************************************
   Animation.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client;

import com.emitrom.gwt4.touch.client.core.config.BaseConfig;
import com.emitrom.gwt4.touch.client.fx.layout.card.Easing;
import com.emitrom.platform.util.client.core.JsoHelper;

public class Animation extends BaseConfig {

    public Animation() {

    }

    public Animation(int duration) {
        this();
        setDuration(duration);
    }

    public Animation(int duration, Easing easing) {
        this(duration);
        setEasing(easing);
    }

    public void setDuration(int value) {
        JsoHelper.setAttribute(jsObj, "duration", value);
    }

    public void setEasing(Easing easing) {
        setEasing(easing.getValue());
    }

    private void setEasing(String value) {
        JsoHelper.setAttribute(jsObj, "easing", value);
    }
}
