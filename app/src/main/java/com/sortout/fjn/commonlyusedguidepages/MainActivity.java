package com.sortout.fjn.commonlyusedguidepages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sortout.fjn.commonlyusedguidepages.commonguidepages.ViewPagerActivity;
import com.sortout.fjn.commonlyusedguidepages.htmlguidepagers.HtmlGuidePages;
import com.sortout.fjn.commonlyusedguidepages.videoviewguidpagers.VideoViewGuidePages;
import com.sortout.fjn.commonlyusedguidepages.visualdifferenceguidepagers.VisualDifference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Go(VideoViewGuidePages.class,false);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Go(HtmlGuidePages.class,false);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Go(VisualDifference.class,false);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Go(ViewPagerActivity.class,false);
            }
        });
    }

    public void Go(Class<?> cls, Boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
        if (isFinish)
            finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
