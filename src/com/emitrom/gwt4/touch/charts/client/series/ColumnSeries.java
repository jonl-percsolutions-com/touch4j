/**************************************************************************
   ColumnSeries.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client.series;

import com.emitrom.gwt4.touch.charts.client.laf.Style;
import com.emitrom.gwt4.touch.client.core.JsoHelper;

public class ColumnSeries extends BaseSeries {

    public ColumnSeries() {
        jsObj = JsoHelper.createObject();
        this.setType("Column");
    }

    public void setXField(String value) {
        JsoHelper.setAttribute(jsObj, "xField", value);
    }

    public void setYField(String value) {
        JsoHelper.setAttribute(jsObj, "yField", value);
    }

    public void setAxis(String value) {
        JsoHelper.setAttribute(jsObj, "axis", value);
    }

    public void setStyle(Style value) {
        JsoHelper.setAttribute(jsObj, "style", value.getJsObj());
    }

    public void setStyle(String value) {
        JsoHelper.setAttribute(jsObj, "style", value);
    }

}
