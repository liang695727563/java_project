package com.example.demo.chart.diffChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DiffChartExample2 {

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

        // 创建 JFreeChart
        JFreeChart chart = ChartFactory.createBarChart("Sales Comparison Chart",
                "Product", "Sales", dataset, PlotOrientation.VERTICAL, true, true, false);

        // 配置渲染器
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.gray);

        CategoryItemRenderer renderer1 = new BarRenderer();
        renderer1.setSeriesPaint(0, Color.blue);
        plot.setRenderer(0, renderer1);

        CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setSeriesPaint(0, Color.red);
        plot.setRenderer(1, renderer2);

        // 配置轴
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(domainAxis.getTickLabelFont().deriveFont(16f));
        domainAxis.setCategoryMargin(0.4);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickLabelFont(rangeAxis.getTickLabelFont().deriveFont(16f));

        // 保存图表为图片
        File outputFile = new File("diff_chart.png");
        ChartUtilities.saveChartAsPNG(outputFile, chart, 800, 600);
    }
}
/**
 * 这段代码将创建一个差异图，其中每个产品都有实际销售和目标销售。该图使用 DefaultCategoryDataset 存储数据，并使用 BarRenderer 和 LineAndShapeRenderer 渲染两个系列的数据。
 *
 * 最后，使用 ChartUtilities.saveChartAsPNG() 方法将图表保存为 PNG 图片文件。
 */