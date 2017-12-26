package com.ganwenpeng.jsbridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.ganwenpeng.jsbridge.bean.JsBridgeResponse;
import com.ganwenpeng.jsbridge.bean.LoginBean;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;

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
        setContentView(R.layout.activity_bridge_webview);
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
