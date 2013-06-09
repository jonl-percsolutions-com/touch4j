/************************************************************************
  SlideNavigationConfig.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.ux.slidenavigation.client;

import com.emitrom.touch4j.client.core.JsObject;
import com.emitrom.touch4j.client.core.JsoHelper;

/**
 * Config class for the slide navigation
 */
class SlideNavigationConfig extends JsObject {

    SlideNavigationConfig() {
        jsObj = JsoHelper.createObject();
    }

    void setCloseOnSelect(boolean value) {
        JsoHelper.setAttribute(jsObj, "closeOnSelect", value);
    }

    void setItems(SlideNavigationItem... items) {
        JsoHelper.setAttribute(jsObj, "items", SlideNavigationItem.fromArray(items));
    }

    void setList(SlideNavigationList list) {
        JsoHelper.setAttribute(jsObj, "list", list.getJsObj());
    }

    void setSelectSlideDuration(int value) {
        JsoHelper.setAttribute(jsObj, "selectSlideDuration", value);
    }

    void setShadowStyle(String value) {
        JsoHelper.setAttribute(jsObj, "shadowStyle", value);
    }

    void setSlideDuration(int value) {
        JsoHelper.setAttribute(jsObj, "slideDuration", value);
    }

    void setSlideSelector(String value) {
        JsoHelper.setAttribute(jsObj, "slideSelector", value);
    }

    void setFullScreen(boolean value) {
        JsoHelper.setAttribute(jsObj, "fullscrenn", value);
    }

    void setListPosition(String value) {
        JsoHelper.setAttribute(jsObj, "listPosition", value);
    }

    void setItemMask(boolean value) {
        JsoHelper.setAttribute(jsObj, "itemMask", value);
    }

    native void setSlideButtonDefaultComponent(String value)/*-{
		var peer = this.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		peer.slideButtonDefaults = {
			selector : value
		};
    }-*/;

}
