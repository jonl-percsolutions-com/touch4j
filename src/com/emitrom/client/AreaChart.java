/**************************************************************************
   AreaChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
import com.emitrom.touch4j.charts.client.axis.CategoryAxis;
import com.emitrom.touch4j.charts.client.axis.NumericAxis;
import com.emitrom.touch4j.charts.client.interactions.PieRotate;
import com.emitrom.touch4j.charts.client.interactions.Reset;
import com.emitrom.touch4j.charts.client.laf.LegendPosition;
import com.emitrom.touch4j.charts.client.series.AreaSeries;
import com.emitrom.touch4j.charts.client.theme.Theme;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.laf.Alignment;
import com.emitrom.touch4j.client.laf.Position;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.Chart;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.ui.Spacer;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class AreaChart {

    private static Store store = ChartDataUtil.getStore(5, 20);

    public static Panel get() {
        Panel p = new Panel(new FitLayout());
        ToolBar toolBar = new ToolBar();
        toolBar.setTitle("Area");

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
        chart.setTheme(Theme.DEFAULT);
        chart.setThemeCls("area1");
        chart.setAnimate(true);

        LegendPosition position = new LegendPosition();
        position.setPortrait(Position.RIGHT);
        position.setLandscape(Position.BOTTOM);
        Legend legend = new Legend(position);

        chart.setLegend(legend);
        chart.setInteractions(new Reset(), new PieRotate());

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setFields("2003", "2004", "2005", "2006", "2007", "2008", "2009");
        numericAxis.setTitle("Number of Hits");
        numericAxis.setMinimum(0);
        numericAxis.setAdjustMinimumByMajorUnit(false);
        chart.addAxis(numericAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        chart.addAxis(categoryAxis);

        AreaSeries areaSeries = new AreaSeries();
        areaSeries.setHighlight(true);
        areaSeries.setAxis(Alignment.LEFT);
        areaSeries.setXField("name");
        areaSeries.setYField("2003", "2004", "2005", "2006", "2007", "2008", "2009");
        chart.addSeries(areaSeries);

        p.add(chart);

        return p;
    }
}
