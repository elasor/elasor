package com.lify.elasor.mvp;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public abstract class ElasorMvpActivity<P extends ElasorMvpPresenter> extends AppCompatActivity implements ElasorMvpView{

    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initActivity();
        setContentView(getLayoutResId());
        initView();
        initViewParam();
        initViewListener();
        initOther();
    }

    protected void initActivity() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    protected void initOther() {

    }
}
