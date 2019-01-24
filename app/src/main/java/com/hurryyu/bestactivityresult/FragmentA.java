package com.hurryyu.bestactivityresult;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hurryyu.bestresult.BestActivityResult;

import static android.app.Activity.RESULT_OK;

/**
 * @author HurryYu
 */
public class FragmentA extends Fragment {

    private Button mBtnOpen;
    private TextView mTvResultInfo;
    private BestActivityResult mBestActivityResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        mBestActivityResult = new BestActivityResult(this);
        initView(view);
        setListener();
        return view;
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

    private void initView(View view) {
        mBtnOpen = view.findViewById(R.id.btn_open);
        mTvResultInfo = view.findViewById(R.id.tv_result_info);
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.content, new FragmentB())
                .commitNow();
    }
}
