/**************************************************************************
   RGB.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.client.laf;

/**
 * Represent a color in RBG format
 * 
 * @author Ekambi
 * 
 */
public class RGB extends Color {

    private int red;
    private int blue;
    private int green;

    private RGB() {
    }

    public RGB(String color) {
        super(color);
    }

    public RGB(int red, int blue, int green) {
        this();
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public String getRawValue() {
        StringBuilder builder = new StringBuilder();
        builder.append("rgb(").append(red + ",").append(green + ",").append(blue + ")");
        return builder.toString();
    }

}
