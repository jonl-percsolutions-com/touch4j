/**************************************************************************
   Animation.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.client.fx.layout.card;

import com.emitrom.platform.util.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class Animation {
    protected JavaScriptObject jso;

    public Animation() {
        create();
    }

    public Animation(AnimationType type) {
        this();
        setType(type);
    }

    public Animation(AnimationType type, Direction direction) {
        this(type);
        setDirection(direction);
    }

    public Animation(AnimationType type, Direction direction, int duration) {
        this(type, direction);
        setDuration(duration);
    }

    public Animation(AnimationType type, int duration) {
        this(type);
        setDuration(duration);
    }

    Animation(JavaScriptObject obj) {
        jso = obj;
    }

    /**
     * @return the jso
     */
    public JavaScriptObject getJSO() {
        return jso;
    }

    public void setType(AnimationType animationType) {
        setType(animationType.getValue());
    }

    public void setDirection(Direction direction) {
        setDirection(direction.getValue());
    }

    private void create() {
        jso = JsoHelper.createObject();
    }

    public native void setType(String value) /*-{
		var jso = this.@com.emitrom.gwt4.touch.client.fx.layout.card.Animation::getJSO()();
		jso.type = value;
    }-*/;

    public native void setDirection(String value) /*-{
		var jso = this.@com.emitrom.gwt4.touch.client.fx.layout.card.Animation::getJSO()();
		jso.direction = value;
    }-*/;

    public native void setDuration(int value) /*-{
		var jso = this.@com.emitrom.gwt4.touch.client.fx.layout.card.Animation::getJSO()();
		jso.duration = value;
    }-*/;

    public native void setReverse(boolean value) /*-{
		var jso = this.@com.emitrom.gwt4.touch.client.fx.layout.card.Animation::getJSO()();
		if (jso.setReverse) {
			jso.setReverse(value);
		}
    }-*/;
}
