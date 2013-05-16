package com.emitrom.touch4j.formfactor.client;

/**
 * Base Interface to generate device specific user interface. Implement this
 * interface to provide different ui implementations based on the user target
 * device.
 * 
 */
public interface ClientFactory {
    public void layoutUI();
}
