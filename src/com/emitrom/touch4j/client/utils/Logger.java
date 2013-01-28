package com.emitrom.touch4j.client.utils;

/**
 * Logs messages to help with debugging.
 */
public class Logger {

    private Logger() {

    }

    /**
     * Convenience method for log with priority 'deprecate'.
     */
    public static native void deprecate(String message)/*-{
		$wnd.Ext.Logger.deprecate(message);
    }-*/;

    /**
     * Convenience method for log with priority 'error'.
     */
    public static native void error(String message)/*-{
		$wnd.Ext.Logger.error(message);
    }-*/;

    /**
     * Convenience method for log with priority 'error'.
     */
    public static native void info(String message)/*-{
		$wnd.Ext.Logger.info(message);
    }-*/;

    /**
     * Logs a message to help with debugging.
     */
    public static native void log(String message, int priority)/*-{
		$wnd.Ext.Logger.log(message, priority);
    }-*/;

    /**
     * Convenience method for log with priority 'verbose'.
     */
    public static native void verbose(String message)/*-{
		$wnd.Ext.Logger.verbose(message);
    }-*/;

    /**
     * Convenience method for log with priority 'warn'.
     */
    public static native void warn(String message)/*-{
		$wnd.Ext.Logger.warn(message);
    }-*/;
}
