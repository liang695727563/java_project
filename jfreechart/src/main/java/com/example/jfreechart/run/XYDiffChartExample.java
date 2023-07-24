//package com.example.jfreechart.run;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.io.File;
//import java.io.IOException;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
//import org.jfree.chart.axis.NumberAxis;
////import org.jfree.chart.ChartUtilities;
//
//public class XYDiffChartExample {
//
//    public static void main(String[] args) throws IOException {
//        // 创建数据集合
//        XYDataset dataset = createDataset();
//
//        // 创建折线图
//        JFreeChart chart = ChartFactory.createXYLineChart("XY Difference Chart",
//                "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
//
//        // 配置渲染器
//        XYPlot plot = (XYPlot) chart.getPlot();
//        plot.setBackgroundPaint(Color.white);
//        plot.setRangeGridlinePaint(Color.gray);
//
//        XYDifferenceRenderer renderer = new XYDifferenceRenderer(Color.blue, Color.red, false);
////        renderer.setGapThreshold(1.0);
//        plot.setRenderer(renderer);
//
//        // 配置轴
//        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
//        domainAxis.setTickLabelFont(domainAxis.getTickLabelFont().deriveFont(16f));
//
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setTickLabelFont(rangeAxis.getTickLabelFont().deriveFont(16f));
//
//        // 保存图表为图片
//        File outputFile = new File("xy_diff_chart.png");
//
//        File chartFile = new File("D://jfreechart//xy_diff_chart.png");
//
//        org.jfree.chart.ChartUtils.saveChartAsPNG(chartFile, chart,800,500);
//
////        ChartUtilities.saveChartAsPNG(outputFile, chart,800, 600);
//        System.out.println("图片已保存到 " + chartFile.getAbsolutePath());
//    }
//
//    // 创建数据集合
//    private static XYDataset createDataset() {
//        double[] xValues = new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 };
//        double[] yActualValues = new double[] { 10.0, 20.0, 30.0, 40.0, 50.0 };
//        double[] yTargetValues = new double[] { 15.0, 25.0, 35.0, 45.0, 55.0 };
//
//        double[] yDiffValues = new double[xValues.length];
//        for (int i = 0; i < xValues.length; i++) {
//            yDiffValues[i] = yActualValues[i] - yTargetValues[i];
//        }
//
//        XYDataset dataset = org.jfree.data.xy.DatasetUtilities
//                .combine(new org.jfree.data.xy.XYSeriesCollection(new org.jfree.data.xy.XYSeries("Actual", createSeries(xValues, yActualValues))),
//                         new org.jfree.data.xy.XYSeriesCollection(new org.jfree.data.xy.XYSeries("Target", createSeries(xValues, yTargetValues))),
//                         new org.jfree.data.xy.XYSeriesCollection(new org.jfree.data.xy.XYSeries("Difference", createSeries(xValues, yDiffValues))));
//
//        return dataset;
//    }
//
//    private static org.jfree.data.xy.XYSeries createSeries(double[] xValues, double[] yValues) {
//        org.jfree.data.xy.XYSeries series = new org.jfree.data.xy.XYSeries("");
//        for (int i = 0; i < xValues.length; i++) {
//            series.add(xValues[i], yValues[i]);
//        }
//        return series;
//    }
//}