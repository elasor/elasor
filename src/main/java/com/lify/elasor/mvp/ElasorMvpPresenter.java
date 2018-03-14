package com.lify.elasor.mvp;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public class ElasorMvpPresenter<V extends ElasorMvpView, M extends ElasorMvpModel> {

    private V mView;
    private M mModel;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attach(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return null != mView;
    }

    /**
     * 获取连接的view
     */
    public V getView(){
        return mView;
    }
}
