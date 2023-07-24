package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;

public class LineChartExample8 {
   public static void main(String[] args) {
      // 创建数据集
              XYSeriesCollection dataset = new XYSeriesCollection();

      XYSeries series = new XYSeries("数据");
      series.add(1, 10);
      series.add(2, 20);
      series.add(3, 30);
      series.add(4, 40);
      series.add(5, 50);
      dataset.addSeries(series);
//      XYDataset dataset = new XYSeriesCollection(series);
      XYSeries series2 = new XYSeries("数据1");
      series2.add(1, 20);
      series2.add(2, 30);
      series2.add(3, 40);
      series2.add(4, 50);
      series2.add(5, 60);
      dataset.addSeries(series2);

      // 创建图表
      JFreeChart chart = ChartFactory.createXYLineChart(
         "折线差图",        // 图表标题
         "X轴",             // X轴标签
         "Y轴",             // Y轴标签
         dataset            // 数据集
      );
     
      // 设置颜色区域
      XYPlot plot = (XYPlot) chart.getPlot();
      plot.setBackgroundPaint(Color.white);
      plot.setDomainGridlinePaint(Color.lightGray);
      plot.setRangeGridlinePaint(Color.lightGray);
      plot.setDomainCrosshairVisible(true);
      plot.setRangeCrosshairVisible(true);
      plot.getRenderer().setSeriesPaint(0, Color.blue);
      plot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
      plot.getRenderer().setSeriesPaint(1, Color.red);
      plot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
      plot.getRenderer().setSeriesPaint(2, Color.green);
      plot.getRenderer().setSeriesStroke(2, new BasicStroke(2.0f));

      // 保存为PNG文件
      File file = new File("D://jfreechart//LineChart8.png");

      try {
         ChartUtilities.saveChartAsPNG(file, chart, 600, 400);
      } catch (Exception e) {
         System.err.println("发生异常: " + e.getMessage());
      }

      System.out.println("图片已保存到 " + file.getAbsolutePath());

   }
}
