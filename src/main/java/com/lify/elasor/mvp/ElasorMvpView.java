package com.lify.elasor.mvp;

import android.content.Context;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public interface ElasorMvpView {

    int getLayoutResId();

    void initView();

    void initViewParam();

    void initViewListener();

    void showLoadingDialog();

    void hideLoadingDialog();

    void showToast(String msg);

    Context getContext();
}
