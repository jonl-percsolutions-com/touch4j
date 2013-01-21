/**************************************************************************
   Toolbar.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.charts.client;

import com.emitrom.touch4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The chart toolbar is a container that is docked to one side of the chart,
 * that is intended to hold buttons for performing user actions without taking
 * up valuable screen real estate from the chart. This is used internally for
 * things like the button for showing the legend when the legend is docked, or
 * the pan/zoom interaction's button for switching between pan and zoom mode in
 * non-multi-touch environments.
 * 
 * An instance of this class is created automatically by the chart when it is
 * needed; authors should not need to instantiate it directly.
 */
public class Toolbar extends Container {

    protected Toolbar(JavaScriptObject jsObj) {
        super(jsObj);
    }

}
