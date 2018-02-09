package com.ganwenpeng.jsinterface.page.jsbridge;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.page.base.BaseActivity;

/**
 * @author gangan
 */
public class JsBridgeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        JsBridgeFragment fragment = (JsBridgeFragment) getFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment == null) {
            fragment = new JsBridgeFragment();
            JsBridgePresenter presenter = new JsBridgePresenter(fragment);
            fragment.setPresenter(presenter);
            addFragment(fragment, R.id.content_frame);
        }
    }
}
