/**
 * Copyright (c) 2013 Emitrom LLC. All rights reserved. For licensing questions,
 * please contact us at licensing@emitrom.com
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
 */
package com.emitrom.touch4j.client.core;

import java.util.Set;

import com.emitrom.touch4j.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;

/**
 * Ext core utilities and functions.
 * 
 */
public class Ext {

    /**
     * URL to a blank file used by Ext when in secure mode for iframe src and
     * onReady src to prevent the IE insecure content warning (defaults to
     * javascript:false).
     * 
     * @param url
     *            the url
     */
    public static native void setSslSecureUrl(String url)/*-{
		$wnd.Ext.SSL_SECURE_URL = url;
    }-*/;

    /**
     * True to automatically uncache orphaned Ext.Elements periodically
     * (defaults to true).
     * 
     * @param enableGarbageCollector
     *            true to enable GC
     */
    public static native void setEnableGarbageCollector(boolean enableGarbageCollector)/*-{
		$wnd.Ext.enableGarbageCollector = enableGarbageCollector;
    }-*/;

    /**
     * Returns is Garbage Collector is enabled.
     * 
     * @return true if GC enabled
     */
    public static native boolean isEnableGarbageCollector()/*-{
		return $wnd.Ext.enableGarbageCollector;
    }-*/;

    /**
     * True to automatically purge event listeners after uncaching an element
     * (defaults to false). Note: this only happens if enableGarbageCollector is
     * true.
     * 
     * @param enableListenerCollection
     *            true to enable listener collection
     */
    public static native void setEnableListenerCollection(boolean enableListenerCollection)/*-{
		$wnd.Ext.enableListenerCollection = enableListenerCollection;
    }-*/;

    /**
     * Retruns true if listener collection is true.
     * 
     * @return true if listener collection is enabled
     */
    public static native boolean isEnableListenerCollection()/*-{
		return $wnd.Ext.enableListenerCollection;
    }-*/;

    /**
     * @return true if bodex box
     */
    public static native boolean isBorderBox()/*-{
		return $wnd.Ext.isBorderBox;
    }-*/;

    /**
     * @return true if Gecko broswer
     */
    public static native boolean isGecko()/*-{
		return $wnd.Ext.isGecko;
    }-*/;

    /**
     * @return true if IE
     */
    public static native boolean isIE()/*-{
		return $wnd.Ext.isIE;
    }-*/;

    /**
     * @return true if IE6
     */
    public static native boolean isIE6()/*-{
		return $wnd.Ext.isIE6;
    }-*/;

    /**
     * @return true if IE7
     */
    public static native boolean isIE7()/*-{
		return $wnd.Ext.isIE7;
    }-*/;

    /**
     * @return true if Linux OS
     */
    public static native boolean isLinux()/*-{
		return $wnd.Ext.isLinux;
    }-*/;

    /**
     * @return true if Mac
     */
    public static native boolean isMac()/*-{
		return $wnd.Ext.isMac;
    }-*/;

    /**
     * @return true if running under Adobe AIR
     */
    public static native boolean isAir()/*-{
		return $wnd.Ext.isAir;
    }-*/;

    /**
     * @return true if Opera
     */
    public static native boolean isOpera()/*-{
		return $wnd.Ext.isOpera;
    }-*/;

    /**
     * @return true when the document is fully initialized and ready for action
     */
    public static native boolean isReady()/*-{
		return $wnd.Ext.isReady;
    }-*/;

    /**
     * @return true if Safari
     */
    public static native boolean isSafari()/*-{
		return $wnd.Ext.isSafari;
    }-*/;

    /**
     * @return true if Safari 2
     */
    public static native boolean isSafari2()/*-{
		return $wnd.Ext.isSafari2;
    }-*/;

    /**
     * @return true if Safari 2
     */
    public static native boolean isSafari3()/*-{
		return $wnd.Ext.isSafari3;
    }-*/;

    /**
     * @return true if the page is running over SSL
     */
    public static native boolean isSecure()/*-{
		return $wnd.Ext.isSecure;
    }-*/;

    /**
     * @return true if the browser is in strict mode
     */
    public static native boolean isStrict()/*-{
		return $wnd.Ext.isStrict;
    }-*/;

    /**
     * @return true if Windows OS
     */
    public static native boolean isWindows()/*-{
		return $wnd.Ext.isWindows;
    }-*/;

    /**
     * By default, Ext intelligently decides whether floating elements should be
     * shimmed. If you are using flash, you may want to set this to true.
     * 
     * @param useShims
     *            true to use shims
     */
    public static native void setUseShims(boolean useShims)/*-{
		$wnd.Ext.useShims = useShims;
    }-*/;

