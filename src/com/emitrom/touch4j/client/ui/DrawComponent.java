package com.emitrom.touch4j.client.ui;

import com.emitrom.touch4j.client.core.Component;
import com.emitrom.touch4j.client.core.config.XType;
import com.emitrom.touch4j.client.draw.Sprite;
import com.emitrom.touch4j.client.draw.Surface;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * The Draw Component is a surface in which sprites can be rendered. The Draw
 * Component manages and holds a Surface instance: an interface that has an SVG
 * or VML implementation depending on the browser capabilities and where Sprites
 * can be appended.
 * 
 */
public class DrawComponent extends Component {

    private static JavaScriptObject configPrototype;

    protected native void init()/*-{
		var c = new $wnd.Ext.draw.Component({
			enginePriority : [ "Svg", "Vml" ]
		});
		@com.emitrom.touch4j.client.ui.DrawComponent::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.DRAW.getValue();
    }

    /**
     * Create a new Panel.
     */
    public DrawComponent() {
        init();
        createSurface();
    }

    protected DrawComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Panel to an existing element.
     * 
     * @param element
     *            the element
     */
    public DrawComponent(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.enginePriority = [ "Svg", "Vml" ];
		return new $wnd.Ext.draw.Component(config);
    }-*/;

    /**
     * create the component surface
     */
    public native void createSurface() /*-{
		var draw = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		draw.createSurface();
    }-*/;

    public native Surface getSurface()/*-{
		var draw = this.@com.emitrom.touch4j.client.core.Component::getOrCreateJsObj()();
		var surface = draw.surface;
		return @com.emitrom.touch4j.client.draw.Surface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(surface);
    }-*/;

    public Sprite add(Sprite sprite) {
        return getSurface().add(sprite);
    }

    public void setViewBox(boolean value) {
        setAttribute("viewBox", value, true);
    }

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void setItems(Sprite... items) {
        setAttribute("items", ComponentFactory.fromArrayOfSprite(items), true);
    }

}
