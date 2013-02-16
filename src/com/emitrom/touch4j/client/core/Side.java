/**************************************************************************
 * Side.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core;

/**
 * Constants for various sides.
 */
public enum Side {

    TOP("t"), LEFT("l"), RIGHT("r"), BOTTOM("b");

    private String side;

    private Side(String side) {
        this.side = side;
    }

    public String getSide() {
        return side;
    }

}
