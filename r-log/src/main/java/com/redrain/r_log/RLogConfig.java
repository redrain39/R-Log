package com.redrain.r_log;

public abstract class RLogConfig {

    static int MAX_LEN = 512;
    static RStackTraceFormatter R_STACK_TRACE_FORMATTER = new RStackTraceFormatter();
    static RThreadFormatter R_THREAD_FORMATTER = new RThreadFormatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    public String getGlobalTag() {
        return "RLog";
    }

    public boolean enable() {
        return true;
    }

    public boolean includeThread() {
        return false;
    }

    public int stackTraceDepth() {
        return 5;
    }

    public RLogPrinter[] printers() {
        return null;
    }

    public interface JsonParser {
        String toJson(Object src);
    }
}
