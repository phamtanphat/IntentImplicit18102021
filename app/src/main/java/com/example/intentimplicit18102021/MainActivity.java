package com.example.intentimplicit18102021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button mBtnGallery, mBtnCamera;
    ImageView mImg;
    int REQUEST_CODE_CAMERA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGallery = findViewById(R.id.buttonGallery);
        mBtnCamera = findViewById(R.id.buttonCamera);
        mImg = findViewById(R.id.imageView);


        mBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CODE_CAMERA
                    );
                } else if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts(
                            "package",
                            BuildConfig.APPLICATION_ID, null
                    );
                    intent.setData(uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_CAMERA){
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED){

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}