/**************************************************************************
   MapRenderHandler.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.gwt4.touch.client.core.handlers.map;

import com.emitrom.gwt4.touch.client.core.handlers.AbstractHandler;
import com.emitrom.gwt4.touch.client.ui.GoogleMap;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class MapRenderHandler extends AbstractHandler {

	  final JavaScriptObject jsoPeer = createPeer(this);

	  private static native JavaScriptObject createPeer(MapRenderHandler listener) /*-{
			return function(source, googlemap) {
				var map = @com.emitrom.gwt4.touch.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				listener.@com.emitrom.gwt4.touch.client.core.handlers.map.MapCenterChangeHandler::fireOnEvent(Lcom/emitrom/gwt4/touch/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(map,googlemap);
			};
	  }-*/;

	  // Called from JSNI
	  private final void fireOnEvent(GoogleMap map, JavaScriptObject googleMap, double mapType) {
	    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
	    if (handler != null) {
	      fireOnEventAndCatch(map,googleMap, mapType, handler);
	    } else {
	      onMapTypeChange(map, googleMap, mapType);
	    }
	  }

	  private void fireOnEventAndCatch(GoogleMap map, JavaScriptObject googleMap, double mapType, UncaughtExceptionHandler handler) {
	    try {
	      onMapTypeChange(map, googleMap, mapType);
	    } catch (Throwable e) {
	      handler.onUncaughtException(e);
	    }
	  }

	  @Override
	  public JavaScriptObject getJsoPeer() {
	    return jsoPeer;
	  }

	 
	  public abstract void onMapTypeChange(GoogleMap map, JavaScriptObject googleMap, double mapType);
	}

