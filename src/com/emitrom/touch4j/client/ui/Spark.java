/**************************************************************************
 * Spark.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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

import com.emitrom.touch4j.charts.client.theme.Theme;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Spark Chart provides small sized charts. This class extends the
 * {@link com.emitrom.touch4j.client.ui.Chart} class with default configuration
 * options needed to create word-sized charts.
 */
public class Spark extends Chart {

    private static JavaScriptObject configPrototype;
    private Store store;

    public native void init()/*-{
		var c = new $wnd.Ext.chart.Spark();
		@com.emitrom.touch4j.client.ui.Spark::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.CHART.getValue();
    }

    /**
     * Create a new Panel.
     */
    public Spark() {
        init();
    }

    public Spark(Store store) {
        setStore(store);
        setTheme(Theme.BASE);
    }

    public Spark(Store store, Theme theme) {
        setStore(store);
        setTheme(theme);
    }

    protected Spark(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.chart.Spark(config);
    }-*/;

}
