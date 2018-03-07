package com.example.caolinh.fullcontentstatusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class TestActivity extends BaseActivity {

    public static final String KEY_EXTRA_CONTENT_MAIN_ACTIVITY = TestActivity.class.getName() + "KEY_EXTRA_CONTENT_MAIN_ACTIVITY";

    @Override
    protected Fragment createFragment() {
        return new TestFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullContentStatusBarTransparent();
    }
}
