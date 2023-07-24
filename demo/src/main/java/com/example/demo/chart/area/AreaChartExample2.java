package com.example.demo.chart.area;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class AreaChartExample2 {

    public static void main(String[] args) throws IOException {
        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYAreaChart(
            "Area Chart Example",
            "X",
            "Y",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        File file = new File("D://jfreechart//area_chart2.png");
        ChartUtilities.saveChartAsPNG(file, chart, 800, 400);
    }

    private static XYDataset createDataset() {
        XYSeries series = new XYSeries("Data");
        series.add(1, 2);
        series.add(2, 3);
        series.add(3, 1);
        series.add(4, 5);
        series.add(5, 4);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }
}