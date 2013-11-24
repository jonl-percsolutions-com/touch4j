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
package com.emitrom.touch4j.client.core.template;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;

/**
 * Configuration object for Template
 * 
 */
public class TemplateConfig extends JsObject {

    public TemplateConfig() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * True to disable format functions (defaults to false).
     * 
     * @param disable true to disable format functions
     */
    public native void setDisableFormats(boolean value) /*-{
		var templateConfig = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		templateConfig.disableFormats = disable;
    }-*/;

    /**
     * True to disable format functions (defaults to false).
     * 
     * @param disable true to disable format functions
     */
    public native void setCompiled(boolean value) /*-{
		var templateConfig = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		templateConfig.compiled = value;
    }-*/;

}
