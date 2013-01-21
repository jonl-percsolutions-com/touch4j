/**************************************************************************
   TreeModel.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.client.data;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.core.config.Attribute;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class TreeModel extends BaseModel {

    private boolean leaf = false;
    private List<? extends TreeModel> items = new ArrayList<TreeModel>();

    public TreeModel() {
        super(JavaScriptObject.createObject());
        setLeaf(leaf);
    }

    protected TreeModel(JavaScriptObject jso) {
        super(jso);
        // setLeaf(leaf);
    }

    public TreeModel(String text) {
        this();
        setText(text);
    }

    public void setText(String text) {
        set(Attribute.TEXT.getValue(), text);
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
        JsoHelper.setAttribute(jsObj, Attribute.LEAF.getValue(), leaf);
    }

    public void setItems(List<? extends TreeModel> items) {

        this.items = items;

        JavaScriptObject[] data = new JavaScriptObject[items.size()];
        for (int i = 0; i < items.size(); i++) {
            data[i] = items.get(i).getJsObj();
        }

        JsoHelper.setAttribute(jsObj, Attribute.ITEMS.getValue(), JsoHelper.arrayConvert(data));

    }

    public String getText() {
        return get(Attribute.TEXT.getValue());
    }

    public boolean isLeaf() {
        return leaf;
    }

    public List<? extends TreeModel> getItems() {
        return items;
    }

}
