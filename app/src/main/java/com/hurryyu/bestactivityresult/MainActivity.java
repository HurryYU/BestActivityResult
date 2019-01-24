package com.hurryyu.bestactivityresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hurryyu.bestresult.BestActivityResult;

/**
 * @author HurryYu
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTvResultInfo;
    private Button mBtnOpen;
    private BestActivityResult mBestActivityResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBestActivityResult = new BestActivityResult(this);
        initView();
        setListener();

    }

    private void setListener() {
        mBtnOpen.setOnClickListener(v ->
                mBestActivityResult.start(ResultActivity.class, (resultCode, data) -> {
                    if (resultCode == RESULT_OK) {
                        mTvResultInfo.setText(data.getStringExtra("data"));
                    }
                })
        );
    }

    private void initView() {
        mTvResultInfo = findViewById(R.id.tv_result_info);
        mBtnOpen = findViewById(R.id.btn_open);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content,new FragmentA())
                .commitNow();
    }
}