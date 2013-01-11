package com.emitrom.gwt4.touch.client.layout;

public enum Layout {

    CARD("card"), FIT("fit"), HBOX("hbox"), VBOX("vbox");

    private String value;

    private Layout(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
