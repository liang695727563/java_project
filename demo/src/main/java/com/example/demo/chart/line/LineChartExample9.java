package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LineChartExample9 {

    public static void main(String[] args) throws IOException {
        //创建数据集
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "Series 1", "2010");
        dataset.addValue(150, "Series 1", "2011");
        dataset.addValue(200, "Series 1", "2012");
        dataset.addValue(250, "Series 1", "2013");

//        dataset.addValue(0, "Series 2", "2010");
//        dataset.addValue(0, "Series 2", "2011");
//        dataset.addValue(0, "Series 2", "2012");
//        dataset.addValue(120, "Series 2", "2013");
        
        //创建折线图表对象
        JFreeChart chart = ChartFactory.createLineChart(
                "Line Chart Example", //图表标题
                "Year", //横轴标签
                "Value", //纵轴标签
                dataset, //数据集
                PlotOrientation.VERTICAL, //图表方向
                true, //显示图例
                true, //使用工具提示
                false //使用url链接
                );
        
        //设置折线颜色
        CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        
        //在指定数值范围内对折线下方区域进行着色
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) chart.getCategoryPlot().getRenderer();
        lineRenderer.setSeriesFillPaint(1, new Color(128, 128, 255, 100));
        lineRenderer.setSeriesShapesVisible(0, false);
        lineRenderer.setSeriesShapesVisible(1, false);
        lineRenderer.setSeriesShapesFilled(1, true);
        //保存图表为PNG格式图片
        File chartFile = new File("D://jfreechart//line_chart9.png");
        ChartUtilities.saveChartAsPNG(chartFile, chart, 500, 300);
        System.out.println("图片已保存到 " + chartFile.getAbsolutePath());

    }
}