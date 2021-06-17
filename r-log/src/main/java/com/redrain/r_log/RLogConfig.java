package com.redrain.r_log;

public abstract class RLogConfig {
    public String getGlobalTag() {
        return "RLog";
    }
    public boolean enable() {
        return true;
    }
}
