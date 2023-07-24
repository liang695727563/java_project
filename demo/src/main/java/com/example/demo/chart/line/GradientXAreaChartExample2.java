package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeTableXYDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GradientXAreaChartExample2 {
    public static void main(String[] args) throws IOException {
        // 创建数据集
        TimeTableXYDataset dataset = new TimeTableXYDataset();
        dataset.add(new Month(1, 2000), 100, "Series 1");
        dataset.add(new Month(2, 2000), 130, "Series 1");
        dataset.add(new Month(3, 2000), 150, "Series 1");
        dataset.add(new Month(4, 2000), 170, "Series 1");
        dataset.add(new Month(5, 2000), 190, "Series 1");
        dataset.add(new Month(6, 2000), 210, "Series 1");

        dataset.add(new Month(1, 2000), 50, "Series 2");
        dataset.add(new Month(2, 2000), 70, "Series 2");
        dataset.add(new Month(3, 2000), 90, "Series 2");
        dataset.add(new Month(4, 2000), 110, "Series 2");
        dataset.add(new Month(5, 2000), 130, "Series 2");
        dataset.add(new Month(6, 2000), 150, "Series 2");

        // 创建堆叠面积图
        JFreeChart chart = ChartFactory.createStackedXYAreaChart("Gradient X Area Chart Example", "Date", "Value", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        // 设置渐变色
        XYItemRenderer renderer = ((XYPlot) chart.getPlot()).getRenderer();
        Color[] colors = { new Color(0x0066CC), new Color(0xFF6600)};
        GradientPaint gp = new GradientPaint(0f, 0f, colors[0], 0f, 0f, colors[1]);
        renderer.setSeriesPaint(0, gp);
        renderer.setSeriesPaint(1, gp);

//        // 设置 GradientPaintTransformType 和 GradientPaintTransformer
//        renderer.setGradientPaintTransformer(
//            new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
//        renderer.setGradientPaintTransformer(
//            new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));

        // 保存为图片
        File file = new File("D://jfreechart//gradient_x_area_chart2.png");
        int width = 640;
        int height = 480;
        ChartUtilities.saveChartAsPNG(file, chart, width, height);
        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}