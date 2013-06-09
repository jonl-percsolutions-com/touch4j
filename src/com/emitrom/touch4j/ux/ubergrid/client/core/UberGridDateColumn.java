/************************************************************************
  UberGridDateColumn.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.ux.ubergrid.client.core;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is a subclass of the base UberGridColumn class, which provides a default
 * UberGrid.column.Column.renderer, simplifying rendering of the dates. You can
 * directly specify the format to render the date in.
 */
public class UberGridDateColumn extends UberGridColumn {

    public UberGridDateColumn() {
        jsObj = JsoHelper.createObject();
    }

    public UberGridDateColumn(String header, String dataIndex) {
        this();
        setHeader(header);
        setDataIndex(dataIndex);
    }

    UberGridDateColumn(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The format to render the date in.
     */
    public void setFormat(String value) {
        JsoHelper.setAttribute(jsObj, "format", value);
    }

    public String getFormat() {
        return JsoHelper.getAttribute(jsObj, "format");
    }

}
