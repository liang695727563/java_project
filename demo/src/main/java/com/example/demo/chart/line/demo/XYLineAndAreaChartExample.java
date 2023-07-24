package com.example.demo.chart.line.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class XYLineAndAreaChartExample {

    public static void main(String[] args) throws IOException {
        // create dataset
        XYSeries series1 = new XYSeries("Series 1");
        series1.add(1, 2);
        series1.add(2, 3);
        series1.add(3, 4);
        series1.add(4, 5);

        XYSeries series2 = new XYSeries("Series 2");
        series2.add(1, 4);
        series2.add(2, 2);
        series2.add(3, 3);
        series2.add(4, 1);

        XYDataset dataset = new XYSeriesCollection();
        ((XYSeriesCollection) dataset).addSeries(series1);
        ((XYSeriesCollection) dataset).addSeries(series2);

        // create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "XY Line and Area Chart Example",
                "X Axis",
                "Y Axis",
                dataset,
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        // set renderer for lines and shapes
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRenderer(new XYLineAndShapeRenderer());

        // set colors and gradient paint for area between two lines
        int numColors = 50; // number of gradient colors to use
        XYAreaRenderer renderer = new XYAreaRenderer() {
            @Override
            public Paint getItemPaint(int row, int col) {
                int index = col * numColors / getPlot().getDataset().getItemCount(row);
                Color startColor = new Color(255, 200, 200); // color for series 1
                Color endColor = new Color(200, 200, 255); // color for series 2
                float fraction = (float) index / (numColors - 1);
                return new GradientPaint(0, 0, startColor, 0, (float) getPlot().getDomainAxis().getUpperBound(), endColor, false);
            }
        };
        plot.setRenderer(1, renderer);

        // save chart as PNG image
        File file = new File("D://jfreechart//XYLineAndAreaChart.png");

        ChartUtilities.saveChartAsPNG(file, chart, 500, 400);
        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}