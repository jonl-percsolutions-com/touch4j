/**************************************************************************
   ToggleStacked.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.platform.util.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class ToggleStacked extends AbstractInteraction {

    public ToggleStacked() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.TOGGLE_STACKED);
    }

    ToggleStacked(JavaScriptObject obj) {
        jsObj = obj;
    }

    public final native void setEvent(String value)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.event = value;
    }-*/;

    public final native void setAnimateDirect(boolean value)/*-{
		var jso = this.@com.emitrom.platform.util.client.core.JsObject::getJsObj()();
		jso.animateDirect = value;
    }-*/;

}
