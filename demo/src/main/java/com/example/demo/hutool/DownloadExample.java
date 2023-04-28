package com.example.demo.hutool;
import cn.hutool.core.util.ZipUtil;

import java.io.File;


public class DownloadExample {

    public static void main(String[] args) {
//        String url = "https://example.com/file.rar"; // 要下载的RAR文件URL

//        String filePath = "D:\\downloads\\file.rar"; // 保存RAR文件的本地路径

//        HttpUtil.downloadFile(url,filePath);
//        HttpUtil.downloadFile(url, FileUtil.file(filePath), true);
        String filePath = "D:\\BaiduNetdiskDownload\\PS CC2023 (适合win10  win11).rar";


        File unzip = ZipUtil.unzip(filePath);
    }

}
