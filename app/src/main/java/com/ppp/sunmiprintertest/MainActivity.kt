package com.ppp.sunmiprintertest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

import com.ppp.sunmiprinter_library.*;

class MainActivity : AppCompatActivity() {
    public var mContext: Context? = null;
    public var sunmiHelper: SunmiPrinterHelper? = null;

    private lateinit var textView_status: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this;
        // not null sure >> !!
        // but it can be null if not find service
        sunmiHelper?.initSunmiPrinterService(mContext);
        Log.d("ppp", mContext.toString())

        val btn_test_printer_click = findViewById(R.id.btn_test_printer) as Button;
        btn_test_printer_click.setOnClickListener {
            Log.d("ppp",  "Onclick() btn")
            if(sunmiHelper != null) {
                Log.d("ppp",  "Sunmi Printer is Not Null")
                setTextView("Sunmi printer is not NULL")
                sunmiHelper!!.printText("Hi!! ppp\n", 18F, true, false, null);
                sunmiHelper!!.printText("Hi!! > . <", 20F, true, false, null);
                sunmiHelper!!.cutpaper();
            } else {
                Log.d("ppp",  "Sunmi Printer is Null")
                setTextView("Sunmi printer is NULL")
            }
        }
    }

    private fun setTextView(data: String) {
        textView_status = findViewById<TextView>(R.id.tv_status_printer);
        textView_status.text = data;
    }

}