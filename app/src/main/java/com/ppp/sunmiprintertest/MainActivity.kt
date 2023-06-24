package com.ppp.sunmiprintertest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    public var mContext: Context? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this;
        Log.d("ppp", mContext.toString())

        val btn_test_printer_click = findViewById(R.id.btn_test_printer) as Button;
        btn_test_printer_click.setOnClickListener {
            Log.d("ppp",  "Onclick() btn")
        }
    }

}