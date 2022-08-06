package com.shane.helloworld

import android.util.Log

fun CLog(description: String, tag: String = "[DEBUG]") {
    Log.d(tag, description)
}