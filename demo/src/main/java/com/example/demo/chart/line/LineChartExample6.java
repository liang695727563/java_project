package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LineChartExample6 {
    public static void main(String[] args) {
        // 创建数据集
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
        plot.setInsets(new RectangleInsets(0, 0, 0, 0));
        StackedXYAreaRenderer renderer = new StackedXYAreaRenderer() {
            @Override
            public boolean getPlotArea() {
                return true;
            }

            @Override
            public Paint getItemPaint(int series, int item) {
                return Color.BLUE;
            }
        };
        plot.setRenderer(renderer);

        // 设置y轴范围
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 5);

        // 显示图表
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Line Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().add(chartPanel);
        frame.setVisible(true);

        // 保存图表为图片
        File file= null;
        try {
            file = new File("D://jfreechart//line-chart6.png");
            ChartUtilities.saveChartAsPNG(file, chart, 500, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}