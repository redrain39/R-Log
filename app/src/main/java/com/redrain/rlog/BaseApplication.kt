package com.redrain.rlog

import android.app.Application
import com.google.gson.Gson
import com.redrain.r_log.RConsolePrinter
import com.redrain.r_log.RLogConfig
import com.redrain.r_log.RLogManager
import com.redrain.r_log.RLogPrinter

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RLogManager.init(object : RLogConfig() {
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "BaseApplication";
            }

            override fun enable(): Boolean {
                return true;
            }
        }, RConsolePrinter())
    }
}