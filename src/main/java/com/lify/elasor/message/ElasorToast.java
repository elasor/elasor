package com.lify.elasor.message;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * @author Elasor
 */
@SuppressWarnings("all")
public class ElasorToast {

    private static Toast toast;

    private ElasorToast(){}

    public static void make(Context context, String msg){
        make(context, msg, Toast.LENGTH_SHORT);
    }

    public static void make(Context context,@StringRes int msgRes){
        make(context, msgRes, Toast.LENGTH_SHORT);
    }

    public static void make(Context context, @StringRes int msgRes, int duration){
        make(context, context.getResources().getString(msgRes), duration);
    }

    public static void make(Context context, String msg, int duration){
        if(null == toast){
            toast = Toast.makeText(context, msg, duration);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }
}
