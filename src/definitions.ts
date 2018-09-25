declare global {
  interface PluginRegistry {
    FileTransfer?: FileTransferPlugin
  }
}

export interface FileTransferPlugin {
  download(options: { source: string; target: string }): Promise<void>
}
