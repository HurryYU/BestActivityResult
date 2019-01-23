package com.hurryyu.bestactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hurryyu.bestresult.BestActivityResult;
import com.hurryyu.bestresult.OnActivityResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BestActivityResult bestActivityResult = new BestActivityResult(this);
        TextView tvResultInfo = findViewById(R.id.tv_result_info);
        Button btnOpen = findViewById(R.id.btn_open);
        btnOpen.setOnClickListener(v ->
                bestActivityResult.start(ResultActivity.class, (resultCode, data) -> {
                    if (resultCode == RESULT_OK) {
                        tvResultInfo.setText(data.getStringExtra("data"));
                    }
                })
        );
    }
}