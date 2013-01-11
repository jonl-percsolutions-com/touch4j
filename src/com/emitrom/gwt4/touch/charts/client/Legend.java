/**************************************************************************
   Legend.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.gwt4.touch.charts.client.laf.LegendPosition;
import com.emitrom.gwt4.touch.client.laf.Position;
import com.emitrom.platform.util.client.core.JsObject;
import com.emitrom.platform.util.client.core.JsoHelper;

public class Legend extends JsObject {

    public Legend() {
        jsObj = JsoHelper.createObject();
    }

    public Legend(Position position) {
        this();
        setPosition(position);
    }

    public Legend(LegendPosition position) {
        this();
        setPosition(position);
    }

    public void setPosition(Position position) {
        JsoHelper.setAttribute(jsObj, "position", position.getValue());
    }

    public void setPosition(LegendPosition position) {
        JsoHelper.setAttribute(jsObj, "position", position.getJsObj());
    }

    public void setLabelFont(String value) {
        JsoHelper.setAttribute(jsObj, "labelFont", value);
    }

}
