package com.redrain.r_log;

public class RThreadFormatter implements RLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}
