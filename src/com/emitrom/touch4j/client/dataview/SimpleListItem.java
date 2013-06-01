package com.emitrom.touch4j.client.dataview;

import com.emitrom.touch4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

public class SimpleListItem extends Component {

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return null;
    }

    protected SimpleListItem() {

    }

    protected SimpleListItem(JavaScriptObject obj) {
        super(obj);
    }

    @Override
    public void setText(String text) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void init() {
        // TODO Auto-generated method stub

    }

    public static SimpleListItem from(JavaScriptObject peer) {
        return new SimpleListItem(peer);
    }

    @Override
    protected JavaScriptObject create(JavaScriptObject config) {
        // TODO Auto-generated method stub
        return null;
    }

}
