/**************************************************************************
 * TiTouchEntryPoint.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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

import com.google.gwt.core.client.EntryPoint;

/**
 * This class should be used as the entry point for Touch applications used
 * inside Titanium Mobile.
 */
public abstract class TiTouchEntryPoint implements EntryPoint {

    public abstract void onWebStart();

    public abstract void onNativeStart();

    @Override
    public void onModuleLoad() {
        if (Ext.isWebMode()) {
            bindTi();
            initTouch();
        } else {
            onNativeStart();
        }
    }

    protected void initTouch() {
        Touch.init(new InitHandler() {
            @Override
            protected void onInit() {
                onWebStart();
            }
        });
    }

    /**
     * Binds Titanium to the global space when using HTML5 UI
     */
    native void bindTi()/*-{
		Titanium = $wnd.Titanium;
		Ti = $wnd.Ti;
    }-*/;

}
