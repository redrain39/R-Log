package com.redrain.r_log;

import android.util.Log;

import androidx.annotation.NonNull;

public class RLog {

    public static void v(Object... contents) {
        log(RLogType.V, contents);
    }

    public static void vt(String tag, Object... contents) {
        log(RLogType.V, tag, contents);
    }

    public static void d(Object... contents) {
        log(RLogType.D, contents);
    }

    public static void dt(String tag, Object... contents) {
        log(RLogType.D, tag, contents);
    }

    public static void i(Object... contents) {
        log(RLogType.I, contents);
    }

    public static void it(String tag, Object... contents) {
        log(RLogType.I, tag, contents);
    }

    public static void w(Object... contents) {
        log(RLogType.W, contents);
    }

    public static void wt(String tag, Object... contents) {
        log(RLogType.W, tag, contents);
    }

    public static void e(Object... contents) {
        log(RLogType.E, contents);
    }

    public static void et(String tag, Object... contents) {
        log(RLogType.E, tag, contents);
    }

    public static void a(Object... contents) {
        log(RLogType.A, contents);
    }

    public static void at(String tag, Object... contents) {
        log(RLogType.A, tag, contents);
    }

    public static void log(@RLogType.TYPE int type, Object... contents) {
        log(type, RLogManager.getInstance().getConfig().getGlobalTag(), contents);
    }

    public static void log(@RLogType.TYPE int type, @NonNull String tag, Object... contents) {
        log(RLogManager.getInstance().getConfig(), type, tag, contents);
    }

    public static void log(@NonNull RLogConfig config, @RLogType.TYPE int type, @NonNull String tag, Object... contents) {
        if (!config.enable()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        String body = parseBody(contents);
        sb.append(body);
        Log.println(type, tag, body);
    }

    private static String parseBody(@NonNull Object[] contents) {
        StringBuilder sb = new StringBuilder();
        for (Object o : contents) {
            sb.append(o.toString()).append(";");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
