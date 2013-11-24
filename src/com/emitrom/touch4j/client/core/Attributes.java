/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.emitrom.touch4j.client.core;

/**
 * Enum representing all jQuery Mobile attributes
 * 
 */
public enum Attributes {

    BACK("back"), BUTTON("button"), CHECKBOX("checkbox"), CODE("code"), COLLAPSIBLE("collapsible"), COLLAPSIBLE_SET(
                    "collapsible-set"), CONTENT("content"), CONTROL_GROUP("controlgroup"), DATA_ADD_BACK_BUTTON(
                    "data-add-back-btn"), DATA_DIVIDER_THEME("data-dividertheme"), DATA_FILTER("data-filter"), DATA_ICON(
                    "data-icon"), DATA_COLLAPSE("data-collapse"), DATA_INLINE("data-inline"), DATA_INSET("data_inset"), DATA_LINE(
                    "data-line"), DATA_MENU_NATIVE("data-menu-native"), DATA_POSITION("data-position"), DATA_REL(
                    "data-rel"), DATA_ROLE("data-role"), DATA_THEME("data-theme"), DATA_TITLE("data-title"), DATA_TRANSITION(
                    "data-transition"), DATA_TYPE("data-type"), DATA_URL("data-url"), DATA_FULLSCREEN("fullscreen"), FOOTER(
                    "footer"), DIALOG("dialog"), EMAIL("email"), EXTERNAL("external"), HASH_TAG("#"), HEADER("header"), HORIZONTAL(
                    "horizontal"), HREF("href"), ID("id"), DATA_ICON_POSITION("data-iconpos"), PAGE("page"), REL("rel"), REVERSE(
                    "reverse"), ACCELERATE_ON_TAP_HOLD("accelerateOnTapHold"), ACTIVE_ITEM("activeItem"), ALIGN("align"), AUTO_CAPITALIZATION(
                    "autoCapitalize"), AUTO_COMPLETE("autoComplete"), AUTO_CORRECT("autoCorrect"), AUTO_DESTROY(
                    "autoDestrooy"), BADGE_TEXT("badgeText"), BASE_CLS("baseCls"), BORDER("border"), BOTTOM("bottom"), BUFFER_RESIZE(
                    "bufferResize"), BUTTONS("buttons"), CENTER("center"), CENTERED("centered"), CHECKED("checked"), CHILDREN(
                    "children"), CLEAR_ICON("clearIcon"), CLOSABLE("closable"), CLS("cls"), COMP_J("__compJ"), CORDOVA(
                    "cordova"), CYCLE("cycle"), COMPONENT_CLS("componentCls"), DATA("data"), DATAINDEX("dataIndex"), DEFAULT_TEXT_HEIGHT(
                    "defaultTextHeight"), DEFAULT_TYPE("defaultType"), DEFAULTS("defaults"), DEFER_EMPTY_TEXT(
                    "deferEmptyText"), DESTROY_PICKER_ON_HIDE("destroyPickerOnHide"), DIRECTION("direction"), DISABLED(
                    "disabled"), DISABLED_CLS("disabledCls"), DISPLAY_FIELD("displayField"), DOCKED("docked"), DOWN(
                    "down"), DRAGGABLE("draggable"), DROPPABLE("droppable"), EDITOR("editor"), EMPTY_TEXT("emptyText"), ENABLE_TOGGLE(
                    "enableToggle"), FIELD_CONTAIN("fieldcontain"), FILTER("filter"), FLEX("flex"), FLOATING("floating"), FOR(
                    "for"), FULL_SCREEN("fullscreen"), FREQUENCY("frequency"), GRID_HEADER("header"), GAUGE("gauge"), HEIGHT(
                    "height"), HIDDEN("hidden"), HIDE_BORDERS("hideBorders"), HIDDEN_NAME("hiddenName"), HIDE_ON_MASK_TAP(
                    "hideOnMaskTap"), HTML("html"), ICON("icon"), ICON_CLS("iconCls"), INCREMENT("increment"), INDICATOR(
                    "indicator"), INPUT("input"), INSET("inset"), INSTRUCTIONS("instructions"), ITEM_TPL("itemTpl"), ITEMS(
                    "items"), LABEL_ALIGN("labelAlign"), LABEL_CLS("labelCls"), LABEL_WIDTH("labelWidth"), LAYOUT(
                    "layout"), LEAF("leaf"), LEFT("left"), LIST_VIEW("listview"), LOADING_TEXT("loadingText"), MARGIN(
                    "margin"), MAX_LENGTH("maxLength"), MAX_ROWS("maxRows"), MAX_VALUE("maxValue"), MESSAGE("message"), LIST_DIVIDER(
                    "list-divider"), MAX_VALUE_CLS("maxValueCls"), MASKED("masked"), METHOD("method"), MIN_VALUE(
                    "minValue"), MIN_VALUE_CLS("minValueCls"), MODAL("modal"), MSG("msg"), MULTILINE("multiline"), MULTIPLE(
                    "multiple"), NAME("name"), NONE("none"), NUMBER("number"), OPTIONS("options"), PADDING("padding"), PASSWORD(
                    "password"), PICKER("picker"), PHONEGAP("phoneGap"), PLATFORM("platform"), PROMPT("prompt"), PROGRESS(
                    "progress"), RENDER("render"), RENDERED_CHANGE("renderedchange"), RENDER_TO("renderTo"), RENDER_TPL(
                    "renderTpl"), REQUIRED("required"), REQUIRED_CLS("requiredCls"), RIGHT("right"), SCROLLABLE(
                    "scrollable"), SLIDER("slider"), SORTABLE("sortable"), SRC("src"), STEP_VALUE("stepValue"), STYLE(
                    "style"), STYLE_HTML_CLS("styleHtmlCls"), STYLE_HTML_CONTENT("styleHtmlContent"), SUBMIT_DISABLED(
                    "submitDisabled"), TAB_INDEX("tabIndex"), TAG("tag"), TEXT("text"), THUMBS("thumbs"), TITLE("title"), TOP(
                    "top"), TPL("tpl"), TPL_WRITE_MODE("tplWriteMode"), TRANSPARENT("transparent"), TYPE("type"), UI(
                    "ui"), UP("up"), URL("url"), UUID("uuid"), VALUE("value"), VALUE_FIELD("valueField"), VERSION(
                    "version"), WIDGET("widget"), WIDTH("width"), X("x"), XTYPE("xtype"), Y("y"), Z_INDEX("zIndex");

    private String attribute;

    private Attributes(String value) {
        this.attribute = value;
    }

    public String getValue() {
        return attribute;
    }
}
