import { registerPlugin } from '@capacitor/core';

import type { AutoStartManagerPlugin } from './definitions';

const AutoStartManager = registerPlugin<AutoStartManagerPlugin>('AutoStartManager', {
  web: () => import('./web').then(m => new m.AutoStartManagerWeb()),
});

export * from './definitions';
export { AutoStartManager };
