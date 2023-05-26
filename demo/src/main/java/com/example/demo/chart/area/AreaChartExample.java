package com.example.demo.chart.area;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class AreaChartExample {

    public static void main(String[] args) throws IOException {
        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYAreaChart(
            null, // 设置标题为空
            null, // 设置横坐标轴标签为空
            null, // 设置纵坐标轴标签为空
            dataset,
            PlotOrientation.VERTICAL,
            false, // 不显示图例
            false, // 不使用工具提示
            false // 不使用 URLs
        );
        chart.setBackgroundPaint(Color.WHITE); // 设置背景颜色为白色

        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(null); // 去除背景
        plot.setOutlinePaint(null); // 去除边框
        plot.setDomainGridlinesVisible(false); // 去除横坐标网格线
        plot.setRangeGridlinesVisible(false); // 去除纵坐标网格线
        plot.setRangeZeroBaselineVisible(true); // 显示 X 轴和 Y 轴交叉点
        plot.setDomainCrosshairVisible(false); // 隐藏横坐标十字线
        plot.setRangeCrosshairVisible(false); // 隐藏纵坐标十字线

        plot.setRenderer(new XYLineAndShapeRenderer(true, false)); // 将折线图设置为实线

        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setVisible(false); // 去除横坐标轴线
        domainAxis.setAutoRangeIncludesZero(false);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setVisible(false); // 去除纵坐标轴线
        rangeAxis.setAutoRangeIncludesZero(false);

//        chart.getTitle().setFont(new Font("宋体", Font.PLAIN, 16)); // 设置标题字体
        ChartUtilities.saveChartAsPNG(new File("D://jfreechart//area_chart.png"), chart, 800, 400);
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