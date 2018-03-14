package com.lify.elasor.mvp;

/**
 * @author Elasor
 */
public interface IMvpCallback<T> {

    void onStart();

    void onSuccess(T t);

    void onFailure(String message);

    void onComplete();
}
