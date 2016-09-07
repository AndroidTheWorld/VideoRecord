package com.video.record.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yixia.camera.demo.ui.record.MediaRecorderActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.mPath);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRecordVideo();
            }
        });
    }

    private void goRecordVideo() {
        Intent intent = new Intent(this, MediaRecorderActivity.class);
        startActivityForResult(intent, 7001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 7001:
                    String path = data.getStringExtra("mPath");
                    mTextView.setText("视频路径： " + path);
                    break;
            }
        }
    }

}
