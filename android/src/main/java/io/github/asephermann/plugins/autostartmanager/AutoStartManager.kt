package io.github.asephermann.plugins.autostartmanager

import android.util.Log

class AutoStartManager {
    fun echo(value: String): String {
        Log.i("Echo", value)
        return value
    }
}