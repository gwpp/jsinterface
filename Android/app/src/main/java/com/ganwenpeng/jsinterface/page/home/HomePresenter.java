package com.ganwenpeng.jsinterface.page.home;

import com.ganwenpeng.jsinterface.model.home.bean.HomeItemBean;
import com.ganwenpeng.jsinterface.page.base.BasePresenter;
import com.ganwenpeng.jsinterface.page.intercept.InterceptActivity;
import com.ganwenpeng.jsinterface.page.jsbridge.JsBridgeActivity;
import com.ganwenpeng.jsinterface.page.jsinterface.JsInterfaceActivity;

import java.util.ArrayList;

class HomePresenter extends BasePresenter implements HomeContract.Presenter {
    private final HomeContract.View mView;
    private final ArrayList<HomeItemBean> mItemList;

    HomePresenter(HomeContract.View view) {
        mView = view;

        mItemList = new ArrayList<HomeItemBean>(){{
            add(new HomeItemBean("拦截跳转", "webView.loadUrl", InterceptActivity.class));
            add(new HomeItemBean("JavaScriptInterface", "webView.loadUrl", JsInterfaceActivity.class));
            add(new HomeItemBean("WebViewJavascriptBridge", "callHandler", JsBridgeActivity.class));
        }};
    }

    @Override
    protected void start(boolean isFirstStart) {
        if (isFirstStart) {
            mView.render(mItemList);
        }
    }

    @Override
    public void clickItem(int position) {
        if (position >= mItemList.size()) {
            return;
        }

        mView.startActivity(mItemList.get(position).getTargetClass());
    }
}
