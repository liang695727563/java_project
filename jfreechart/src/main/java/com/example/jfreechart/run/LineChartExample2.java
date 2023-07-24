package com.example.jfreechart.run;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class LineChartExample2 {

    public static void main(String[] args) {
        // 创建数据集
        XYSeries series = new XYSeries("Data");
        series.add(1, 50);
        series.add(2, 100);
        series.add(3, 70);
        series.add(4, 120);
        series.add(5, 90);
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // 创建折线图对象
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Title", // 标题
            "X Axis Label", // X轴标签
            "Y Axis Label", // Y轴标签
            dataset, // 数据集
            PlotOrientation.VERTICAL, // 方向
            true, // 是否显示图例
            true, // 是否显示工具提示
            false // 是否生成URL链接
        );

        // 配置渐变色和折线颜色
        XYPlot plot = chart.getXYPlot();
        GradientPaint paint = new GradientPaint(
            0f, (float) plot.getRangeAxis().getLowerBound(), new Color(0, 0, 64),
            0f, 0f, Color.BLUE
        );
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesFillPaint(0, paint); // 这里使用第一个系列
        plot.setRenderer(renderer);

        // 配置图表样式
        chart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);

        // 显示图表
        JFrame frame = new JFrame("Chart Title");
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.setContentPane(chartPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}