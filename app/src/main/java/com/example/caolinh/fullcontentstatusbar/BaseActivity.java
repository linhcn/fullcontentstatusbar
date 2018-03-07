package com.example.caolinh.fullcontentstatusbar;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;

    @BindView(R.id.fl_content)
    FrameLayout flContent;

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fg = createFragment();
        fm.beginTransaction().add(R.id.fl_content, fg).commit();

    }

    @OnClick(R.id.img_back)
    public void onClickImgBtnBack() {
        onBackPressed();
    }

    public void setupFullContentStatusBar() {
        toolBar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        flContent.setLayoutParams(layoutParams);
    }

    public void setFullContentStatusBarTransparent() {
        toolBar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        flContent.setLayoutParams(layoutParams);

        // Remove blur status bar just using when we not use windowSoftInputMode="adjustResize"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    /**
     * Will making navigation bar android auto hide and make
     * content margin bottom = size of navigation bar
     */
    public void setAutoHideNavigationBar() {
        // Auto hide android navigation bar
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        final View decorView = this.getWindow().getDecorView();
        decorView.setSystemUiVisibility(flags);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                decorView.setSystemUiVisibility(flags);
            }
        });
    }
}
