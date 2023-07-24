//package com.example.demo.chart.line.demo;
//
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.DateAxis;
//import org.jfree.chart.axis.DateTickMarkPosition;
//import org.jfree.chart.labels.StandardXYToolTipGenerator;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYItemRenderer;
//import org.jfree.chart.renderer.xy.XYSplineRenderer;
//
//import java.awt.*;
//import java.text.SimpleDateFormat;
//
//public class LineChartDemo3 {
//    XYSplineRenderer renderer = new XYSplineRenderer();
//renderer.setBaseShapesVisible(false); //绘制的线条上不显示图例，如果显示的话，会使图片变得很丑陋
//renderer.setSeriesPaint(0, Color.GREEN); //设置0号数据的颜色。这是手工设置线条颜色的方法
//renderer.setPrecision(5); //设置精度，大概意思是在源数据两个点之间插入5个点以拟合出一条平滑曲线
//    //create plot
//    NumberAxis xAxis = new NumberAxis("Time(ns)");
//xAxis.setAutoRangeIncludesZero(false);
//    NumberAxis yAxis = new NumberAxis("Voltage(mv)");
//yAxis.setAutoRangeIncludesZero(false);
//    XYPlot plot = new XYPlot(createDataset("D:/V.dat"), xAxis, yAxis, renderer);
//plot.setBackgroundPaint(Color.black);
//plot.setDomainGridlinePaint(Color.white);
//plot.setRangeGridlinePaint(Color.white);
//plot.setAxisOffset(new RectangleInsets(4, 4, 4, 4)); //设置坐标轴与绘图区域的距离
//    JFreeChart chart = new JFreeChart("细胞电压图", //标题
//            JFreeChart.DEFAULT_TITLE_FONT, //标题的字体，这样就可以解决中文乱码的问题
//            plot,
//            false //不在图片底部显示图例
//    );
//    //设置X轴的显示格式
//    XYPlot xyplot   =   chart.getXYPlot();
//xyplot.setForegroundAlpha(0.5f);
//    XYItemRenderer renderer   =   xyplot.getRenderer();
//renderer.setToolTipGenerator(
//        new   StandardXYToolTipGenerator(
//            StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
//new SimpleDateFormat(yyyy-MM),   new   DecimalFormat( "0 ")
//)
//        );
//    DateAxis dateAxis   =   new   DateAxis( "时间 ");
//dateAxis.setDateFormatOverride(new   SimpleDateFormat( "yyyy-MM "));
//dateAxis.setAutoRange(true);
//dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
//xyplot.setDomainAxis(dateAxis);
//ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 1024, 768, null);
//}
