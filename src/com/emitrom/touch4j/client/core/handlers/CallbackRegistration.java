package com.emitrom.touch4j.client.core.handlers;

import com.emitrom.touch4j.client.core.TouchWidget;
import com.google.gwt.core.client.JavaScriptObject;

public class CallbackRegistration {

    private final TouchWidget uiObject;
    private final String actionString;
    private final JavaScriptObject functionJso;

    public CallbackRegistration(TouchWidget uiObject, String actionString, JavaScriptObject jso) {
        this.uiObject = uiObject;
        this.actionString = actionString;
        this.functionJso = jso;
    }

    public TouchWidget getWidget() {
        return uiObject;
    }

    public String getActionString() {
        return actionString;
    }

    public JavaScriptObject getJso() {
        return functionJso;
    }

    public native void unregister() /*-{
		var obj = this.@com.emitrom.touch4j.client.core.handlers.CallbackRegistration::getWidget()();
		var objjso = obj.@com.emitrom.touch4j.client.core.TouchWidget::getOrCreateJsObj()();
		var action = this.@com.emitrom.touch4j.client.core.handlers.CallbackRegistration::getActionString()();
		var jso = this.@com.emitrom.touch4j.client.core.handlers.CallbackRegistration::getJso()();
		objjso.removeListener(action, jso);
    }-*/;
}
