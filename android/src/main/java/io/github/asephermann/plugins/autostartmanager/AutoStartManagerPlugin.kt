package io.github.asephermann.plugins.autostartmanager

import com.getcapacitor.JSObject

@CapacitorPlugin(name = "AutoStartManager")
class AutoStartManagerPlugin : Plugin() {
    private val implementation = AutoStartManager()
    @PluginMethod
    fun echo(call: PluginCall) {
        val value: String = call.getString("value")
        val ret = JSObject()
        ret.put("value", implementation.echo(value))
        call.resolve(ret)
    }
}