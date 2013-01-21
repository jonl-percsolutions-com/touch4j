/**************************************************************************
   Grid.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.ux.grid.client;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.ui.Container;
import com.emitrom.touch4j.client.ui.DataView;
import com.emitrom.touch4j.ux.grid.client.core.GridColumn;
import com.emitrom.touch4j.ux.grid.client.core.GridFeature;
import com.emitrom.touch4j.ux.grid.client.core.NativeGrid;

public class Grid {

	private NativeGrid widget;

	public Grid(Store store, List<GridColumn> cols) {
		widget = NativeGrid.newInstance(store, cols);
	}

	public Grid(Store store, List<GridFeature> features, GridColumn... cols) {
		List<GridColumn> columns = new ArrayList<GridColumn>();
		List<String> values = new ArrayList<String>();
		for (GridColumn column : cols) {
			columns.add(column);
		}
		for (GridFeature feature : features) {
			values.add(feature.getValue());
		}
		widget = NativeGrid.newInstance(store, columns, values);
	}

	public Grid(Store store, List<GridColumn> cols, List<GridFeature> features) {
		List<String> values = new ArrayList<String>();
		for (GridFeature feature : features) {
			values.add(feature.getValue());
		}
		widget = NativeGrid.newInstance(store, cols, values);
	}

	public Grid(Store store, List<GridColumn> cols, GridFeature... features) {
		List<String> values = new ArrayList<String>();
		for (GridFeature feature : features) {
			values.add(feature.getValue());
		}
		widget = NativeGrid.newInstance(store, cols, values);
	}

	public void addTo(Container container) {
		container.add(this.widget);
	}

	public GridColumn getColumn(int index) {
		return widget.getColumn(index);
	}

	public List<GridColumn> getColumns() {
		return widget.getColumns();
	}

	public DataView getView() {
		return this.widget;
	}

	public void toggleColumn(int index) {
		widget.toggleColumn(index);
	}

	public void showColumn(int index) {
		widget.showColumn(index);
	}

	public void hideColumn(int index) {
		widget.hideColumn(index);
	}

}
