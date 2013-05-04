/**************************************************************************
 * PullRefresh.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.ux.dataview.pullrefresh.client;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.template.Template;
import com.google.gwt.core.client.JavaScriptObject;

public class PullRefresh extends Component {

    @Override
    protected void init() {

    }

    public PullRefresh() {

    }

    public PullRefresh(String pullRefreshText) {
        this();
        setPullRefreshText(pullRefreshText);
    }

    public PullRefresh(String pullRefreshText, String releaseRefreshText) {
        this(pullRefreshText);
        setReleaseRefreshText(releaseRefreshText);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.plugin.PullRefresh(config);
    }-*/;

    /**
     * The text that will be shown while you are pulling down.
     * 
     * @param value
     */
    public native void setPullRefreshText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setPullRefreshText(value);
    }-*/;

    public native String getPullRefreshText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getPullRefreshText();
    }-*/;

    /**
     * The text that will be shown to display when the list was last updated
     * 
     * @param value
     */
    public native void setLastUpdatedText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setLastUpdatedText(value);
    }-*/;

    public native String getLastUpdatedText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getLastUpdatedText();
    }-*/;

    /**
     * The template being used for the pull to refresh markup
     * 
     * @param value
     */
    public native void setPullTemplate(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setPullTpl(value);
    }-*/;

    /**
     * The template being used for the pull to refresh markup
     * 
     * @param value
     */
    public native void setPullTemplate(Template value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr
				.setPullTpl(value.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()());
    }-*/;

    /**
     * The text that will be shown after you have pulled down enough to show the
     * release message.
     * 
     * @param value
     */
    public native void setReleaseRefreshText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setReleaseRefreshText(value);
    }-*/;

    public native String getReleaseRefreshText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getReleaseRefreshText();
    }-*/;

    /**
     * The text that will be shown while the list is refreshing.
     * 
     * @param value
     */
    public native void setLoadingText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setLoadingText(value);
    }-*/;

    public native String getLoadingText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getLoadingText();
    }-*/;

    /**
     * The duration for snapping back animation after the data has been
     * refreshed
     * 
     * @param value
     */
    public native void setSnapAnimationDuration(int value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setSnapAnimationDuration(value);
    }-*/;

    public native int getSnapAnimationDuration()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getSnapAnimationDuration();
    }-*/;

    /**
     * The handler that will be called to refresh the list.
     * 
     * @param callback
     */
    public native void addPullRefreshHandler(PullRefreshHandler callback)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr
				.setRefreshFn($entry(function(plugin) {
					callback.@com.emitrom.touch4j.ux.dataview.pullrefresh.client.PullRefreshHandler::onRefresh()();
				}));
    }-*/;

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

}
