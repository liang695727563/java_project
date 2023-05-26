//package com.example.demo.chart;
//
//import java.awt.Color;
//import java.io.File;
//import java.io.IOException;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxisLabelPosition;
//import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//public class LineChartExample1 {
//
//    public static void main(String[] args) throws IOException {
//        // 创建数据集
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(15, "Sales", "Jan");
//        dataset.addValue(30, "Sales", "Feb");
//        dataset.addValue(25, "Sales", "Mar");
//        dataset.addValue(40, "Sales", "Apr");
//        dataset.addValue(50, "Sales", "May");
//
//        // 创建折线图
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Sales Report", // 图表标题
//                "Month", // 横轴标签
//                "Sales", // 纵轴标签
//                dataset, // 数据集
//                PlotOrientation.VERTICAL, // 图表方向
//                true, // 是否显示图例
//                true, // 是否生成工具（提示）
//                false // 是否生成 URL 链接
//        );
//
//        // 设置背景色
//        chart.setBackgroundPaint(Color.WHITE);
//
//        // 获取绘图区域对象
//        CategoryPlot plot = chart.getCategoryPlot();
//
//        // 设置网格线
//        plot.setDomainGridlinesVisible(true); // 显示横向网格线
//        plot.setRangeGridlinesVisible(true); // 显示纵向网格线
//        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // 纵向网格线颜色
//        plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // 横向网格线颜色
//
//        // 获取坐标轴对象
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        CategoryAxisLabelPosition position = new CategoryAxisLabelPosition(
//                CategoryLabelPositions.UP_45);
//        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
//
//        // 设置折线图数据点样式
//        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setSeriesPaint(0, Color.BLUE); // 设置线条颜色
//        renderer.setDrawOutlines(true);
//        renderer.setUseFillPaint(true);
//        renderer.setBaseFillPaint(Color.WHITE);
//        renderer.setSeriesOutlinePaint(0, Color.BLACK);
//        renderer.setSeriesStroke(0, new java.awt.BasicStroke(2.0f)); // 设置线宽度
//
//        // 保存为图片
//        int width = 800; /* 图片宽度 */
//        int height = 600; /* 图片高度 */
//        File lineChart = new File("lineChart.png");
//        ChartUtilities.saveChartAsPNG(lineChart, chart, width, height);
//    }
//}