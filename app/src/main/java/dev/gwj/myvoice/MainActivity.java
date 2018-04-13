package dev.gwj.myvoice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import javax.inject.Inject;

import dev.gwj.myvoice.bean.DaggerFoodComponent;
import dev.gwj.myvoice.bean.Perseon;
import dev.gwj.mfmod.MFmod;

/**
 * Created by dd on 18-4-12.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    Perseon person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DaggerFoodComponent.builder().build().inject(this);

        requestPermission();
        init();
    }

    MFmod mFmod = null;
    private void init(){
        mFmod = MFmod.getInstance();
        mFmod.onFmodEvent1();
        mFmod.init();

        try {
            Log.e("tag", "aaaa"+getAssets().list(".").length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSound(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "/sdcard/netease/cloudmusic/Music/az.mp3";
                mFmod.playSound(path);

            }
        }).start();

    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private void requestPermission(){
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}
