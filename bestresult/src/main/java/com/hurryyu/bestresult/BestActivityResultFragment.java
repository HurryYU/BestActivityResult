package com.hurryyu.bestresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.TreeMap;

/**
 * @author HurryYu
 */
public class BestActivityResultFragment extends Fragment {
    private static final TreeMap<Integer, OnActivityResultListener> LISTENER_MAP = new TreeMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivity(Intent intent, OnActivityResultListener listener) {
        int requestCode = getRequestCode();
        LISTENER_MAP.put(requestCode, listener);
        startActivityForResult(intent, requestCode);
    }

    private int getRequestCode() {
        int requestCode;
        if (LISTENER_MAP.isEmpty()) {
            requestCode = 1;
        } else {
            requestCode = LISTENER_MAP.lastKey() + 1;
        }
        return requestCode;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        OnActivityResultListener listener = LISTENER_MAP.remove(requestCode);
        if (listener != null) {
            listener.onActivityResult(resultCode, data);
        }
    }
}