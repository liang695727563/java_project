package com.example.demo.chart.area;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

public class StackedXYAreaRendererExample3 {
    public static void main(String[] args) throws IOException {
        // 创建一个 XY 数据集
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        XYSeries serie1 = new XYSeries("Series 1", false,false);
        serie1.add(0.0, 1.0);
        serie1.add(1.0, 3.0);
        serie1.add(2.0, 4.0);
        serie1.add(3.0, 2.0);
        serie1.add(4.0, 5.0);

//        serie1.add(0.0, 5.0);
//        serie1.add(1.0, 5.0);
//        serie1.add(2.0, 5.0);
//        serie1.add(3.0, 5.0);
//        serie1.add(4.0, 5.0);
        dataset.addSeries(serie1);

//        XYSeries serie2 = new XYSeries("Series 2", false,false);
//        serie2.add(0.0, 3.0);
//        serie2.add(1.0, 2.0);
//        serie2.add(2.0, 1.0);
//        serie2.add(3.0, 5.0);
//        serie2.add(4.0, 2.0);
//        dataset.addSeries(serie2);

        // 创建一个 JFreeChart 折线图对象
//        JFreeChart chart = ChartFactory.createXYLineChart(
//                "Stacked XY Area Renderer Example",
//                null,
//                null,
//                dataset,
//                PlotOrientation.VERTICAL,
//                true,
//                true,
//                false);

        JFreeChart chart = ChartFactory.createXYLineChart(
                null,
                null,
                null,
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        // 获取图表区域对象
        XYPlot plot = (XYPlot) chart.getPlot();
        // 取消 X 轴和 Y 轴的显示
        ValueAxis domainAxis = plot.getDomainAxis();
        domainAxis.setVisible(false);
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setVisible(false);

        plot.setBackgroundPaint(null); // 去除背景
        plot.setOutlinePaint(null); // 去除边框
        plot.setForegroundAlpha(1f);//前影透明

        // 创建渐变色
//        Color color1 = new Color(255,214,192);
        Color color1 = new Color(255,160 ,122	);
        Color color2 = new Color(255, 255, 255);
        GradientPaint gradient = new GradientPaint(0, 0, color1, 500, 360, color2);

        // 使用 StackedXYAreaRenderer 展示数据
        StackedXYAreaRenderer renderer = new StackedXYAreaRenderer(XYAreaRenderer.AREA_AND_SHAPES);
//        renderer.setSeriesPaint(0, Color.RED);
        // 设置第一个数据系列的绘制颜色和渐变色
//        renderer.setSeriesPaint(0, Color.BLUE); // 绘制颜色

        renderer.setOutline(true);
//        renderer.setSeriesPaint(0, new Color(255,214,192));//图形前景
        renderer.setSeriesPaint(0, gradient); // 渐变色

        renderer.setSeriesOutlinePaint(0,new Color(252,69,0));
        renderer.setSeriesOutlineStroke(0, new BasicStroke(10));

//        plot.setOutlinePaint(Color.TRANSPARENT); // 设置外边框线条颜色为透明
//        plot.setDomainGridlinePaint(Color.BLACK); // 设置内部竖线条颜色
//        plot.setRangeGridlinePaint(Color.BLACK); // 设置内部横线条颜色

        plot.setRenderer(renderer);







        // 将折线图保存为图片
        int width = 500;    /* 图片宽度 */
        int height = 360;   /* 图片高度 */
        File file = new File("D://jfreechart//StackedXYAreaRenderer3.png");  /* 图片文件路径 */
        ChartUtilities.saveChartAsPNG(file, chart, width, height);  /* 保存图片 */

        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}