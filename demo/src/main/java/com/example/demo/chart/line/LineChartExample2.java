package com.example.demo.chart.line;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

/**
 * 你可以根据需要修改代码中的数据集、图表标题、X轴标签、Y轴标签等信息，并将保存路径改为你想要保存的位置。
 */
public class LineChartExample2 {
    public static void main(String[] args) throws IOException {
        // 创建数据集
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = {{1,2,3,4,5}, {1,2,3,4,5}};
        dataset.addSeries("series1", data);

        // 创建折线图
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Line Chart Demo", // 图表标题
            "X", // X轴标签
            "Y", // Y轴标签
            dataset, // 数据集
            PlotOrientation.VERTICAL, // 图表方向
            true, // 是否显示图例
            true, // 是否显示提示
            false // 是否生成URL链接
        );

        // 设置背景色
        chart.setBackgroundPaint(Color.white);

        // 获取绘图区域对象
        XYPlot plot = (XYPlot) chart.getPlot();

        // 设置绘图区域背景色
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // 设置X轴和Y轴
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        xAxis.setLabel("X");
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        yAxis.setLabel("Y");

        // 设置折线和标记的颜色
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesShapesVisible(0, true);
        plot.setRenderer(renderer);

        // 保存图表为PNG图片
        ChartUtilities.saveChartAsPNG(new File("D://jfreechart//linechart.png"), chart, 400, 300);
    }
}