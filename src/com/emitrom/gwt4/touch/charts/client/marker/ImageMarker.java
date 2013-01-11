/**************************************************************************
   ImageMarker.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client.marker;

import com.emitrom.platform.util.client.core.JsoHelper;

public class ImageMarker extends MarkerConfig {

    public ImageMarker() {
        jsObj = JsoHelper.createObject();
        setType("image");
    }

    public ImageMarker(String imageSrc) {
        this();
        setSource(imageSrc);
    }

    public void setSource(String value) {
        JsoHelper.setAttribute(jsObj, "src", value);
    }

    @Override
    public void setSize(int value) {
        setWidth(value);
        setHeight(value);
    }

    public void setSize(String value) {
        setWidth(value);
        setHeight(value);
    }

    public void setWidth(int value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    public void setHeight(int value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    public void setWidth(String value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    public void setHeight(String value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

}
