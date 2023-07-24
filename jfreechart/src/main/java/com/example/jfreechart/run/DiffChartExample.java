package com.example.jfreechart.run;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

public class DiffChartExample {

    public static void main(String[] args) throws IOException {
        // 创建数据集合
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Actual", "Product 1");
        dataset.addValue(20, "Actual", "Product 2");
        dataset.addValue(30, "Actual", "Product 3");
        dataset.addValue(40, "Actual", "Product 4");
        dataset.addValue(50, "Actual", "Product 5");

        dataset.addValue(15, "Target", "Product 1");
        dataset.addValue(25, "Target", "Product 2");
        dataset.addValue(35, "Target", "Product 3");
        dataset.addValue(45, "Target", "Product 4");
        dataset.addValue(55, "Target", "Product 5");

        // 求出 Actual 和 Target 之间的差异
        DefaultCategoryDataset diffDataset = new DefaultCategoryDataset();
        for (int i = 0; i < dataset.getColumnCount(); i++) {
            String category = (String) dataset.getColumnKey(i);
            Number actualValue = dataset.getValue("Actual", category);
            Number targetValue = dataset.getValue("Target", category);
            double diffValue = actualValue.doubleValue() - targetValue.doubleValue();
            diffDataset.addValue(diffValue, "Diff", category);
        }

        // 创建 JFreeChart
        JFreeChart chart = ChartFactory.createLineChart("Sales Comparison Chart",
                "Product", "Sales", diffDataset, PlotOrientation.VERTICAL, true, true, false);

        // 配置渲染器
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.gray);

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.blue);
//        renderer.setBaseShapesVisible(true);
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer.setBaseItemLabelsVisible(true);
        plot.setRenderer(renderer);

        // 配置轴
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(domainAxis.getTickLabelFont().deriveFont(16f));
        domainAxis.setCategoryMargin(0.4);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickLabelFont(rangeAxis.getTickLabelFont().deriveFont(16f));

        // 将两个折线之间的差异作为面积图形式显示
        CategoryItemRenderer diffRenderer = new LineAndShapeRenderer();
//        diffRenderer.setPaint(Color.lightGray);
        diffRenderer.setSeriesShape(0, null);
        diffRenderer.setSeriesStroke(0, null);
        diffRenderer.setSeriesPaint(0, new Color(0, 0, 0, 0));
        diffRenderer.setSeriesShape(1,new Ellipse2D.Double(-3, -3, 10, 10),true);
//        diffRenderer.setSeriesShapesVisible(1, false);

//        diffRenderer.setSeriesLinesVisible(1, false);
        diffRenderer.setSeriesPaint(1, new Color(0, 0, 0, 0));
//        diffRenderer.setSeriesShapesVisible(2, false);
//        diffRenderer.setSeriesLinesVisible(2, false);
        diffRenderer.setSeriesPaint(2, new Color(0, 0, 0, 0));
//        diffRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator) null);
        plot.setDataset(1, diffDataset);
        plot.setRenderer(1, diffRenderer);

        // 配置绘图区域
        plot.setInsets(new RectangleInsets(5.0, 0, 0, 5.0));
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        // 保存图表为图片
        File outputFile = new File("diff_chart.png");
        File chartFile = new File("D://jfreechart//diff_chart.png");

        org.jfree.chart.ChartUtils.saveChartAsPNG(chartFile, chart,800,500);

//        ChartUtilities.saveChartAsPNG(outputFile, chart,800, 600);
        System.out.println("图片已保存到 " + chartFile.getAbsolutePath());

    } }