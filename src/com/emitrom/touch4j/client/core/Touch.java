/**************************************************************************
 * Touch.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class is used to bootstrap the Sencha Touch library or get the current
 * version of the Touch4j library. The bootstrap mechanisism should nt be called
 * directly instead one should extends the
 * {@link com.emitrom.touch4j.client.core.TouchEntryPoint} or the
 * {@link com.emitrom.touch4j.client.core.ConfigurableTouchEntryPoint} class.
 * 
 */
public class Touch {

    private static final String VERSION = "4.0.0";

    public static void init(InitHandler handler) {
        // setPlugingBasePath(GWT.getModuleBaseURL() + "plugins");
        init(handler.getJsoPeer());
    }

    public static void init(TouchConfig config) {
        // setPlugingBasePath(GWT.getModuleBaseURL() + "plugins");
        init(config.getJsObj());
    }

    private static native void init(JavaScriptObject handler)/*-{
		if (typeof ($wnd) != 'undefined' && typeof ($wnd.Ext) != 'undefined') {
			$wnd.Ext.setup({
				onReady : handler
			});
		}

    }-*/;

    private static native void init2(JavaScriptObject config)/*-{
		if (typeof ($wnd) != 'undefined' && typeof ($wnd.Ext) != 'undefined') {
			$wnd.Ext.setup(config);
		}
    }-*/;

    /**
     * gets the current version of Touch4j. note this is not the version of the
     * underlying Sencha Touch library.
     * 
     * @return, the current version of Touch4j
     */
    public static String getVersion() {
        return VERSION;
    }

    private static native void setPlugingBasePath(String path)/*-{
		if (typeof ($wnd) != 'undefined' && typeof ($wnd.Ext) != 'undefined') {
			$wnd.Ext.Loader.setPath({
				'Ext.plugin' : path, // add class path   
			});
		}

    }-*/;

}
