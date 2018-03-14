package com.lify.elasor.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public abstract class ElasorMvpFragment extends Fragment implements ElasorMvpView {

    private View mView;
    protected boolean mIsLazyMode = true;
    protected boolean mIsVisible = false;
    protected boolean mHasCreated = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mView) {
            mView = LayoutInflater.from(getContext()).inflate(getLayoutResId(), container, false);
            initView();
            initViewParam();
            initViewListener();
            initOther();
        }
        mHasCreated = true;
        loadData();
        return mView;
    }

    protected void initFragment() {

    }

    protected void initOther() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (!mIsLazyMode) {
            return;
        }

        if (getUserVisibleHint()) {
            mIsVisible = true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }
    }

    /**
     * 加载数据
     */
    protected void loadData() {

        //是否是懒加载模式，视图是否创建，视图是否可见
        if (mIsLazyMode && (!mHasCreated || !mIsVisible)) {
            return;
        }

    }

    ;

    protected void onVisible() {
        loadData();
    }

    protected void onInvisible() {

    }
}
