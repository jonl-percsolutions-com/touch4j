/**************************************************************************
   OffsetValue.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client.interactions;

import com.emitrom.gwt4.touch.client.core.JsObject;
import com.emitrom.gwt4.touch.client.core.JsoHelper;

public class OffsetValue extends JsObject {

    public OffsetValue() {
        jsObj = JsoHelper.createObject();
    }

    public OffsetValue(double offsetX) {
        this();
        setX(offsetX);
    }

    public OffsetValue(double offsetX, double offsetY) {
        this(offsetX);
        setY(offsetY);
    }

    public native void setX(double value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		jso.x = value;
    }-*/;

    public native void setY(double value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		jso.y = value;
    }-*/;

}
