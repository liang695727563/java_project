//package com.example.demo.hutool;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import de.innosystec.unrar.Archive;
//import de.innosystec.unrar.exception.RarException;
//import de.innosystec.unrar.rarfile.FileHeader;
//
//public class UnRar {
//    public static void main(String[] args) throws RarException, IOException {
//        // 输入RAR文件路径和输出目录
//        String sourcePath = "/path/to/source.rar";
//        String destinationPath = "/path/to/destination/directory/";
//
//        // 打开RAR文件
//        Archive archive = new Archive(new File(sourcePath));
//
//        // 迭代RAR文件中的每个文件
//        FileHeader fileHeader = archive.nextFileHeader();
//        while (fileHeader != null) {
//            // 获取文件名和路径
//            String fileName = fileHeader.getFileNameString().trim();
//            String filePath = destinationPath + fileName;
//
//            // 如果是文件夹，则创建文件夹
//            if (fileHeader.isDirectory()) {
//                File directory = new File(filePath);
//                directory.mkdirs();
//            } else {
//                // 如果是文件，则将其写入磁盘
//                File file = new File(filePath);
//                OutputStream outputStream = new FileOutputStream(file);
//
//                archive.extractFile(fileHeader, outputStream);
//                outputStream.close();
//            }
//
//            // 处理下一个RAR文件
//            fileHeader = archive.nextFileHeader();
//        }
//
//        // 关闭RAR文件
//        archive.close();
//    }
//}