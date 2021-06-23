package com.redrain.r_log;

public interface RLogFormatter<T> {
    String format(T data);
}
