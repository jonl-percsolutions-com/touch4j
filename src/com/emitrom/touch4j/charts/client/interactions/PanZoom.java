/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.emitrom.touch4j.charts.client.interactions;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.ui.Button;
import com.google.gwt.core.client.JavaScriptObject;

public class PanZoom extends AbstractInteraction {

    public PanZoom() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.PANZOOM);
    }

    public PanZoom(PanzoomAxis axes) {
        this();
        setAxes(axes);
    }

    PanZoom(JavaScriptObject obj) {
        jsObj = obj;
    }

    public void setAxes(PanzoomAxis value) {
        _setAxes(value.getJsObj());
    }

    private native void _setAxes(JavaScriptObject value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.axes = value;
    }-*/;

    public native void setshowOverflowArrows(boolean value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.showOverflowArrows = value;
    }-*/;

    public native void setOverflowArrowOptions(JavaScriptObject value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.overflowArrowOptions = value;
    }-*/;

    public native void setZoomOnPanGesture(boolean value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.zoomOnPanGesture = value;
    }-*/;

    public native Button getModeToggleButton()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		if (jso.getModeToggleButton) {
			var btn = jso.getModeToggleButton();
			return @com.emitrom.touch4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(btn);
		}
		return null;

    }-*/;

    public native void setPanGesture(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		if (jso.setPanGesture) {
			jso.setPanGesture(value);
		} else {
			jso.panGesture = value;
		}

    }-*/;

    public native void setZoomPanGesture(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		if (jso.setZoomPanGesture) {
			jso.setZoomPanGesture(value);
		} else {
			jso.zoomPanGesture = value;
		}

    }-*/;

    public static PanZoom cast(AbstractInteraction peer) {
        return new PanZoom(peer.getJsObj());
    }

}
