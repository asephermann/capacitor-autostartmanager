export interface AutoStartManagerPlugin {

  checkAutomaticDateTimeZone(): Promise<{isAutomatic: Boolean}>;

}
