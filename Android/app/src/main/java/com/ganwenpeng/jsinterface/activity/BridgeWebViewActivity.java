package com.ganwenpeng.jsinterface.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.model.bean.JsBridgeResponse;
import com.ganwenpeng.jsinterface.model.bean.LoginBean;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.lang.String;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BridgeWebViewActivity extends AppCompatActivity {

    @BindView(R.id.web)
    BridgeWebView mWebView;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bridge_webview);
        mUnbinder = ButterKnife.bind(this);

        initWebView();

        mWebView.loadUrl("file:///android_asset/jsbridge-test.html");
    }

    private void initWebView() {
        mWebView.registerHandler("getOS", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                HashMap<String, Object> dataMap = new HashMap<>();
                dataMap.put("os", "android");

                JsBridgeResponse response = new JsBridgeResponse(0, "", dataMap);
                function.onCallBack(new Gson().toJson(response));
            }
        });

        mWebView.registerHandler("login", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Gson gson = new Gson();

                if (TextUtils.isEmpty(data)) {
                    JsBridgeResponse response = new JsBridgeResponse(-1, "调用参数有误", null);
                    function.onCallBack(gson.toJson(response));
                    return;
                }

                LoginBean loginBean;
                try {
                    loginBean = gson.fromJson(data, LoginBean.class);
                } catch (JsonSyntaxException e) {
                    return;
                }
                if (loginBean == null) {
                    JsBridgeResponse response = new JsBridgeResponse(-1, "调用参数有误", null);
                    function.onCallBack(gson.toJson(response));
                    return;
                }

                JsBridgeResponse response = new JsBridgeResponse(0, "登录成功", String.format("执行登录操作，账号为：%s、密码为：%s", loginBean.getAccount(), loginBean.getPassword()));
                function.onCallBack(gson.toJson(response));
            }
        });

        WebViewClient webViewClient = new WebViewClient() {
            // 老方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains("app://login")) {
                    Uri uri = Uri.parse(url);
                    String account = uri.getQueryParameter("account");
                    String password = uri.getQueryParameter("password");

                    // 这里写执行登录的代码

                    // 完了之后返回true，告诉WebView该链接已经被处理了，不要继续加载这个URL
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            // 新方法，API21之后支持
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                if (uri.getScheme().contentEquals("app")) {

                    if (uri.getHost().contentEquals("login")) {

                        String account = uri.getQueryParameter("account");
                        String password = uri.getQueryParameter("password");

                        // 这里写执行登录的代码

                        // 完了之后返回true，告诉WebView该链接已经被处理了，不要继续加载这个URL
                        return true;
                    }

                    return true;
                }

                return super.shouldOverrideUrlLoading(view, request);
            }
        };

        mWebView.setWebViewClient(webViewClient);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }
}
