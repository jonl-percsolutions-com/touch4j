/**************************************************************************
 * Select.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.ui;

import java.util.List;

import com.emitrom.touch4j.client.core.config.Event;
import com.emitrom.touch4j.client.core.config.SelectConfig;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.core.handlers.CallbackRegistration;
import com.emitrom.touch4j.client.core.handlers.field.select.SelectChangeHandler;
import com.emitrom.touch4j.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Select<T> extends Text<T> implements HasStore {

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.field.Select();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.RADIO_FIELD.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.field.Select(config);
    }-*/;

    public Select(SelectConfig selectConfig) {
        super(selectConfig.getJsObj());
    }

    public Select() {
    }

    public Select(Store store) {
        setStore(store);
    }

    protected Select(JavaScriptObject jso) {
        super(jso);
    }

    /**
     * Returns the value of displayField.
     * 
     * @param <T>
     * @return
     */
    public native T getDisplayField() /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getDisplayField();
		}
    }-*/;

    /**
     * Returns the value of hiddenName.
     * 
     * @return
     */
    public native String getHiddenName() /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getHiddenName();
		}
    }-*/;

    /**
     * Returns the value of options.
     * 
     * @return
     */
    public native JsArray<JavaScriptObject> getOptions() /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getOptions();
		}
    }-*/;

    /**
     * Returns the value of valueField.
     * 
     * @param <T>
     * @return
     */
    public native T getValueField() /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			return field.getValueField();
		}
    }-*/;

    /**
     * Sets the value of displayField.
     * 
     * @param value
     */
    public native void setDisplayField(String value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setDisplayField(value);
		}
    }-*/;

    /**
     * Sets the value of displayField.
     * 
     * @param value
     */
    public native void setDisplayField(double value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setDisplayField(value);
		}
    }-*/;

    /**
     * Sets the value of hiddenName.
     * 
     * @param value
     */
    public native void setHiddenName(String value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setHiddenName(value);
		}
    }-*/;

    /**
     * Sets the value of options.
     * 
     * @param value
     */
    public native void setOptions(JsArray<JavaScriptObject> value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setOptions(value);
		}
    }-*/;

    /**
     * Sets the value of valueField.
     * 
     * @param value
     */
    public native void setValueField(double value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValueField(value);
		}
    }-*/;

    /**
     * Sets the value of valueField.
     * 
     * @param value
     */
    public native void setValueField(String value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.setValueField(value);
		}
    }-*/;

    /**
     * Updates the underlying <options> list with new values.
     * 
     * @param value
     */
    public native void updateOptions(JsArray<JavaScriptObject> value) /*-{
		var field = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (field != null) {
			field.updateOptions(value);
		}
    }-*/;

    /**
     * Fires when an option selection has changed
     * 
     * @param handler
     */
    public CallbackRegistration addChangeHandler(SelectChangeHandler handler) {
        return this.addWidgetListener(Event.CHANGE.getValue(), handler.getJsoPeer());
    }

    public void setStore(Store store) {
        setStore(store.getJsObj());
    }

    public native Store getStore()/*-{
		var select = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var store = select.getStore();
		return @com.emitrom.touch4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
    }-*/;

    public void setOptions(List<SelectOption> options) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (SelectOption option : options) {
            array.push(option.getJsObj());
        }
        setOptions(array);
    }

    public void setOptions(SelectOption... options) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (SelectOption option : options) {
            array.push(option.getJsObj());
        }
        setOptions(options);
    }

    private void setOptions(JavaScriptObject options) {
        setAttribute("options", options, true);
    }

    private native void setStore(JavaScriptObject value)/*-{
		var select = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		select.setStore(value);
    }-*/;

}