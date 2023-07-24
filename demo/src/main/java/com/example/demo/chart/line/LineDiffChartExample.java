//package com.example.demo.chart.line;
//
//import java.awt.Color;
//import java.awt.BasicStroke;
//import java.io.File;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.ui.RectangleInsets;
//import org.jfree.chart.ChartUtilities;
//
//public class LineDiffChartExample {
//    public static void main(String[] args) throws Exception {
//        // 创建数据集合
//        XYSeriesCollection dataset = new XYSeriesCollection();
//
//        // 添加第一个数据系列
//        XYSeries series1 = new XYSeries("Series 1");
//        series1.add(1.0, 4.5);
//        series1.add(2.0, 3.2);
//        series1.add(3.0, 6.0);
//        series1.add(4.0, 8.0);
//        series1.add(5.0, 4.5);
//
//        // 添加第二个数据系列
//        XYSeries series2 = new XYSeries("Series 2");
//        series2.add(1.0, 2.0);
//        series2.add(2.0, 1.0);
//        series2.add(3.0, 3.5);
//        series2.add(4.0, 5.0);
//        series2.add(5.0, 2.5);
//
//        dataset.addSeries(series1);
//        dataset.addSeries(series2);
//
//        // 创建图表对象
//        JFreeChart chart = ChartFactory.createXYLineChart(
//            "Line Diff Chart Example", // 图表标题
//            "X Axis", // X 轴标题
//            "Y Axis", // Y 轴标题
//            dataset, // 数据集合
//            PlotOrientation.VERTICAL, // 图表方向
//            true, // 是否显示图例
//            true, // 是否使用工具提示
//            false // 是否使用 URLs
//        );
//
//        // 自定义图表样式
//        chart.setBackgroundPaint(Color.white);
//
//        XYPlot plot = (XYPlot)chart.getPlot();
//        plot.setBackgroundPaint(Color.lightGray);
//        plot.setDomainGridlinePaint(Color.white);
//        plot.setRangeGridlinePaint(Color.white);
//        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
//        plot.setDomainCrosshairVisible(true);
//        plot.setRangeCrosshairVisible(true);
//
//        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
//        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
//
//        // 显示不同的颜色区域
//        int seriesCount = dataset.getSeriesCount();
//        for (int i = 0; i < seriesCount - 1; i++) {
//            double x1 = dataset.getXValue(i, 0);
//            double x2 = dataset.getXValue(i, dataset.getItemCount(i) - 1);
//            double y1 = dataset.getYValue(i, 0);
//            double y2 = dataset.getYValue(i, dataset.getItemCount(i) - 1);
//            Color color = i % 2 == 0 ? new Color(255, 0, 0, 50) : new Color(0, 255, 0, 50);
//            plot.addRangeMarker(new org.jfree.chart.plot.ValueMarker(x1, color, new BasicStroke(0), color, null, 0.5f));
//            plot.addRangeMarker(new org.jfree.chart.plot.ValueMarker(x2, color, new BasicStroke(0), color, null, 0.5f));
//            plot.addDomainMarker(new org.jfree.chart.plot.Marker() {
//                @Override
//                public void draw(java.awt.Graphics2D g2, XYPlot plot, java.awt.geom.Rectangle2D dataArea, org.jfree.chart.axis.ValueAxis domainAxis, org.jfree.chart.axis.ValueAxis rangeAxis, int rendererIndex, org.jfree.chart.plot.PlotRenderingInfo info) {}
//
//                @Override
//                public boolean contains(java.awt.geom.Point2D point, XYPlot plot, java.awt.geom.Rectangle2D dataArea, org.jfree.chart.axis.ValueAxis domainAxis, org.jfree.chart.axis.ValueAxis rangeAxis) {
//                    double x = domainAxis.java2DToValue(point.getX());
//                     return x >= x1 && x <= x2; } }, i % 2 == 0 ? new Color(255, 0, 0, 50) : new Color(0, 255, 0, 50), new BasicStroke(0), null, null, 0.5f); }
//                    plot.setRenderer(renderer);
//
//                    // 保存图表为 PNG 图片
//                    int width = 640;    // 图片宽度
//                    int height = 480;   // 图片高度
//                    File file = new File("line_diff_chart.png");
//                    ChartUtilities.saveChartAsPNG(file, chart, width, height);
//                }