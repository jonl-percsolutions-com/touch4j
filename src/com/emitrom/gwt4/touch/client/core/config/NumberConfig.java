/**************************************************************************
   NumberConfig.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.client.core.config;

import com.emitrom.gwt4.touch.client.ui.NumberField;
import com.emitrom.platform.util.client.core.JsoHelper;

/**
 * Configuration object that may be used to initialize {@link NumberField}
 */
public class NumberConfig extends FieldConfig {

    public NumberConfig() {
    }

    /**
     * The maximum value that this Number field can accept. Defaults to: null
     * 
     * @param value
     */
    public void setMaxValue(double value) {
        JsoHelper.setAttribute(jsObj, Attribute.MAX_VALUE.getValue(), value);
    }

    /**
     * The minimum value that this Number field can accept. Defaults to: null
     * 
     * @param value
     */
    public void setMinValue(double value) {
        JsoHelper.setAttribute(jsObj, Attribute.MIN_VALUE.getValue(), value);
    }

    /**
     * The amount by which the field is incremented or decremented each time the
     * spinner is tapped. Defaults to undefined, which means that the field goes
     * up or down by 1 each time the spinner is tapped. Defaults to: null
     * 
     * @param value
     */
    public void setStepValue(double value) {
        JsoHelper.setAttribute(jsObj, Attribute.STEP_VALUE.getValue(), value);
    }

}
