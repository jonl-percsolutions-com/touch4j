/**************************************************************************
   HasBoxHandlers.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.client.core;

import com.emitrom.gwt4.touch.client.core.handlers.component.BottomChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.CenteredChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.DockedChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.HeightChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.LeftChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.ResizeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.RightChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.TopChangeHandler;
import com.emitrom.gwt4.touch.client.core.handlers.component.WidthChangeHandler;

public interface HasBoxHandlers {

    public void addBottomChangeHandler(BottomChangeHandler handler);

    public void addCenteredChangeHandler(CenteredChangeHandler handler);

    public void addDockChangeHandler(DockedChangeHandler handler);

    public void addHeightChangeHandler(HeightChangeHandler handler);

    public void addLeftChangeHandler(LeftChangeHandler handler);

    public void addRightChangeHandler(RightChangeHandler handler);

    public void addTopChangeHandler(TopChangeHandler handler);

    public void addWidthHandler(WidthChangeHandler handler);
    
    public void addResizeHandler(ResizeHandler handler);

}
