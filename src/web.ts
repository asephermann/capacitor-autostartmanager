import { WebPlugin } from '@capacitor/core';

import type { AutoStartManagerPlugin } from './definitions';

export class AutoStartManagerWeb extends WebPlugin implements AutoStartManagerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
