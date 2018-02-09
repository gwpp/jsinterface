package com.ganwenpeng.jsinterface.page.base;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * @author gangan
 */
public class BaseActivity extends AppCompatActivity {
    public void addFragment(@NonNull android.app.Fragment fragment, int frameId) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment);
        fragmentTransaction.commit();
    }
}
