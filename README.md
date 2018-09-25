# Capacitor Plugin for downloading files

```ts
import { Plugins } from '@capacitor/core'

const { FileTransfer } = Plugins

async function download(source: string, target: string): Promise<void> {
  await FileTransfer.download({ source, target })
  console.log('Download complete')
}

download('https://example.com/logo.png', 'file:///some/local/path/logo.png')
```
