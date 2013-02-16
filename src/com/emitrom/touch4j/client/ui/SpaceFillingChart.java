/**************************************************************************
 * AbstractChart.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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

import com.emitrom.touch4j.charts.client.AbstractChart;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Creates a chart that fills the entire area of the chart. e.g. Treemap
 */
public class SpaceFillingChart extends AbstractChart {

    protected static JavaScriptObject configPrototype;

    protected native void init()/*-{
		var c = new $wnd.Ext.chart.SpaceFillingChart();
		@com.emitrom.touch4j.client.ui.SpaceFillingChart::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.SPACE_FILLING_CHART.getValue();
    }

    /**
     * Create a new AbstractChart Panel.
     */
    public SpaceFillingChart() {

    }

    public SpaceFillingChart(Store store) {
        setStore(store);
        // setTheme(Theme.BASE);
    }

    protected SpaceFillingChart(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.chart.SpaceFillingChart(config);
    }-*/;

    public static SpaceFillingChart cast(AbstractChart chart) {
        return new SpaceFillingChart(chart.getOrCreateJsObj());
    }

}
