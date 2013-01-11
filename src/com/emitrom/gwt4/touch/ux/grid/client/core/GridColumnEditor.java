/**************************************************************************
   GridColumnEditor.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.ux.grid.client.core;

import com.emitrom.gwt4.touch.client.core.config.Attribute;
import com.emitrom.gwt4.touch.client.core.config.XType;
import com.emitrom.platform.util.client.core.JsObject;
import com.emitrom.platform.util.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class GridColumnEditor extends JsObject {

    protected GridColumnEditor(JavaScriptObject obj) {
        jsObj = obj;
    }

    public GridColumnEditor() {
        jsObj = JsoHelper.createObject();
    }

    public GridColumnEditor(XType xtype) {
        this();
        setXType(xtype);
    }

    /**
     * The type of the filter
     * 
     * @param value
     */
    public void setXType(XType value) {
        JsoHelper.setAttribute(jsObj, Attribute.XTYPE.getValue(), value.getValue());
    }

}
