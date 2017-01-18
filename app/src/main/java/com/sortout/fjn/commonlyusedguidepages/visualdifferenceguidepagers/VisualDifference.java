package com.sortout.fjn.commonlyusedguidepages.visualdifferenceguidepagers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.sortout.fjn.commonlyusedguidepages.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VisualDifference extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bRetry)
    Button mBRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_difference);
        ButterKnife.bind(this);
        mBRetry.setOnClickListener(this);
        if (savedInstanceState == null) {
            replaceTutorialFragment();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRetry:
                replaceTutorialFragment();
                break;
        }
    }

    public void replaceTutorialFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new CustomTutorialSupportFragment())
                .commit();
    }
}
