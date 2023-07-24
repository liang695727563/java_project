package com.example.jfreechart.run;

import org.math.plot.Plot2DPanel;

import javax.swing.*;

public class LineChartExample {
    public static void main(String[] args) {
        // 创建绘图面板
        Plot2DPanel plot = new Plot2DPanel();
        
        // 添加数据
        double[] x = { 1, 2, 3, 4, 5 };
        double[] y = { 10, 20, 30, 40, 50 };
        plot.addLinePlot("series1", x, y);
        
        // 填充区域颜色
        plot.getRenderer(0).getSeriesLines()[0].setColor(java.awt.Color.BLUE);
//        plot.getRenderer(0).getSeriesPath().getPolygon().xpoints[0] = 10000;
//        plot.getRenderer(0).getSeriesPath().getPolygon().addPoint((int) x[0], (int) y[0]);
//        plot.getRenderer(0).getSeriesPath().getPolygon().addPoint((int) x[x.length - 1], (int) y[y.length - 1]);
//        plot.getRenderer(0).getSeriesPath().getPolygon().addPoint((int) x[x.length - 1], 0);
        
        // 创建窗口并显示
        JFrame frame = new JFrame("Line Chart Example");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}