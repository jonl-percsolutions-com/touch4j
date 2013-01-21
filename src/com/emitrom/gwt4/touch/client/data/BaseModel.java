package com.emitrom.gwt4.touch.client.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.emitrom.gwt4.touch.client.core.JsObject;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Base class for all data to be displayed in data driven components
 */

public class BaseModel extends JsObject {

    protected Map<String, Object> map = new HashMap<String, Object>();

    protected BaseModel() {
        jsObj = JsoHelper.createObject();
    }

    protected BaseModel(JavaScriptObject obj) {
        super(obj);
    }

    public <X> void set(String property, X value) {
        map.put(property, value);
        _setNative(property, value);
    }

    public void set(String property, double value) {
        map.put(property, value);
        _setNative(property, value);
    }

    public void set(String property, List<BaseModel> values) {
        map.put(property, values);
        JsArray<JavaScriptObject> rawValues = JsArray.createArray().cast();
        for (BaseModel model : values) {
            rawValues.push(model.getJsObj());
        }
        _setNative(property, rawValues);
    }

    public native String get(String property)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public native double getNumber(String property)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public native boolean getBoolean(String property)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public Set<String> getFields() {
        return map.keySet();
    }

    private native <X> X _setNative(String property, X value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    private native void _setNative(String property, double value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    static JsArray<JavaScriptObject> fromList(List<BaseModel> models) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (BaseModel model : models) {
            values.push(model.getJsObj());
        }
        return values;
    }

    public static List<BaseModel> fromJsArray(JavaScriptObject array) {
        List<BaseModel> toReturn = new ArrayList<BaseModel>();
        int size = JsoHelper.getArrayLength(array);
        for (int i = 0; i < size; i++) {
            JavaScriptObject peer = JsoHelper.getValueFromJavaScriptObjectArray(array, i);
            toReturn.add(new BaseModel(peer));
        }
        return toReturn;
    }

    public static BaseModel from(JavaScriptObject obj) {
        return new BaseModel(obj);
    }

    public void update(JavaScriptObject obj) {
        jsObj = obj;
    }

    @SuppressWarnings("unchecked")
    public <X> X getFromCache(String property) {
        return (X) map.get(property);
    }

}
