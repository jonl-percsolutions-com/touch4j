/**************************************************************************
   RadarChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.touch4j.charts.client.Legend;
import com.emitrom.touch4j.charts.client.axis.RadialAxis;
import com.emitrom.touch4j.charts.client.interactions.PieRotate;
import com.emitrom.touch4j.charts.client.interactions.Reset;
import com.emitrom.touch4j.charts.client.laf.Label;
import com.emitrom.touch4j.charts.client.series.RadarSeries;
import com.emitrom.touch4j.charts.client.theme.Theme;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.laf.Position;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.Chart;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.ui.Spacer;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class RadarChart {

    private static Store store = ChartDataUtil.getStore(12, 20);

    public static Panel get() {
        Panel p = new Panel(new FitLayout());
        ToolBar toolBar = new ToolBar();
        toolBar.setTitle("Radar");

        Button button = new Button();
        button.setIconCls(TouchIcons.SHUFFLE);
        button.setIconMask(true);
        button.setUi(UI.PLAIN);
        button.addTapHandler(new TapHandler() {
            @Override
            public void onTap(Button button, EventObject event) {
                store.setData(ChartDataUtil.getColumnChartValues(12, 20));
            }
        });
        toolBar.add(new Spacer());
        toolBar.add(button);
        p.add(toolBar);

        final Chart chart = new Chart(store);
        chart.setTheme(Theme.DEFAULT);
        chart.setThemeCls("radar1");
        chart.setAnimate(true);
        chart.setInsetPadding(20);
        chart.setLegend(new Legend(Position.LEFT));
        chart.setInteractions(new Reset(), new PieRotate());

        RadialAxis radialAxis = new RadialAxis();
        Label label = new Label();
        label.setDisplay(true);
        radialAxis.setLabel(label);
        chart.setAxes(radialAxis);

        RadarSeries radarSeries = new RadarSeries();
        radarSeries.setXField("name");
        radarSeries.setYField("2007");

        label = new Label();
        label.setDisplay("rotate");
        label.setField("2007");
        radarSeries.setLabel(label);

        RadarSeries radarSeries2 = new RadarSeries();
        radarSeries2.setXField("name");
        radarSeries2.setYField("2008");
        radarSeries2.setShowInLegend(true);

        RadarSeries radarSeries3 = new RadarSeries();
        radarSeries3.setXField("name");
        radarSeries3.setYField("2009");
        radarSeries3.setShowInLegend(true);

        chart.setSeries(radarSeries, radarSeries2, radarSeries3);
        p.add(chart);

        return p;
    }
}
