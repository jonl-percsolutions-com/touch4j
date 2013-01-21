/**************************************************************************
   ListDataViewTest.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.config.Dock;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.ListDataView;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.google.gwt.user.client.Timer;

public class ListDataViewTest {

    public static Panel get() {
        final ListDataView list = new ListDataView("{name}", new MyStore(Company.getList()));

        ToolBar toolBar = new ToolBar(Dock.TOP);
        toolBar.setTitle("Users");

        toolBar.add(new Button("Test", UI.ACTION, new TapHandler() {
            @Override
            public void onTap(Button button, EventObject event) {
                final MyStore store = (MyStore) list.getStore();
                store.test();

                new Timer() {
                    @Override
                    public void run() {
                        Company model = (Company) store.getAt(0);
                        model.setName("Yes baby");

                        Company c = new Company();
                        c.setName("Google Inc");
                        list.getStore().insert(1, c);

                        list.refresh();

                    }
                }.schedule(2000);
            }
        }));

        Panel p = new Panel(new FitLayout());
        p.add(toolBar);
        p.add(list);
        return p;

    }
}
