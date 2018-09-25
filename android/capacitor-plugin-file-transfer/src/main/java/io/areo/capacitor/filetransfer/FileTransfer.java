package io.areo.capacitor.filetransfer;

import android.net.Uri;

import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

@NativePlugin()
public class FileTransfer extends Plugin {
    @PluginMethod()
    public void download(PluginCall call) {
        String srcUrl = call.getString("source");
        String dstFile = call.getString("target");

        try {
            this.downloadToFile(srcUrl, dstFile);
            call.success();
        } catch (IOException e) {
            call.error("FileTransfer download failed", e);
        }
    }

    private void downloadToFile(String url, String filePath) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("HTTP response was not successful. Status code: " + response.code());
        }

        writeResponseToFile(response, filePath);
    }

    private void writeResponseToFile(Response response, String filePath) throws IOException {
        File downloadedFile = new File(Uri.parse(filePath).getPath());
        File parent = downloadedFile.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
        sink.writeAll(response.body().source());
        sink.close();
    }
}
