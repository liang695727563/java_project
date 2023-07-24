package com.example.demo.chart.line.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class XYAreaRendererExample {
    
    public static void main(String[] args) {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        saveChartAsJPEG(chart, "chart.jpeg", 800, 600); // 保存为JPEG图片
    }
    
    private static XYDataset createDataset() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = new double[][] {{1, 2, 3}, {4, 5, 6}};
        dataset.addSeries("series", data);
        return dataset;
    }
    
    private static JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Title", "X Label", "Y Label", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        XYAreaRenderer areaRenderer = new XYAreaRenderer();
        XYLineAndShapeRenderer lineRenderer = new XYLineAndShapeRenderer();
        
        // 设置区域颜色
        plot.setRenderer(areaRenderer);
        
        // 设置折线颜色和样式
        lineRenderer.setSeriesPaint(0, Color.BLUE);
        lineRenderer.setSeriesShapesVisible(0, false);
        
        plot.setRenderer(1, lineRenderer);
        return chart;
    }
    
    private static void saveChartAsJPEG(JFreeChart chart, String filename, int width, int height) {
        File file = new File("D://jfreechart//"+filename);
        try {
            ChartUtilities.saveChartAsJPEG(file, chart, width, height);
        } catch (IOException e) {
            System.err.println("Error saving chart as JPEG: " + e.getMessage());
        }
        System.out.println("图片保存成功："+file.getAbsolutePath());
    }

}