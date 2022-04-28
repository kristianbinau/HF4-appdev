package com.example.androidapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnFlash;
    private EditText editTextTextPersonName;
    private Button btnSendData;

    private boolean flashOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnFlash = (Button) this.findViewById(R.id.btnFlash);
        this.btnFlash.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                toggleFlash();
            }
        });

        this.btnSendData = (Button) this.findViewById(R.id.btnSendData);
        this.btnSendData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switchAndSend();
            }
        });
    }

    protected void switchAndSend() {
        this.editTextTextPersonName = (EditText) this.findViewById(R.id.editTextTextPersonName);

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("MY_GRAND_MOTHERS_NAME", this.editTextTextPersonName.getText().toString());
        startActivity(intent);
    }

    protected void toggleFlash() {
        CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = null;

        if (this.flashOn) {
            try {
                cameraId = camManager.getCameraIdList()[0];
                camManager.setTorchMode(cameraId, false);
                this.flashOn = false;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                cameraId = camManager.getCameraIdList()[0];
                camManager.setTorchMode(cameraId, true);
                this.flashOn = true;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }
}