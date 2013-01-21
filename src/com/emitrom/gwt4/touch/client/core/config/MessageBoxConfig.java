/**************************************************************************
 * MessageBoxConfig.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.gwt4.touch.client.core.config;

import com.emitrom.gwt4.touch.client.fx.layout.card.Animation;
import com.emitrom.gwt4.touch.client.ui.MessageBox;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * {@link com.emitrom.gwt4.touch.client.ui.MessageBox} configuration class.
 * 
 * @see com.emitrom.gwt4.touch.client.ui.MessageBox#show(MessageBoxConfig)
 */
public class MessageBoxConfig extends BaseConfig {

    public MessageBoxConfig() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * The title text.
     * 
     * @param title
     *            the title
     */
    public void setTitle(String title) {
        JsoHelper.setAttribute(jsObj, Attribute.TITLE.getValue(), title);
    }

    /**
     * A custom CSS class to apply to the message box element.
     * 
     * @param cls
     *            the css class
     */
    public void setCls(String cls) {
        JsoHelper.setAttribute(jsObj, Attribute.CLS.getValue(), cls);
    }

    /**
     * The default height in pixels of the message box's multiline textarea if
     * displayed (defaults to 75).
     * 
     * @param defaultTextHeight
     *            the default text height
     */
    public void setDefaultTextHeight(int defaultTextHeight) {
        JsoHelper.setAttribute(jsObj, Attribute.DEFAULT_TEXT_HEIGHT.getValue(), defaultTextHeight);
    }

    /**
     * True to prompt the user to enter single-line text (defaults to false).
     * 
     * @param prompt
     *            true to prompt
     */
    public void setPrompt(boolean prompt) {
        JsoHelper.setAttribute(jsObj, Attribute.PROMPT.getValue(), prompt);
    }

    /**
     * True to prompt the user to enter multi-line text (defaults to false).
     * 
     * @param multiline
     *            true for multiline prompt
     */
    public void setMultiline(boolean multiline) {
        JsoHelper.setAttribute(jsObj, Attribute.MULTILINE.getValue(), multiline);
    }

    /**
     * the string value to set into the active textbox element if displayed.
     * 
     * @param value
     *            the value text
     */
    public void setValue(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.VALUE.getValue(), value);
    }

    /**
     * The buttons to display.
     * 
     * @param buttons
     *            the buttons
     */
    public void setButtons(MessageBox.Button... buttons) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (MessageBox.Button b : buttons) {
            values.push(b.getJsObj());
        }
        _setButtons(values);
    }

    private native void _setButtons(JsArray<JavaScriptObject> values)/*-{
		var config = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		config.buttons = values;
    }-*/;

    /**
     * False to not show any buttons.
     * 
     * @param buttons
     *            display buttons
     */
    public void setButtons(boolean buttons) {
        JsoHelper.setAttribute(jsObj, Attribute.BUTTONS.getValue(), buttons);
    }

    public void stAnimation(Animation animation) {
        JsoHelper.setAttribute(jsObj, "animation", animation.getJSO());
    }

    /**
     * A callback function to execute after closing the dialog. The arguments to
     * the function will be btn (the name of the button that was clicked, if
     * applicable, e.g. "ok"), and text (the value of the active text field, if
     * applicable). Progress and wait dialogs will ignore this option since they
     * do not respond to user actions and can only be closed programmatically,
     * so any required function should be called by the same code after it
     * closes the dialog.
     * 
     * @param cb
     *            the callback
     */
    public void setPromptCallback(MessageBox.PromptCallback cb) {
        _setPromptCallback(cb);
    }

    private native void _setPromptCallback(MessageBox.PromptCallback cb)/*-{
		var config = this.@com.emitrom.gwt4.touch.client.core.JsObject::getJsObj()();
		config['fn'] = function(btnID, text) {
			if (btnID === undefined)
				btnID = null;
			if (text === undefined || text == '')
				text = null;
			cb.@com.emitrom.gwt4.touch.client.ui.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
		};
    }-*/;

    /**
     * The string that will replace the existing message box body text (defaults
     * to the XHTML-compliant non-breaking space character ' ')
     * 
     * @param msg
     *            the message
     */
    public void setMessage(String msg) {
        JsoHelper.setAttribute(jsObj, Attribute.MSG.getValue(), msg);
    }

    /**
     * A CSS class that provides a background image to be used as an icon for
     * the dialog (e.g., Ext.MessageBox.WARNING or 'custom-class', defaults to
     * '').
     * 
     * @param iconCls
     *            the icon CSS class
     */
    public void setIconCls(String iconCls) {
        JsoHelper.setAttribute(jsObj, Attribute.ICON_CLS.getValue(), iconCls);
    }

    /**
     * False to allow user interaction with the page while the message box is
     * displayed (defaults to true).
     * 
     * @param modal
     *            false for non modal
     */
    public void setModal(boolean modal) {
        JsoHelper.setAttribute(jsObj, Attribute.MODAL.getValue(), modal);
    }

    /**
     * The width of the dialog in pixels.
     * 
     * @param width
     *            the dialog width
     */
    public void setWidth(int width) {
        JsoHelper.setAttribute(jsObj, Attribute.WIDTH.getValue(), width);
    }
}
