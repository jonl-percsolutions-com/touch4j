package com.emitrom.touch4j.client.utils;

import com.emitrom.touch4j.client.core.Function;
import com.emitrom.touch4j.client.core.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a convenient method of performing setTimeout where a new timeout
 * cancels the old timeout. An example would be performing validation on a
 * keypress. You can use this class to buffer the keypress events for a certain
 * number of milliseconds, and perform only if they stop for that amount of
 * time.
 */
public class DelayedTask extends JsObject {

    /**
     * Creates a new DelayedTask.
     */
    public DelayedTask() {
        jsObj = create();
    }

    private native JavaScriptObject create() /*-{
		return new $wnd.Ext.util.DelayedTask();
    }-*/;

    /**
     * Cancel the last queued timeout.
     */
    public native void cancel() /*-{
		var dtask = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		dtask.cancel();
    }-*/;

    /**
     * Cancels any pending timeout and queues a new one.
     * 
     * @param delay
     *            the milliseconds to delay
     * @param task
     *            the task
     */
    public native void delay(int delay, Function task) /*-{
		var dtask = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		dtask.delay(delay, function() {
			task.@com.emitrom.touch4j.client.core.Function::execute()();
		});
    }-*/;
}
