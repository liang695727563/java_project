//package com.example.jfreechart.run;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.annotations.XYDrawableAnnotation;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYSplineAndShapeRenderer;
//import org.jfree.data.xy.DefaultXYDataset;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.geom.Ellipse2D;
//
//public class LineChartExample3 {
//   public static void main(String[] args) {
//      SwingUtilities.invokeLater(() -> {
//         JFrame frame = new JFrame("Line Chart Example");
//         frame.setSize(600, 400);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//         // 创建数据集合
//         DefaultXYDataset dataset = new DefaultXYDataset();
//         double[][] data = { { 1, 2, 3, 4, 5 }, { 10, 20, 30, 40, 50 } };
//         dataset.addSeries("series1", data);
//
//         // 创建图表
//         JFreeChart chart = ChartFactory.createXYLineChart("Line Chart",
//                 "X Axis", "Y Axis", dataset, PlotOrientation.VERTICAL, true, true, false);
//         XYPlot plot = (XYPlot) chart.getPlot();
//         plot.setDomainPannable(true);
//         plot.setRangePannable(true);
//
//         // 创建折线渲染器
//         XYSplineAndShapeRenderer renderer = new XYSplineAndShapeRenderer(true, false);
//         renderer.setSeriesPaint(0, Color.BLUE);
//
//         // 将渲染器应用到图表中
//         plot.setRenderer(renderer);
//
//         // 填充区域颜色
//         Color fillColor = new Color(200, 200, 255, 100);
//         XYDrawableAnnotation annotation = new XYDrawableAnnotation((float) 1.5, 0,
//             new Ellipse2D.Double(-4, -4, 8, 8));
//         annotation.setDrawBorder(true);
//         annotation.setOutlinePaint(fillColor);
//         annotation.setFillPaint(fillColor);
//         annotation.setToolTipText("填充区域");
//         plot.addAnnotation(annotation);
//
//         // 创建图表面板
//         ChartPanel panel = new ChartPanel(chart);
//         frame.getContentPane().add(panel);
//         frame.setVisible(true);
//      });
//   }
//}