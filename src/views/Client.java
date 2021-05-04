package views;

import model.FileDownloaderProxy;

import java.io.File;

public class Client {
    public static void main(String[] args) {
        FileDownloaderProxy fileDownloaderProxy = new FileDownloaderProxy("https://cellphones.com.vn/sforum/wp-content/uploads/2020/04/LR-29-scaled.jpg",new File("output.jpg"));
        fileDownloaderProxy.download();
    }
}
