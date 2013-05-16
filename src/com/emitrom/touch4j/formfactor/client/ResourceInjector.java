package com.emitrom.touch4j.formfactor.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.user.client.Window;

public class ResourceInjector {

    protected String cssUrl;
    protected String jsUrl;
    protected JsLoadCallback callBack;

    public ResourceInjector() {

    }

    public ResourceInjector(String cssUrl, String jsUrl) {
        this.cssUrl = cssUrl;
        this.jsUrl = jsUrl;
    }

    public ResourceInjector(String cssUrl, String jsUrl, JsLoadCallback cb) {
        this.cssUrl = cssUrl;
        this.jsUrl = jsUrl;
        this.callBack = cb;
    }

    public void setCssUrl(String cssUrl) {
        this.cssUrl = cssUrl;
    }

    public void setJsUrl(String jsUrl) {
        this.jsUrl = jsUrl;
    }

    public ResourceInjector setJsLoadCallback(JsLoadCallback cb) {
        this.callBack = cb;
        return this;
    }

    /**
     * Loads a css file base on the file url
     * 
     * @param url
     *            , url of the file to load
     */
    public void loadCss(String url) {
        LinkElement link = Document.get().createLinkElement();
        link.setRel("stylesheet");
        link.setHref(url);
        attachToHead(link);
    }

    /**
     * Loads a javascript file base on the file url
     * 
     * @param url
     *            , url of the file to load
     */
    public void inject() {
        if (this.cssUrl != null) {
            loadCss(this.cssUrl);
        }
        if (this.jsUrl != null) {

            ScriptInjector.fromUrl(this.jsUrl).setCallback(new Callback<Void, Exception>() {
                @Override
                public void onSuccess(Void result) {
                    if (ResourceInjector.this.callBack != null) {
                        ResourceInjector.this.callBack.onJsLoaded();
                    }
                }

                @Override
                public void onFailure(Exception reason) {
                    Window.alert(reason.getMessage() + " for link " + jsUrl);
                }
            }).setWindow(ScriptInjector.TOP_WINDOW).inject();

        }
    }

    private native void attachToHead(JavaScriptObject cssElement)/*-{
		$doc.getElementsByTagName('head')[0].appendChild(cssElement);
    }-*/;

}
