/**************************************************************************
 * NativeUberGrid.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 **************************************************************************/
package com.emitrom.touch4j.ux.ubergrid.client.core;

import java.util.List;

import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class NativeUberGrid extends Container {

    protected NativeUberGrid(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native void init()/*-{
		
    }-*/;

    protected NativeUberGrid() {
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.UberGrid.Panel(config);
    }-*/;

    public static NativeUberGrid newInstance(Store store, List<UberGridColumn> cols) {
        JavaScriptObject obj = _createNative(store.getJsObj(), UberGridColumn.fromValues(cols));
        return new NativeUberGrid(obj);
    }

    public static NativeUberGrid newInstance(Store store, List<UberGridColumn> cols, List<String> features) {
        JsArrayString values = JsArrayString.createArray().cast();
        for (String s : features) {
            values.push(s);
        }
        JavaScriptObject obj = _createNative(store.getJsObj(), UberGridColumn.fromList(cols), values);
        return new NativeUberGrid(obj);
    }

    @Override
    public String getXType() {
        return "ubergrid";
    }

    public native void toggleColumn(int index)/*-{
		var grid = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		grid.toggleColumn(index);
    }-*/;

    public native void hideColumn(int index)/*-{
		var grid = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		grid.hideColumn(index);
    }-*/;

    public native void showColumn(int index)/*-{
		var grid = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		grid.showColumn(index);
    }-*/;

    public List<UberGridColumn> getColumns() {
        return null;
        // return UberGridColumn.fromJsArray(_getColumns());
    }

    private static native JavaScriptObject _createNative(JavaScriptObject store, JavaScriptObject cols)/*-{
		var grid = $wnd.Ext.create('UberGrid.Panel', {
			store : store,
			columns : cols
		});
		return grid;
    }-*/;

    private static native JavaScriptObject _createNative(JavaScriptObject store, JavaScriptObject cols,
                    JsArrayString array)/*-{
		var config = {};
		config.store = store;
		config.columns = cols;
		var grid = $wnd.Ext.create('UberGrid.Panel', config);
		return grid;
    }-*/;

}
