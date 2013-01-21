/**********************************************************************************
   JsObject.java is part of Emitrom Platform Core 1.0.  Copyright 2012 Emitrom LLC

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 **********************************************************************************/
package com.emitrom.gwt4.touch.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for representing a native Javascript class. <b>Note</b> : For
 * internal use only.
 */
public abstract class JsObject {

    protected JavaScriptObject jsObj;

    protected JsObject() {
    }

    protected JsObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    protected boolean isCreated() {
        return jsObj != null;
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    protected void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public native String[] getProperties() /*-{
		var jsObj = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		return @com.emitrom.gwt4.touch.client.core.JsoHelper::getProperties(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
    }-*/;

}
