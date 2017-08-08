package com.jaycee88.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimatorFromXML();
            }
        });
    }

    private void startAnimatorFromXML() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_set);
        animator.setTarget(mTextView);
        animator.start();
    }

    private void startAnimatorSet() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(mTextView, "translationX", -1000f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mTextView, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mTextView, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }

    private void startObjectAnimator() {
//        ObjectAnimator anim = ObjectAnimator.ofFloat(mTextView, "alpha", 1f, 0f, 1f);
//        ObjectAnimator anim = ObjectAnimator.ofFloat(mTextView, "rotation", 0f, 360f);
//        float curTranslationX = mTextView.getTranslationX();
//        ObjectAnimator anim = ObjectAnimator.ofFloat(mTextView, "translationX", curTranslationX, -1000f, curTranslationX);
        ObjectAnimator anim = ObjectAnimator.ofFloat(mTextView, "scaleY", 1f, 3f, 1f);
        anim.setDuration(500);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.start();
    }

    private void startValueAnimator() {
//        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
//        ValueAnimator anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);
        ValueAnimator anim = ValueAnimator.ofInt(0, 10);
        anim.setDuration(500);
        // 动画延迟播放时间
        anim.setStartDelay(100);
        // 循环播放次数
        anim.setRepeatCount(3);
        // 循环播放模式
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                float currentValue = (float) animation.getAnimatedValue();
                int currentValue = (int) animation.getAnimatedValue();
                Log.d("TAG", "current value is " + currentValue);
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                Log.d("TAG", "Repeat -------------------------------------------");
            }
        });
//        anim.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//                Log.d("TAG", "Repeat -------------------------------------------");
//            }
//        });
        anim.start();
    }
}
