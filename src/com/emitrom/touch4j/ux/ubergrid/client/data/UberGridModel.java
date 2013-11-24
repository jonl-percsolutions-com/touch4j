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
package com.emitrom.touch4j.ux.ubergrid.client.data;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.data.BaseModel;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for data to be used with the UberGrid
 * 
 */
public class UberGridModel extends BaseModel {

    protected static final String EVENT_TYPE = "EventType";

    public UberGridModel() {
        jsObj = JsoHelper.createObject();
    }

    UberGridModel(JavaScriptObject obj) {
        jsObj = obj;
    }

    public void setEventType(String value) {
        set(EVENT_TYPE, value);
    }
}
