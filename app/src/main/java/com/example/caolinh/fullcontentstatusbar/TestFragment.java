package com.example.caolinh.fullcontentstatusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.caolinh.fullcontentstatusbar.TestActivity.KEY_EXTRA_CONTENT_MAIN_ACTIVITY;

public class TestFragment extends Fragment {

    @BindView(R.id.txt_content)
    TextView txtContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        txtContent.setText(getActivity().getIntent().getStringExtra(KEY_EXTRA_CONTENT_MAIN_ACTIVITY));
    }
}
