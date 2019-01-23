package com.hurryyu.bestactivityresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button btnReturnData = findViewById(R.id.btn_return_data);
        btnReturnData.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
    }
}