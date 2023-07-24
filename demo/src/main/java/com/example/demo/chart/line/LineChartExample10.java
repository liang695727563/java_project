package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LineChartExample10 {

    public static void main(String[] args) throws IOException {
        //创建数据集
        XYSeries series = new XYSeries("Series 1");
        series.add(0, 100);
        series.add(1, 130);
        series.add(2, 240);
        series.add(3, 250);
        XYDataset dataset = new XYSeriesCollection(series);
        
        //创建折线图表对象
        JFreeChart chart = ChartFactory.createXYLineChart(
                null, //图表标题
                null, //横轴标签
                null, //纵轴标签
                dataset, //数据集
                PlotOrientation.VERTICAL, //图表方向
                false, //显示图例
                false, //使用工具提示
                false //使用url链接
                );
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
   /*     // 获取Y轴
        ValueAxis yAxis = chart.getXYPlot().getRangeAxis();

// 设置Y轴的范围
        yAxis.setRange(0, 15);*/
        //设置折线颜色
        XYItemRenderer renderer = chart.getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesStroke(0,new BasicStroke(10));
        renderer.setSeriesOutlinePaint(0,Color.blue);
        renderer.setSeriesOutlineStroke(0,new BasicStroke(100));
        
        //在指定数值范围内对折线下方区域进行着色
        XYLineAndShapeRenderer lineRenderer = (XYLineAndShapeRenderer) chart.getXYPlot().getRenderer();
        lineRenderer.setSeriesFillPaint(0, new Color(128, 128, 255, 50));
        lineRenderer.setSeriesShapesVisible(0, false);
        lineRenderer.setSeriesShapesVisible(1, false);
        lineRenderer.setSeriesShapesFilled(0, true);

        // 获取渲染器
//        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

// 将折线设置为不可见
        lineRenderer.setSeriesShapesVisible(0,false);
        lineRenderer.setSeriesLinesVisible(0,true);

// 将形状填充
        lineRenderer.setSeriesShapesFilled(0,true);

// 将折线设置为平滑曲线
//        lineRenderer.setSeriesSmooth(0,true);

// 设置图表的渲染器
        chart.getXYPlot().setRenderer(renderer);
        //保存图表为PNG格式图片
        File chartFile = new File("D://jfreechart//line_chart10.png");
        ChartUtilities.saveChartAsPNG(chartFile, chart, 500, 300);
        System.out.println("图片已保存到 " + chartFile.getAbsolutePath());

    }
}