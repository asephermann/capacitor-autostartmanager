package io.github.asephermann.plugins.autostartmanager

import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "AutoStartManager")
class AutoStartManagerPlugin : Plugin() {
    private val implementation = AutoStartManager()

    @PluginMethod
    fun checkAutomaticDateTimeZone(call: PluginCall) {
        val ret = JSObject()
        val isAutomatic = implementation.checkAutomaticDateTimeZone(activity)
        ret.put("isAutomatic", isAutomatic)
        call.resolve(ret)
    }

    @PluginMethod
    fun checkCamera(call: PluginCall) {
        val ret = JSObject()
        ret.put("isCameraOpen", implementation.checkCamera())
        call.resolve(ret)
    }
}