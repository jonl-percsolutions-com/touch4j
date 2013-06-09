/************************************************************************
  AreaSeries.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.charts.client.series;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Creates a Stacked Area AbstractChart. The stacked area chart is useful when
 * displaying multiple aggregated layers of information. As with all other
 * series, the Area Series must be appended in the *series* AbstractChart array
 * configuration.
 */
public class AreaSeries extends StackedCartesianSeries {

    public AreaSeries() {
        jsObj = JsoHelper.createObject();
        setType("area");
    }

    AreaSeries(JavaScriptObject obj) {
        jsObj = obj;
    }
}
