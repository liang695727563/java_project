package com.example.demo.chart.line.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class Demo {
    public static void main(String args[]) {
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);
        XYSeriesCollection mCollection = GetCollection();
        JFreeChart mChart = ChartFactory.createXYLineChart(
                "测试图",
                "x轴",
                "y轴",
                mCollection, //数据集
                PlotOrientation.VERTICAL,  //绘制方向
                true,        //显示图例
                true,        //标准生成器
                false);      //是否生成超链接
        XYPlot xyplot = mChart.getXYPlot();
        NumberAxis yAxis = (NumberAxis) xyplot.getRangeAxis();       //获取Y轴
        yAxis.setAutoRangeIncludesZero(false);                   //不强制显示0，让图形显示在图中，自适应
        xyplot.setBackgroundPaint(Color.WHITE);         //折线背景
        xyplot.setRangeGridlinePaint(Color.gray);       //虚线颜色
        /*设置折线粗细，颜色*/
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(2F));      //0表示第一个折线
        xylineandshaperenderer.setSeriesPaint(0,Color.BLACK);

     /*   // 创建渐变颜色
//        Color orange1 = new Color(255, 200, 0);
//        Color orange2 = new Color(255, 244, 183);
        Color orange1 = new Color(255,160 ,122	);
        Color orange2 = new Color(255, 255, 255);
        XYAreaRenderer areaRenderer = new XYAreaRenderer();
//        areaRenderer.setOutline(true);
        areaRenderer.setSeriesPaint(0,Color.red);

//        areaRenderer.setSeriesPaint(0, new GradientPaint(0.0f, 0.0f, orange1, 0.0f, 0.0f, orange2));
        areaRenderer.setSeriesFillPaint(0, new GradientPaint(0.0f, 0.0f, orange1, 0.0f, 0.0f, orange2));
        areaRenderer.setUseFillPaint(true);
        xyplot.setRenderer(areaRenderer);*/
	    /*
	    xylineandshaperenderer.setSeriesStroke(1, new BasicStroke(2F));
	    xylineandshaperenderer.setSeriesStroke(2, new BasicStroke(2F));
	    xylineandshaperenderer.setSeriesStroke(3, new BasicStroke(2F));
	    */
        ChartFrame mChartFrame = new ChartFrame("测试图", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);
        mChart.getLegend().setVisible(false);              //设置标签隐藏
    }

    public static XYSeriesCollection GetCollection(){
        int X[]={5,2,78,2,1};
        int Y[]={54,23,78,21,3};
        XYSeriesCollection mCollection = new XYSeriesCollection();
        XYSeries m[] = new XYSeries[4];           //五个点需要四条折线
        for(int i=0;i<4;i++) {
            m[i]=new XYSeries(i);
            m[i].add(X[i],Y[i]);
            m[i].add(X[i+1],Y[i+1]);
            mCollection.addSeries(m[i]);
        }

        //    mCollection.addSeries(mSeriesForth);

        return mCollection;
    }

}
/*
* https://blog.csdn.net/C_lea/article/details/114103269?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-114103269-blog-53080880.235%5Ev36%5Epc_relevant_default_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-114103269-blog-53080880.235%5Ev36%5Epc_relevant_default_base3&utm_relevant_index=2
* */