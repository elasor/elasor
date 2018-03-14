package com.lify.elasor.normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Elasor
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
        setContentView(getLayoutResId());
        initControl();
        initControlParam();
        initControlListener();
        initOther();
    }

    protected void initActivity() {

    }

    protected abstract int getLayoutResId();

    protected abstract void initControl();

    protected abstract void initControlParam();

    protected abstract void initControlListener();

    protected void initOther() {

    }

    protected void showToast(String msg){

    }
}
