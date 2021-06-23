package com.redrain.r_log;

public class RStackTraceFormatter implements RLogFormatter<StackTraceElement[]> {
    @Override
    public String format(StackTraceElement[] stackTrace) {
        StringBuilder stringBuilder = new StringBuilder(128);

        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        } else if (stackTrace.length == 1) {
            return "\t- " + stackTrace[0].toString();
        } else {
            for (int i = 0, len = stackTrace.length; i < len; i++) {
                if (i == 0) {
                    stringBuilder.append("stackTrace: \n");
                }
                if (i != len - 1) {
                    stringBuilder.append("\t├ ");
                    stringBuilder.append(stackTrace[i].toString());
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append("\t⎣");
                    stringBuilder.append(stackTrace[i].toString());
                }
            }
            return stringBuilder.toString();
        }
    }
}
