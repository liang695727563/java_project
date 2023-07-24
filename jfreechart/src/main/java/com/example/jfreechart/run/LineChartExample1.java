package com.example.jfreechart.run;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class LineChartExample1 {

    public static void main(String[] args) {
        // 数据集
        XYSeries series = new XYSeries("Data");
        series.add(1, 50);
        series.add(2, 100);
        series.add(3, 70);
        series.add(4, 120);
        series.add(5, 90);
        XYDataset dataset = new XYSeriesCollection(series);

        // 创建图表对象
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Title", // 图表标题
            "X Axis Label", // X轴标签
            "Y Axis Label", // Y轴标签
            dataset, // 数据集
            PlotOrientation.VERTICAL, // 图表方向
            true, // 是否显示图例
            true, // 是否生成提示工具
            false // 是否生成URL链接
        );

        // 配置渐变色和折线颜色
        XYPlot plot = (XYPlot) chart.getPlot();
        // 配置折线颜色
        plot.getRenderer().setSeriesPaint(0, Color.RED);
        // 配置渐变色
        GradientPaint paint = new GradientPaint(
            0f, 0f, Color.BLUE,
            0f, (float) plot.getRangeAxis().getLowerBound(), new Color(0, 0, 64)
        );
        plot.setRenderer(new XYLineAndShapeRenderer(true, false));
        plot.getRenderer().setSeriesPaint(1, paint);
        // 配置折线填充
        plot.getRenderer().setSeriesFillPaint(1, paint,true);
        plot.getRenderer().setSeriesFillPaint(1, paint); // 这一行是填充区域需要的代码

        plot.getRenderer().setSeriesPaint(0, Color.RED);
        plot.getRenderer().setSeriesFillPaint(1, paint);
//        plot.getRenderer().setSeriesShapesVisible(1, false);
        plot.getRenderer().setSeriesShape(1,new Ellipse2D.Double(-3, -3, 10, 10),true);
        plot.getRenderer().setSeriesShape(2,new Ellipse2D.Double(-3, -3, 10, 10),true);
        plot.getRenderer().setSeriesOutlinePaint(1,Color.yellow,true);
//        plot.getRenderer().setseries;

        plot.setBackgroundPaint(Color.WHITE);

        // 配置X轴
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit(1.0));
        xAxis.setRange(0.5, 5.5);
        xAxis.setAutoRangeIncludesZero(false);

// 配置Y轴
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setRange(0, 150);

        // 显示图表
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Chart Title");
        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }}