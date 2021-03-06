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
import com.google.gwt.core.client.JavaScriptObject;

public class Rotate extends AbstractInteraction {

    public Rotate() {
        jsObj = JsoHelper.createObject();
        setType(InteractionType.ROTATE);
    }

    Rotate(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native void setGesture(String value)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		if (jso.setGesture) {
			jso.setGesture(value);
		} else {
			jso.gesture = value;
		}
    }-*/;

    public static Rotate cast(AbstractInteraction peer) {
        return new Rotate(peer.getJsObj());
    }

}
