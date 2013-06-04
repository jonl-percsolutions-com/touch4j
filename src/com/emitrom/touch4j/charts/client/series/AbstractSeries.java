/**************************************************************************
 * AbstractSeries.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.charts.client.series;

import com.emitrom.touch4j.charts.client.Animation;
import com.emitrom.touch4j.charts.client.HighLight;
import com.emitrom.touch4j.charts.client.laf.Label;
import com.emitrom.touch4j.charts.client.laf.Style;
import com.emitrom.touch4j.charts.client.marker.MarkerConfig;
import com.emitrom.touch4j.charts.client.series.renderers.SeriesRenderer;
import com.emitrom.touch4j.client.core.Function;
import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * 
 * AbstractSerie is the class containing the common logic to all chart series.
 * Series includes methods from Labels, Highlights, Tips and Callouts mixins.
 * This class implements the logic of animating, hiding, showing all elements
 * and returning the color of the series to be used as a legend item.
 * 
 */
public class AbstractSeries extends JsObject {

    public AbstractSeries() {

    }

    public AbstractSeries(JavaScriptObject obj) {
        super(obj);
    }

    protected void setType(String title) {
        JsoHelper.setAttribute(jsObj, "type", title);
    }

    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }

    public void setFill(boolean value) {
        JsoHelper.setAttribute(jsObj, "fill", value);
    }

    public void setFill(String... colors) {
        JsArrayString values = JsArrayString.createArray().cast();
        for (String color : colors) {
            values.push(color);
        }
        setFill(values);
    }

    private native void setFill(JsArrayString colors)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.subStyle = {
			fill : colors
		};
    }-*/;

    public void setAnimate(Animation value) {
        JsoHelper.setAttribute(jsObj, "fill", value.getJsObj());
    }

    public void setAnimate(boolean value) {
        JsoHelper.setAttribute(jsObj, "fill", value);
    }

    public void setBackground(Object value) {
        JsoHelper.setAttribute(jsObj, "background", value);
    }

    public void setColors(String... values) {
        JsArrayString peers = JsArrayString.createArray().cast();
        for (String s : values) {
            peers.push(s);
        }
        setColors(peers);
    }

    public void setColors(JsArrayString value) {
        JsoHelper.setAttribute(jsObj, "colors", value);
    }

    public void setLabel(Label label) {
        JsoHelper.setAttribute(jsObj, "label", label.getJsObj());
    }

    public void setHidden(boolean value) {
        JsoHelper.setAttribute(jsObj, "hidden", value);
    }

    public void setSmooth(boolean value) {
        JsoHelper.setAttribute(jsObj, "smooth", value);
    }

    public void setHighlight(HighLight value) {
        JsoHelper.setAttribute(jsObj, "highlight", value.getJsObj());
    }

    public void setMarker(MarkerConfig marker) {
        JsoHelper.setAttribute(jsObj, "markerConfig", marker.getJsObj());
    }

    public void setShowInLegend(boolean value) {
        JsoHelper.setAttribute(jsObj, "showInLegend", value);
    }

    /**
     * The horizontal pan transformation offset for this chart item.
     * 
     * @param value
     */
    public void setPanX(double value) {
        JsoHelper.setAttribute(jsObj, "panX", value);
    }

    /**
     * The vertical pan transformation offset for this chart item.
     * 
     * @param value
     */
    public void setPanY(double value) {
        JsoHelper.setAttribute(jsObj, "panY", value);
    }

    /**
     * The horizontal pan zoom offset for this chart item.
     * 
     * @param value
     */
    public void setZoomX(double value) {
        JsoHelper.setAttribute(jsObj, "zoomX", value);
    }

    /**
     * The vertical pan zoom offset for this chart item.
     * 
     * @param value
     */
    public void setZoomY(double value) {
        JsoHelper.setAttribute(jsObj, "zoomY", value);
    }

    public native void setTitle(int index, String title)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.setTitle(index, title);
    }-*/;

    public native void showAll()/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.showAll(index, title);
    }-*/;

    public native void setRenderer(SeriesRenderer renderer)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		jso.renderer = function(sprite, record, attr, index, store) {
			var s = @com.emitrom.touch4j.client.draw.Sprite::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sprite);
			var st = @com.emitrom.touch4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
			var model = @com.emitrom.touch4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var attribute = @com.emitrom.touch4j.charts.client.laf.BarAttribute::new(Lcom/google/gwt/core/client/JavaScriptObject;)(attr);
			renderer.@com.emitrom.touch4j.charts.client.series.renderers.SeriesRenderer::onRender(Lcom/emitrom/touch4j/client/draw/Sprite;Lcom/emitrom/touch4j/client/data/BaseModel;Lcom/emitrom/touch4j/charts/client/laf/BarAttribute;ILcom/emitrom/touch4j/client/data/Store;)(s,model,attribute, index,st);
			return attr;
		};
    }-*/;

    public static AbstractSeries create(JavaScriptObject obj) {
        return new AbstractSeries(obj) {
        };
    }

    public void setStyle(Style style) {
        JsoHelper.setAttribute(jsObj, "style", style.getJsObj());
    }

    public void setSubStyle(Style style) {
        JsoHelper.setAttribute(jsObj, "subStyle", style.getJsObj());
    }

    public void addItemMouseUpHandler(Function fn) {
        _addListener("itemmouseup", fn);
    }

    public void addItemMouseDownHandler(Function fn) {
        _addListener("itemmousedouwn", fn);
    }

    public void addItemMouseMoveHandler(Function fn) {
        _addListener("itemmousemove", fn);
    }

    public void addAfterRender(Function fn) {
        _addListener("afterrender", fn);
    }

    private native void _addListener(String event, Function fn) /*-{
		var component = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		var listener = function() {
			fn.@com.emitrom.touch4j.client.core.Function::execute()();
		};
		component.addListener(event, listener);

    }-*/;

}
