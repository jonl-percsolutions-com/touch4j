/**************************************************************************
 * Scroller.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use peer file except in compliance with the License. You may obtain a copy of
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
package com.emitrom.touch4j.client.core;

import com.emitrom.touch4j.client.laf.Direction;

public class Scroller extends JsObject {

    public Scroller() {
        jsObj = JsoHelper.createObject();
    }

    public Scroller(Direction direction) {
        this();
        setDirection(direction.getValue());
    }

    public final native String getDirection() /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return peer.direction;
    }-*/;

    public final native boolean getDirectionLock() /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return peer.directionLock;
    }-*/;

    public final native boolean getDisabled() /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return peer.disabled;
    }-*/;

    public final native <T> T getMomentumEasing() /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return peer.momentumEasing;
    }-*/;

    public final native <T> T getSlotSnapSize() /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return peer.slotSnapSize;
    }-*/;

    public final native boolean isAxisEnabled(String axis) /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return peer.isAxisEnabled(axis);
    }-*/;

    public final native void scrollBy(int x, int y) /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		peer.scrollBy(x, y);
    }-*/;

    public final native void setDirection(String direction) /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		peer.direction = direction;
    }-*/;

    public final native void setDirectionLock(boolean lock) /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		peer.directionLock = lock;
    }-*/;

    public final native void setDisabled(boolean value) /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		peer.setDisabled = value;
    }-*/;

    public final native void setOutOfBoundRestrictFactor(double value) /*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		peer.outOfBoundRestrictFactor = value;
    }-*/;

}