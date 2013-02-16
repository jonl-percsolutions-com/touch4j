/**************************************************************************
 * ComponentConfig.java is part of Touch4j 4.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core.config;

import com.emitrom.touch4j.client.core.JsoHelper;
import com.emitrom.touch4j.client.laf.UI;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class ComponentConfig extends BaseConfig {

  public ComponentConfig() {
	  super();
  }

  /**
   * The base CSS class to apply to this components's element.
   * This will also be prepended to other elements within this component.
   * To add specific styling for sub-classes, use the cls config.
   * 
   * Defaults to: null
   */
  public void setBaseCls(String value) {
	  JsoHelper.setAttribute(jsObj, Attribute.BASE_CLS.getValue(), value);
  }

  /**
   * The border to use on this Component. 
   * Can be specified as a number (in which case all edges get the same border width) or a CSS string like '5 10 10 10'
   * 
   * Defaults to: null
   */
  public void setBorder(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.BORDER.getValue(), value);
  }

  /**
   * The border to use on this Component. 
   * Can be specified as a number (in which case all edges get the same border width) or a CSS string like '5 10 10 10'
   * 
   * Defaults to: null
   */
  public void setBorder(double value) {
	  JsoHelper.setAttribute(jsObj, Attribute.BORDER.getValue(), value);
  }
  
  /**
   * Defaults to: null
   */
  public void setBottom(double value) {
	  JsoHelper.setAttribute(jsObj, Attribute.BOTTOM.getValue(), value);
  }
  
  /**
   * Defaults to: null
   */
  public void setBottom(boolean value) {
	  JsoHelper.setAttribute(jsObj, Attribute.BOTTOM.getValue(), value);
  }

  /**
   * Whether or not this component is absolutely centered inside its container
   * 
   * Defaults to: null
   */
  public void setCentered(boolean value) {
	  JsoHelper.setAttribute(jsObj, Attribute.CENTERED.getValue(), value);
  }

  /**
   * The CSS class to add to this component's element, in addition to the baseCls
   * 
   * Defaults to: null
   */
  public void setCls(String value) {
	  JsoHelper.setAttribute(jsObj, Attribute.CLS.getValue(), value);
  }

  /**
   * CSS class to add to this Component. Deprecated, please use cls instead
   */
  @Deprecated
  public void setComponentCls(String value) {
	  JsoHelper.setAttribute(jsObj, Attribute.COMPONENT_CLS.getValue(), value);
  }
  
  /**
   * The initial set of data to apply to the tpl to update the content area of the Component.
   * 
   * Defaults to: null
   */
  public void setData(Object value) {
	  JsoHelper.setAttribute(jsObj, Attribute.DATA.getValue(), value);
  }

  /**
   * Whether or not this component is disabled
   * 
   * Defaults to: null
   */
  public void setDisabled(boolean value) {
	  JsoHelper.setAttribute(jsObj, Attribute.DISABLED.getValue(), value);
  }

  /**
   * The CSS class to add to the component when it is disabled
   */
  public void setDisabledCls(String value) {
	  JsoHelper.setAttribute(jsObj, Attribute.DISABLED_CLS.getValue(), value);
  }
  
  /**
   * The dock position of this component in its container. Can be 'left', 'top', 'right' or 'bottom'.
   */
  public void setDocked(Dock dock) {
	  setDocked(dock.getValue());
  }

  /**
   * Configuration options to make this Component draggable
   * 
   * Defaults to: null
   */
  @Deprecated
  public void setDraggable(boolean value) {
	  JsoHelper.setAttribute(jsObj, Attribute.DRAGGABLE.getValue(), value);
  }

  /**
   * Configuration options to make this Component draggable
   * 
   * Defaults to: null
   */
  public void setDraggable(Object value) {
	  JsoHelper.setAttribute(jsObj, Attribute.DRAGGABLE.getValue(), value);
  }

  /**
   * Configuration options to make this Component droppable
   * 
   * Defaults to: null
   */
  public void setDroppable(Object value) {
		JsoHelper.setAttribute(jsObj, Attribute.DROPPABLE.getValue(), value);
  }
  
  public void setFlex(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.FLEX.getValue(), value);
  }

  /**
   * Force the component to take up 100% width and height available, by adding it to Ext.viewport.Viewport.
   */
  @Deprecated
  public void setFullScreen(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.FULL_SCREEN.getValue(), value);
  }

  /**
   * The height of this component in pixels.
   * 
   * Defaults to: null
   */
  public void setHeight(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.HEIGHT.getValue(), value);
  }

  /**
   * True to hide this component
   * 
   * Defaults to: false
   */
  public void setHidden(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.HIDDEN.getValue(), value);
  }

  /**
   * When using a modal Component, setting this to true (the default) will hide the 
   * modal mask and the Component when the mask is tapped on.
   * 
   * Defaults to: true
   */
  public void setHideOnMaskTap(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.HIDE_ON_MASK_TAP.getValue(), value);
  }

  /**
   * Optional HTML content to render inside this Component.
   * 
   * Defaults to: null
   */
  public void setHtml(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.HTML.getValue(), value);
  }
  
  /**
   * Defaults to: null
   */
  public void setLeft(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.LEFT.getValue(), value);
  }

  /**
   * Defaults to: null
   */
  public void setLeft(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.LEFT.getValue(), value);
  }
  
  /**
   * The margin to use on this Component. Can be specified as a number 
   * (in which case all edges get the same margin) or a CSS string like '5 10 10 10'
   * 
   * Defaults to: null
   */
  public void setMargin(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.MARGIN.getValue(), value);
  }

  /**
   * The margin to use on this Component. Can be specified as a number 
   * (in which case all edges get the same margin) or a CSS string like '5 10 10 10'
   * 
   * Defaults to: null
   */
  public void setMargin(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.MARGIN.getValue(), value);
  }

  /**
   * True to mask this component.
   * 
   * Defaults to: null
   */
  public void setMasked(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.MASKED.getValue(), value);
  }
  
  /**
   * True to make this Component modal. This will create a mask underneath the 
   * Component that covers the whole page and does not allow the user to interact with any 
   * other Components until this Component is dismissed
   * 
   * Defaults to: null 
   */
  public void setModal(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.MODAL.getValue(), value);
  }

  /**
   * The padding to use on this Component. Can be specified as a number 
   * (in which case all edges get the same padding) or a CSS string like '5 10 10 10'
   * 
   * Defaults to: null
   */
  public void setPadding(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.PADDING.getValue(), value);
  }

  /**
   * The padding to use on this Component. Can be specified as a number 
   * (in which case all edges get the same padding) or a CSS string like '5 10 10 10'
   * 
   * Defaults to: null
   */
  public void setPadding(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.PADDING.getValue(), value);
  }

  /**
   * An XTemplate used to create the internal structure inside this Component's 
   * encapsulating Element. You do not normally need to specify this. For the base classes Ext.Component 
   * and Ext.Container, this defaults to null which means that they will be initially rendered with 
   * no internal structure; they render their Element empty.
   * The more specialized ExtJS and Touch classes which use a more complex DOM structure, provide their own 
   * template definitions. 
   * This is intended to allow the developer to create application-specific utility Components with customized internal structure.
   * 
   * @param value
   */
  public void setRenderTpl(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.RENDER_TPL.getValue(), value);
  }

  /**
   * An XTemplate used to create the internal structure inside this Component's 
   * encapsulating Element. You do not normally need to specify this. For the base classes Ext.Component 
   * and Ext.Container, this defaults to null which means that they will be initially rendered with 
   * no internal structure; they render their Element empty.
   * The more specialized ExtJS and Touch classes which use a more complex DOM structure, provide their own 
   * template definitions. 
   * This is intended to allow the developer to create application-specific utility Components with customized internal structure.
   */
  protected void setRenderTpl(JavaScriptObject value) {
		JsoHelper.setAttribute(jsObj, Attribute.RENDER_TPL.getValue(), value);
  }

  /**
   * Defaults to: null
   */
  public void setRight(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.RIGHT.getValue(), value);
  }

  /**
   * Defaults to: null
   */
  public void setRight(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.RIGHT.getValue(), value);
  }
  
  /**
   * Optional CSS styles that will be rendered into an inline style attribute
   * when the Component is rendered
   * 
   * Defaults to: null
   */
  public void setStyle(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.STYLE.getValue(), value);
  }
  
  /**
   * The class that is added to the content target when you set styleHtmlContent to true.
   */
  public void setStyleHtmlCls(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.STYLE_HTML_CLS.getValue(), value);
  }

  /**
   * True to automatically style the html inside the content target of this component (body for panels).
   * 
   * Defaults to: null
   */
  public void setStyleHtmlContent(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.STYLE_HTML_CONTENT.getValue(), value);
  }
  
  /**
   * Defaults to: null
   */
  public void setTop(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.TOP.getValue(), value);
  }

  /**
   * Defaults to: null
   */
  public void setTop(boolean value) {
		JsoHelper.setAttribute(jsObj, Attribute.TOP.getValue(), value);
  }

  /**
   * An Ext.Template, Ext.XTemplate or an array of strings to form an Ext.XTemplate.
   * Used in conjunction with the data and tplWriteMode configurations.
   * 
   * Defaults to: null
   */
  public void setTpl(JsArrayString value) {
		JsoHelper.setAttribute(jsObj, Attribute.TPL.getValue(), value);
  }

  /**
   * An Ext.Template, Ext.XTemplate or an array of strings to form an Ext.XTemplate.
   * Used in conjunction with the data and tplWriteMode configurations.
   * 
   * Defaults to: null
   */
  public void setTpl(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.TPL.getValue(), value);
  }

  /**
   * The Ext.(X)Template method to use when updating the content area of the Component.
   * 
   * Defaults to 'overwrite' (see Ext.XTemplate.overwrite).
   */
  public void setTplWriteMode(String value) {
		JsoHelper.setAttribute(jsObj, Attribute.TPL_WRITE_MODE.getValue(), value);
  }
  
  /**
   * The ui to be used on this Component
   * 
   * Defaults to: null
   */
  public final void setUi(UI ui) {
	  _setUi(ui.getValue());
  }
  
  /**
   * The width of this component in pixels.
   *
   * Defaults to: null
   */
  public void setWidth(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.WIDTH.getValue(), value);
  }

  /**
   * The z-index to give this Component when it is rendered
   * 
   * Defaults to: null
   */
  public void setZindex(double value) {
		JsoHelper.setAttribute(jsObj, Attribute.Z_INDEX.getValue(), value);
  }

  protected void setRenderTo(JavaScriptObject value) {
		JsoHelper.setAttribute(jsObj, Attribute.RENDER_TO.getValue(), value);
  }

  private  void _setUi(String value) {
	  JsoHelper.setAttribute(jsObj, Attribute.UI.getValue(), value);
  }
  
  /**
   * The dock position of this component in its container. Can be 'left', 'top', 'right' or 'bottom'.
   */
  private  void setDocked(String value) {
	  JsoHelper.setAttribute(jsObj, Attribute.DOCKED.getValue(), value);
  }

}
