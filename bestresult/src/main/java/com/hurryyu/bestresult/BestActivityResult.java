package com.hurryyu.bestresult;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class BestActivityResult {
    private static final String TAG = BestActivityResult.class.getSimpleName();
    private BestActivityResultFragment mBestActivityResultFragment;

    public BestActivityResult(Fragment fragment) {
        mBestActivityResultFragment = getBestActivityResultFragment(fragment.getChildFragmentManager());
    }

    public BestActivityResult(FragmentActivity activity) {
        mBestActivityResultFragment = getBestActivityResultFragment(activity.getSupportFragmentManager());
    }

    private BestActivityResultFragment getBestActivityResultFragment(FragmentManager fragmentManager) {
        return null;
    }

    public void start(Intent intent, OnActivityResultListener listener) {
        mBestActivityResultFragment.startActivity(intent, listener);
    }
}
