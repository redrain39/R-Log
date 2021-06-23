package com.redrain.r_log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RLogManager {

    private RLogConfig config;
    private static RLogManager instance;
    private List<RLogPrinter> printers = new ArrayList<>();

    private RLogManager(RLogConfig config, RLogPrinter[] printers) {
        this.config = config;
        this.printers.addAll(Arrays.asList(printers));
    }

    public static RLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull RLogConfig config, RLogPrinter... printers) {
        instance = new RLogManager(config, printers);
    }

    public RLogConfig getConfig() {
        return config;
    }

    public List<RLogPrinter> getPrinters() {
        return printers;
    }

    public void addPrinter(RLogPrinter printer) {
        printers.add(printer);
    }

    public void removePrinter(RLogPrinter printer) {
        if (printer != null) {
            printers.remove(printer);
        }
    }
}
