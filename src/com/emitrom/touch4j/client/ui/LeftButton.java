/**************************************************************************
   LeftButton.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

class LeftButton extends Button {

    public LeftButton(String text) {
        super(text);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.align = "left";
		return new $wnd.Ext.Button(config);
    }-*/;

}
