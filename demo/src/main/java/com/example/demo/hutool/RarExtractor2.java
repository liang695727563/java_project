//package com.example.demo.hutool;
//import com.nikemc.mgmt.j7zip.ISevenZipInArchive;
//import com.nikemc.mgmt.j7zip.SevenZip;
//import com.nikemc.mgmt.j7zip.archive.SevenZipEntry;
//import com.nikemc.mgmt.j7zip.archive.SevenZipException;
//import com.nikemc.mgmt.j7zip.archive.SevenZipFile;
//import com.nikemc.mgmt.j7zip.archive.SevenZipNativeLibs;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class RarExtractor2 {
//
//    static {
//        SevenZipNativeLibs.loadNativeLibraries();
//    }
//
//    public static void extract(String sourcePath, String destinationPath) throws IOException, SevenZipException {
//        try (SevenZipFile sevenZipFile = new SevenZipFile(new File(sourcePath))) {
//            ISevenZipInArchive inArchive = sevenZipFile.getInArchive();
//            int numItems = inArchive.getNumberOfItems();
//            for (int i = 0; i < numItems; ++i) {
//                SevenZipEntry entry = inArchive.getEntry(i);
//                if (entry.isDirectory()) {
//                    continue;
//                }
//                String name = entry.getName();
//                File file = new File(destinationPath, name);
//                try (FileOutputStream outputStream = new FileOutputStream(file)) {
//                    inArchive.extractSlow(i, outputStream);
//                }
//            }
//        }
//    }
//
//}