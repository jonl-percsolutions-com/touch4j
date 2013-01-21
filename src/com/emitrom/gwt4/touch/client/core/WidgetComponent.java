/**************************************************************************
 * WidgetComponent.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.gwt4.touch.client.core;

import com.emitrom.gwt4.touch.client.core.config.XType;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Adapter between GWT {@link com.google.gwt.user.client.ui.Widget}'s and
 * {@link com.emitrom.gwt4.touch.client.core.Component}'s. This class enables
 * the use of pure GWT component inside Touch4j panels
 */
public class WidgetComponent extends Component {

    private static int widgetComponentId = 0;

    public static final String hiddenDivID = "__touch4j_hidden";
    private Widget widget;

    static {
        bootstrap();
    }

    public WidgetComponent() {
        id = new StringBuilder().append("ext-").append(this.getXType()).append("-").append(++widgetComponentId)
                        .toString();
        JsoHelper.setAttribute(config, "id", id);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.WidgetComponent(config);
    }-*/;

    @Override
    public String getXType() {
        return XType.WIDGET_COMPONENT.getValue();
    }

    private static native void bootstrap()/*-{
		$wnd.Ext.define('Ext.ux.WidgetComponent', {
			extend : 'Ext.Component',
			xtype : 'widgetComponent',
			widget : null,
			constructor : function(config) {
				var me = this;
				me.callParent(config);
			}
		});
    }-*/;

    public WidgetComponent(final Widget widget) {
        this();
        createHiddenDiv();
        this.widget = widget;
        setWidget(widget);
    }

    public static void createHiddenDiv() {
        ExtElement hiddenDiv = Ext.get(hiddenDivID);
        if (hiddenDiv == null) {
            DOMConfig domConfig = new DOMConfig("div", hiddenDivID, null);
            domConfig.setStyle("display:none;");
            DOMHelper.append(RootPanel.getBodyElement(), domConfig);
        }
    }

    protected WidgetComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public native void setWidget(Widget w)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.WidgetComponent::getOrCreateJsObj()();
		jso.widget = w;
		//a GWT widget must be attached to a GWT Panel for its events to fire.
		var attached = jso.widget.@com.google.gwt.user.client.ui.Widget::isAttached()();
		if (!attached) {
			var rp = @com.google.gwt.user.client.ui.RootPanel::get(Ljava/lang/String;)('__touch4j_hidden');
			rp.@com.google.gwt.user.client.ui.HasWidgets::add(Lcom/google/gwt/user/client/ui/Widget;)(jso.widget);

		}
		var widgetEl = jso.widget.@com.google.gwt.user.client.ui.UIObject::getElement()();
		widgetEl.width = "100%";
		widgetEl.height = "100%";
		jso.element.dom.insertBefore(widgetEl);
    }-*/;

    @Override
    protected void init() {
    }

}
