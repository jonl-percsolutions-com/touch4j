/**
 * Copyright (c) 2013 Emitrom LLC. All rights reserved. For licensing questions,
 * please contact us at licensing@emitrom.com
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
 */
package com.emitrom.touch4j.plugins.dataview.pullrefresh.client;

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

    public native void setAutoSnapBack(boolean value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setPullRefreshText(value);
    }-*/;

    public native boolean isAutoSnapBack()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getAutoSnapBack();
    }-*/;

    public native void setLastUpdatedDateFormat(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setLastUpdatedDateFormat(value);
    }-*/;

    public native String getLastUpdatedDateFormat()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getLastUpdatedDateFormat();
    }-*/;

    public native void setLastUpdatedText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setLastUpdatedText(value);
    }-*/;

    public native String getLastUpdatedText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getLastUpdatedText();
    }-*/;

    public native void setLoadedText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setLoadedText(value);
    }-*/;

    public native String getLoadedText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getLoadedText();
    }-*/;

    public native void setLoadingText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setLoadingText(value);
    }-*/;

    public native String getLoadingText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getLoadingText();
    }-*/;

    public native void setOverpullSnapBackDuration(int value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setOverpullSnapBackDuration(value);
    }-*/;

    public native int getOverpullSnapBackDuration()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getOverpullSnapBackDuration();
    }-*/;

    public native void setPullTpl(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setPullTpl(value);
    }-*/;

    public native void setPullTpl(Template value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr
				.setPullTpl(value.@com.emitrom.touch4j.client.core.JsObject::getJsObj()());
    }-*/;

    public native String getPullTpl()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getPullTpl();
    }-*/;

    public native void setReleaseRefreshText(String value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setReleaseRefreshText(value);
    }-*/;

    public native String getReleaseRefreshText()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getReleaseRefreshText();
    }-*/;

    public native void setSnappingAnimationDuration(int value)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr.setSnappingAnimationDuration(value);
    }-*/;

    public native int getSnappingAnimationDuration()/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return pr.getSnappingAnimationDuration();
    }-*/;

    /**
     * The handler that will be called to refresh the list.
     * 
     * @param callback
     */
    public native void addPullRefreshHandler(PullRefreshHandler callback)/*-{
		var pr = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		pr
				.on(
						'latestfetched',
						$entry(function(plugin) {
							callback.@com.emitrom.touch4j.plugins.dataview.pullrefresh.client.PullRefreshHandler::onRefresh()();
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
