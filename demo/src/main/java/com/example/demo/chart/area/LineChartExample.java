package com.example.demo.chart.area;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;

public class LineChartExample {
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
        StackedXYAreaRenderer renderer = new StackedXYAreaRenderer() {
            @Override
            public boolean getPlotArea() {
                return true;
            }
        };
        plot.setRenderer(renderer);

        // 显示图表
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Line Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().add(chartPanel);
        frame.setVisible(true);
    }
}