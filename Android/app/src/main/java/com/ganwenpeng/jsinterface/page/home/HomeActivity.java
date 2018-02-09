package com.ganwenpeng.jsinterface.page.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.page.base.BaseActivity;

public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        HomeFragment fragment = (HomeFragment) getFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment == null) {
            fragment = new HomeFragment();
            HomePresenter presenter = new HomePresenter(fragment);
            fragment.setPresenter(presenter);
            addFragment(fragment, R.id.content_frame);
        }
    }

}
