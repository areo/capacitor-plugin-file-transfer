# Capacitor Plugin for downloading files

```ts
import { Plugins } from '@capacitor/core'

const { FileTransfer } = Plugins

async function download(url, file): Promise<void> {
  await FileTransfer.download({ url, file })
  console.log('Download complete')
}

download('https://example.com/logo.png', 'file:///some/local/path/logo.png')
```
