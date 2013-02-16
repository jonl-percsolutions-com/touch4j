/**************************************************************************
 * ToolTip.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.charts.client;

import com.emitrom.touch4j.charts.client.laf.ToolTipRenderer;
import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A tooltip to the visualization's markers for charts
 * 
 */
public class ToolTip extends JsObject {

    public ToolTip() {
        jsObj = JsoHelper.createObject();
    }

    ToolTip(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * True to have the tooltip follow the mouse as it moves over the target
     * element.
     * 
     * @param value
     */
    public void setTrackMouse(boolean value) {
        JsoHelper.setAttribute(jsObj, "trackMouse", value);
    }

    public boolean trackMouse() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "trackMouse");
    }

    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    public double getWidth() {
        return JsoHelper.getAttributeAsDouble(jsObj, "width");
    }

    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    public double getHeight() {
        return JsoHelper.getAttributeAsDouble(jsObj, "height");
    }

    public native void setRenderer(ToolTipRenderer renderer)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.renderer = function(sroteItem, item) {
			var model = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(storeItem);
			var chartItem = @com.emitrom.touch4j.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
			renderer.@com.emitrom.touch4j.charts.client.laf.ToolTipRenderer::onRender(Lcom/emitrom/touch4j/client/data/BaseModel;Lcom/emitrom/touch4j/charts/client/interactions/ChartItem;)(model, chartItem);
		};
    }-*/;

    public void setAnchor(String value) {
        JsoHelper.setAttribute(jsObj, "anchor", value);
    }

    public void setAnchorOffset(double value) {
        JsoHelper.setAttribute(jsObj, "anchorOffset", value);
    }

    public void setAnchorToTarget(boolean value) {
        JsoHelper.setAttribute(jsObj, "anchorToTarget", value);
    }

    public void setAntoHide(boolean value) {
        JsoHelper.setAttribute(jsObj, "autoHide", value);
    }

    public void setDismissDelay(int value) {
        JsoHelper.setAttribute(jsObj, "dissmissDelay", value);
    }

    public void hideDelay(int value) {
        JsoHelper.setAttribute(jsObj, "hideDelay", value);
    }

    public void setShowDelay(double value) {
        JsoHelper.setAttribute(jsObj, "showDelay", value);
    }

}
