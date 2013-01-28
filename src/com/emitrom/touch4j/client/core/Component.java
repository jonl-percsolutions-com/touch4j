/**************************************************************************
 * Component.java is part of Touch4j 3.0. Copyright 2012 Emitrom LLC
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
package com.emitrom.touch4j.client.core;

import com.emitrom.touch4j.client.core.config.Attribute;
import com.emitrom.touch4j.client.core.config.ComponentConfig;
import com.emitrom.touch4j.client.core.config.Dock;
import com.emitrom.touch4j.client.core.config.Event;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.core.handlers.CallbackRegistration;
import com.emitrom.touch4j.client.core.handlers.component.BottomChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.CenteredChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.DisabledChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.DockedChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.HeightChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.HideHandler;
import com.emitrom.touch4j.client.core.handlers.component.LeftChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.ResizeHandler;
import com.emitrom.touch4j.client.core.handlers.component.RightChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.ShowHandler;
import com.emitrom.touch4j.client.core.handlers.component.TopChangeHandler;
import com.emitrom.touch4j.client.core.handlers.component.WidthChangeHandler;
import com.emitrom.touch4j.client.fx.layout.card.Animation;
import com.emitrom.touch4j.client.fx.layout.card.AnimationType;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.Element;

/**
 * <p>
 * Base class for all Ext components. All subclasses of Component may
 * participate in the automated Ext component lifecycle of creation, rendering
 * and destruction which is provided by the Container class. Components may be
 * added to a Container through the items config option at the time the
 * Container is created, or they may be added dynamically via the add method.
 * </p>
 * 
 * <p>
 * The Component base class has built-in support for basic hide/show and
 * enable/disable behavior.
 * </p>
 * 
 * <p>
 * All Components are registered with the Ext.ComponentMgr on construction so
 * that they can be referenced at any time via Ext.getCmp, passing the id.
 * </p>
 * 
 * <p>
 * All user-developed visual widgets that are required to participate in
 * automated lifecycle and size management should subclass Component (or
 * Ext.BoxComponent if managed box model handling is required, ie height and
 * width management).
 * </p>
 * <p>
 * Every component has a specific xtype. This is the list of all valid xtypes:
 * </p>
 * 
 * <pre>
 * <p/>
 * xtype            Class
 * -------------    ------------------
 * button           Button
 * component        Component
 * container        Container
 * dataview         DataView
 * panel            Panel
 * toolbar          Toolbar
 * spacer           Spacer
 * tabpanel         TabPanel
 * <p/>
 * 
 * Form components
 * ---------------------------------------
 * formpanel        FormPanel
 * checkboxField    Checkbox
 * selectfield      Select
 * field            Field
 * fieldset         FieldSet
 * hiddenField      Hidden
 * numberfield      Number
 * radiofield       Radio
 * textareafield    TextArea
 * textfield        Text
 * togglefield      Toggle
 * </pre>
 * 
 * @see <a
 *      href=http://docs.sencha.com/touch/2-0/#!/api/Ext.Component>Ext.Component
 *      </a>
 */
