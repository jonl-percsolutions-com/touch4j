/************************************************************************
  Media.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
**************************************************************************/
package com.emitrom.touch4j.client.core;

import com.emitrom.touch4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a base class for audio/visual controls. Should not be used directly.
 */
public abstract class Media extends Component implements Playable, HasUrl {

    protected Media(JavaScriptObject config) {
        super(config);
    }

    @Override
    protected native void init()/*-{
		var c = new $wnd.Ext.Media();
		this.@com.emitrom.touch4j.client.core.Component::configPrototype = c.initialConfig;
    }-*/;

    @Override
    public String getXType() {
        return XType.MEDIA.getValue();
    }

    /**
     * Create a new Sheet.
     */
    public Media() {
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Media(config);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#isAutoResume()
     */
    @Override
    public native boolean isAutoResume() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getAutoResume();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#isAutoPause()
     */
    @Override
    public native boolean isAutoPause() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getAutoPause();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#isEnableControls()
     */
    @Override
    public native boolean isEnableControls() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getEnableControls();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#isLoop()
     */
    @Override
    public native boolean isLoop() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getLoop();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#getMedia()
     */
    @Override
    public native ExtElement getMedia() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getMedia();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#isPreload()
     */
    @Override
    public native boolean isPreload() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getPreload();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasUrl#getUrl()
     */
    @Override
    public native String getUrl() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.getUrl();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#isPlaying()
     */
    @Override
    public native boolean isPlaying() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		return media.isPlaying();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#pause()
     */
    @Override
    public native void pause() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.pause();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#play()
     */
    @Override
    public native void play() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.play();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#setAutoPause(boolean)
     */
    @Override
    public native void setAutoPause(boolean value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
	    media.setAutoPause(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#setAutoResume(boolean)
     */
    @Override
    public native void setAutoResume(boolean value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.setAutoResume(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.Playable#setEnableControls(boolean)
     */
    @Override
    public native void setEnableControls(boolean value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.setEnableControls(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#setLoop(boolean)
     */
    @Override
    public native void setLoop(boolean value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
	    media.setLoop(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.Playable#setMedia(com.emitrom.gwt4
     * .touch.client.core.ExtElement)
     */
    @Override
    public native void setMedia(ExtElement value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.setMedia(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#setPreload(boolean)
     */
    @Override
    public native void setPreload(boolean value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.setPreload(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasUrl#setUrl(java.lang.String)
     */
    @Override
    public native void setUrl(String value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.setUrl(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.Playable#toggle()
     */
    @Override
    public native void toggle() /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.toggle();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.Playable#updateEnableControls(java
     * .lang.Object)
     */
    @Override
    public native void updateEnableControls(Object value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.updateEnableControls(value);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.Playable#updateLoop(java.lang.Object)
     */
    @Override
    public native void updateLoop(Object value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.updateLoop(value);
    }-*/;

    public native void updateUrl(Object value) /*-{
		var media = this.@com.emitrom.touch4j.client.core.Media::getOrCreateJsObj()();
		media.updateUrl(value);
    }-*/;

}
