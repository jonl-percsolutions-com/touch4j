/**************************************************************************
 * Scroller.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.gwt4.touch.client.core;

import com.emitrom.gwt4.touch.client.laf.Direction;
import com.google.gwt.core.client.JavaScriptObject;

public class Scroller {

    private ScrollerJSO jso;

    public Scroller() {
        jso = ScrollerJSO.getJSO();
    }

    public Scroller(Direction direction) {
        this();
        setDirection(direction);
    }

    public void setDirection(Direction direction) {
        jso.setDirection(direction.getValue());
    }

    public Direction getDirection() {
        return Direction.fromValue(jso.getDirection());
    }

    public ScrollerJSO getJso() {
        return jso;
    }

    static class ScrollerJSO extends JavaScriptObject {

        protected ScrollerJSO() {
        }

        public static native ScrollerJSO getJSO() /*-{
			return {};
        }-*/;

        public final native String getDirection() /*-{
			return this.direction;
        }-*/;

        public final native boolean getDirectionLock() /*-{
			return this.directionLock;
        }-*/;

        public final native boolean getDisabled() /*-{
			return this.disabled;
        }-*/;

        public final native <T> T getMomentumEasing() /*-{
			return this.momentumEasing;
        }-*/;

        public final native <T> T getSlotSnapSize() /*-{
			return this.slotSnapSize;
        }-*/;

        public final native boolean isAxisEnabled(String axis) /*-{
			return this.isAxisEnabled(axis);
        }-*/;

        public final native void scrollBy(int x, int y) /*-{
			this.scrollBy(x, y);
        }-*/;

        public final native void setDirection(String direction) /*-{
			this.direction = direction;
        }-*/;

        public final native void setDirectionLock(boolean lock) /*-{
			this.directionLock = lock;
        }-*/;

        public final native void setDisabled(boolean value) /*-{
			this.setDisabled = value;
        }-*/;

        public final native void setOutOfBoundRestrictFactor(double value) /*-{
			this.outOfBoundRestrictFactor = value;
        }-*/;

    }

}