/**************************************************************************
 * XType.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
 **************************************************************************/
package com.emitrom.gwt4.touch.client.core.config;

/**
 * Class to enumerate all the Touch xtype fields.
 */
public enum XType {
    AUDIO("audio"), ACTONSHEET("actionsheet"), BOX("box"), BUTTON("button"), CHART("chart"), CALENDAR("calendar"), CHECKBOX_FIELD(
                    "checkboxfield"), CAROUSEL("carousel"), COMPONENT("component"), CONTAINER("container"), CROSSCUT(
                    "crosscut"), DATAVIEW("dataview"), DATAITEM("dataitem"), DATEPICKER("datepicker"), DATEPICKER_FIELD(
                    "datepickerfield"), EMAIL_FIELD("emailfield"), FIELD("field"), FIELDSET("fieldset"), FORMPANEL(
                    "formpanel"), GWT_WIDGET("gwtwidget"), HIDDEN_FIELD("hiddenfield"), IMAGE("image"), INPUT_FIELD(
                    "input"), LABEL("label"), LIST("list"), LOADMASK("loadmask"), MAP("map"), MASK("mask"), MEDIA(
                    "media"), NAVIGATION_VIEW("navigationview"), NESTEDLIST("nestedlist"), NUMBER_FIELD("numberfield"), PANEL(
                    "panel"), PASSWORD_FIELD("passwordfield"), PICKER("picker"), RADIO_FIELD("radiofield"), RATING(
                    "rating"), SEARCH_FIELD("searchfield"), SEGMENTED_BUTTON("segmentedbutton"), SELECT_FIELD(
                    "selectfield"), SHEET("sheet"), SLIDER_FIELD("sliderfield"), SPACER("spacer"), SPINNER_FIELD(
                    "spinnerfield"), TAB_PANEL("tabpanel"), TEXT_FIELD("textfield"), TEXTAREA_FIELD("textareafield"), TEXTAREA_INPUT_FIELD(
                    "textareainput"), TITLEBAR("titlebar"), TOGGLE_FIELD("togglefield"), TOOLBAR("toolbar"), URL_FIELD(
                    "urlfield"), VIDEO("video"), TITLE("title"), TOUCH_GRID("touchgridpanel"), WIDGET_COMPONENT(
                    "widgetComponent"), TABAR("tabbar");

    private String value;

    private XType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
