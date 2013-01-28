/**************************************************************************
 * Picker.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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

import java.util.ArrayList;
import java.util.List;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.emitrom.touch4j.client.core.config.Event;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.core.handlers.CallbackRegistration;
import com.emitrom.touch4j.client.core.handlers.picker.PickerCancelHandler;
import com.emitrom.touch4j.client.core.handlers.picker.PickerChangeHandler;
import com.emitrom.touch4j.client.core.handlers.picker.PickerPickHandler;
import com.emitrom.touch4j.client.data.BaseModel;
import com.emitrom.touch4j.client.data.PickerSlot;
import com.emitrom.touch4j.client.data.PickerSlotData;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * A general picker class. Ext.picker.Slots are used to organize multiple
 * scrollable slots into a single picker. slots is the only necessary
 * configuration.
 * 
 * The slots configuration with a few key values:
 * 
 * name: The name of the slot (will be the key when using getValues in this
 * Ext.picker.Picker) title: The title of this slot (if useTitles is set to
 * true) data/store: The data or store to use for this slot.
 * 
 */
public class Picker extends Sheet {

    private Button doneButton;
    private Button cancelButton;

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.picker.Picker();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.picker.Picker(config);
    }-*/;

    protected Picker(JavaScriptObject obj) {
        super(obj);
    }

    public Picker() {
    }

    @Override
    public String getXType() {
        return XType.PICKER.getValue();
    }

    /**
     * Updates the cancelButton configuration. Will change it into a button when
     * appropriate, or just update the text if needed.
     * 
     * @param value
     */
    public native void applyCancelButton(JavaScriptObject value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.applyCancelButton(value);
		}
    }-*/;

    /**
     * Updates the doneButton configuration. Will change it into a button when
     * appropriate, or just update the text if needed.
     * 
     * @param value
     */
    public native void applyDoneButton(JavaScriptObject value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.applyDoneButton(value);
		}
    }-*/;

    /**
     * Returns the value of cancelButton.
     * 
     * @return
     */
    public Button getCancelButton() {
        JavaScriptObject peer = _getCancelButton();
        if (peer != null) {
            this.cancelButton = Button.instance(peer);
        }
        return this.cancelButton;
    }

    private native JavaScriptObject _getCancelButton() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			return picker.getCancelButton();
		}
		return null;
    }-*/;

    /**
     * Returns the value of doneButton.
     * 
     * @return
     */
    public Button getDoneButton() {
        JavaScriptObject peer = _getDoneButton();
        if (peer != null) {
            this.doneButton = Button.instance(peer);
        }
        return this.doneButton;
    }

    private native JavaScriptObject _getDoneButton() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			return picker.getDoneButton();
		}
		return null;
    }-*/;

    /**
     * Returns the value of slots.
     * 
     * @return
     */
    public native JsArray<JavaScriptObject> getSlots() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			return picker.getSlots();
		}
    }-*/;

    /**
     * Returns the value of toolbar.
     * 
     * @return
     */
    public native ToolBar getToolBar() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			var tb = picker.getToolbar();
			return @com.emitrom.touch4j.client.ui.ToolBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tb);
		}
    }-*/;

    /**
     * Returns the value of useTitles.
     * 
     * @return
     */
    public native boolean getUseTitles() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			return picker.getUseTitles();
		}
    }-*/;

    /**
     * Returns the values of each of the pickers slots
     * 
     * @return
     */
    public native JavaScriptObject getValue() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			return picker.getValue();
		}
    }-*/;

    /**
     * Returns the values of eaach of the pickers slots
     * 
     * @return
     */
    public List<PickerSlotData> getValues() {
        List<PickerSlotData> slotsData = new ArrayList<PickerSlotData>();
        JsArray<JavaScriptObject> values = _getValues();
        for (int i = 0; i < values.length(); i++) {
            String text = JsoHelper.getAttribute(values.get(i), Attribute.TEXT.getValue());
            String value = JsoHelper.getAttribute(values.get(i), Attribute.VALUE.getValue());
            slotsData.add(new PickerSlotData(text, value));
        }
        return slotsData;
    }

    /**
     * Sets the value of cancelButton. This method is deprecated. Use
     * setCancelButtonText instead.
     * 
     * @param value
     * @deprecated
     */
    public native void setCancelButton(String value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setCancelButton(value);
		}
    }-*/;

    /**
     * Sets the value of cancelButton.
     * 
     * @param value
     */
    public native void setCancelButtonText(String value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setCancelButton(value);
		}
    }-*/;

    /**
     * Sets the cancel button to this button
     * 
     * @param button
     *            , the new cancel button
     */
    public void setCancelButton(Button button) {
        this.cancelButton = button;
        setCancelButton(button.getOrCreateJsObj());
    }

    /**
     * Sets the value of cancelButton.
     * 
     * @param value
     */
    public native void setCancelButton(JavaScriptObject value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setCancelButton(value);
		}
    }-*/;

    /**
     * Disable Cancel button. Typically used when a ToolBar is used as the
     * configuration instead of the default buttons.
     * 
     * @param value
     */
    public native void setCancelButton(boolean value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setCancelButton(value);
		}
    }-*/;

    /**
     * Disable Done button. Typically used when a ToolBar is used as the
     * configuration instead of the default buttons.
     * 
     * @param value
     */
    public native void setDoneButton(boolean value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setDoneButton(value);
		}
    }-*/;

    /**
     * Sets the value of doneButton. This method is deprecated. use
     * setDoneButtonText instead
     * 
     * @param value
     * @deprecated
     */
    public native void setDoneButton(String value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setDoneButton(value);
		}
    }-*/;

    /**
     * Sets the value of the text on the done button.
     * 
     * @param value
     */
    public native void setDoneButtonText(String value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setDoneButton(value);
		}
    }-*/;

    /**
     * Sets the done button to this button
     * 
     * @param button
     *            , the new done button
     */
    public void setDoneButton(Button button) {
        this.doneButton = button;
        setDoneButton(button.getOrCreateJsObj());
    }

    /**
     * Sets the value of doneButton.
     * 
     * @param value
     */
    public native void setDoneButton(JavaScriptObject value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setDoneButton(value);
		}
    }-*/;

    /**
     * Sets the value of slots.
     * 
     * @param values
     */
    public void setSlots(List<PickerSlot> values) {
        _setSlots(JsoHelper.convertToJavaScriptArray(values.toArray()).cast());
    }

    /**
     * Sets the value of toolbar.
     * 
     * @param value
     */
    public void setToolBar(ToolBar value) {
        setToolBar(value.getJsObj());
    }

    /**
     * Sets the value of useTitles.
     * 
     * @param value
     */
    public native void setUseTitles(boolean value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setUseTitles(value);
		}
    }-*/;

    /**
     * Sets the values of the pickers slots. Be aware that this method is
     * depended upon the number of slots setup for the picker.
     * 
     * For example, if the picker has two slots, the first one with name of hour
     * and the second one using name minutes, the BaseModel would need to
     * provide a model describing the following data structure:
     * 
     * {hour: "05", minutes: "20"}.
     * 
     * @param value
     * @param animated
     * @return
     */
    public void setValue(BaseModel value, boolean animated) {
        setValue(value.getJsObj(), animated);
    }

    /**
     * Adds any new slots to this picker, and removes existing slots
     * 
     * @param newSlots
     */
    public void updateSlots(List<PickerSlot> newSlots) {
        updateSlots(JsoHelper.convertToJavaScriptArray(newSlots.toArray()).cast());
    }

    /**
     * 
     * @param value
     */
    public native void updateUseTitles(JavaScriptObject value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.updateUseTitles(value);
		}
    }-*/;

    /**
     * Fired when the cancel button is tapped and the values are reverted back
     * to what they were.
     * 
     * @param handler
     */
    public CallbackRegistration addCancelHandler(PickerCancelHandler handler) {
        return this.addWidgetListener(Event.CANCEL.getValue(), handler.getJsoPeer());
    }

    /**
     * Fired when the picked value has changed
     * 
     * @param handler
     */
    public CallbackRegistration addChangeHandler(PickerChangeHandler handler) {
        return this.addWidgetListener(Event.CHANGE.getValue(), handler.getJsoPeer());
    }

    /**
     * Fired when a slot has been picked
     * 
     * @param handler
     */
    public CallbackRegistration addPickerHandler(PickerPickHandler handler) {
        return this.addWidgetListener(Event.PICK.getValue(), handler.getJsoPeer());
    }

    private native void setToolBar(JavaScriptObject value) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setToolbar(value);
		}
    }-*/;

    private native JsArray<JavaScriptObject> _getValues() /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			var slotsData = [];
			var values = picker.getValues();
			var i = 0;
			for ( var value in values) {
				var slotData = {};
				slotData.text = value;
				slotData.value = values[value];
				slotsData[i] = slotData;
				i++;
			}
			return slotsData;
		}
    }-*/;

    private native void _setSlots(JavaScriptObject values) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setSlots(values);
		}
    }-*/;

    private native void updateSlots(JavaScriptObject newSlots) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.updateSlots(newSlots);
		}
    }-*/;

    public native void setValue(JavaScriptObject value, boolean animated) /*-{
		var picker = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (picker != null) {
			picker.setValue(value, true);
		}
    }-*/;

}
