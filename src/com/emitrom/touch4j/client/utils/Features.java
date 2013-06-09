/************************************************************************
  Features.java is part of Touch4j 4.2.2.1  Copyright 2013 Emitrom LLC

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
package com.emitrom.touch4j.client.utils;

/**
 * Utility class to detect the feature of the device
 */
public class Features {

    private static Features instance = null;

    public static Features get() {
        if (instance == null) {
            instance = new Features();
        }
        return instance;
    }

    private Features() {

    }

    public Has has() {
        return Has.get();
    }

    public Browser browser() {
        return Browser.get();
    }

    public OS os() {
        return OS.get();
    }
}
