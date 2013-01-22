/**************************************************************************
 * ComponentFactory.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Component factory class.
 */
public class ComponentFactory {

    /**
     * Return a Component from the passed native component object.
     * 
     * @param jsObj
     *            native object
     * @return the corresponding Component.
     * @see com.emitrom.touch4j.client.core.Component
     */
    public static Component getComponent(JavaScriptObject jsObj) {
        Object componentJ = JsoHelper.getAttributeAsObject(jsObj, "__compJ");
        if (componentJ != null) {
            return (Component) componentJ;
        }

        String xtype = getXType(jsObj);

        if (xtype == null) {
            return null;
        }
        if (xtype.equalsIgnoreCase(XType.ACTONSHEET.getValue())) {
            return new ActionSheet(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.AUDIO.getValue())) {
            return new Audio(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.BUTTON.getValue())) {
            return new Button(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CAROUSEL.getValue())) {
            return new Carousel(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CHECKBOX_FIELD.getValue())) {
            return new CheckBox(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CHART.getValue())) {
            return new Chart(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.CONTAINER.getValue())) {
            return new Container(jsObj);
        }
        return null;
    }

    private static native String getXType(JavaScriptObject jsObj) /*-{
		var xtype = jsObj.getXType ? jsObj.getXType() : null;
		return xtype === undefined ? null : xtype;
    }-*/;

}
