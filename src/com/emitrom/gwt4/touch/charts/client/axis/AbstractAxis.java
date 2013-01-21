/**************************************************************************
   AbstractAxis.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.charts.client.axis;

import java.util.ArrayList;

import com.emitrom.gwt4.touch.charts.client.laf.GridConfig;
import com.emitrom.gwt4.touch.charts.client.laf.Label;
import com.emitrom.gwt4.touch.charts.client.laf.SpriteConfig;
import com.emitrom.gwt4.touch.client.laf.Color;
import com.emitrom.gwt4.touch.client.laf.Position;
import com.emitrom.gwt4.touch.client.core.JsObject;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Base class for all axis classes.
 * 
 */
public abstract class AbstractAxis extends JsObject {

    public AbstractAxis() {

    }

    public AbstractAxis(JavaScriptObject obj) {
        super(obj);
    }

    public void setTitle(String title) {
        JsoHelper.setAttribute(jsObj, "title", title);
    }

    /**
     * The size of the dash marker. Default's 3.
     * 
     * @param title
     */
    public void setDashSize(double title) {
        JsoHelper.setAttribute(jsObj, "dashSize", title);
    }

    /**
     * Given a minimum and maximum bound for the series to be rendered (that can
     * be obtained automatically or by manually setting minimum and maximum)
     * tick marks will be added on each increment from the minimum value to the
     * maximum one.
     * 
     * @param title
     */
    public void setIncrement(int title) {
        JsoHelper.setAttribute(jsObj, "increment", title);
    }

    public void setGrid(boolean value) {
        JsoHelper.setAttribute(jsObj, "grid", value);
    }

    public void setGrid(GridConfig value) {
        JsoHelper.setAttribute(jsObj, "grid", value.getJsObj());
    }

    public void setGrid(Color oddStroke) {
        SpriteConfig odd = new SpriteConfig();
        odd.setFill(oddStroke);
        setGrid(new GridConfig(odd));
    }

    public void setGrid(Color oddStroke, Color evenStroke) {
        SpriteConfig odd = new SpriteConfig();
        odd.setFill(oddStroke);

        SpriteConfig even = new SpriteConfig();
        even.setFill(oddStroke);
        setGrid(new GridConfig(odd, even));
    }

    public void setAxis(String value) {
        JsoHelper.setAttribute(jsObj, "axis", value);
    }

    protected void setType(String title) {
        JsoHelper.setAttribute(jsObj, "type", title);
    }

    public void setPosition(Position position) {
        setPosition(position.getValue());
    }

    private void setPosition(String title) {
        JsoHelper.setAttribute(jsObj, "position", title);
    }

    public String getPosition() {
        return JsoHelper.getAttribute(jsObj, "position");
    }

    public void setFields(ArrayList<String> fields) {
        JsArrayString array = JsArrayString.createArray().cast();
        for (String string : fields) {
            array.push(string);
        }
        JsoHelper.setAttribute(jsObj, "fields", array);
    }

    public void setFields(String... fields) {
        JsArrayString array = JsArrayString.createArray().cast();
        for (String string : fields) {
            array.push(string);
        }
        JsoHelper.setAttribute(jsObj, "fields", array);
    }

    public void setLabel(Label label) {
        JsoHelper.setAttribute(jsObj, "label", label.getJsObj());
    }

    public void setMinimum(int value) {
        JsoHelper.setAttribute(jsObj, "minimum", value);
    }

    public void setMinorTickSteps(int value) {
        JsoHelper.setAttribute(jsObj, "minorTickSteps", value);
    }

    public void setMaximum(int value) {
        JsoHelper.setAttribute(jsObj, "maximum", value);
    }
}
