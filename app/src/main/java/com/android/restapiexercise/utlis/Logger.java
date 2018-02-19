package com.android.restapiexercise.utlis;

import android.util.Log;

/**
 * Created by Rajesh on 19/02/18.
 */

public class Logger
{
    public static void logVerbose(String tag, String msg)
    {
        Log.v(tag,msg);
    }

    public static void logError(String tag, String msg)
    {
        Log.e(tag, msg);
    }
}
