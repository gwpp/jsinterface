package com.ganwenpeng.jsinterface.page.intercept;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.page.base.BaseActivity;

/**
 * @author gangan
 */
public class InterceptActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        InterceptFragment fragment = (InterceptFragment) getFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment == null) {
            fragment = new InterceptFragment();
            InterceptPresenter presenter = new InterceptPresenter(fragment);
            fragment.setPresenter(presenter);
            addFragment(fragment, R.id.content_frame);
        }
    }
}
