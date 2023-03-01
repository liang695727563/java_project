package com.example.demo.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class MatrixToImageWriter2 {
    private static final int BLACK = 0xFF000000;

    private static final int WHITE = 0x00FFFFFF;

    private static final int BLACK2 = 0x00000000;

    private static final int WHITE2 = 0xFFFFFFFF;

    private MatrixToImageWriter2() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }

        return image;
    }
    public static BufferedImage toBufferedImage2(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? WHITE2 : BLACK2 );
            }
        }

        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file, File file2)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
        BufferedImage image2 = toBufferedImage2(matrix);
        if (!ImageIO.write(image2, format, file2)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    public static void main(String[] args) {
        try {
            String content = "这是测试xing二维码生成";
            String path = "D:/image";
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            //内容所使用编码
            hints.put(EncodeHintType.CHARACTER_SET, "gb2312");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200, hints);
            //生成二维码
            File outputFile = new File(path, "14.PNG");
            File outputFile2 = new File(path, "15.png");
            MatrixToImageWriter2.writeToFile(bitMatrix, "PNG", outputFile,outputFile2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}