package com.ganwenpeng.jsinterface.model.jsinterface;

import android.webkit.JavascriptInterface;

import com.ganwenpeng.jsinterface.page.base.BaseFragment;

import org.json.JSONObject;

import java.util.HashMap;

public class JsInterfaceLogic {
    private BaseFragment mFragment;

    public JsInterfaceLogic(BaseFragment mFragment) {
        this.mFragment = mFragment;
    }

    @JavascriptInterface
    public void login(String account, String password) {
        mFragment.showNativeMessage(String.format("执行登录操作，账号为：%s，密码为：%s", account, password));
    }

    @JavascriptInterface
    public void logout() {
        mFragment.showNativeMessage("执行【登出】操作");
    }

    @JavascriptInterface
    public String getLoginUser() {
        return new JSONObject(new HashMap(4) {{
            put("user_id", 666);
            put("username", "你就说6不6");
            put("sex", "未知");
            put("isStudent", false);
        }}).toString();
    }
}
