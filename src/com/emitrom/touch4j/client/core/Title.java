/**************************************************************************
   Title.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.touch4j.client.core.config.Attribute;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.ui.TitleBar;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 This classed is used for the {@link ToolBar} title configuration in the
 * {@link TitleBar} component.
 * 
 */
public class Title extends Component {

    @Override
    protected void init() {

    }

    public Title() {

    }

    public Title(JavaScriptObject obj) {
        super(obj);
    }

    @Override
    public String getXType() {
        return XType.TITLE.getValue();
    }

    @Override
    protected JavaScriptObject create(JavaScriptObject config) {
        return null;
    }

    /**
     * sets the title
     * 
     * @param value
     */
    public void setTitle(String value) {
        setAttribute(Attribute.TITLE.getValue(), value, true);
    }

    /**
     * gets the title
     */
    public String getTitle() {
        return getAttribute(Attribute.TITLE.getValue());
    }

}
