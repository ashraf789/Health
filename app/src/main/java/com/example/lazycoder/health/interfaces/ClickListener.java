package com.example.lazycoder.health.interfaces;


import android.support.v4.app.Fragment;

/**
 * Created by lazycoder on 2/9/18.
 */

public interface ClickListener {
    void onProductClick();
    void onProductClick(String productCode);
    void onProductClick(Fragment fragment);
}
