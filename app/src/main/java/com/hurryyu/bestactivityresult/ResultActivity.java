package com.hurryyu.bestactivityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button btnReturnData = findViewById(R.id.btn_return_data);
        btnReturnData.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("data", "The message returned from the ResultActivity");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}