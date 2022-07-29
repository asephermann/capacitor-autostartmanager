export interface AutoStartManagerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
