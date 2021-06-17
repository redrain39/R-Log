package com.redrain.r_log;

import androidx.annotation.NonNull;

public class RLogManager {

    private RLogConfig config;
    private static RLogManager instance;

    private RLogManager(RLogConfig config) {
        this.config = config;
    }

    public static RLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull RLogConfig config) {
        instance = new RLogManager(config);
    }

    public RLogConfig getConfig() {
        return config;
    }
}
