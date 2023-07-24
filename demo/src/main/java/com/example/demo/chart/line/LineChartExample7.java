package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LineChartExample7 {
    public static void main(String[] args) {
        // 创建数据集
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        XYSeries serie1 = new XYSeries("Series 1", false,false);
        serie1.add(0.0, 1.0);
        serie1.add(1.0, 3.0);
        serie1.add(2.0, 4.0);
        serie1.add(3.0, 2.0);
        serie1.add(4.0, 5.0);

//        serie1.add(0.0, 5.0);
//        serie1.add(1.0, 5.0);
//        serie1.add(2.0, 5.0);
//        serie1.add(3.0, 5.0);
//        serie1.add(4.0, 5.0);
        dataset.addSeries(serie1);


// 创建JFreeChart对象
        JFreeChart chart = ChartFactory.createXYLineChart(
                "折线图", // 图表标题
                "X轴", // X轴标签
                "Y轴", // Y轴标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向
                true, // 是否显示图例
                true, // 是否生成工具
                false // 是否生成URL链接
        );

// 创建XYPlot对象
        XYPlot plot = chart.getXYPlot();
        plot.setRenderer(new StackedXYAreaRenderer());

// 设置背景色为渐变色
        GradientPaint gp = new GradientPaint(0, 0, Color.white, 0,(float) plot.getRangeAxis().getUpperBound(), Color.blue);
        plot.setBackgroundPaint(gp);

// 创建ChartPanel对象
        ChartPanel panel = new ChartPanel(chart);

// 创建BufferedImage对象
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

// 绘制折线图到BufferedImage上
        Graphics2D g2d = image.createGraphics();
        panel.paint(g2d);
        g2d.dispose();

// 将BufferedImage保存为图片文件
        File file = new File("D://jfreechart//折线图.png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }

    private static XYDataset createDataset() {
        XYSeries series = new XYSeries("Data");
        series.add(1, 2);
        series.add(2, 3);
        series.add(3, 1);
        series.add(4, 5);
        series.add(5, 4);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }
}