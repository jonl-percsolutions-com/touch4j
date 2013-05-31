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
		alert('');
		return new $wnd.Ext.plugin.SlideToRemove(config);
    }-*/;

}
