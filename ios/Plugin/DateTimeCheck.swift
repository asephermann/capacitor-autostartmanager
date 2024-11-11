import Foundation

public class DateTimeCheck {

    // Fungsi untuk mengecek apakah pengaturan waktu otomatis aktif
    public func checkIfAutomaticDateTimeIsEnabled(completion: @escaping (Bool) -> Void) {
        fetchServerTime { serverDate in
            let deviceDate = Date()
            let timeDifference = abs(deviceDate.timeIntervalSince(serverDate))
            let isAutomaticDateTimeEnabled = timeDifference < 300
            completion(isAutomaticDateTimeEnabled)
        }
    }

    // Fungsi untuk mengambil waktu dari server eksternal
    private func fetchServerTime(completion: @escaping (Date) -> Void) {
        let url = URL(string: "https://worldtimeapi.org/api/timezone/Etc/UTC")!
        URLSession.shared.dataTask(with: url) { data, response, error in
            guard let data = data, error == nil else {
                completion(Date())
                return
            }

            if let json = try? JSONSerialization.jsonObject(with: data) as? [String: Any],
               let utcString = json["utc_datetime"] as? String,
               let serverDate = ISO8601DateFormatter().date(from: utcString) {
                completion(serverDate)
            } else {
                completion(Date())
            }
        }.resume()
    }
}
