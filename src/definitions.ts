export interface AutoStartManagerPlugin {

  showStartManager(): Promise<void>;
  checkAutomaticDateTimeZone(): Promise<{isAutomatic: Boolean}>;
  checkCamera(): Promise<{isCameraOpen: Boolean}>;

}
