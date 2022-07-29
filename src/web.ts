import { WebPlugin } from '@capacitor/core';

import type { AutoStartManagerPlugin } from './definitions';

export class AutoStartManagerWeb extends WebPlugin implements AutoStartManagerPlugin {
  async checkAutomaticDateTimeZone(): Promise<{isAutomatic: Boolean}> {
    throw new Error('Method not implemented.');
  }
}
