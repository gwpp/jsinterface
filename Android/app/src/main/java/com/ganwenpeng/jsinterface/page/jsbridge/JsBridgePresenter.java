package com.ganwenpeng.jsinterface.page.jsbridge;

import com.ganwenpeng.jsinterface.page.base.BasePresenter;

/**
 * @author gangan
 */
public class JsBridgePresenter extends BasePresenter implements JsBridgeContract.Presenter {
    private final JsBridgeContract.View mView;

    JsBridgePresenter(JsBridgeContract.View mView) {
        this.mView = mView;
    }

    @Override
    protected void start(boolean isFirstStart) {
        if (isFirstStart) {
            mView.renderUrl("file:///android_asset/jsbridge.html");
        }
    }

    @Override
    public void clickBtn1() {
        mView.bridgeShowMessage("点击了按钮111111111111");
    }

    @Override
    public void clickBtn2() {
        mView.bridgeGetMessage("点击了按钮2222222222222");
    }
}
