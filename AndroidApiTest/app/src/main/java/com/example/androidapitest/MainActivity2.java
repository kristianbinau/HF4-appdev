package com.example.androidapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textViewName;
    private Button btnGoBack;
    private Button btnOpenApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.textViewName = (TextView) this.findViewById(R.id.textViewName);

        String grandMothersName = getIntent().getStringExtra("MY_GRAND_MOTHERS_NAME");
        this.textViewName.setText(grandMothersName);
        Log.i("Grand Mothers Name", grandMothersName);

        this.btnGoBack = (Button) this.findViewById(R.id.btnGoBack);
        this.btnGoBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        Context vm = this;

        this.btnOpenApp = (Button) this.findViewById(R.id.btnOpenApp);
        this.btnOpenApp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                watchYoutubeVideo(vm, "pTfC3YpMDMw");
            }
        });
    }

    protected void watchYoutubeVideo(Context context, String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
    }
}