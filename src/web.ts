import { WebPlugin } from '@capacitor/core';

import type { AutoStartManagerPlugin } from './definitions';

export class AutoStartManagerWeb extends WebPlugin implements AutoStartManagerPlugin {
  async showStartManager(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  async checkAutomaticDateTimeZone(): Promise<{isAutomatic: Boolean}> {
    throw new Error('Method not implemented.');
  }
  async checkCamera(): Promise<{ isCameraOpen: Boolean; }> {
    throw new Error('Method not implemented.');
  }
}
