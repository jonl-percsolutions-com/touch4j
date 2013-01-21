/**************************************************************************
   ChartDataUtil.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import java.util.ArrayList;

import com.emitrom.touch4j.client.data.Store;

public class ChartDataUtil {

    private static String[] months = {
                    "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                    "Novemver", "December"};

    public static ArrayList<ChartValue> getValues(int n, int floor) {
        floor = 10;
        ArrayList<ChartValue> values = new ArrayList<ChartValue>();
        ChartValue value = null;
        for (int i = 0; i < n; i++) {
            value = new ChartValue();
            value.setName(months[i % 12]);
            value.setData1(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData2(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData3(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData4(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData5(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData6(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData7(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData8(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData9(Math.floor(Math.max((Math.random() * 100), floor)));
            values.add(value);
        }

        return values;
    }

    public static ArrayList<ColumnChartValue> getColumnChartValues(int n, int floor) {
        floor = 10;
        ArrayList<ColumnChartValue> values = new ArrayList<ColumnChartValue>();
        ColumnChartValue value = null;
        for (int i = 0; i < n; i++) {
            value = new ColumnChartValue();
            value.setName(months[i % 12]);
            value.setData1(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData2(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setData3(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2003(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2004(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2005(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2006(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2007(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2008(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2009(Math.floor(Math.max((Math.random() * 100), floor)));
            value.set2010(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setIphone(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setAndroid(Math.floor(Math.max((Math.random() * 100), floor)));
            value.setIpad(Math.floor(Math.max((Math.random() * 100), floor)));
            values.add(value);
        }

        return values;
    }

    public static Store getData() {
        return new Store(getValues(6, 20));
    }

    public static Store getColumnChartData() {
        return new Store(getColumnChartValues(5, 20));
    }

    public static Store getStore(int n, int floor) {
        return new Store(getColumnChartValues(n, floor));
    }

}
