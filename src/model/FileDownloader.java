package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;

public class FileDownloader implements Downloader{
    private String link;
    private File out;
    public FileDownloader(String link, File out){
        this.link = link;
        this.out = out;

    }

    @Override
    public void download() {
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            double fileSize = (double)httpURLConnection.getContentLengthLong();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(out);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream,1024);
            byte[] buffer = new byte[1024];
            double download = 0.00;
            int read = 0;
            double percentDownload = 0.00;
            while ((read = bufferedInputStream.read(buffer,0,1024)) >= 0){
                bufferedOutputStream.write(buffer,0,read);
                download +=read;
                percentDownload = (download*100)/fileSize;
                String percent = String .format("%,4f",percentDownload);
                System.out.println("Downloaded "+percent+" % of a file.");

            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
            System.out.println("Download complete");
        } catch (Exception e) {
            System.out.println("Download failed");
        }
    }
}
