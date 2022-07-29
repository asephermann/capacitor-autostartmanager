package io.github.asephermann.plugins.autostartmanager

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.hardware.Camera
import android.os.Build
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.util.Log

const val TAG = "AutoStartManager"

class AutoStartManager {

    fun showStartManager(activity: Activity) {
        val context: Context = activity.applicationContext
        AutoStartPermissionHelper().getAutoStartPermission(context)
    }

    fun checkAutomaticDateTimeZone(activity: Activity): Boolean{
        try {
            val result = isAutomaticChecked(activity)
            val context: Context = activity.applicationContext
            if (!result) {
                val alertDialog: AlertDialog = AlertDialog.Builder(activity).create()
                alertDialog.setTitle("Enable Automatic Date Time")
                alertDialog.setCancelable(false)
                alertDialog.setMessage("Your Automatic Date Time or Time Zone Settings is set to 'Off'.\nPlease Enable to use this feature")
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Show Settings"
                ) { dialog, _ ->
                    val i = Intent(Settings.ACTION_DATE_SETTINGS)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(i)
                    dialog.dismiss()
                }
                alertDialog.show()
                return false
            } else {
                return true
            }
        } catch (e: SettingNotFoundException) {
            Log.d(TAG, "SettingNotFoundException")
        }
        return false
    }

    @Throws(SettingNotFoundException::class)
    fun isAutomaticChecked(activity: Activity): Boolean {
        val dateTime: Int
        val timezone: Int
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            dateTime =
                Settings.Global.getInt(activity.contentResolver, Settings.Global.AUTO_TIME, 0)
            timezone =
                Settings.Global.getInt(activity.contentResolver, Settings.Global.AUTO_TIME_ZONE, 0)
        } else {
            dateTime = Settings.System.getInt(
                activity.contentResolver,
                Settings.System.AUTO_TIME_ZONE,
                0
            )
            timezone = Settings.System.getInt(
                activity.contentResolver,
                Settings.System.AUTO_TIME,
                0
            )
        }
        return !(dateTime == 0 || timezone == 0)
    }

    fun checkCamera(): Boolean{
        var camera: Camera? = null
        try {
            camera = Camera.open()
        } catch (e: RuntimeException) {
            return false
        } finally {
            camera?.release()
        }
        return true
    }

}