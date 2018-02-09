package com.ganwenpeng.jsinterface.page.intercept;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.page.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author gangan
 */
public class InterceptFragment extends BaseFragment<InterceptContract.Presenter> implements InterceptContract.View {

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

    private void setupUI() {
        mTvToolbarTitle.setText("拦截跳转");
        mImgToolbarBack.setVisibility(View.VISIBLE);

        mWebView.getSettings().setJavaScriptEnabled(true);
        WebViewClient webViewClient = new WebViewClient() {
            // 老方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);

                if (uri.getScheme().contentEquals("app")) {

                    callNative(uri);

                    return true;
                }


                return super.shouldOverrideUrlLoading(view, url);
            }

            // 新方法，API21之后支持
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT < 21) {
                    return super.shouldOverrideUrlLoading(view, request);
                }

                Uri uri = request.getUrl();
                if (uri.getScheme().contentEquals("app")) {

                    callNative(uri);

                    return true;
                }

                return super.shouldOverrideUrlLoading(view, request);
            }
        };

        mWebView.setWebViewClient(webViewClient);
    }

    /**
     * js 调用原生方法时的特殊跳转链接
     * @param uri 特殊的跳转链接
     */
    private void callNative(Uri uri){
        String host = uri.getHost();

        if (host.contentEquals("login")) {

            String account = uri.getQueryParameter("account");
            String password = uri.getQueryParameter("password");

            showNativeMessage(String.format("执行登录操作，账号为：%s，密码为：%s", account, password));

        } else if (host.contentEquals("share")) {
            String title = uri.getQueryParameter("title");
            String desc = uri.getQueryParameter("desc");
            showNativeMessage(String.format("执行分享操作，title为：【%s】，desc为：【%s】", title, desc));
        }
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
        mWebView.evaluateJavascript("javascript:"+js, null);
    }
}
