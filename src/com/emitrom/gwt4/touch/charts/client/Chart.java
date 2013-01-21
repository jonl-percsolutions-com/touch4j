/**************************************************************************
   Chart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.touch.charts.client.axis.AbstractAxis;
import com.emitrom.gwt4.touch.charts.client.handlers.BeforeRefreshHandler;
import com.emitrom.gwt4.touch.charts.client.handlers.ChartChangeHandler;
import com.emitrom.gwt4.touch.charts.client.handlers.ChartEventHandler;
import com.emitrom.gwt4.touch.charts.client.interactions.AbstractInteraction;
import com.emitrom.gwt4.touch.charts.client.interactions.SavingType;
import com.emitrom.gwt4.touch.charts.client.laf.Gradient;
import com.emitrom.gwt4.touch.charts.client.laf.Shadow;
import com.emitrom.gwt4.touch.charts.client.series.AbstractSerie;
import com.emitrom.gwt4.touch.charts.client.theme.Theme;
import com.emitrom.gwt4.touch.client.core.Component;
import com.emitrom.gwt4.touch.client.core.config.XType;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.laf.Color;
import com.emitrom.gwt4.touch.client.laf.Position;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * The Chart component provides the capability to visualize data. Each chart
 * binds directly to a Store enabling automatic updates of the chart.
 */
public class Chart extends Component {

    private static final String BEFORE_REFRESH = "beforerefresh";
    private static final String ITEM_CLICK = "itemclick";
    private static final String ITEM_DOUBLE_CLICK = "itemdoubleclick";
    private static final String ITEM_DOUBLE_TAP = "itemdoubletap";
    private static final String ITEM_DRAG = "itemdrag";
    private static final String ITEM_DRAG_END = "itemdragend";
    private static final String ITEM_DRAG_START = "itemdragstart";
    private static final String ITEM_MOUSE_DOWN = "itemmousedown";
    private static final String ITEM_MOUSE_MOVE = "itemmousemove";
    private static final String ITEM_MOUSE_OUT = "itemmouseout";
    private static final String ITEM_MOUSE_OVER = "itemmouseover";
    private static final String ITEM_MOUSE_UP = "itemmouseup";
    private static final String ITEM_PINCH = "itempinch";
    private static final String ITEM_PINCH_END = "itempinchend";
    private static final String ITEM_PINCH_START = "itempinchstart";
    private static final String ITEM_SINGLE_TAP = "itemsingletap";
    private static final String ITEM_SWIPE = "itemswipe";
    private static final String ITEM_TAP = "itemtap";
    private static final String ITEM_TAP_CANCEL = "itemtapcancel";
    private static final String ITEM_TAP_END = "itemtapend";
    private static final String ITEM_TAP_HOLD = "itemtaphold";
    private static final String ITEM_TAP_START = "itemtapstart";
    private static final String ITEM_TOUCH_END = "itemtouchend";
    private static final String ITEM_TOUCH_MOVE = "itemtouchmove";
    private static final String ITEM_TOUCH_START = "itemtouchstart";
    private static final String REDRAW = "redraw";
    private static final String REFRESH = "refresh";

    private static JavaScriptObject configPrototype;
    private Store store;
    private List<AbstractSerie> series = new ArrayList<AbstractSerie>();
    private List<AbstractAxis> axis = new ArrayList<AbstractAxis>();
    private List<AbstractInteraction> interactions = new ArrayList<AbstractInteraction>();
    private List<Gradient> gradients = new ArrayList<Gradient>();

    protected native void init()/*-{
		var c = new $wnd.Ext.chart.Chart();
		@com.emitrom.gwt4.touch.charts.client.Chart::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.CHART.getValue();
    }

    /**
     * Create a new Chart Panel.
     */
    public Chart() {

    }

    public Chart(Store store) {
        setStore(store);
        setTheme(Theme.BASE);
    }

    public Chart(Store store, Theme theme) {
        setStore(store);
        setTheme(theme);
    }

    protected Chart(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.chart.Chart(config);
    }-*/;

