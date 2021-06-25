package com.redrain.rlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redrain.r_log.RViewPrinter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPrinter = RViewPrinter(this)
        viewPrinter.viewPrinterProvider.showFloatingView()
    }
}