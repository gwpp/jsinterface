package com.ganwenpeng.jsinterface.page.jsinterface;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.page.base.BaseActivity;

/**
 * @author gangan
 */
public class JsInterfaceActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        JsInterfaceFragment fragment = (JsInterfaceFragment) getFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment == null) {
            fragment = new JsInterfaceFragment();
            JsInterfacePresenter presenter = new JsInterfacePresenter(fragment);
            fragment.setPresenter(presenter);
            addFragment(fragment, R.id.content_frame);
        }
    }
}