public abstract class Component extends TouchWidget implements BoxWidget, HasBoxHandlers, HasFocusHandlers,
                FocusWidget, HasHtml {

    protected JavaScriptObject configPrototype;
    private boolean initHidden = false;
    private boolean initDisabled = false;
    private static final String POST_RENDER = "post-render";

    protected abstract void init();

    protected native JavaScriptObject cloneConfig(JavaScriptObject config)/*-{
		var clone = {};
		var id = $wnd.Ext.id();
		var cfg = $wnd.Ext.applyIf(clone, config);
		cfg.id = id; // prevent dup id
		return clone;
    }-*/;

    protected static native String getConfigAsString(JavaScriptObject jsObj) /*-{
		var props = '{';
		for ( var k in jsObj) {
			props += '\n[' + k + '=>' + jsObj[k] + ']';
		}
		return props + '}';
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    protected Component(JavaScriptObject jsObj) {
        id = JsoHelper.getAttribute(jsObj, Attribute.ID.getValue());
        config = jsObj;
        setElement(getElement(jsObj));
        init();
    }

    /**
     * Create a new Component.
     */
    public Component() {
        id = Ext.generateId("ext-emitrom-");

        initConfig();
        if (config == null) {
            config = JsoHelper.createObject();
        }
        JsoHelper.setAttribute(config, Attribute.COMP_J.getValue(), this);
        JsoHelper.setAttribute(config, Attribute.ID.getValue(), id);
        JsoHelper.setAttribute(config, Attribute.XTYPE.getValue(), getXType());
        init();
    }

    /**
     * Component Constructor. Applies the Component to an existing element.
     * 
     * @param element
     *            the Element to apply the Component to
     */
    public Component(Element element) {
        id = DOMUtil.getID(element);
        if (id == null) {
            id = Ext.generateId();
            DOMUtil.setID(element, id);
        }
        config = JsoHelper.createObject();
        setId(id);
        getOrCreateJsObj();
        init();
    }

    /**
     * Component with config options
     * 
     * @param configOptions
     */
    public Component(ComponentConfig configOptions) {
        this(configOptions.getJsObj());
    }

    /**
     * Creates a Component object reference for an already rendered Component.
     * 
     * @param id
     *            the Component ID
     */
    public Component(String id) {
        setElement(getElement(getComponentJS(id)));
        init();
    }

    /**
     * Adds a CSS class (or classes) to this Component's rendered element
     * 
     * @param cls
     * @param prefix
     * @param suffix
     */
    public native void addCls(String cls, String prefix, String suffix) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.addCls(cls, prefix, suffix);
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#destroy()
     */
    @Override
    public native void destroy() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null)
			component.destroy();
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#disable()
     */
    @Override
    public void disable() {
        if (!isRendered()) {
            initDisabled = true;
            setAttribute(Attribute.DISABLED.getValue(), true, true);
            addListener(Attribute.RENDER.getValue(), new Function() {
                public void execute() {
                    disableRendered();
                }
            });
        } else {
            disableRendered();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#enable()
     */
    @Override
    public void enable() {
        if (!isRendered()) {
            setAttribute(Attribute.DISABLED.getValue(), false, true);
            addListener(Attribute.RENDER.getValue(), new Function() {
                public void execute() {
                    enableRendered();
                }
            });
        } else {
            enableRendered();
        }
    }

    /**
     * Returns the value of baseCls.
     * 
     * @return baseCls
     */
    public native String getBaseCls() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getBaseCls();
		}
    }-*/;

    /**
     * Returns the value of border.
     * 
     * @param <T>
     * 
     *            Returns Number/String
     */
    public native <T> T getBorder() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getBorder();
		}
    }-*/;

    /**
     * Returns the value of bottom.
     * 
     * @param <T>
     * @return Number/Boolean
     */
    public native <T> T getBottom() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getBottom();
		}
    }-*/;

    /**
     * Returns the value of centered.
     * 
     * @return Boolean
     */
    public native boolean isCentered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getCentered();
		}
    }-*/;

    /**
     * Returns the value of cls.
     * 
     * @return String
     */
    public native String getCls() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getCls();
		}
    }-*/;

    /**
     * Returns the value of data.
     * 
     * @return Object
     */
    public native <T> T getData() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getData();
		}
    }-*/;

    /**
     * Returns the value of disabledCls.
     * 
     * @return String
     */
    public native String getDisabledCls() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDisabledCls();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#getDraggable()
     */
    @Override
    public native <T> T getDraggable() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDraggable();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#getDroppable()
     */
    @Override
    public native <T> T getDroppable() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDroppable();
		}
    }-*/;

    @Override
    public native ExtElement getEl() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var el = component.element;
		if (el == null || el === undefined) {
			return null;
		} else {
			return @com.emitrom.touch4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getHeight()
     */
    @Override
    public native int getHeight() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getHeight();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#getHtml()
     */
    @Override
    public native String getHtml() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getHtml();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getLeft()
     */
    @Override
    public native <T> T getLeft() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getLeft();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getMargin()
     */
    @Override
    public native <T> T getMargin() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getMargin();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#isMasked()
     */
    @Override
    public native boolean isMasked() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getMasked();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#isModal()
     */
    @Override
    public native boolean isModal() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getModal();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getPadding()
     */
    @Override
    public native <T> T getPadding() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getPadding();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#getRenderTo()
     */
    @Override
    public Element getRenderTo() {
        return JsoHelper.getAttributeAsElement(config, Attribute.RENDER_TO.getValue());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#getRenderTpl()
     */
    @Override
    public native <T> T getRenderTpl() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getRenderTpl();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getRight()
     */
    @Override
    public native <T> T getRight() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getRight();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getSize()
     */
    @Override
    public native Size getSize() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return @com.emitrom.touch4j.client.core.Size::new(Lcom/google/gwt/core/client/JavaScriptObject;)(component.getSize());
		}
    }-*/;

    /**
     * Returns the value of style.
     * 
     * @param <T>
     * @return String/Object
     */
    public native <T> T getStyle() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getStyle();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#getStyleHtmlCls()
     */
    @Override
    public native String getStyleHtmlCls() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getStyleHtmlCls();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#hasStyleHtmlContent()
     */
    @Override
    public native boolean hasStyleHtmlContent() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getStyleHtmlContent();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getTop()
     */
    @Override
    public native <T> T getTop() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getTop();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#getTpl()
     */
    @Override
    public native <T> T getTpl() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getTpl();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#getTplWriteMode()
     */
    @Override
    public native String getTplWriteMode() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getTplWriteMode();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#getWidth()
     */
    @Override
    public native int getWidth() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getWidth();
		}
    }-*/;

    /**
     * Returns this component's xtype hierarchy as a slash-delimited string. For
     * a list of all available xtypes, see the Component class javadocs.
     * <p/>
     * 
     * <pre>
     * <code>
     * <p/>
     * Text field = new Text();
     * field.getXTypes() returns "component/box/field/textfield"
     * </code>
     * </pre>
     * 
     * @return the xtype hierarchy string
     */
    public native String getXTypes() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getXTypes();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#getZIndex()
     */
    @Override
    public native double getZIndex() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getZIndex();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#hide()
     */
    @Override
    public void hide() {

        hideRendered();
        if (!isRendered()) {
            initHidden = true;
            this.addListener(Attribute.RENDERED_CHANGE.getValue(), new Function() {
                @Override
                public void execute() {
                    Scheduler.get().scheduleDeferred(new ScheduledCommand() {

                        @Override
                        public void execute() {
                            hideRendered();
                        }
                    });
                }
            });
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#isDisabled()
     */
    @Override
    public boolean isDisabled() {
        if (!isRendered()) {
            return initDisabled;
        } else {
            return isDisabledRendered();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#isHidden()
     */
    @Override
    public boolean isHidden() {
        if (!isRendered()) {
            return initHidden;
        } else {
            return isHiddenRendered();
        }
    }

    /**
     * Tests whether or not this component is of a specific xtype. This can test
     * whether this component is descended from the xtype (default) or whether
     * it is directly of the xtype specified (shallow = true). For a list of all
     * available xtypes, see the {@link Component} header. Example usage:
     * <p/>
     * 
     * <pre>
     * <code>
     * <p/>
     * <p/>
     * Text t = new Text();
     * boolean isText = t.isXType('textfield');        // true
     * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
     * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
     * <p/>
     * </code>
     * </pre>
     * 
     * @param xtype
     *            the xtype to check for this component
     * @return true if is style
     */
    public native boolean isXType(String xtype) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return component.isXType(xtype);
    }-*/;

    /**
     * Tests whether or not this component is of a specific xtype. This can test
     * whether this component is descended from the xtype (default) or whether
     * it is directly of the xtype specified (shallow = true). For a list of all
     * available xtypes, see the {@link Component} header. Example usage:
     * <p/>
     * 
     * <pre>
     * <code>
     * <p/>
     * <p/>
     * Text t = new Text();
     * boolean isText = t.isXType('textfield');        // true
     * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
     * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
     * <p/>
     * </code>
     * </pre>
     * 
     * @param xtype
     *            the xtype to check for this component
     * @param shallow
     *            false to check whether this component is descended from the
     *            xtype (this is the default), or true to check whether this
     *            component is directly of the specified xtype.
     * @return true if is style
     */
    public native boolean isXType(String xtype, boolean shallow) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return component.isXType(xtype, shallow);
    }-*/;

    public native void removeCls(String cls, String prefix, String suffix) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.removeCls(cls, prefix, suffix);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.FocusWidget#setBaseCls(java.lang.String )
     */
    @Override
    public native void setBaseCls(String baseCls) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBaseCls(baseCls);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setBorder(double)
     */
    @Override
    public native void setBorder(double value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBorder(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.BoxWidget#setBorder(java.lang.String)
     */
    @Override
    public native void setBorder(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBorder(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setBottom(double)
     */
    @Override
    public native void setBottom(double value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBottom(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setBottom(boolean)
     */
    @Override
    public native void setBottom(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setBottom(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setCentered(boolean)
     */
    @Override
    public native void setCentered(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setCentered(value);
		}
    }-*/;

    public native void setCls(String cls) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setCls(cls);
		}
    }-*/;

    /**
     * Sets the value of data.
     * 
     * @param value
     *            , Object
     * 
     */
    public void setFullScreen(boolean value) {
        JsoHelper.setAttribute(config, Attribute.FULL_SCREEN.getValue(), value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setDisabled(boolean)
     */
    @Override
    public native void setDisabled(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDisabled(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setDisabledCls(java.lang
     * .String)
     */
    @Override
    public native void setDisabledCls(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDisabledCls(value);
		}
    }-*/;

    /**
     * Sets the value of docked.
     * 
     * @param dock
     */
    public void setDocked(Dock dock) {
        setDocked(dock.getValue());
    }

    public Dock getDocked() {
        return Dock.valueOf(_getDocked());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setDraggable(java.lang
     * .Object)
     */
    @Override
    public native void setDraggable(Object value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDraggable(value);
		}
    }-*/;

    @Override
    public native void setDroppable(Object value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDroppable(value);
		}
    }-*/;

    @Override
    public native void setHeight(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHeight(value);
		}
    }-*/;

    public native void setHeight(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHeight(value);
		}
    }-*/;

    @Override
    public native void setHidden(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHidden(value);
		}
    }-*/;

    @Override
    public native void setHtml(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHtml(value);
		}
    }-*/;

    @Override
    public native void setLeft(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setLeft(value);
		}
    }-*/;

    @Override
    public native void setLeft(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setLeft(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setMargin(int)
     */
    @Override
    public native void setMargin(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setMargin(value);
		}
    }-*/;

    /**
     * Sets the value of margin.
     * 
     * @param value
     */
    public native void setMargin(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setMargin(value);
		}
    }-*/;

    /**
     * Sets the value of masked.
     * 
     * @param value
     */
    public native void setMasked(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setMasked(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setModal(boolean)
     */
    @Override
    public native void setModal(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setModal(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setPadding(int)
     */
    @Override
    public native void setPadding(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setPadding(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.BoxWidget#setPadding(java.lang.String)
     */
    @Override
    public native void setPadding(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setPadding(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setRenderTo(com.google
     * .gwt.user.client.Element)
     */
    @Override
    public native void setRenderTo(Element value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRenderTo(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setRenderTpl(java.lang
     * .Object)
     */
    @Override
    public native void setRenderTpl(Object value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRenderTpl(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setRight(int)
     */
    @Override
    public native void setRight(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRight(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setRight(boolean)
     */
    @Override
    public native void setRight(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setRight(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setSize(int, int)
     */
    @Override
    public native void setSize(int width, int height) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setSize(width, height);
		}
    }-*/;

    public void setSize(String width, String height) {
        setWidth(width);
        setHeight(height);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setSize(com.emitrom.gwt4
     * .touch.client.core.Size)
     */
    @Override
    public void setSize(Size size) {
        this.setSize(size.getWidth(), size.getHeight());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.FocusWidget#setStyle(java.lang.String)
     */
    @Override
    public native void setStyle(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyle(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.FocusWidget#setStyle(java.lang.Object)
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#setStyle(java.lang.Object)
     */
    @Override
    public native void setStyle(Object value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyle(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#setStyleHtmlCls(java.lang.
     * String)
     */
    @Override
    public native void setStyleHtmlCls(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyleHtmlCls(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#setStyleHtmlContent(boolean)
     */
    @Override
    public native void setStyleHtmlContent(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setStyleHtmlContent(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setTop(int)
     */
    @Override
    public native void setTop(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTop(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setTop(boolean)
     */
    @Override
    public native void setTop(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTop(value);
		}
    }-*/;

    /**
     * Sets the value of tpl.
     * 
     * @param value
     */
    public native void setTpl(Object value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTpl(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#setTplWriteMode(java.lang.
     * String)
     */
    @Override
    public native void setTplWriteMode(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setTplWriteMode(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.BoxWidget#setWidth(int)
     */
    @Override
    public native void setWidth(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setWidth(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setZIndex(int)
     */
    @Override
    public native void setZIndex(int value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setZIndex(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#show()
     */
    @Override
    public native void show() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.show();
		}
    }-*/;

    public native void showBy(Component target) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component
					.showBy(target.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()());
		}
    }-*/;

    // public void showBy(Component component, ShowByAlignment alignment) {
    // _showBy(component, alignment.getValue());
    // }

    public native void showBy(Component target, String alignment) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component
					.showBy(
							target.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()(),
							alignment);
		}
    }-*/;

    /**
     * Walks up the ownerCt axis looking for an ancestor Container which matches
     * the passed simple selector.
     * 
     * Example: var owningTabPanel = grid.up('tabpanel');
     * 
     * @param value
     */
    public native void up(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.up(value);
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#update()
     */
    @Override
    @Deprecated
    public native void update() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.update();
		}
    }-*/;

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasHtml#updateStyleHtmlCls(java.lang
     * .Object, java.lang.Object)
     */
    @Override
    public native void updateStyleHtmlCls(Object newHtmlCls, Object oldHtmlCls) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.updateStyleHtmlCls(newHtmlCls, oldHtmlCls);
		}
    }-*/;

    /**
     * Allow the component to fire these events.
     * 
     * @param events
     *            the events
     */
    public void addEvents(String[] events) {
        for (int i = 0; i < events.length; i++) {
            String event = events[i];
            addEvent(event);
        }
    }

    public String getXType() {
        return XType.COMPONENT.getValue();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setVisible(boolean)
     */
    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            show();
        } else {
            hide();
        }
    }

    /**
     * Add a raw event listener.
     * 
     * @param event
     *            the event name
     * @param fn
     *            the function to execute
     */
    public native void addListener(String event, Function fn)/*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.addListener(event, function() {
			return fn.@com.emitrom.touch4j.client.core.Function::execute()();
		});
    }-*/;

    /**
     * The unique id of this component (defaults to an auto-assigned id).
     * <p/>
     * <br>
     * <b>Note:</b> ID's cannot be changed after the component has been
     * rendered.
     * 
     * @param id
     *            the components ID
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public final void setId(String id) throws IllegalStateException {
        setAttribute(Attribute.ID.getValue(), id, false);
        this.id = id;
    }

    /**
     * @return the ID of the Component
     */
    public String getId() {
        return id;
    }

    /**
     * sets the title attribute of this component. This title will only be
     * displayed when the containing parent of this element support titled
     * children
     */
    public void setTitle(String title) {
        setAttribute(Attribute.TITLE.getValue(), title, true, true);
    }

    /**
     * sets the align attribute of this component.
     */
    public void setAlign(String title) {
        setAttribute(Attribute.ALIGN.getValue(), title, true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.FocusWidget#setRenderToID(java.lang
     * .String)
     */
    @Override
    public void setRenderToID(String elemID) throws IllegalStateException {
        setAttribute(Attribute.RENDER_TO.getValue(), elemID, false);
    }

    public void setFlex(int value) {
        getElement().getStyle().setProperty("webkitBoxFlex", String.valueOf(value));
    }

    public String toString() {
        if (!isRendered()) {
            return "<<Lazy Component>>::" + getXType() + ", ID:" + getId();
        } else {
            return super.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Component) {
            if (obj == this) {
                return true;
            } else {
                Component other = (Component) obj;
                if (other.getId().equals(getId())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getId().hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.HasBoxHandlers#addBottomChangeHandler
     * (com
     * .emitrom.gwt4.touch.client.core.handlers.component.BottomChangeHandler)
     */
    @Override
    public CallbackRegistration addBottomChangeHandler(BottomChangeHandler handler) {
        return this.addListener(Event.BOTTOM_CHANGE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.HasBoxHandlers#addCenteredChangeHandler (
     * com.emitrom.touch4j.client.core.handlers.component.CenteredChangeHandler
     * )
     */
    @Override
    public CallbackRegistration addCenteredChangeHandler(CenteredChangeHandler handler) {
        return this.addListener(Event.CENTERED_CHANGED.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.HasFocusHandlers#addDisabledChangeHandler
     * (
     * com.emitrom.touch4j.client.core.handlers.component.DisabledChangeHandler
     * )
     */
    @Override
    public CallbackRegistration addDisabledChangeHandler(DisabledChangeHandler handler) {
        return this.addListener(Event.DISABLED_CHANGE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasBoxHandlers#addDockChangeHandler
     * (com
     * .emitrom.gwt4.touch.client.core.handlers.component.DockedChangeHandler)
     */
    @Override
    public CallbackRegistration addDockChangeHandler(DockedChangeHandler handler) {
        return this.addListener(Event.DOCKED_CHANGE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.emitrom.touch4j.client.core.HasBoxHandlers#addHeightChangeHandler
     * (com
     * .emitrom.gwt4.touch.client.core.handlers.component.HeightChangeHandler)
     */
    @Override
    public CallbackRegistration addHeightChangeHandler(HeightChangeHandler handler) {
        return this.addListener(Event.HEIGHT_CHANGE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasFocusHandlers#addHideHandler(com
     * .emitrom.gwt4.touch.client.core.handlers.component.HideHandler)
     */
    @Override
    public CallbackRegistration addHideHandler(HideHandler handler) {
        return this.addListener(Event.HIDE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasBoxHandlers#addLeftChangeHandler
     * (com.emitrom.touch4j.client.core.handlers.component.LeftChangeHandler)
     */
    @Override
    public CallbackRegistration addLeftChangeHandler(LeftChangeHandler handler) {
        return this.addListener(Event.LEFT_CHANGE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasBoxHandlers#addRightChangeHandler
     * (com
     * .emitrom.gwt4.touch.client.core.handlers.component.RightChangeHandler)
     */
    @Override
    public CallbackRegistration addRightChangeHandler(RightChangeHandler handler) {
        return this.addListener(Event.RIGHT_CHANGE.getValue(), handler);
    }

    /**
     * Important note: For the best performance on mobile devices, use this only
     * when you absolutely need to monitor a Component's size.
     * 
     * Note: This event is not available to be used with event delegation.
     * Instead 'resize' only fires if you explicily add at least one listener to
     * it, due to performance reason.
     */
    public CallbackRegistration addResizeHandler(ResizeHandler handler) {
        return this.addListener(Event.RESIZE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasFocusHandlers#addShowHandler(com
     * .emitrom.gwt4.touch.client.core.handlers.component.ShowHandler)
     */
    @Override
    public CallbackRegistration addShowHandler(ShowHandler handler) {
        return this.addListener(Event.SHOW.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasBoxHandlers#addTopChangeHandler
     * (com.emitrom.touch4j.client.core.handlers.component.TopChangeHandler)
     */
    @Override
    public CallbackRegistration addTopChangeHandler(TopChangeHandler handler) {
        return this.addListener(Event.TOP_CHANGE.getValue(), handler);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.emitrom.touch4j.client.core.HasBoxHandlers#addWidthHandler(com
     * .emitrom.gwt4.touch.client.core.handlers.component.WidthChangeHandler)
     */
    @Override
    public CallbackRegistration addWidthHandler(WidthChangeHandler handler) {
        return this.addListener(Event.WIDTH_CHANGE.getValue(), handler);
    }

    /**
     * set the list of components as plugin for this component
     * 
     * @param components
     *            , array of plugins
     */
    public void setPlugins(Component[] components) {
        _setPlugins(JsoHelper.convertToJavaScriptArray(components));
    }

    /**
     * Add the given component as pluging
     * 
     * @param component
     *            , the component to add as plugin
     */
    public void addPlugin(Component component) {
        _setPlugins(component.getOrCreateJsObj());
    }

    /**
     * sets the show animation
     */
    public void setShowAnimation(Animation animation) {
        _setShowAnimation(animation.getJSO());
    }

    /**
     * sets the show animation
     */
    public native void setShowAnimation(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setShowAnimation(value);
		}
    }-*/;

    public void setShowAnimation(AnimationType animationType) {
        setShowAnimation(animationType.getValue());
    }

    /**
     * sets the hide animation
     */
    public void setHideAnimation(Animation animation) {
        _setHideAnimation(animation.getJSO());
    }

    public void setHideAnimation(AnimationType animationType) {
        setHideAnimation(animationType.getValue());
    }

    /**
     * sets the hide animation
     */
    public native void setHideAnimation(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHideAnimation(value);
		}
    }-*/;

    /**
     * show this component
     */
    public void show(Animation animation) {
        _show(animation.getJSO());
    }

    /**
     * hide this component
     */
    public void hide(Animation animation) {
        _hide(animation.getJSO());
    }

    /**
     * hide this component
     */
    public native void hide(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.hide(value);
		}
    }-*/;

    private native void _hide(JavaScriptObject value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.hide(value);
		}
    }-*/;

    /**
     * show this component
     */
    public native void show(boolean value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.show(value);
		}
    }-*/;

    private native void _show(JavaScriptObject value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.show(value);
		}
    }-*/;

    private native void _setShowAnimation(JavaScriptObject value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setShowAnimation(value);
		}
    }-*/;

    private native void _setHideAnimation(JavaScriptObject value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setHideAnimation(value);
		}
    }-*/;

    private native void _setPlugins(JavaScriptObject values)/*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.setPlugins(values);
    }-*/;

    private native void disableRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.disable();
    }-*/;

    private native void enableRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.enable();
    }-*/;

    private native void hideRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.hide();
    }-*/;

    private native void showRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		component.show();
    }-*/;

    // --------------------- config properties --------------------------

    public native void setDocked(String value) /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			component.setDocked(value);
		}
    }-*/;

    private native boolean isDisabledRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component.disabled;
    }-*/;

    private native boolean isHiddenRendered() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component._hidden;
    }-*/;

    private native void doClear() /*-{
		var config = this.@com.emitrom.touch4j.client.core.TouchWidget::config;
		config['__compJ'] = null;
    }-*/;

    private native void makeObservable(JavaScriptObject config) /*-{
		if (config.listeners == null || config.listeners === undefined) {
			config.listeners = new Object();
		}
    }-*/;

    private void initConfig() {
        config = cloneConfig(getConfigPrototype());
        JsoHelper.setAttribute(config, Attribute.XTYPE.getValue(), getXType());
    }

    private native String _getDocked() /*-{
		var component = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		if (component != null) {
			return component.getDocked();
		}
    }-*/;

}
