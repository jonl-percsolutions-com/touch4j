/**************************************************************************
   ColumnChart.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
import com.emitrom.gwt4.touch.charts.client.ChartPanel;
import com.emitrom.gwt4.touch.charts.client.axis.CategoryAxis;
import com.emitrom.gwt4.touch.charts.client.axis.NumericAxis;
import com.emitrom.gwt4.touch.charts.client.laf.BarAttribute;
import com.emitrom.gwt4.touch.charts.client.laf.Gradient;
import com.emitrom.gwt4.touch.charts.client.laf.Label;
import com.emitrom.gwt4.touch.charts.client.series.ColumnSeries;
import com.emitrom.gwt4.touch.charts.client.series.renderers.SeriesRenderer;
import com.emitrom.gwt4.touch.client.core.EventObject;
import com.emitrom.gwt4.touch.client.core.handlers.button.TapHandler;
import com.emitrom.gwt4.touch.client.data.BaseModel;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.draw.Sprite;
import com.emitrom.gwt4.touch.client.fx.layout.card.Easing;
import com.emitrom.gwt4.touch.client.laf.Color;
import com.emitrom.gwt4.touch.client.laf.Position;
import com.emitrom.gwt4.touch.client.laf.RGB;
import com.emitrom.gwt4.touch.client.laf.UI;
import com.emitrom.gwt4.touch.client.ui.Button;
import com.emitrom.gwt4.touch.client.utils.TouchIcons;

public class ColumnChart {

    private static Store store = ChartDataUtil.getColumnChartData();

    public static ChartPanel get() {
        final Chart chart = new Chart(store);
        chart.setAnimate(new Animation(750, Easing.BOUNCE_OUT));

        Gradient gradient1 = new Gradient("v-1", 0);
        gradient1.setStops(new RGB(212, 40, 40), new RGB(117, 14, 14));

        Gradient gradient2 = new Gradient();
        gradient2.setId("v-2");
        gradient2.setAngle(0);
        gradient2.setStops(new RGB(180, 216, 42), new RGB(94, 114, 13));

        Gradient gradient3 = new Gradient();
        gradient3.setId("v-3");
        gradient3.setAngle(0);
        gradient3.setStops(new RGB(43, 221, 115), new RGB(14, 117, 56));

        Gradient gradient4 = new Gradient();
        gradient4.setId("v-4");
        gradient4.setAngle(0);
        gradient4.setStops(new RGB(45, 117, 226), new RGB(14, 56, 117));

        Gradient gradient5 = new Gradient();
        gradient5.setId("v-5");
        gradient5.setAngle(0);
        gradient5.setStops(new RGB(187, 45, 222), new RGB(85, 10, 103));

        chart.setGradients(gradient1, gradient2, gradient3, gradient4, gradient5);

        NumericAxis axis = new NumericAxis();
        axis.setPosition(Position.LEFT);
        axis.setFields("2009");
        axis.setMinimum(0);
        axis.setMaximum(100);
        axis.setTitle("Number of Hits");
        axis.setGrid(new Color("#555"), new Color("#777"));

        CategoryAxis axis2 = new CategoryAxis();
        axis2.setPosition(Position.BOTTOM);
        axis2.setFields("name");
        axis2.setTitle("Month of the Year");

        chart.setAxes(axis, axis2);

        final Color[] colors = {gradient1, gradient2, gradient3, gradient4, gradient5};

        final ColumnSeries serie = new ColumnSeries();
        serie.setAxis("left");
        serie.setHighlight(true);
        serie.setXField("name");
        serie.setYField("2009");

        Label label = new Label();
        label.setField("2009");
        serie.setLabel(label);
        serie.setRenderer(new SeriesRenderer() {
            @Override
            public void onRender(Sprite sprite, BaseModel record, BarAttribute attributes, int index, Store store) {
                attributes.setFill(colors[index % colors.length]);
            }
        });
        chart.setSeries(serie);

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
        ChartPanel chartPanel = new ChartPanel("Column Chart", chart);
        chartPanel.addButton(button);

        return chartPanel;
    }
}
