package com.example.demo.chart.area;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

public class StackedXYAreaRendererExample2 {
    public static void main(String[] args) throws IOException {
        // 创建一个 XY 数据集
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        XYSeries serie1 = new XYSeries("Series 1", false,false);
        serie1.add(0.0, 1.0);
        serie1.add(1.0, 3.0);
        serie1.add(2.0, 4.0);
        serie1.add(3.0, 2.0);
        serie1.add(4.0, 5.0);
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
//                "X",
//                "Y",
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
        ValueAxis domainAxis = plot.getDomainAxis();

        domainAxis.setLowerMargin(0.0);//Ｘ轴相对左边距离

        domainAxis.setUpperMargin(0.0);//Ｘ轴相对右边距离

        plot.getRangeAxis().setLowerMargin(0.0);//Ｙ轴距离底边距离

        plot.setBackgroundPaint(null); // 去除背景
        plot.setOutlinePaint(null); // 去除边框
        plot.setDomainCrosshairVisible(false); // 隐藏横坐标十字线
        plot.setRangeCrosshairVisible(false); // 隐藏纵坐标十字线

        // 设置 Y 轴的范围为 0 到 10
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 10);
        // 使用 StackedXYAreaRenderer 展示数据
        StackedXYAreaRenderer renderer = new StackedXYAreaRenderer(XYAreaRenderer.AREA_AND_SHAPES);
        renderer.setOutline(true);
        renderer.setSeriesPaint(0, new Color(255,222,204));//图形前景
        renderer.setSeriesOutlinePaint(0, Color.black);
        plot.setRenderer(renderer);

        // 将折线图保存为图片
        int width = 640;    /* 图片宽度 */
        int height = 480;   /* 图片高度 */
        File file = new File("D://jfreechart//StackedXYAreaRenderer.png");  /* 图片文件路径 */
        ChartUtilities.saveChartAsPNG(file, chart, width, height);  /* 保存图片 */

        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}