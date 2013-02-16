/**************************************************************************
 * PanzoomAxis.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 **************************************************************************/
package com.emitrom.touch4j.charts.client.interactions;

import com.emitrom.touch4j.client.core.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class PanzoomAxis extends JsObject {

    public PanzoomAxis(PanzoomOrientation orientation) {
        if (orientation.equals(PanzoomOrientation.LEFT)) {
            jsObj = getLeft();
        } else if (orientation.equals(PanzoomOrientation.RIGHT)) {
            jsObj = getRight();
        } else {
            jsObj = getBoth();
        }

    }

    private native JavaScriptObject getLeft()/*-{
		return ({
			left : {}
		});
    }-*/;

    private native JavaScriptObject getRight()/*-{
		return ({
			right : {}
		});
    }-*/;

    private native JavaScriptObject getBoth()/*-{
		return ({
			right : {},
			left : {}
		});
    }-*/;

}
