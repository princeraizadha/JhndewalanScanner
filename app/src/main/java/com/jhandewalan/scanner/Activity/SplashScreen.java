package com.jhandewalan.scanner.Activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.jhandewalan.scanner.R;
import com.jhandewalan.scanner.Support.SavedData;


/**
 * Created by nishantgupta on 10/08/17.
 */

public class SplashScreen extends AppCompatActivity {
    Context mContext;
    int GET_PERMISSION = 1;
    int SPLASH_TIME_OUT = 4000;
    MediaPlayer music;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mContext = SplashScreen.this;
        try {
            checkPermission();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

       /* Intent intent = new Intent(SplashScreen.this, GetStarted.class);
        startActivity(intent);
        finish();*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_PERMISSION) {
            getStarted();
        } else {
            getStarted();
        }
    }

    private void checkPermission() {

        Log.e("i am heree", "i am heree  333");
        final boolean isMarshMallow = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
        Log.e("i am heree", "i am heree  444");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               /* if (isMarshMallow) {
                    Log.e("i am heree","i am heree  222");

                    Intent intent = new Intent(mContext, RunTimePermission.class);
                    startActivityForResult(intent, GET_PERMISSION);
                } else {
                    Log.e("i am heree","i am heree  555");
                    getStarted();
                }*/
                getStarted();
            }
        }, SPLASH_TIME_OUT);
    }


    public void getStarted() {
       /* Intent intent = new Intent(SplashScreen.this, Demo.class);
        startActivity(intent);*/
        Log.e("i am heree", "i am heree");

  /*      Intent intent = new Intent();
        intent.setClass(SplashScreen.this, Demo.class);
        startActivity(intent);
        finish();
*/
        if (SavedData.getUserID().equalsIgnoreCase("")) {
       /*    Intent intent = new Intent(SplashScreen.this, GetStarted.class);
            startActivity(intent);
            finish();
*/
            Intent intent = new Intent();
            intent.setClass(SplashScreen.this, LoginPage.class);
            startActivity(intent);
            finish();

        } else {
            Intent intent = new Intent(SplashScreen.this, Scanning_page.class);
            startActivity(intent);
            finish();
        }
    }

}
