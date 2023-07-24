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

public class XYLineAndAreaChartExample2 {

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

        XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
        renderer1.setSeriesPaint(0, Color.RED); // set color for series 1
        renderer1.setSeriesPaint(1, Color.BLUE); // set color for series 2
        renderer1.setSeriesShapesVisible(0, true);
        renderer1.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer1);

        plot.setRenderer(new XYAreaRenderer());

        // set colors for area between two lines
        XYAreaRenderer renderer = (XYAreaRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 200, 200)); // set color for area between series 1 and X axis
        renderer.setSeriesPaint(1, new Color(200, 200, 255)); // set color for area between series 2 and X axis


        // save chart as PNG image
        File file = new File("D://jfreechart//XYLineAndAreaChart.png");

        ChartUtilities.saveChartAsPNG(file, chart, 500, 400);
        System.out.println("图片已保存到 " + file.getAbsolutePath());
    }
}