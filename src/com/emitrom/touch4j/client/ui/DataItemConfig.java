/**************************************************************************
 * DataItemConfig.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.ui;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.layout.AbstractLayout;

public class DataItemConfig extends JsObject {

    public DataItemConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setComponentProperty(XType xType, boolean value) {
        JsoHelper.setAttribute(jsObj, xType.getValue(), value);
    }
    
    public void setComponentProperty(String name, boolean value) {
        JsoHelper.setAttribute(jsObj, name, value);
    }

    public void setLayout(AbstractLayout layout) {
        JsoHelper.setAttribute(jsObj, "layout", layout.getJSO());
    }

    public void setComponentProperty(XType xType, JsObject value) {
        JsoHelper.setAttribute(jsObj, xType.getValue(), value.getJsObj());
    }
    
    public void setComponentProperty(String type, JsObject value) {
        JsoHelper.setAttribute(jsObj, type, value.getJsObj());
    }

}
