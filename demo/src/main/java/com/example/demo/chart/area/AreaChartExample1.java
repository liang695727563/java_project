package com.example.demo.chart.area;

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.xy.*;

public class AreaChartExample1 extends JFrame {

    public AreaChartExample1() {
        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYAreaChart(
            "Area Chart Example",
            "X",
            "Y",
            dataset
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
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

    public static void main(String[] args) {
        AreaChartExample1 example = new AreaChartExample1();
        example.setSize(800, 400);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        example.setVisible(true);
    }
}