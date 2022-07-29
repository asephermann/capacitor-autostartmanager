export interface AutoStartManagerPlugin {

  checkAutomaticDateTimeZone(): Promise<{isAutomatic: Boolean}>;
  checkCamera(): Promise<{isCameraOpen: Boolean}>;

}
