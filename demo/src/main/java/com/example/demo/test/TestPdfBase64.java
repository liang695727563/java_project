package com.example.demo.test;

import sun.misc.BASE64Decoder;

import java.io.*;

public class TestPdfBase64 {
    public static void main(String[] args) {
        String base64Content= "JVBERi0xLjQKJeLjz9MKMiAwIG9iajw8L0ZvbnRCQm94IFstMjUgLTI1NCAxMDAwIDg4MF0vQ2FwSGVpZ2h0IDg4MC9TdHlsZTw8L1Bhbm9zZSgBBQICBAAAAAAAAAApPj4vVHlwZS9Gb250RGVzY3JpcHRvci9TdGVtViA5My9EZXNjZW50IC0xMjAvRmxhZ3MgNi9Gb250TmFtZS9TVFNvbmctTGlnaHQvQXNjZW50IDg4MC9JdGFsaWNBbmdsZSAwPj4KZW5kb2JqCjMgMCBvYmo8PC9CYXNlRm9udC9TVFNvbmctTGlnaHQvQ0lEU3lzdGVtSW5mbzw8L09yZGVyaW5nKEdCMSkvUmVnaXN0cnkoQWRvYmUpL1N1cHBsZW1lbnQgND4+L1cgWzM0WzY4NF0zNls2OTVdXS9UeXBlL0ZvbnQvU3VidHlwZS9DSURGb250VHlwZTAvRm9udERlc2NyaXB0b3IgMiAwIFIvRFcgMTAwMD4+CmVuZG9iagoxIDAgb2JqPDwvRGVzY2VuZGFudEZvbnRzWzMgMCBSXS9CYXNlRm9udC9TVFNvbmctTGlnaHQtVW5pR0ItVUNTMi1IL1R5cGUvRm9udC9FbmNvZGluZy9VbmlHQi1VQ1MyLUgvU3VidHlwZS9UeXBlMD4+CmVuZG9iago0IDAgb2JqIDw8L0xlbmd0aCAxMC9GaWx0ZXIvRmxhdGVEZWNvZGU+PnN0cmVhbQp4nCvkAgAA7gB8CmVuZHN0cmVhbQplbmRvYmoKNSAwIG9iaiA8PC9MZW5ndGggOTkvRmlsdGVyL0ZsYXRlRGVjb2RlPj5zdHJlYW0KeJxTCOQq5HIK4dKPyDRUMFQISeMCUYYKRelAhgEQGiqYGABJI1OFkFwuAz1zA3NDoASU1kUXQFKr0f3U/25waN35/uPB4n5rGJwZHLuXdB/UDMmCmwwigSpdQ7gCuQAfziCmCmVuZHN0cmVhbQplbmRvYmoKNiAwIG9iajw8L1BhcmVudCA3";
        String filePath = "D:\\test.pdf";
        base64StringToPdf(base64Content,filePath);
    }

    public static void base64StringToPdf(String base64Content, String filePath) {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = null;
        try {
            bytes = decoder.decodeBuffer(base64Content);// base64编码内容转换为字节数组
        } catch (IOException e) {
//            throw new BusinessRuntimeException("base64转换pdf失败：base64转换为字节数组失败");
        }
        File file = new File(filePath);
        File path = file.getParentFile();
        if (!path.exists()) {
            boolean b = path.mkdirs();
            if (!b) {
//                throw new BusinessRuntimeException("base64转换pdf失败：创建文件失败");
            }
        }
        try (
                ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
                BufferedInputStream bis = new BufferedInputStream(byteInputStream);
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
