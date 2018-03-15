package com.lify.elasor;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.lify.elasor.http.ElasorHttp;
import com.lify.elasor.message.ElasorLog;

/**
 * @author Elasor
 */
@SuppressWarnings("unused")
public class Elasor {

    public static void init(Context context, boolean isReleaseLog){
        ElasorLog.init(context, isReleaseLog);
        ElasorHttp.init(context);
    }

    public static boolean isDebugMode(Context context){
        ApplicationInfo ai = context.getApplicationContext().getApplicationInfo();
        return null != ai && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }
}
