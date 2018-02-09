package com.ganwenpeng.jsinterface.page.base;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.webkit.WebView;

import butterknife.Unbinder;

/**
 * @author gangan
 */
public class BaseFragment<T extends BasePresenterInterface> extends Fragment {
    static {
        WebView.setWebContentsDebuggingEnabled(true);
    }

    protected T mPresenter;
    protected Unbinder mUnbinder;

    @Override
    public void onStart() {
        super.onStart();

        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }
        super.onDestroy();
    }

    public void setPresenter(@NonNull T presenter) {
        mPresenter = presenter;
    }

    public void startActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(getActivity(), activity);
        startActivity(intent);
    }

    public void showNativeMessage(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("原生弹窗");
        builder.setMessage(message);
        builder.create().show();
    }
}
