package com.emitrom.touch4j.client.core.config;

/**
 * Controls on which side to display the menu component on the viewport
 */
public enum MenuSide {

    LEFT("left"), TOP("top"), RIGHT("right"), BOTTOM("bottom");

    private String side;

    private MenuSide(String side) {
        this.side = side;
    }

    public String getValue() {
        return this.side;
    }
}
