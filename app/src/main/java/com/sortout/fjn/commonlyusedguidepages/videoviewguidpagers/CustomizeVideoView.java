package com.sortout.fjn.commonlyusedguidepages.videoviewguidpagers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by fanjingnan on 2017/1/16.
 */

public class CustomizeVideoView extends VideoView {
    public CustomizeVideoView(Context context) {
        super(context);
    }

    public CustomizeVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomizeVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if(widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY){
            setMeasuredDimension(widthSize,heightSize);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }
}
