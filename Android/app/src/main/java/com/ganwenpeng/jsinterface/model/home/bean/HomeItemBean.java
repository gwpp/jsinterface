package com.ganwenpeng.jsinterface.model.home.bean;

import com.ganwenpeng.jsinterface.page.base.BaseActivity;

public class HomeItemBean {
    /**
     * js调用原生的方式
     */
    private final String jsCallNative;

    /**
     * 原生调用js的方式
     */
    private final String nativeCallJs;
    /**
     * 点击该行之后跳转的界面
     */
    private final Class<? extends BaseActivity> targetClass;

    public String getJsCallNative() {
        return jsCallNative;
    }

    public String getNativeCallJs() {
        return nativeCallJs;
    }

    public Class<? extends BaseActivity> getTargetClass() {
        return targetClass;
    }

    public HomeItemBean(String jsCallNative, String nativeCallJs, Class<? extends BaseActivity> targetClass) {
        this.jsCallNative = jsCallNative;
        this.nativeCallJs = nativeCallJs;
        this.targetClass = targetClass;
    }
}
