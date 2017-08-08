package com.jaycee88.propertyanimationdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * MyAnimViewActivity
 * Created by jaycee on 2017/8/8.
 */
public class MyAnimViewActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MyAnimViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_view);
    }
}
