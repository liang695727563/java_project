package com.example.demo.chart.area;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class AreaChartExample3 {
    public static void main(String[] args) throws IOException {


        double[][] data = new double[][]{

                {27000,17125,24250,7375,12500,9532,11600,1768,28100,28700,29600} };

        String[] rowKeys =

                {"index"};

        String[] columnKeys =

                {"10", "15", "20", "25", "30", "35","40","45","50","55","60"};



        CategoryDataset dateSet = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);



        JFreeChart chart = ChartFactory.createAreaChart(

                "2008-3-20",

                null,

                null,

                dateSet,

                PlotOrientation.VERTICAL,

                false,

                false,

                false);



        chart.setBackgroundPaint(new Color(245,245,245));//全图背景色

//        BufferedImage image = ImageIO.read(new File("C:\\Users\\admin\\Downloads\\png\\1.jpeg"));//背景图片



        AreaRenderer renderer = new AreaRenderer();//绘制的图形

        renderer.setSeriesPaint(0, new Color(255,222,204));//图形前景



        /*

         * 以下两句，你是设置画出图形的轮廓．可是没什么效果．

         */

        renderer.setSeriesOutlinePaint(0, Color.black);

        renderer.setSeriesOutlineStroke(0, new BasicStroke(50));
//        renderer.set(Color.black,false);


        CategoryPlot plot = chart.getCategoryPlot();//整个绘图区（不包括ＸＹ坐标以外）

        plot.setForegroundAlpha(1.0f);//前影透明

        plot.setRenderer(renderer);

//        plot.setBackgroundImage(image);//绘图区背景



        CategoryAxis axis = plot.getDomainAxis();

        axis.setLowerMargin(0.0);//Ｘ轴相对左边距离

        axis.setUpperMargin(0.0);//Ｘ轴相对右边距离



        plot.getRangeAxis().setLowerMargin(0.0);//Ｙ轴距离底边距离



        FileOutputStream out = new FileOutputStream("D://jfreechart//test.jpg");

        ChartUtilities.writeChartAsPNG(out, chart, 500, 510);

        //ChartUtilities.writeChartAsJPEG(out,chart,500,510);//为什么用JPEG输出后图片变呈一片橙色?

    }
}
