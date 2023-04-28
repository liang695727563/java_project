//package com.example.demo.hutool;
//import org.apache.commons.compress.archivers.ArchiveEntry;
//import org.apache.commons.compress.archivers.ArchiveInputStream;
//import org.apache.commons.compress.archivers.ArchiveStreamFactory;
//
//import java.io.*;
//
//public class RarExtractor1 {
//
//    public static void extract(String sourcePath, String destinationPath) throws IOException {
//        try (InputStream inputStream = new FileInputStream(sourcePath)) {
//            ArchiveInputStream archiveInputStream = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.RAR, inputStream);
//            ArchiveEntry entry;
//            while ((entry = archiveInputStream.getNextEntry()) != null) {
//                if (!archiveInputStream.canReadEntryData(entry)) {
//                    continue;
//                }
//                String name = entry.getName();
//                File file = new File(destinationPath, name);
//                if (entry.isDirectory()) {
//                    file.mkdirs();
//                } else {
//                    byte[] buffer = new byte[1024];
//                    try (OutputStream outputStream = new FileOutputStream(file)) {
//                        int bytesRead;
//                        while ((bytesRead = archiveInputStream.read(buffer)) != -1) {
//                            outputStream.write(buffer, 0, bytesRead);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}