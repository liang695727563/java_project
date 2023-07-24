package com.example.jfreechart.JMathPlot;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.GradientToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

public class LineChartExample {
   public static void main(String[] args) throws IOException {
      // 创建绘图面板
      Plot2DPanel plot = new Plot2DPanel();

      // 添加数据
      double[] x = {1, 2, 3, 4, 5};
      double[] y = {10, 20, 30, 40, 50};
      plot.addLinePlot("line", x, y);

      // 设置填充区域颜色
      Color colorFrom = new Color(255, 255, 255, 128);
      Color colorTo = new Color(0, 0, 255, 128);
      GradientToolBar gradientToolBar = new GradientToolBar(plot, colorFrom, colorTo,
              GradientToolBar.HORIZONTAL_GRADIENT, 0.5, 0.5, true);

      // 创建窗口并显示
      JFrame frame = new JFrame("Line Chart Example");
      frame.setSize(600, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(plot);
      frame.setVisible(true);

      // 保存为 PNG 图片
      Point2D.Double p1 = new Point2D.Double(0, 1);
      Point2D.Double p2 = new Point2D.Double(1, 0);
      GradientPaint gradientPaint = new GradientPaint(p1, colorFrom, p2, colorTo);
      plot.getPlot().getRenderer().setSeriesFillPaint(0, gradientPaint);
      plot.saveAsPNG(new File("line_chart.png"));
   }
}