/**************************************************************************
   JsonStore.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.client.data;

import java.util.ArrayList;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class JsonStore extends Store {

    protected JsonStore() {
        create();
    }

    public JsonStore(ArrayList<? extends BaseModel> data) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        create(JsoHelper.arrayConvert(storeData));
    }

    protected JsonStore(JavaScriptObject obj) {
        super(obj);
    }

    private native void create()/*-{
		this.@com.emitrom.touch4j.client.core.JsObject::jsObj = new $wnd.Ext.data.JsonStore();
    }-*/;

    private native void create(JavaScriptObject values)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::jsObj;
		jso = new $wnd.Ext.data.JsonStore({
			model : "Emitrom",
			data : values
		});
    }-*/;

}
