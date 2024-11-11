import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(AutoStartManagerPlugin)
public class AutoStartManagerPlugin: CAPPlugin {
    private let implementation = AutoStartManager()
    private let dateTimeCheck = DateTimeCheck()  // Instance dari DateTimeCheck

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    // Fungsi untuk mengecek apakah pengaturan waktu otomatis aktif
    @objc func checkAutomaticDateTime(_ call: CAPPluginCall) {
        dateTimeCheck.checkIfAutomaticDateTimeIsEnabled { isAutomatic in
            call.resolve([
                "isAutomatic": isAutomatic
            ])
        }
    }
}
