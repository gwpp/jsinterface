package com.ganwenpeng.jsinterface.page.jsbridge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.model.jsinterface.bean.User;
import com.ganwenpeng.jsinterface.page.base.BaseFragment;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author gangan
 */
public class JsBridgeFragment extends BaseFragment<JsBridgeContract.Presenter> implements JsBridgeContract.View {
    @BindView(R.id.tv_toolbar_title)
    TextView mTvToolbarTitle;
    @BindView(R.id.web)
    BridgeWebView mWeb;
    @BindView(R.id.img_toolbar_back)
    ImageView mImgToolbarBack;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bridge_webview, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        setupUI();
        return view;
    }

    private void setupUI() {
        mTvToolbarTitle.setText("JSBridge");
        mImgToolbarBack.setVisibility(View.VISIBLE);

        mWeb.registerHandler("getOS", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                HashMap response = new HashMap(){{
                   put("error", 0);
                   put("message", "");
                   put("data", new HashMap(){{
                       put("os", "android");
                   }});
                }};
                function.onCallBack(response.toString());
            }
        });

        mWeb.registerHandler("login", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {


                Gson gson = new Gson();
                final User user = gson.fromJson(data, User.class);
                HashMap response = new HashMap(){{
                    put("error", 0);
                    put("message", "");
                    put("data", String.format("执行登录操作，账号为：%s、密码为：%s", user.getAccount(), user.getPassword()));
                }};

                function.onCallBack(response.toString());
            }
        });
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
        mWeb.loadUrl(url);
    }

    @Override
    public void bridgeShowMessage(@NonNull String message) {
        mWeb.callHandler("jsbridge_showMessage", message, null);
    }

    @Override
    public void bridgeGetMessage(@NonNull String message) {
        mWeb.callHandler("jsbridge_getJsMessage", message, new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                showNativeMessage(String.format("原生调用JsBridge方法后，Js方法的返回值为：【%s】", data));
            }
        });
    }
}
