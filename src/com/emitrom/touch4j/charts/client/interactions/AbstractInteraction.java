/**************************************************************************
 * AbstractInteraction.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.charts.client.interactions;

import com.emitrom.touch4j.charts.client.AbstractChart;
import com.emitrom.touch4j.client.core.Function;
import com.emitrom.touch4j.client.core.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class AbstractInteraction extends JsObject {

    protected AbstractInteraction() {

    }

    AbstractInteraction(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native void setGesture(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.gesture = value;
    }-*/;

    public native void addChartListener(String name, Function fn)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.addChartListener(name, $entry(function() {
			fn.@com.emitrom.touch4j.client.core.Function::execute()();
		}));
    }-*/;

    public native void initEvents()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.initEvents();
    }-*/;

    private native void _setType(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.type = value;
    }-*/;

    public void setType(InteractionType type) {
        _setType(type.getValue());
    }

    public native void setChart(AbstractChart value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.chart = value.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
    }-*/;

    public native void setEnabled(boolean value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.enabled = value;
    }-*/;

}
