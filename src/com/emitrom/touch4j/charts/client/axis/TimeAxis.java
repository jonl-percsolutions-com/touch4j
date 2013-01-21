/**************************************************************************
   TimeAxis.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.charts.client.axis;

import com.emitrom.touch4j.client.core.JsoHelper;

/**
 * A type of axis whose units are measured in time values. Use this axis for
 * listing dates that you will want to group or dynamically change. If you just
 * want to display dates as categories then use the Category class for axis
 * instead.
 * 
 */
public class TimeAxis extends AbstractAxis {

    public TimeAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("Time");
    }

    public void setGroupBy(String value) {
        JsoHelper.setAttribute(jsObj, "groupBy", value);
    }

    public void setDateFormat(String value) {
        JsoHelper.setAttribute(jsObj, "dateFormat", value);
    }

}