    /**
     * @return true if use shims.
     */
    public static native boolean isUseShims()/*-{
		return $wnd.Ext.useShims;
    }-*/;

    /**
     * Escapes the passed string for use in a regular expression.
     * 
     * @param str
     *            the String to escape
     * @return escaped String
     */
    public static native String escapeRe(String str)/*-{
		return $wnd.Ext.escapeRe(str);
    }-*/;

    // made package protected. Users don't need to call this anymore since it is
    // handled internally on
    // applicaiotn startup.
    native static void setBlankImageUrl(String url) /*-{
		$wnd.Ext.BLANK_IMAGE_URL = url;
    }-*/;

    /**
     * Method to retrieve Element objects. Uses simple caching to consistently
     * return the same object. Automatically fixes if an object was recreated
     * with the same id via AJAX or DOM.
     * 
     * @param id
     *            element ID
     * @return the element
     */
    public static native ExtElement get(String id) /*-{
		var el = $wnd.Ext.get(id);
		return el == null || el === undefined ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Method to retrieve Element objects. Uses simple caching to consistently
     * return the same object. Automatically fixes if an object was recreated
     * with the same id via AJAX or DOM.
     * 
     * @param element
     *            the element
     * @return the element
     */
    public static native ExtElement get(Element element) /*-{
		var el = $wnd.Ext.get(element);
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native ExtElement get(ExtElement element) /*-{
		var el = $wnd.Ext
				.get(element.@com.emitrom.touch4j.client.core.JsObject::getJsObj()());
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Attempts to destroy the objects by removing all event listeners, removing
     * them from the DOM (if applicable) and calling their destroy functions (if
     * available).
     * 
     * @param element
     *            the element to destroy
     */
    public static native void destroy(ExtElement element) /*-{
		var el = element.@com.emitrom.touch4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.destroy(el);
    }-*/;

    /**
     * Attempts to destroy the component passed to it by removing all event
     * listeners, removing them from the DOM (if applicable) and calling their
     * destroy functions (if available).
     * 
     * @param component
     *            the component to destroy
     */
    public static native void destroy(Component component) /*-{
		var comp = component.@com.emitrom.touch4j.client.core.Component::getJsObj()();
		$wnd.Ext.destroy(comp);
    }-*/;

    /**
     * Returns the current HTML document object as an {@link ExtElement}.
     * 
     * @return the document
     */
    public static native ExtElement getDoc() /*-{
		var el = $wnd.Ext.getDoc();
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the current document body as an{@link ExtElement}.
     * 
     * @return the document body
     */
    public static native ExtElement getBody() /*-{
		var el = $wnd.Ext.getBody();
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns a component by id. Shorthand for
     * {@link ComponentMgr#getComponent(String)}.
     * 
     * @param id
     *            the component ID
     * @return the Component
     */
    public static Component getCmp(String id) {
        return ComponentMgr.getComponent(id);
    }

    /**
     * Returns a component that the passed element represents. Shorthand for
     * {@link ComponentMgr#getComponent(Element)}.
     * 
     * @param element
     *            the component's element
     * @return the Component
     */
    public static Component getCmp(Element element) {
        return ComponentMgr.getComponent(element);
    }

    /**
     * Returns a component that the passed element represents. Shorthand for
     * {@link ComponentMgr#getComponent(ExtElement)}.
     * 
     * @param element
     *            the component's element
     * @return the Component
     */
    public static Component getCmp(ExtElement element) {
        return ComponentMgr.getComponent(element);
    }

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param id
     *            the element ID
     * @return the ExtElement
     */
    public static native ExtElement fly(String id) /*-{
		var el = $wnd.Ext.fly(id);
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param id
     *            the element ID
     * @param named
     *            allows for creation of named reusable flyweights to prevent
     *            conflicts (e.g. internally Ext uses "_internal")
     * @return the ExtElement
     */
    public static native ExtElement fly(String id, String named) /*-{
		var el = $wnd.Ext.fly(id, named);
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param element
     *            the element
     * @return the ExtElement
     */
    public static native ExtElement fly(Element element) /*-{
		var el = $wnd.Ext.fly(element);
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param element
     *            the element
     * @param named
     *            allows for creation of named reusable flyweights to prevent
     *            conflicts (e.g. internally Ext uses "_internal")
     * @return the ExtElement
     */
    public static native ExtElement fly(Element element, String named) /*-{
		var el = $wnd.Ext.fly(element, named);
		return el == null ? null
				: @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @return a unique ID
     */
    public static native String generateId()/*-{
		return $wnd.Ext.id();
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @param prefix
     *            Id prefix (defaults "ext-gen")
     * @return a unique ID
     */
    public static native String generateId(String prefix)/*-{
		return $wnd.Ext.id(null, prefix);
    }-*/;

