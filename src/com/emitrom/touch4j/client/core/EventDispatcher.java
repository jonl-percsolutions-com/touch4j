/**************************************************************************
   EventDispatcher.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
package com.emitrom.touch4j.client.core;

import com.emitrom.touch4j.client.core.handlers.AbstractHandler;

/**
 * Base interface for elements that are able to dispatch events.
 */
public interface EventDispatcher {

    /**
     * If this is a lazy rendering component, render it to its container
     * element.
     * 
     * @param element
     *            the element
     */
    public void addListener(String event, AbstractHandler handler);

    /**
     * Allow the component to fire this event.
     * 
     * @param event
     *            the event
     */
    public void addEvent(String event);

    /**
     * Fires the specified event.
     * 
     * @param event
     *            the event
     */
    public void fireEvent(String event);

    /**
     * Removes all listeners for this Component.
     */
    public void purgeListeners();

    /**
     * Resume firing events.
     * 
     * @see #suspendEvents()
     */
    public void resumeEvents();

    /**
     * Suspend the firing of all events.
     * 
     * @see #resumeEvents()
     */
    public void suspendEvents();

}
