package com.example.caolinh.fullcontentstatusbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFullContentStatusBar();
    }
}
