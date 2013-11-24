/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
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
