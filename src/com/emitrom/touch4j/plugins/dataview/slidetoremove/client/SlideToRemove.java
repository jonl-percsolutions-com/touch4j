/************************************************************************
  SlideToRemove.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.plugins.dataview.slidetoremove.client;

import com.emitrom.touch4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

public class SlideToRemove extends Component {

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

    public SlideToRemove() {

    }

    public SlideToRemove(String removeText) {
        this();
        this.setRemoveText(removeText);
    }

    public void setRemoveText(String value) {
        this.setAttribute("removeText", value, true);
    }

    public void setButtonWidth(int value) {
        this.setAttribute("buttonWidth", value, true);
    }

    @Override
    protected void init() {
        // TODO Auto-generated method stub

    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.plugin.SlideToRemove(config);
    }-*/;

}
