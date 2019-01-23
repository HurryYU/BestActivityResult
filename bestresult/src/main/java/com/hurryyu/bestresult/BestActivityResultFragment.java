package com.hurryyu.bestresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author HurryYu
 */
public class BestActivityResultFragment extends Fragment {
    private Map<Integer, OnActivityResultListener> mListenerMap = new LinkedHashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivity(Intent intent, OnActivityResultListener listener) {
        int requestCode = listener.hashCode();
        mListenerMap.put(requestCode, listener);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        OnActivityResultListener listener = mListenerMap.remove(requestCode);
        if (listener != null) {
            listener.onActivityResult(resultCode, data);
        }
    }
}