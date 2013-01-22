/**************************************************************************
   PieChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
import com.emitrom.touch4j.charts.client.handlers.ItemShowHandler;
import com.emitrom.touch4j.charts.client.interactions.ChartItem;
import com.emitrom.touch4j.charts.client.interactions.ItemHighlight;
import com.emitrom.touch4j.charts.client.interactions.ItemInfo;
import com.emitrom.touch4j.charts.client.interactions.PieRotate;
import com.emitrom.touch4j.charts.client.interactions.Reset;
import com.emitrom.touch4j.charts.client.laf.Label;
import com.emitrom.touch4j.charts.client.series.PieSeries;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.laf.Position;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.Chart;
import com.emitrom.touch4j.client.ui.ChartPanel;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class PieChart {

    private static Store store = ChartDataUtil.getColumnChartData();

    public static ChartPanel get() {
        final Chart chart = new Chart(store);
        chart.setThemeCls("pie1");
        chart.setAnimate(true);
        chart.setInsetPadding(20);
        chart.setLegend(new Legend(Position.LEFT));

        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setGesture("longpress");
        itemInfo.addItemShowHandler(new ItemShowHandler() {
            @Override
            public void onItemShow(ItemInfo itemInfo, ChartItem item, Panel panel) {
                panel.setHtml("<ul><li>Month: <b>" + item.getStoreItem().get("name") + "</b></li><li>Value : <b>"
                                + "</b></li></ul>");

            }
        });
        chart.setInteractions(new PieRotate(), new Reset(), new ItemHighlight(), itemInfo);

        PieSeries pieSeries = new PieSeries();
        pieSeries.setAngleField("data1");
        pieSeries.setField("2007");
        pieSeries.setDonut(20);
        pieSeries.setShowInLegend(false);
        pieSeries.setHighlight(true);

        Label label = new Label();
        label.setField("name");
        pieSeries.setLabel(label);

        chart.setSeries(pieSeries);

        ChartPanel panel = new ChartPanel("Pie", chart);

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
        panel.addButton(button);

        return panel;
    }
}
