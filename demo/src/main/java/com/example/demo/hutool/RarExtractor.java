//package com.example.demo.hutool;
//
//import com.github.junrar.Archive;
//import com.github.junrar.exception.RarException;
//import com.github.junrar.impl.FileVolumeManager;
//import com.github.junrar.rarfile.FileHeader;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class RarExtractor {
//
//    public static void extract(String sourcePath, String destinationPath) throws IOException, RarException {
//        File sourceFile = new File(sourcePath);
//        Archive archive = new Archive(new FileVolumeManager(sourceFile));
//        FileHeader fileHeader;
//        while ((fileHeader = archive.nextFileHeader()) != null) {
//            if (fileHeader.isDirectory()) {
//                continue;
//            }
//            String name = fileHeader.getFileNameString().trim();
//            File file = new File(destinationPath, name);
//            try (FileOutputStream outputStream = new FileOutputStream(file)) {
//                archive.extractFile(fileHeader, outputStream);
//            }
//        }
//    }
//
//}