package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RectangleInsets;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LineChartExample5 {
    public static void main(String[] args) {
        // 创建数据集
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        double[][] data = {{1,2,3,4,5}, {1,3,2,4,3}};
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


        // 创建图表
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Line Chart Example",
                "X Axis Label",
                "Y Axis Label",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // 隐藏区域填充
        XYPlot plot = chart.getXYPlot();
        plot.setInsets(new RectangleInsets(100, 0, 0, 0));
        plot.setBackgroundPaint(null); // 去除背景
        plot.setOutlinePaint(null); // 去除边框
        plot.setForegroundAlpha(1f);//前影透明
        StackedXYAreaRenderer renderer = new StackedXYAreaRenderer() {
            @Override
            public boolean getPlotArea() {
                return true;
            }

            @Override
            public Paint getItemPaint(int series, int item) {
                return new Color(255,214,192);
            }
        };
        renderer.setOutline(true);
        renderer.setSeriesPaint(0, new Color(255,214,192));//图形前景

        plot.setRenderer(renderer);

        // 设置y轴范围
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 5);

        // 保存图表为图片
        File file= null;
        try {
            file = new File("D://jfreechart//line-chart5.png");
            ChartUtilities.saveChartAsPNG(file, chart, 500, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}