package com.hurryyu.bestresult;

import android.content.Intent;

/**
 * @author HurryYu
 */
@FunctionalInterface
public interface OnActivityResultListener {
    void onActivityResult(int resultCode, Intent data);
}
