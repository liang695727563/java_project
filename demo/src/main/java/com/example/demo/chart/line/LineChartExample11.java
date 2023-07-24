package com.example.demo.chart.line;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LineChartExample11 {

    public static void main(String[] args) throws IOException {
        //创建数据集
        XYSeries series = new XYSeries("Series 1");
        series.add(0, 100);
        series.add(1, 150);
        series.add(2, 200);
        series.add(3, 250);
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        //创建坐标轴
        NumberAxis xAxis = new NumberAxis("X");
        NumberAxis yAxis = new NumberAxis("Y");

        //创建折线图表对象
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        renderer.setSeriesStroke(0, new BasicStroke(2f));
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesFillPaint(0, new Color(128, 128, 255, 100));
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        // 获取图表区域对象
//        XYPlot plot = (XYPlot) chart.getPlot();
        // 取消 X 轴和 Y 轴的显示
        ValueAxis domainAxis = plot.getDomainAxis();
        domainAxis.setVisible(false);
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setVisible(false);



        // 创建渐变颜色
//        Color orange1 = new Color(255, 200, 0);
//        Color orange2 = new Color(255, 244, 183);
        Color orange1 = new Color(255,160 ,122	);
        Color orange2 = new Color(255, 255, 255);
        Color[] colors = {orange1, orange2};
        float[] fractions = {0.0f, 1.0f};
        XYAreaRenderer areaRenderer = new XYAreaRenderer();
//        areaRenderer.setOutline(true);
        areaRenderer.setSeriesPaint(0,Color.red);

//        areaRenderer.setSeriesPaint(0, new GradientPaint(0.0f, 0.0f, orange1, 0.0f, 0.0f, orange2));
        areaRenderer.setSeriesFillPaint(0, new GradientPaint(0.0f, 0.0f, orange1, 0.0f, 0.0f, orange2));
        areaRenderer.setUseFillPaint(true);
        plot.setRenderer(areaRenderer);


        plot.setBackgroundPaint(null); // 去除背景
        plot.setOutlinePaint(null); // 去除边框
        plot.setDomainGridlinesVisible(false); // 去除横坐标网格线
        plot.setRangeGridlinesVisible(false); // 去除纵坐标网格线
        plot.setRangeZeroBaselineVisible(false); // 显示 X 轴和 Y 轴交叉点
        plot.setDomainCrosshairVisible(false); // 隐藏横坐标十字线
        plot.setRangeCrosshairVisible(false); // 隐藏纵坐标十字线
        //设置图表背景颜色(透明)
        plot.setBackgroundPaint(null);
        plot.setForegroundAlpha(1f);//前影透明
        plot.setBackgroundAlpha(0.5f);//前影透明


        //设置标注
        XYTextAnnotation annotation = new XYTextAnnotation("Threshold", 2.5, 175);
        annotation.setFont(annotation.getFont().deriveFont(14f));
        annotation.setPaint(Color.RED);
        plot.addAnnotation(annotation);

        //创建折线图表
        JFreeChart chart = new JFreeChart(plot);
        chart.setTitle("");
        chart.removeLegend();

        //保存图表为PNG格式图片
        File chartFile = new File("D://jfreechart//line_chart11.png");
        ChartUtilities.saveChartAsPNG(chartFile, chart, 500, 300);
        System.out.println("图片已保存到 " + chartFile.getAbsolutePath());
    }
}