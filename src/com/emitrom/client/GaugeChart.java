/**************************************************************************
   GaugeChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.client;

import com.emitrom.gwt4.touch.charts.client.Animation;
import com.emitrom.gwt4.touch.charts.client.Chart;
import com.emitrom.gwt4.touch.charts.client.axis.GaugeAxis;
import com.emitrom.gwt4.touch.charts.client.series.GaugeSeries;
import com.emitrom.gwt4.touch.client.core.EventObject;
import com.emitrom.gwt4.touch.client.core.handlers.button.TapHandler;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.fx.layout.card.Easing;
import com.emitrom.gwt4.touch.client.laf.Color;
import com.emitrom.gwt4.touch.client.laf.UI;
import com.emitrom.gwt4.touch.client.layout.FitLayout;
import com.emitrom.gwt4.touch.client.ui.Button;
import com.emitrom.gwt4.touch.client.ui.Panel;
import com.emitrom.gwt4.touch.client.ui.Spacer;
import com.emitrom.gwt4.touch.client.ui.ToolBar;
import com.emitrom.gwt4.touch.client.utils.TouchIcons;

public class GaugeChart {

    private static Store store = ChartDataUtil.getStore(5, 20);

    public static Panel get() {
        Panel p = new Panel(new FitLayout());
        ToolBar toolBar = new ToolBar();
        toolBar.setTitle("Gauge");

        Button button = new Button();
        button.setIconCls(TouchIcons.SHUFFLE);
        button.setIconMask(true);
        button.setUi(UI.PLAIN);
        button.addTapHandler(new TapHandler() {
            @Override
            public void onTap(Button button, EventObject event) {
                store.setData(ChartDataUtil.getColumnChartValues(5, 20));
            }
        });
        toolBar.add(new Spacer());
        toolBar.add(button);
        p.add(toolBar);

        final Chart chart = new Chart(store);
        // chart.setTheme(Theme.DEFAULT);
        // chart.setThemeCls("scatter1");
        Animation animation = new Animation(500, Easing.ELASTIC_IN);
        chart.setAnimate(animation);

        GaugeAxis gaugeAxis = new GaugeAxis();
        gaugeAxis.setMinimum(0);
        gaugeAxis.setMaximum(100);
        gaugeAxis.setSteps(10);
        gaugeAxis.setMargin(10);
        chart.addAxis(gaugeAxis);

        GaugeSeries gaugeSeries = new GaugeSeries();
        gaugeSeries.setField("data1");
        gaugeSeries.setDonut(55);
        gaugeSeries.setColorSet(new Color("#2582B5"), new Color("#555"));
        chart.addSeries(gaugeSeries);

        p.add(chart);

        return p;
    }
}
