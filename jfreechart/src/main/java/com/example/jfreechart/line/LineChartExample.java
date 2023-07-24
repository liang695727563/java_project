package com.example.jfreechart.line;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChartExample {

    public static void main(String[] args) throws IOException {
        // 创建一个数据集合
        XYSeries series = new XYSeries("Data Series");
        series.add(1, 5);
        series.add(2, 10);
        series.add(3, 8);
        series.add(4, 12);

        // 将数据集合添加到XY数据集合中
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // 创建一个基于XY数据集合的图表
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Title",
            "X Axis Label",
            "Y Axis Label",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        // 获取渲染器
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // 将折线设置为不可见
        renderer.setSeriesShapesVisible(0,false);
        renderer.setSeriesLinesVisible(0,true);

        // 将形状填充
        renderer.setSeriesShapesFilled(0,true);

        // 将折线设置为平滑曲线

        renderer.setSeriesSmooth(0,true);

        // 设置图表的渲染器
        chart.getXYPlot().setRenderer(renderer);

        // 保存图表为文件
        File outputFile = new File("D://jfreechart//chart.png");
        ChartUtils.saveChartAsPNG(outputFile, chart, 800, 600);

        System.out.println("图片已保存到 " + outputFile.getAbsolutePath());
    }
}