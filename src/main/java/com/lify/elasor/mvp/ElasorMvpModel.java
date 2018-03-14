package com.lify.elasor.mvp;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public abstract class ElasorMvpModel<T> {

    abstract void execute();

    protected void get(String url, IMvpCallback<T> callback) {

    }

    void get(String url, Map<String, String> params, IMvpCallback<T> callback) {
        if (null == params || params.isEmpty()) {
            get(url, callback);
            return;
        }

        StringBuilder sb = new StringBuilder();
        Set<String> keySet = params.keySet();
        Iterator<String> iterator = keySet.iterator();

        sb.append("?");
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = params.get(key);
            sb.append(key + "=" + value + "&");
        }

        get(url + sb.substring(0, sb.length() - 1), callback);
    }

    protected void post(String url, Map<String, String> params, IMvpCallback<T> callback) {

    }

}