    /**
     * Fires when the document is ready (before onload and before images are
     * loaded). Can alternatively use the GWT entry point mechanism.
     * 
     * @param cb
     *            callback to execute
     */
    public static native void onReady(Function cb) /*-{
		$wnd.Ext.onReady(function() {
			cb.@com.emitrom.touch4j.client.core.Function::execute()();
		});
    }-*/;

    /**
     * Utility method to kick up Javascript debugger. Userful during development
     * / troubleshooting where it is desired to step through Javascript code.
     */
    public static native void debugger()/*-{
		debugger;
    }-*/;

    /**
     * Return true if Firebug is enabled.
     * 
     * @return true if firebug is enabled
     */
    public static native boolean isFirebug() /*-{
		if ($wnd.Ext.isGecko && window.console) {
			var fb = window.console.firebug;
			if (fb == null || fb === undefined) {
				return false;
			} else {
				return fb;
			}
		} else {
			return false;
		}
    }-*/;

    /**
     * Disable firebug.
     */
    public static native void disableFirebug()/*-{
		var consoleMethods = [ "log", "debug", "info", "warn", "error",
				"assert", "dir", "dirxml", "group", "groupEnd", "time",
				"timeEnd", "count", "trace", "profile", "profileEnd" ];
		window.console = {};

		for ( var i = consoleMethods.length - 1; i > -1; i--) {
			window.console[consoleMethods[i]] = function() {
			};
		}
    }-*/;

    public static native String getVersion()/*-{
		return $wnd.Ext.version;
    }-*/;

    public static native String getOrientation()/*-{
		return $wnd.Ext.orientation;
    }-*/;

    public static native Store getStore(String id)/*-{
		var obj = $wnd.Ext.getStore(id);
		var toReturn = @com.emitrom.touch4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    protected static native Store getStore(JavaScriptObject id)/*-{
		var obj = $wnd.Ext.getStore(id);
		var toReturn = @com.emitrom.touch4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public static native void repaint()/*-{
		$wnd.Ext.repaint();
    }-*/;

    public static native boolean isAndroid()/*-{
		return $wnd.Ext.is.Android;
    }-*/;

    public static native boolean isBlackberry()/*-{
		return $wnd.Ext.is.Blackberry;
    }-*/;

    public static native boolean isDesktop()/*-{
		return $wnd.Ext.is.Desktop;
    }-*/;

    public static native boolean isStandAlone()/*-{
		return $wnd.Ext.is.standAlone;
    }-*/;

    public static native boolean isTablet()/*-{
		return $wnd.Ext.is.tablet;
    }-*/;

    public static native boolean hasAndroidVersion()/*-{
		return $wnd.Ext.is.androidVersion;
    }-*/;

    public static native boolean isIOS()/*-{
		return $wnd.Ext.is.iOS;
    }-*/;

    public static native boolean isIPad()/*-{
		return $wnd.Ext.is.iPad;
    }-*/;

    public static native boolean isIPhone()/*-{
		return $wnd.Ext.is.iPhone;
    }-*/;

    public static native boolean isIPod()/*-{
		return $wnd.Ext.is.iPod;
    }-*/;

    public static native int getRandomInt(int min, int max)/*-{
		return $wnd.Math.floor(Math.random() * (max - min + 1)) + min;
    }-*/;

    public static void defineModel(String name, Set<String> fields) {
        JsArray<FieldDefinition> fieldsDefinition = JsArray.createArray().cast();
        for (String s : fields) {
            fieldsDefinition.push(FieldDefinition.create(s));
        }
        createModel(name, fieldsDefinition);

    }

    public static void defineModel(String name, String... fields) {
        JsArray<FieldDefinition> fieldsDefinition = JsArray.createArray().cast();
        for (String s : fields) {
            fieldsDefinition.push(FieldDefinition.create(s));
        }
        createModel(name, fieldsDefinition);

    }

    /**
     * Convenient method to detect if the application is running in the browser
     * Useful when Mobile web app are running inside a webview of a native
     * mobile application like Apache Cordova or Titanium
     * 
     * @return true if we are running in the regular browser
     */
    public native static boolean isWebMode()/*-{
		return ((typeof ($wnd) != 'undefined') || (typeof (window) != 'undefined'));
    }-*/;

    private static native void createModel(String name, JsArray<FieldDefinition> f)/*-{
		$wnd.Ext.define(name, {
			extend : 'Ext.data.Model',
			config : {
				fields : f
			}
		});
    }-*/;

}
