/************************************************************************
  CrossZoom.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.charts.client.interactions;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.ui.Button;
import com.google.gwt.core.client.JavaScriptObject;

public class CrossZoom extends AbstractInteraction {

    public CrossZoom() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.CROSS_ZOOM);
    }

    public CrossZoom(PanzoomAxis axes) {
        this();
        setAxes(axes);
    }

    CrossZoom(JavaScriptObject obj) {
        jsObj = obj;
    }

    public void setAxes(PanzoomAxis value) {
        _setAxes(value.getJsObj());
    }

    private native void _setAxes(JavaScriptObject value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.axes = value;
    }-*/;

    public native Button getUngoButton()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		if (jso.getUngoButton) {
			var btn = jso.getUngoButton();
			return @com.emitrom.touch4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(btn);
		}
		return null;

    }-*/;

    public native void setGesture(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		if (jso.setGesture) {
			jso.setGesture(value);
		} else {
			jso.gesture = value;
		}
    }-*/;

    public static CrossZoom cast(AbstractInteraction peer) {
        return new CrossZoom(peer.getJsObj());
    }

}
