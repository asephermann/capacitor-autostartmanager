package io.github.asephermann.plugins.autostartmanager

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.os.Build
import java.util.*


class AutoStartPermissionHelper {

    /***
     * Xiaomi
     */
    val BRAND_XIAOMI = "xiaomi"
    private val PACKAGE_XIAOMI_MAIN = "com.miui.securitycenter"
    private val PACKAGE_XIAOMI_COMPONENT = "com.miui.permcenter.autostart.AutoStartManagementActivity"

    /***
     * Letv
     */
    val BRAND_LETV = "letv"
    private val PACKAGE_LETV_MAIN = "com.letv.android.letvsafe"
    private val PACKAGE_LETV_COMPONENT = "com.letv.android.letvsafe.AutobootManageActivity"

    /***
     * ASUS ROG
     */
    val BRAND_ASUS = "asus"
    val PACKAGE_ASUS_MAIN = "com.asus.mobilemanager"
    val PACKAGE_ASUS_COMPONENT = "com.asus.mobilemanager.MainActivity"

    /***
     * Honor
     */
    val BRAND_HONOR = "honor"
    private val PACKAGE_HONOR_MAIN = "com.huawei.systemmanager"
    private val PACKAGE_HONOR_COMPONENT = "com.huawei.systemmanager.optimize.process.ProtectActivity"

    /**
     * Oppo
     */
    val BRAND_OPPO = "oppo"
    private val PACKAGE_OPPO_MAIN = "com.coloros.safecenter"
    private val PACKAGE_OPPO_FALLBACK = "com.oppo.safe"
    private val PACKAGE_OPPO_COMPONENT = "com.coloros.safecenter.permission.startup.StartupAppListActivity"
    private val PACKAGE_OPPO_COMPONENT_FALLBACK = "com.oppo.safe.permission.startup.StartupAppListActivity"
    private val PACKAGE_OPPO_COMPONENT_FALLBACK_A = "com.coloros.safecenter.startupapp.StartupAppListActivity"

    /**
     * Vivo
     */
    val BRAND_VIVO = "vivo"
    private val PACKAGE_VIVO_MAIN = "com.iqoo.secure"
    private val PACKAGE_VIVO_FALLBACK = "com.vivo.permissionmanager"
    private val PACKAGE_VIVO_COMPONENT = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"
    private val PACKAGE_VIVO_COMPONENT_FALLBACK = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
    private val PACKAGE_VIVO_COMPONENT_FALLBACK_A = "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"

    /**
     * Nokia
     */
    val BRAND_NOKIA = "nokia"
    private val PACKAGE_NOKIA_MAIN = "com.evenwell.powersaving.g3"
    private val PACKAGE_NOKIA_COMPONENT = "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity"

    fun getAutoStartPermission(context: Context) {
        val build_info = Build.BRAND.lowercase(Locale.getDefault())
        println(build_info)
        when (build_info) {
            BRAND_ASUS -> autoStartAsus(context)
            BRAND_XIAOMI -> autoStartXiaomi(context)
            BRAND_LETV -> autoStartLetv(context)
            BRAND_HONOR -> autoStartHonor(context)
            BRAND_OPPO -> autoStartOppo(context)
            BRAND_VIVO -> autoStartVivo(context)
            BRAND_NOKIA -> autoStartNokia(context)
        }
    }

    private fun isPackageExists(context: Context, targetPackage: String): Boolean {
        val packages: List<ApplicationInfo>
        val pm = context.packageManager
        packages = pm.getInstalledApplications(0)
        println(targetPackage)
        for (i in packages.indices) {
            println(packages[i].packageName)
            if (packages[i].packageName == targetPackage) {
                return true
            }
        }
        return false
    }

    @Throws(Exception::class)
    private fun startIntent(context: Context, packageName: String, componentName: String) {
        println(packageName)
        println(componentName)
        try {
            val intent = Intent()
            intent.component = ComponentName(packageName, componentName)
            context.startActivity(intent)
        } catch (exc: Exception) {
            println(exc)
            exc.printStackTrace()
        }
    }

    private fun autoStartXiaomi(context: Context) {
        if (isPackageExists(context, PACKAGE_XIAOMI_MAIN)) {
            try {
                startIntent(context, PACKAGE_XIAOMI_MAIN, PACKAGE_XIAOMI_COMPONENT)
            } catch (var3: java.lang.Exception) {
                var3.printStackTrace()
            }
        }
    }

    private fun autoStartAsus(context: Context) {
        println("Masuk Asus")
        println(isPackageExists(context, PACKAGE_ASUS_MAIN))
        if (isPackageExists(context, PACKAGE_ASUS_MAIN)) {
            try {
                startIntent(context, PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT)
            } catch (var3: java.lang.Exception) {
                println(var3)
                var3.printStackTrace()
            }
        }
    }

    private fun autoStartLetv(context: Context) {
        if (isPackageExists(context, PACKAGE_LETV_MAIN)) {
            try {
                startIntent(context, PACKAGE_LETV_MAIN, PACKAGE_LETV_COMPONENT)
            } catch (var3: java.lang.Exception) {
                var3.printStackTrace()
            }
        }
    }

    private fun autoStartHonor(context: Context) {
        if (isPackageExists(context, PACKAGE_HONOR_MAIN)) {
            try {
                startIntent(context, PACKAGE_HONOR_MAIN, PACKAGE_HONOR_COMPONENT)
            } catch (var3: java.lang.Exception) {
                var3.printStackTrace()
            }
        }
    }

    private fun autoStartOppo(context: Context) {
        if (isPackageExists(context, PACKAGE_OPPO_MAIN) || isPackageExists(
                context,
                PACKAGE_OPPO_FALLBACK
            )
        ) {
            try {
                startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT)
            } catch (var7: java.lang.Exception) {
                var7.printStackTrace()
                try {
                    startIntent(context, PACKAGE_OPPO_FALLBACK, PACKAGE_OPPO_COMPONENT_FALLBACK)
                } catch (var6: java.lang.Exception) {
                    var6.printStackTrace()
                    try {
                        startIntent(context, PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT_FALLBACK_A)
                    } catch (var5: java.lang.Exception) {
                        var5.printStackTrace()
                    }
                }
            }
        }
    }

    private fun autoStartVivo(context: Context) {
        if (isPackageExists(context, PACKAGE_VIVO_MAIN) || isPackageExists(
                context,
                PACKAGE_VIVO_FALLBACK
            )
        ) {
            try {
                startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT)
            } catch (var7: java.lang.Exception) {
                var7.printStackTrace()
                try {
                    startIntent(context, PACKAGE_VIVO_FALLBACK, PACKAGE_VIVO_COMPONENT_FALLBACK)
                } catch (var6: java.lang.Exception) {
                    var6.printStackTrace()
                    try {
                        startIntent(context, PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT_FALLBACK_A)
                    } catch (var5: java.lang.Exception) {
                        var5.printStackTrace()
                    }
                }
            }
        }
    }

    private fun autoStartNokia(context: Context) {
        if (isPackageExists(context, PACKAGE_NOKIA_MAIN)) {
            try {
                startIntent(context, PACKAGE_NOKIA_MAIN, PACKAGE_NOKIA_COMPONENT)
            } catch (var3: java.lang.Exception) {
                var3.printStackTrace()
            }
        }
    }

}