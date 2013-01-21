/**************************************************************************
   MapElement.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.client.ui;

import com.emitrom.touch4j.client.core.handlers.map.MapCenterChangeHandler;
import com.emitrom.touch4j.client.core.handlers.map.MapTypeChangeHandler;
import com.emitrom.touch4j.client.core.handlers.map.MapZoomChangeHandler;

public interface MapElement {

    /**
     * Returns the value of useCurrentLocation.
     * 
     * @return boolean
     */
    public boolean isUseCurrentLocation();

    /**
     * Sets the value of useCurrentLocation.
     * 
     * @param value
     */
    public void setUseCurrentLocation(boolean value);

    public void addCenterChangeHandler(MapCenterChangeHandler handler);

    public void addTypeChangeHandler(MapTypeChangeHandler handler);

    public void addZoomChangeHandler(MapZoomChangeHandler handler);

}