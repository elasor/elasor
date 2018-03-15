package com.lify.elasor.message;

import android.content.Context;
import android.util.Log;

import com.lify.elasor.Elasor;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public class ElasorLog {

    private static Context mContext;
    private static boolean mIsReleaseLog;

    private ElasorLog() {
    }

    public static void init(Context context) {
        init(context, true);
    }

    public static void init(Context context, boolean isReleaseLog) {
        mContext = context;
        mIsReleaseLog = isReleaseLog;
    }

    private static String getClassTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(ElasorLog.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass
                        .lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }

    /**
     * 错误
     * @param msg 信息
     */
    public static void e(String msg) {
        if(!mIsReleaseLog && !Elasor.isDebugMode(mContext)){
            return;
        }
        Log.e(getClassTag(), msg);
    }

    /**
     * 警告
     * @param msg 信息
     */
    public static void w(String msg) {
        if(!mIsReleaseLog && !Elasor.isDebugMode(mContext)){
            return;
        }
        Log.w(getClassTag(), msg);
    }

    /**
     * 信息
     * @param msg 信息
     */
    public static void i(String msg) {
        if(!mIsReleaseLog && !Elasor.isDebugMode(mContext)){
            return;
        }
        Log.i(getClassTag(), msg);
    }

    /**
     * debug
     * @param msg 信息
     */
    public static void d(String msg) {
        if(!mIsReleaseLog && !Elasor.isDebugMode(mContext)){
            return;
        }
        Log.d(getClassTag(), msg);
    }

    /**
     * verbose
     * @param msg 信息
     */
    public static void v(String msg) {
        if(!mIsReleaseLog && !Elasor.isDebugMode(mContext)){
            return;
        }
        Log.v(getClassTag(), msg);
    }

}
