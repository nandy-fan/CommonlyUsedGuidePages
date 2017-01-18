package com.sortout.fjn.commonlyusedguidepages.videoviewguidpagers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sortout.fjn.commonlyusedguidepages.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sortout.fjn.commonlyusedguidepages.videoviewguidpagers.VideoViewGuidePages.InputType.LOGIN;
import static com.sortout.fjn.commonlyusedguidepages.videoviewguidpagers.VideoViewGuidePages.InputType.SIGN_UP;

public class VideoViewGuidePages extends AppCompatActivity implements View.OnClickListener {

    public static final String VIDEO_NAME = "welcome_video.mp4";
    private InputType inputType = InputType.NONE;
    @BindView(R.id.videoView)
    CustomizeVideoView mVideoView;
    @BindView(R.id.formView)
    FormView mFormView;
    @BindView(R.id.buttonLeft)
    Button mButtonLeft;
    @BindView(R.id.buttonRight)
    Button mButtonRight;
    @BindView(R.id.appName)
    TextView mAppName;
    @BindView(R.id.activity_video_view_guide_pages)
    RelativeLayout mActivityVideoViewGuidePages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_video_view_guide_pages);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        File videoFile = getFileStreamPath(VIDEO_NAME);
        if (!videoFile.exists()) {
            videoFile = copyVideoFile();
        }
        playVideo(videoFile);
        playAnim();

    }

    private File copyVideoFile() {
        File videoFile;
        try {
            FileOutputStream fos = openFileOutput(VIDEO_NAME, MODE_PRIVATE);
            InputStream in = getResources()
                    .openRawResource(R.raw.welcome_video);
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoFile = getFileStreamPath(VIDEO_NAME);
        if (!videoFile.exists())
            throw new RuntimeException(
                    "video file has problem, are you sure you have welcome_video.mp4 in res/raw folder?");
        return videoFile;
    }

    private void playVideo(File videoFile) {
        mVideoView.setVideoPath(videoFile.getPath());
        mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        });
    }
    private void playAnim() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(mAppName, "alpha", 0, 1);
        anim.setDuration(4000);
        anim.setRepeatCount(1);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mAppName.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int delta = mFormView.getTop() + mFormView.getHeight();
        switch (inputType) {
            case NONE:

                mFormView.animate().translationY(0).alpha(1).setDuration(500)
                        .start();
                if (view == mButtonLeft) {
                    inputType = LOGIN;
                    mButtonLeft.setText(R.string.button_confirm_login);
                    mButtonRight.setText(R.string.button_cancel_login);
                } else if (view == mButtonRight) {
                    inputType = SIGN_UP;
                    mButtonLeft.setText(R.string.button_confirm_signup);
                    mButtonRight.setText(R.string.button_cancel_signup);
                }

                break;
            case LOGIN:

                mFormView.animate().translationY(-1 * delta).alpha(0)
                        .setDuration(500).start();
                if (view == mButtonLeft) {

                } else if (view == mButtonRight) {

                }
                inputType = InputType.NONE;
                mButtonRight.setText(R.string.button_login);
                mButtonRight.setText(R.string.button_signup);
                break;
            case SIGN_UP:

                mFormView.animate().translationY(-1 * delta).alpha(0)
                        .setDuration(500).start();
                if (view == mButtonLeft) {

                } else if (view == mButtonRight) {

                }
                inputType = InputType.NONE;
                mButtonLeft.setText(R.string.button_login);
                mButtonRight.setText(R.string.button_signup);
                break;
        }
    }

    enum InputType {
        NONE, LOGIN, SIGN_UP;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }
}
