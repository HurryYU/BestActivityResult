package com.hurryyu.bestresult;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.Objects;

/**
 * @author HurryYu
 */
public class BestActivityResult {
    private static final String TAG = BestActivityResult.class.getSimpleName();
    private BestActivityResultFragment mBestActivityResultFragment;

    public BestActivityResult(@NonNull Fragment fragment) {
        this(Objects.requireNonNull(fragment.getActivity()));
    }

    public BestActivityResult(@NonNull FragmentActivity activity) {
        mBestActivityResultFragment = getBestActivityResultFragment(activity.getSupportFragmentManager());
    }

    private BestActivityResultFragment getBestActivityResultFragment(FragmentManager fragmentManager) {
        BestActivityResultFragment bestActivityResultFragment = findActResultFragment(fragmentManager);
        boolean isNewInstance = bestActivityResultFragment == null;
        if (isNewInstance) {
            bestActivityResultFragment = new BestActivityResultFragment();
            fragmentManager
                    .beginTransaction()
                    .add(bestActivityResultFragment, TAG)
                    .commitNow();
        }
        return bestActivityResultFragment;
    }

    private BestActivityResultFragment findActResultFragment(FragmentManager fragmentManager) {
        return (BestActivityResultFragment) fragmentManager.findFragmentByTag(TAG);
    }

    public void start(Intent intent, OnActivityResultListener listener) {
        mBestActivityResultFragment.startActivity(intent, listener);
    }

    public void start(Class<?> clazz, OnActivityResultListener listener) {
        Intent intent = new Intent(mBestActivityResultFragment.getActivity(), clazz);
        start(intent, listener);
    }
}
