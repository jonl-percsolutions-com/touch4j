/************************************************************************
  MapCenterChangeHandler.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.core.handlers.map;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;
import com.emitrom.touch4j.client.ui.GoogleMap;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class MapCenterChangeHandler extends AbstractHandler {

	  final JavaScriptObject jsoPeer = createPeer(this);

	  private static native JavaScriptObject createPeer(MapCenterChangeHandler listener) /*-{
			return function(source, googlemap, latlgn) {
				var map = @com.emitrom.touch4j.client.ui.GoogleMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				listener.@com.emitrom.touch4j.client.core.handlers.map.MapCenterChangeHandler::fireOnEvent(Lcom/emitrom/touch4j/client/ui/GoogleMap;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(map,googlemap, latlgn);
			};
	  }-*/;

	  // Called from JSNI
	  private final void fireOnEvent(GoogleMap map, JavaScriptObject googleMap, JavaScriptObject latLgn) {
	    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
	    if (handler != null) {
	      fireOnEventAndCatch(map,googleMap, latLgn, handler);
	    } else {
	      onCenterChange(map, googleMap, latLgn);
	    }
	  }

	  private void fireOnEventAndCatch(GoogleMap map, JavaScriptObject googleMap, JavaScriptObject latLgn, UncaughtExceptionHandler handler) {
	    try {
	      onCenterChange(map, googleMap, latLgn);
	    } catch (Throwable e) {
	      handler.onUncaughtException(e);
	    }
	  }

	  @Override
	  public JavaScriptObject getJsoPeer() {
	    return jsoPeer;
	  }

	  public abstract void onCenterChange(GoogleMap map, JavaScriptObject googleMap, JavaScriptObject latLgn);
	}