    /**
     * The name of the theme to be used. A theme defines the colors and other
     * visual displays of tick marks on axis, text, title text, line colors,
     * marker colors and styles, etc. Possible theme values are 'Base', 'Green',
     * 'Sky', 'Red', 'Purple', 'Blue', 'Yellow' and also six category themes
     * 'Category1' to 'Category6'. Default value is 'Base'.
     * 
     * @param theme
     */
    public void setTheme(Theme theme) {
        setTheme(theme.getValue());
    }

    /**
     * Adds a given Axis to this chart
     * 
     * @param axis
     */
    public void addAxis(AbstractAxis axis) {
        this.axis.add(axis);
    }

    /**
     * draw the axis of this chart
     */
    public void drawAxis() {
        if (this.axis.size() <= 0) {
            throw new RuntimeException("You must add add atleast one axis to the chart before calling drawAxis");
        }
        this.setAxes(this.axis);
    }

    /**
     * set a list of AbstractAxis instances.
     * 
     * @param axes
     */
    public void setAxes(List<AbstractAxis> axes) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractAxis axe : axes) {
            jsos.push(axe.getJsObj());
        }
        setAttribute("axes", jsos, true);

    }

    public void setAxes(AbstractAxis... axes) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractAxis axe : axes) {
            jsos.push(axe.getJsObj());
        }
        setAttribute("axes", jsos, true);
    }

    /**
     * Add a given series to this chart
     * 
     * @param series
     */
    public void addSeries(AbstractSerie series) {
        this.series.add(series);
    }

    /**
     * draw the series of this chart
     */
    public void drawSeries() {
        if (this.series.size() <= 0) {
            throw new RuntimeException("You must add add atleast one series to the chart before calling drawSeries");
        }
        this.setSeries(this.series);
    }

    /**
     * set a list of Series instances or config objects
     * 
     * @param series
     */
    public void setSeries(List<AbstractSerie> series) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractSerie serie : series) {
            jsos.push(serie.getJsObj());
        }
        setAttribute("series", jsos, true);
    }

    public void setSeries(AbstractSerie... series) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractSerie serie : series) {
            jsos.push(serie.getJsObj());
        }
        setAttribute("series", jsos, true);
    }

    /**
     * The store that supplies data to this chart.
     * 
     * @param store
     */
    public void setStore(Store store) {
        this.store = store;
        setAttribute("store", store.getJsObj(), true);
    }

    /**
     * set a legend config
     * 
     * @param legend
     */
    public void setLegend(Legend legend) {
        setAttribute("legend", legend.getJsObj(), true);
    }

    /**
     * true for the default legend display.
     * 
     * @param legend
     */
    public void setLegend(boolean legend) {
        setAttribute("legend", legend, true);
    }

    /**
     * 
     * true for the default shadow configuration
     * 
     * @param value
     */
    public void setShadow(boolean value) {
        setAttribute("shadow", value, true);
    }

    /**
     * shadow config object to be used for default chart shadows.
     * 
     * @param value
     */
    public void setShadow(Shadow value) {
        setAttribute("shadow", value.getJsObj(), true);
    }

    /**
     * Turn on autoSize support which will set the bounding div's size to the
     * natural size of the contents.
     * 
     * @param value
     */
    public void setAutoSize(boolean value) {
        setAttribute("autosize", value, true);
    }

    /**
     * (optional) true for the default animation (easing: 'ease' and duration:
     * 500) or a standard animation config object to be used for default chart
     * animations.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setAnimate(boolean value) {
        setAttribute("animate", value, true, true);
    }

    /**
     * (optional) true for the default animation (easing: 'ease' and duration:
     * 500) or a standard animation config object to be used for default chart
     * animations.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setAnimate(Animation value) {
        setAttribute("animate", value.getJsObj(), true, true);
    }

    public void setInsetPadding(int value) {
        setAttribute("insetPadding", value, true, true);
    }

    /**
     * Set the chart background
     * 
     * @param value
     */
    public void setBackGround(Color value) {
        setAttribute("background", createFill(value.getValue()), true);
    }

    /**
     * Set the chart background
     * 
     * @param value
     */
    public void setBackGround(String image) {
        setAttribute("background", createImage(image), true);
    }

    /**
     * Set the chart background
     * 
     * @param value
     */
    public void setBackGround(Gradient value) {
        setAttribute("background", createGradient(value.getJsObj()), true);
    }

    /**
     * Array of gradients to override the color of items and legends.
     * 
     * @param values
     */
    public void setColors(Gradient... values) {
        JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
        for (Gradient g : values) {
            gradients.push(g.getJsObj());
        }
        setAttribute("colors", gradients, true, true);
    }

    /**
     * Array of gradients to override the color of items and legends.
     * 
     * @param values
     */
    public void setColors(List<Gradient> values) {
        JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
        for (Gradient g : values) {
            gradients.push(g.getJsObj());
        }
        setAttribute("colors", gradients, true, true);
    }

    /**
     * Array of colors to override the color of items and legends.
     * 
     * @param values
     */
    public void setColors(Color... values) {
        JsArrayString colors = JsArray.createArray().cast();
        for (Color c : values) {
            colors.push(c.getValue());
        }
        setAttribute("colors", colors, true, true);
    }

    /**
     * Define a set of gradients that can be used as fill property in sprites.
     * ...
     * 
     * @param values
     */
    public void setGradients(Gradient... values) {
        JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
        for (Gradient g : values) {
            gradients.push(g.getJsObj());
        }
        setAttribute("gradients", gradients, true, true);
    }

    /**
     * Add a gradient to this chart
     */
    public void addGradient(Gradient gradient) {
        this.gradients.add(gradient);
    }

    /**
     * draw the axis of this chart
     */
    public void drawGradients() {
        if (this.gradients.size() <= 0) {
            throw new RuntimeException(
                            "You must add add atleast one gradient to the chart before calling drawGradients");
        }
        this.setColors(this.gradients);
    }

    /**
     * Set the chart background
     * 
     * @param value
     */
    public void setInsetPadding(double value) {
        setAttribute("insetPadding", value, true);
    }

    /**
     * The class name used only in theming system.
     * 
     * @param value
     */
    public void setThemeCls(String value) {
        setAttribute("themeCls", value, true);
    }

    /**
     * The position at which the toolbar should be docked in relation to the
     * chart.
     * 
     * @param position
     */
    public void setToolbar(Position position) {
        setAttribute("toolbar", createToolbarPosition(position.getValue()), true);
    }

    public native Toolbar getToolbar()/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		var tb = component.getToolbar();
		var toReturn = @com.emitrom.gwt4.touch.charts.client.Toolbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tb);
		return toReturn;
    }-*/;

    /**
     * Turn on view box support which will scale and position items in the draw
     * component to fit to the component while maintaining aspect ratio. Note
     * that this scaling can override other sizing settings on yor items.
     * 
     * @param position
     */
    public void setViewBox(boolean value) {
        setAttribute("viewBox", value, true);
    }

    /**
     * return the Store bound to this chart
     * 
     * @return
     */
    public Store getStore() {
        return this.store;
    }

    private native JavaScriptObject createToolbarPosition(String value)/*-{
		return {
			position : value
		}
    }-*/;

    /**
     * Add a given interaction to this chart
     * 
     * @param interaction
     */
    public void addInteraction(AbstractInteraction interaction) {
        this.interactions.add(interaction);
        this.setInteractions(this.interactions);
    }

    /**
     * Interactions are optional modules that can be plugged in to a chart to
     * allow the user to interact with the chart and its data in special ways
     * 
     * @param interactions
     */
    public void setInteractions(List<AbstractInteraction> interactions) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (AbstractInteraction interaction : interactions) {
            values.push(interaction.getJsObj());
        }
        _setInteractions(values);
    }

    /**
     * Interactions are optional modules that can be plugged in to a chart to
     * allow the user to interact with the chart and its data in special ways
     * 
     * @param interactions
     */
    public void setInteractions(AbstractInteraction... interactions) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (AbstractInteraction interaction : interactions) {
            values.push(interaction.getJsObj());
        }
        _setInteractions(values);
    }

    /**
     * Changes the data store bound to this chart and refreshes it.
     * 
     * @param store
     */
    public native void bindStore(Store store)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component
				.bindStore(store.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Cancel the last queued timeout
     */
    public native void cancel()/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.cancel();
    }-*/;

    /**
     * Cancels any pending timeout and queues a new one
     */
    public native void delay(double delay)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.delay(delay);
    }-*/;

    /**
     * Clean up the Surface instance on component destruction
     */
    public native void destroy()/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.destroy();
    }-*/;

    /**
     * Redraw the chart. If animations are set this will animate the chart too.
     */
    public native void redraw(boolean resize)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.redraw(resize);
    }-*/;

    /**
     * Redraw the chart. If animations are set this will animate the chart too.
     */
    public native void redraw()/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.redraw();
    }-*/;

    /**
     * Reset the chart back to its initial state, before any user interaction.
     */
    public native void reset(boolean skipRedraw)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.reset(skipRedraw);
    }-*/;

    /**
     * Used to save a chart.
     */
    public void save(SavingType type) {
        _save(createSaveType(type.getValue()));
    }

    protected void setTheme(String value) {
        setAttribute("theme", value, true);
    }

    /**
     * Fires before a refresh to the chart data is called. If the beforerefresh
     * handler returns false the refresh action will be cancelled.
     * 
     * @param handler
     */
    public native void addBeforeRefreshHandler(BeforeRefreshHandler handler)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component
				.addEventListener(
						@com.emitrom.gwt4.touch.charts.client.Chart::BEFORE_REFRESH,
						$entry(function(chart) {
							chartObject = @com.emitrom.gwt4.touch.charts.client.Chart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);
							handler.@com.emitrom.gwt4.touch.charts.client.handlers.BeforeRefreshHandler::onBeforeRefresh(Lcom/emitrom/gwt4/touch/charts/client/Chart;)(chartObject);
						}));
    }-*/;

    /**
     * Fires when a click event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemClickHandler(ChartEventHandler handler) {
        addHandler(ITEM_CLICK, handler);
    }

    /**
     * Fires when a doubleclick event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemDoubleClickHandler(ChartEventHandler handler) {
        addHandler(ITEM_DOUBLE_CLICK, handler);
    }

    /**
     * Fires when a doubletap event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemDoubleTapHandler(ChartEventHandler handler) {
        addHandler(ITEM_DOUBLE_TAP, handler);
    }

    /**
     * Fires when a drag event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemDraHandler(ChartEventHandler handler) {
        addHandler(ITEM_DRAG, handler);
    }

    /**
     * Fires when a dragend event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemDragEndHandler(ChartEventHandler handler) {
        addHandler(ITEM_DRAG_END, handler);
    }

    /**
     * Fires when a dragstart event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemDragStartHandler(ChartEventHandler handler) {
        addHandler(ITEM_DRAG_START, handler);
    }

    /**
     * Fires when a mousedown event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemMouseDownHandler(ChartEventHandler handler) {
        addHandler(ITEM_MOUSE_DOWN, handler);
    }

    /**
     * Fires when a mousemove event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemMouseMoveHandler(ChartEventHandler handler) {
        addHandler(ITEM_MOUSE_MOVE, handler);
    }

    /**
     * Fires when a mouseout event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemMouseOutHandler(ChartEventHandler handler) {
        addHandler(ITEM_MOUSE_OUT, handler);
    }

    /**
     * Fires when a mouseover event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemMouseOverHandler(ChartEventHandler handler) {
        addHandler(ITEM_MOUSE_OVER, handler);
    }

    /**
     * Fires when a mouseup event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemMouseUpHandler(ChartEventHandler handler) {
        addHandler(ITEM_MOUSE_UP, handler);
    }

    /**
     * Fires when a pinch event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemPinchHandler(ChartEventHandler handler) {
        addHandler(ITEM_PINCH, handler);
    }

    /**
     * Fires when a pinchend event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemPinchEndHandler(ChartEventHandler handler) {
        addHandler(ITEM_PINCH_END, handler);
    }

    /**
     * Fires when a pinchstart event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemPinchStartHandler(ChartEventHandler handler) {
        addHandler(ITEM_PINCH_START, handler);
    }

    /**
     * Fires when a singletap event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemSingleTapHandler(ChartEventHandler handler) {
        addHandler(ITEM_SINGLE_TAP, handler);
    }

    /**
     * Fires when a swipe event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemSwipeHandler(ChartEventHandler handler) {
        addHandler(ITEM_SWIPE, handler);
    }

    /**
     * Fires when a tap event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTapHandler(ChartEventHandler handler) {
        addHandler(ITEM_TAP, handler);
    }

    /**
     * Fires when a tapcancel event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTapCancelHandler(ChartEventHandler handler) {
        addHandler(ITEM_TAP_CANCEL, handler);
    }

    /**
     * Fires when a tapend event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTapEndHandler(ChartEventHandler handler) {
        addHandler(ITEM_TAP_END, handler);
    }

    /**
     * Fires when a taphold event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTapHoldHandler(ChartEventHandler handler) {
        addHandler(ITEM_TAP_HOLD, handler);
    }

    /**
     * Fires when a tapstart event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTapStartHandler(ChartEventHandler handler) {
        addHandler(ITEM_TAP_START, handler);
    }

    /**
     * Fires when a touchend event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTouchEndHandler(ChartEventHandler handler) {
        addHandler(ITEM_TOUCH_END, handler);
    }

    /**
     * Fires when a touchmove event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTouchMoveHandler(ChartEventHandler handler) {
        addHandler(ITEM_TOUCH_MOVE, handler);
    }

    /**
     * Fires when a touchstart event occurs on a series item.
     * 
     * @param handler
     */
    public void addItemTouchStartHandler(ChartEventHandler handler) {
        addHandler(ITEM_TOUCH_START, handler);
    }

    /**
     * Fires after the chart is redrawn.
     * 
     * @param handler
     */
    public void addRedrawHandler(ChartChangeHandler handler) {
        addChangeHandler(REDRAW, handler);
    }

    /**
     * Fires after the chart data has been refreshed.
     * 
     * @param handler
     */
    public void addRefreshHandler(ChartChangeHandler handler) {
        addChangeHandler(REFRESH, handler);
    }

    private native void _save(JavaScriptObject type)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component.save(type);
    }-*/;

    private void _setInteractions(JavaScriptObject value) {
        setAttribute("interactions", value, true);
    }

    private native JavaScriptObject createFill(String value)/*-{
		return {
			fill : value
		};
    }-*/;

    private native JavaScriptObject createSaveType(String value)/*-{
		return {
			type : value
		};
    }-*/;

    private native JavaScriptObject createImage(String value)/*-{
		return {
			image : value
		};
    }-*/;

    private native JavaScriptObject createGradient(JavaScriptObject obj)/*-{
		return {
			gradient : obj
		};
    }-*/;

    private native void addHandler(String event, ChartEventHandler handler)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component
				.addEventListener(
						event,
						$entry(function(series, item, e) {
							var seriesObject = @com.emitrom.gwt4.touch.charts.client.series.AbstractSerie::new(Lcom/google/gwt/core/client/JavaScriptObject;)(series);
							var chartItem = @com.emitrom.gwt4.touch.charts.client.interactions.ChartItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
							var eventObject = @com.emitrom.gwt4.touch.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							chartObject = @com.emitrom.gwt4.touch.charts.client.Chart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);

							handler.@com.emitrom.gwt4.touch.charts.client.handlers.ChartEventHandler::onEvent(Lcom/emitrom/gwt4/touch/charts/client/series/BaseSeries;Lcom/emitrom/gwt4/touch/charts/client/interactions/ChartItem;Lcom/emitrom/gwt4/touch/client/core/EventObject;)(seriesObject, chartItem, eventObject);
						}));
    }-*/;

    private native void addChangeHandler(String event, ChartChangeHandler handler)/*-{
		var component = this.@com.emitrom.gwt4.touch.client.core.Component::getOrCreateJsObj()();
		component
				.addEventListener(
						event,
						$entry(function(chart) {
							chartObject = @com.emitrom.gwt4.touch.charts.client.Chart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(chart);
							handler.@com.emitrom.gwt4.touch.charts.client.handlers.ChartChangeHandler::onEvent(Lcom/emitrom/gwt4/touch/charts/client/Chart;)(chartObject);
						}));
    }-*/;

}
