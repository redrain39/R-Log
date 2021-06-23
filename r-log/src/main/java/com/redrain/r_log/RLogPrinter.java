package com.redrain.r_log;

import androidx.annotation.NonNull;

public interface RLogPrinter {
    void print(@NonNull RLogConfig config, int level, String tag, @NonNull String printString);
}
