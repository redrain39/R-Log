package com.redrain.r_log;

import android.util.Log;

import androidx.annotation.NonNull;

import static com.redrain.r_log.RLogConfig.MAX_LEN;

public class RConsolePrinter implements RLogPrinter {
    @Override
    public void print(@NonNull RLogConfig config, int level, String tag,
                      @NonNull String printString) {
        int len = printString.length();
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            if (index != len) {
                Log.println(level, tag, printString.substring(index, len));
            }
        } else {
            Log.println(level, tag, printString);
        }
    }
}
