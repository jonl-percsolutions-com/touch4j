/**************************************************************************
   BarChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.touch4j.charts.client.Animation;
import com.emitrom.touch4j.charts.client.Chart;
import com.emitrom.touch4j.charts.client.ChartPanel;
import com.emitrom.touch4j.charts.client.Legend;
import com.emitrom.touch4j.charts.client.axis.CategoryAxis;
import com.emitrom.touch4j.charts.client.axis.NumericAxis;
import com.emitrom.touch4j.charts.client.handlers.ItemCompareInteractionHandler;
import com.emitrom.touch4j.charts.client.handlers.ItemShowHandler;
import com.emitrom.touch4j.charts.client.interactions.ChartItem;
import com.emitrom.touch4j.charts.client.interactions.ItemCompare;
import com.emitrom.touch4j.charts.client.interactions.ItemHighlight;
import com.emitrom.touch4j.charts.client.interactions.ItemInfo;
import com.emitrom.touch4j.charts.client.interactions.OffsetValue;
import com.emitrom.touch4j.charts.client.interactions.PanZoom;
import com.emitrom.touch4j.charts.client.interactions.Reset;
import com.emitrom.touch4j.charts.client.interactions.ToggleStacked;
import com.emitrom.touch4j.charts.client.series.BarSeries;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.fx.layout.card.AnimationType;
import com.emitrom.touch4j.client.fx.layout.card.Easing;
import com.emitrom.touch4j.client.laf.Alignment;
import com.emitrom.touch4j.client.laf.Position;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class BarChart {

    private static Store store = ChartDataUtil.getColumnChartData();
    private static ChartPanel panel;

    public static ChartPanel get() {
        final Chart chart = new Chart(store);
        chart.setAnimate(new Animation(750, Easing.BOUNCE_OUT));

        Legend legend = new Legend(Position.RIGHT);
        legend.setLabelFont("20 px Arial");
        chart.setLegend(legend);

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.BOTTOM);
        numericAxis.setFields("2008", "2009", "2010");
        numericAxis.setTitle("Number of Hits");
        numericAxis.setMinimum(0);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.LEFT);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        chart.setAxes(numericAxis, categoryAxis);

        BarSeries barSeries = new BarSeries();
        barSeries.setXField("name");
        barSeries.setYField("2008", "2009", "2010");
        barSeries.setAxis(Alignment.BOTTOM);
        barSeries.setHighlight(true);
        barSeries.setShowInLegend(true);
        chart.setSeries(barSeries);

        ItemCompare itemCompare = new ItemCompare();
        itemCompare.setOffset(new OffsetValue(-10));
        itemCompare.addInteractionHandler(new ItemCompareInteractionHandler() {
            @Override
            public void onShow(ItemCompare itemCompare) {
                ChartItem firstItem = itemCompare.getFirtsItem();
                ChartItem secondItem = itemCompare.getSecondItem();
                panel.setDescriptionTitle(firstItem.getValue().getString(0)
                                + " to "
                                + secondItem.getValue().getString(0)
                                + " : "
                                + Math.round((secondItem.getValue().getNumber(1) - firstItem.getValue().getNumber(1))
                                                / firstItem.getValue().getNumber(1) * 100) + "%");
                panel.getHeaderPanel().getLayout().setAnimation(AnimationType.SLIDE);
                panel.getHeaderPanel().setActiveItem(1);

            }

            @Override
            public void onHide() {
                panel.getHeaderPanel().getLayout().getAnimation().setReverse(true);
                panel.getHeaderPanel().setActiveItem(0);
            }
        });

        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setGesture("longpress");
        itemInfo.addItemShowHandler(new ItemShowHandler() {
            @Override
            public void onItemShow(ItemInfo itemInfo, ChartItem item, Panel panel) {
                panel.removeAll();

                ToolBar toolBar = new ToolBar("Details");
                panel.add(toolBar);

                String html = "<ul>";
                html += "<li><b>Month : </b>" + item.getValue().getString(0) + "</li>";
                html += "<li><b>Value : </b>" + item.getValue().getNumber(1) + "</li>";
                html += "</li>";
                panel.setHtml(html);
            }
        });
        chart.setInteractions(new Reset(), new ToggleStacked(), new PanZoom(), new ItemHighlight(), itemInfo,
                        itemCompare);

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

        panel = new ChartPanel("Bar Chart", chart);
        panel.addButton(button);

        return panel;
    }
}
