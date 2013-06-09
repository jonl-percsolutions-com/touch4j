/************************************************************************
  Surface.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.draw;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Surface is an interface to render methods inside {@link DrawComponent}.
 * <p>
 * Most of the Surface methods are abstract and they have a concrete
 * implementation in VML or SVG engines.
 * <p>
 * A Surface contains methods to render sprites, get bounding boxes of sprites,
 * add sprites to the canvas, initialize other graphic components, etc.
 * 
 */
public class Surface extends JsObject {

    public Surface() {
        jsObj = JsoHelper.createObject();
    }

    public Surface(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public Sprite add(Sprite sprite) {
        return new Sprite(this.add(sprite.getJsObj()));
    }

    private native JavaScriptObject add(JavaScriptObject sprite)/*-{
		var jso = this.@com.emitrom.touch4j.client.core.JsObject::jsObj;
		return jso.add(sprite);
    }-*/;

}
