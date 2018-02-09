package com.ganwenpeng.jsinterface.page.intercept;

import com.ganwenpeng.jsinterface.page.base.BasePresenter;

class InterceptPresenter extends BasePresenter implements InterceptContract.Presenter {
    private final InterceptContract.View mView;

    InterceptPresenter(InterceptContract.View mView) {
        this.mView = mView;
    }

    @Override
    protected void start(boolean isFirstStart) {
        if (isFirstStart) {
            mView.renderUrl("file:///android_asset/intercept.html");
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
