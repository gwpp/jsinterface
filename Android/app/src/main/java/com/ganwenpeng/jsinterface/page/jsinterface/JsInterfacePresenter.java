package com.ganwenpeng.jsinterface.page.jsinterface;

import com.ganwenpeng.jsinterface.page.base.BasePresenter;

public class JsInterfacePresenter extends BasePresenter implements JsInterfaceContract.Presenter {
    private final JsInterfaceContract.View mView;

    JsInterfacePresenter(JsInterfaceContract.View mView) {
        this.mView = mView;
    }

    @Override
    protected void start(boolean isFirstStart) {
        if (isFirstStart) {
            mView.renderUrl("file:///android_asset/jsinterface.html");
        }
    }

    @Override
    public void clickBtn1() {
        mView.execJavaScript("showResponse('点击了按钮111111111111')");
    }

    @Override
    public void clickBtn2() {
        mView.execJavaScript("showResponse('点击了按钮22222222222')");
    }
}
