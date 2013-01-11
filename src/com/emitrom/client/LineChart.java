/**************************************************************************
   LineChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.gwt4.touch.charts.client.Chart;
import com.emitrom.gwt4.touch.charts.client.ChartPanel;
import com.emitrom.gwt4.touch.charts.client.HighLight;
import com.emitrom.gwt4.touch.charts.client.Legend;
import com.emitrom.gwt4.touch.charts.client.axis.CategoryAxis;
import com.emitrom.gwt4.touch.charts.client.axis.NumericAxis;
import com.emitrom.gwt4.touch.charts.client.handlers.ItemShowHandler;
import com.emitrom.gwt4.touch.charts.client.interactions.ChartItem;
import com.emitrom.gwt4.touch.charts.client.interactions.ItemInfo;
import com.emitrom.gwt4.touch.charts.client.interactions.PanZoom;
import com.emitrom.gwt4.touch.charts.client.interactions.PanzoomAxis;
import com.emitrom.gwt4.touch.charts.client.interactions.PanzoomOrientation;
import com.emitrom.gwt4.touch.charts.client.laf.GridConfig;
import com.emitrom.gwt4.touch.charts.client.laf.SpriteConfig;
import com.emitrom.gwt4.touch.charts.client.marker.Circle;
import com.emitrom.gwt4.touch.charts.client.marker.Cross;
import com.emitrom.gwt4.touch.charts.client.series.LineSeries;
import com.emitrom.gwt4.touch.client.core.EventObject;
import com.emitrom.gwt4.touch.client.core.handlers.button.TapHandler;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.laf.Alignment;
import com.emitrom.gwt4.touch.client.laf.Color;
import com.emitrom.gwt4.touch.client.laf.Position;
import com.emitrom.gwt4.touch.client.laf.UI;
import com.emitrom.gwt4.touch.client.ui.Button;
import com.emitrom.gwt4.touch.client.ui.Panel;
import com.emitrom.gwt4.touch.client.utils.TouchIcons;

public class LineChart {

    private static Store store = ChartDataUtil.getData();

    public static ChartPanel get() {
        final Chart chart = new Chart(store);
        chart.setAnimate(true);
        chart.setLegend(new Legend(Position.RIGHT));

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setTitle("Number of Hits");

        SpriteConfig config = new SpriteConfig();
        config.setOpacity(1);
        config.setFill(new Color("#ddd"));
        config.setStroke(new Color("#bbb"));
        config.setStrokeWidth(0.5);

        numericAxis.setGrid(new GridConfig(config));
        numericAxis.setMinimum(0);
        numericAxis.setMaximum(100);
        numericAxis.setMinorTickSteps(1);
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setFields("data1", "data2", "data3");

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setTitle("Month of the year");
        categoryAxis.setFields("name");

        chart.setAxes(numericAxis, categoryAxis);

        LineSeries serie1 = new LineSeries();
        serie1.setXField("name");
        serie1.setYField("data1");
        serie1.setAxis(Alignment.LEFT);
        serie1.setFill(true);
        serie1.setHighlight(new HighLight(7, 7));
        serie1.setMarker(new Cross(4, 4));
        serie1.setSmooth(true);

        LineSeries serie2 = new LineSeries();
        serie2.setXField("name");
        serie2.setYField("data2");
        serie2.setAxis(Alignment.LEFT);
        serie2.setHighlight(new HighLight(7, 7));
        serie2.setMarker(new Circle(4, 4));
        serie2.setSmooth(true);

        LineSeries serie3 = new LineSeries();
        serie3.setXField("name");
        serie3.setYField("data3");
        serie3.setAxis(Alignment.LEFT);
        serie3.setFill(true);
        serie3.setHighlight(new HighLight(7, 7));
        serie3.setMarker(new Circle(4, 4));
        serie3.setSmooth(true);

        chart.setSeries(serie1, serie2, serie3);

        ItemInfo itemInfo = new ItemInfo();
        itemInfo.addItemShowHandler(new ItemShowHandler() {
            @Override
            public void onItemShow(ItemInfo itemInfo, ChartItem item, Panel panel) {
                panel.setHtml("<ul><li>Month: <b>" + item.getStoreItem().get("name") + "</b></li><li>Value : <b>"
                                + item.getValue().getString(1) + "</b></li></ul>");
            }
        });

        PanZoom panzoom = new PanZoom();
        panzoom.setAxes(new PanzoomAxis(PanzoomOrientation.BOTH));
        chart.setInteractions(itemInfo, panzoom);

        Button button = new Button();
        button.setIconCls(TouchIcons.SHUFFLE);
        button.setIconMask(true);
        button.setUi(UI.PLAIN);
        button.addTapHandler(new TapHandler() {
            @Override
            public void onTap(Button button, EventObject event) {
                store.setData(ChartDataUtil.getValues(6, 20));
            }
        });

        ChartPanel chartPanel = new ChartPanel("Line Chart", chart);
        chartPanel.addButton(button);

        return chartPanel;
    }
}
