package com.example.demo.chart.line;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 {

    public static void main(String[] args) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(15, "Sales", "Jan");
        dataset.addValue(30, "Sales", "Feb");
        dataset.addValue(25, "Sales", "Mar");
        dataset.addValue(40, "Sales", "Apr");
        dataset.addValue(50, "Sales", "May");
        JFreeChart jFreeChart = createLineChart1("近7日金额(日报)", null, null, dataset);

        saveAsFile(jFreeChart, "D://jfreechart//testline.png", 500, 300);
        System.out.println("执行完成！");

    }

    public static JFreeChart createLineChart1(
            String chartTitle, String x,
            String y, CategoryDataset dataset) {

        // 构建一个chart
        JFreeChart chart = ChartFactory.createLineChart(
                chartTitle,
                x,
                y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        return chart;
    }

    /**
     * 生成折线图
     *
     * @param chartTitle 图的标题
     * @param x          横轴标题
     * @param y          纵轴标题
     * @param dataset    数据集
     * @return
     */
    public static JFreeChart createLineChart(
            String chartTitle, String x,
            String y, CategoryDataset dataset) {

        // 构建一个chart
        JFreeChart chart = ChartFactory.createLineChart(
                chartTitle,
                x,
                y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        //字体清晰
        chart.setTextAntiAlias(false);
        // 设置背景颜色
        chart.setBackgroundPaint(Color.WHITE);

        // 设置图标题的字体
        Font font = new Font("隶书", Font.BOLD, 25);
        chart.getTitle().setFont(font);

        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        // 设置图示的字体
        chart.getLegend().setItemFont(labelFont);

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // x轴 // 分类轴网格是否可见
        categoryplot.setDomainGridlinesVisible(true);
        // y轴 //数据轴网格是否可见
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setDomainGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setBackgroundPaint(Color.lightGray);// 折线图的背景颜色

        // 设置轴和面板之间的距离
        // categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

        // 横轴 x
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值
        // domainAxis.setLabelPaint(Color.BLUE);//轴标题的颜色
        // domainAxis.setTickLabelPaint(Color.BLUE);//轴数值的颜色

        // 横轴 lable 的位置 横轴上的 Lable 45度倾斜 DOWN_45
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.0);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.0);



        // 纵轴 y
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setLabelFont(labelFont);
        numberaxis.setTickLabelFont(labelFont);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);

        // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
                .getRenderer();
//        lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见
//        lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
        lineandshaperenderer.setShapesVisible(true);

        lineandshaperenderer.setDrawOutlines(true);

        lineandshaperenderer.setUseFillPaint(true);
        // 显示折点数据
        lineandshaperenderer
                .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);

        return chart;
    }

    //     保存为文件
    public static void saveAsFile(JFreeChart chart, String outputPath,
                                  int weight, int height) {
        FileOutputStream out = null;
        try {
            File outFile = new File(outputPath);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(outputPath);
            // 保存为PNG文件
            ChartUtilities.writeChartAsPNG(out, chart, 600, 350);
            // 保存为JPEG文件
            //ChartUtilities.writeChartAsJPEG(out, chart, 500, 400);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // do nothing
                }
            }
        }
    }
}
