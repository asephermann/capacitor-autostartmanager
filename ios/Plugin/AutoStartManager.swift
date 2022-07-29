import Foundation

@objc public class AutoStartManager: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
