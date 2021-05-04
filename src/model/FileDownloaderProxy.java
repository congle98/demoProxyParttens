package model;

import java.io.File;

public class FileDownloaderProxy implements Downloader{
    private FileDownloader fileDownloader;

    public FileDownloaderProxy(String link, File file) {
        fileDownloader = new FileDownloader(link,file);
    }

    @Override
    public void download() {
        fileDownloader.download();
    }
}
