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
package com.emitrom.touch4j.ux.slidenavigation.client;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Configuration for the navigation list
 * <p>
 * Defaults to: {width: 250, maxDrag: null, itemTpl: '{title}', grouped: true,
 * items: [{xtype: 'toolbar', docked: 'top', ui: 'light'}]}
 * 
 */
public class SlideNavigationList extends JsObject {

    public SlideNavigationList() {
        jsObj = JsoHelper.createObject();
    }

    public void setWidth(int value) {
        JsoHelper.setAttribute(jsObj, Attribute.WIDTH.getValue(), value);
    }

    public void setMaxDrag(int value) {
        JsoHelper.setAttribute(jsObj, "maxDrag", value);
    }

    public void setItemTpl(String value) {
        JsoHelper.setAttribute(jsObj, "itemTpl", value);
    }

    public void setGrouped(boolean value) {
        JsoHelper.setAttribute(jsObj, "grouped", value);
    }

    public void setItems(Component... items) {
        JsoHelper.setAttribute(jsObj, "items", fromArray(items));
    }

    private static JavaScriptObject fromArray(Component[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < components.length; i++) {
            JavaScriptObject c = components[i].getOrCreateJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

}
