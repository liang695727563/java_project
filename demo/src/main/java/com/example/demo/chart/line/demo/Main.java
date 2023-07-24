package com.example.demo.chart.line.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeTableXYDataset;

import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // create dataset
        // 创建数据集
        TimeTableXYDataset dataset = new TimeTableXYDataset();
        dataset.add(new Month(1, 2000), 100, "Series 1");
        dataset.add(new Month(2, 2000), 90, "Series 1");
        dataset.add(new Month(3, 2000), 150, "Series 1");
        dataset.add(new Month(4, 2000), 80, "Series 1");
        dataset.add(new Month(5, 2000), 190, "Series 1");
        dataset.add(new Month(6, 2000), 210, "Series 1");

//        dataset.add(new Month(1, 2000), 50, "Series 2");
//        dataset.add(new Month(2, 2000), 70, "Series 2");
//        dataset.add(new Month(3, 2000), 90, "Series 2");
//        dataset.add(new Month(4, 2000), 110, "Series 2");
//        dataset.add(new Month(5, 2000), 130, "Series 2");
//        dataset.add(new Month(6, 2000), 150, "Series 2");


        // create chart
        JFreeChart chart = ChartFactory.createStackedXYAreaChart(
            null,
            "X Axis Label",
            "Y Axis Label",
            dataset,
            PlotOrientation.VERTICAL,
            false,
            false,
            false
        );

        // set renderer
        StackedXYAreaRenderer2 renderer = new StackedXYAreaRenderer2();
        renderer.setSeriesPaint(0, new GradientPaint(
            0.0f, 0.0f, Color.BLUE,
            0.0f, 0.0f, Color.WHITE
        ));
        renderer.setOutline(true);

        // 创建渐变色
//        Color color1 = new Color(255,214,192);
        Color color1 = new Color(255,160 ,122	);
        Color color2 = new Color(255, 255, 255);
        GradientPaint gradient = new GradientPaint(0, 0, color1, 500, 360, color2);
        renderer.setSeriesPaint(0, gradient); // 渐变色


//        renderer.setSeriesPaint(0, new Color(255,214,192));//图形前景
        renderer.setSeriesOutlineStroke(0, new BasicStroke(100));

        XYPlot xyPlot = chart.getXYPlot();
        xyPlot.setRenderer(renderer);

        // 取消 X 轴和 Y 轴的显示
        ValueAxis domainAxis = xyPlot.getDomainAxis();
        domainAxis.setVisible(false);
        ValueAxis rangeAxis = xyPlot.getRangeAxis();
        rangeAxis.setVisible(false);
        xyPlot.setBackgroundPaint(null); // 去除背景
        xyPlot.setOutlinePaint(null); // 去除边框
        xyPlot.setForegroundAlpha(0.5f);//前影透明
        xyPlot.setBackgroundAlpha(0.1f);
        // save chart as PNG image
        File file = new File("D://jfreechart//chart.png");

        ChartUtilities.saveChartAsPNG(file, chart, 500, 300);
        System.out.println("图片已保存到 " + file.getAbsolutePath());

    }
}