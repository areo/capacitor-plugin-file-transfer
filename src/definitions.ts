declare global {
  interface PluginRegistry {
    FileTransfer?: FileTransferPlugin;
  }
}

export interface FileTransferPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
}
