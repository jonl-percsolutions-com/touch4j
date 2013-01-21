/**************************************************************************
   ComponentFactory.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.client.core;

import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Component factory class.
 */
public class ComponentFactory {

    /**
     * Return a Component from the passed native component object.
     * 
     * @param jsObj native object
     * @return the corresponding Component.
     * @see com.emitrom.gwt4.touch.client.core.Component
     */
    protected static Component getComponent(JavaScriptObject jsObj) {
        Object componentJ = JsoHelper.getAttributeAsObject(jsObj, "__compJ");
        if (componentJ != null) {
            return (Component) componentJ;
        }
        return null;
    }

}
