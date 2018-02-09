package com.ganwenpeng.jsinterface.page.jsinterface;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.model.jsinterface.JsInterfaceLogic;
import com.ganwenpeng.jsinterface.page.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author gangan
 */
public class JsInterfaceFragment extends BaseFragment<JsInterfaceContract.Presenter> implements JsInterfaceContract.View {
    @BindView(R.id.tv_toolbar_title)
    TextView mTvToolbarTitle;
    @BindView(R.id.img_toolbar_back)
    ImageView mImgToolbarBack;
    @BindView(R.id.web)
    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intercept_webview, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        setupUI();
        return view;
    }

    @SuppressWarnings("all")
    private void setupUI() {
        mTvToolbarTitle.setText("拦截跳转");
        mImgToolbarBack.setVisibility(View.VISIBLE);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.addJavascriptInterface(new JsInterfaceLogic(this), "app");
    }

    @OnClick(R.id.img_toolbar_back)
    public void onBackClick() {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.tv_btn1)
    public void onBtn1Click(){
        mPresenter.clickBtn1();
    }

    @OnClick(R.id.tv_btn2)
    public void onBtn2Click(){
        mPresenter.clickBtn2();
    }

    @Override
    public void renderUrl(@NonNull String url) {
        mWebView.loadUrl(url);
    }

    @Override
    public void execJavaScript(@NonNull String js) {
        mWebView.evaluateJavascript(js, null);
    }
}
