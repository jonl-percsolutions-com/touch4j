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
package com.emitrom.touch4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Just as Ext.Element wraps around a native DOM node, EventObject wraps the
 * browser's native event-object normalizing cross-browser differences, such as
 * which mouse button is clicked, keys pressed, mechanisms to stop
 * event-propagation along with a method to prevent default actions from taking
 * place.
 */
public class EventObject extends JsObject {

    protected EventObject(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The angle of the rotation.
     * 
     * This is only available when the event type is rotate
     */
    public native int getAngle() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.angle;
    }-*/;

    /**
     * The direction of the swipe. Note: In order to recognise swiping up and
     * down, you must enable the vertical swipe recogniser.
     * 
     * This is only available when the event type is swipe
     */
    public native int getDirection() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.direction;
    }-*/;

    /**
     * The distance of the event.
     * 
     * This is only available when the event type is swipe and pinch
     */
    public native int getDistance() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.distance;
    }-*/;

    /**
     * The duration of the swipe.
     * 
     * This is only available when the event type is swipe
     */
    public native double getDuration() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.duration;
    }-*/;

    /**
     * The browsers x coordinate of the event.
     * 
     * @return
     */
    public native double getPageX() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.pageX;
    }-*/;

    /**
     * Gets the y coordinate of the event.
     * 
     * @return the y coordinate of the event.
     */
    public native int getPageY() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.pageY;
    }-*/;

    /**
     * A amount of rotation, since the start of the event.
     * 
     * This is only available when the event type is rotate
     */
    public native double getRotation() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.rotation;
    }-*/;

    /**
     * The scape of a pinch event.
     * 
     * This is only available when the event type is pinch
     */
    public native double getScale() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		return e.scale;
    }-*/;

    /**
     * Stop the event (preventDefault and stopPropagation)
     */
    public native void stopEvent() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		e.stopEvent();
    }-*/;

    public native ExtElement getTarget() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var obj = e.target;
		return @com.emitrom.touch4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Cancels bubbling of the event.
     */
    public native void stopPropagation() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		e.stopPropagation();
    }-*/;

    /**
     * Cancels the default behavior of the event.
     */
    public native void preventDefault() /*-{
		var e = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		e.preventDefault();
    }-*/;

}
