//package com.example.demo.chart;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Paint;
//import java.awt.Rectangle;
//import java.io.File;
//import java.io.IOException;
//import java.text.NumberFormat;
//import java.util.*;
//import java.util.Map.Entry;
//
//import org.apache.commons.compress.utils.Lists;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.StandardChartTheme;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.axis.ValueAxis;
//import org.jfree.chart.block.BlockBorder;
//import org.jfree.chart.labels.ItemLabelAnchor;
//import org.jfree.chart.labels.ItemLabelPosition;
//import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
//import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
//import org.jfree.chart.plot.*;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.chart.renderer.category.StandardBarPainter;
//import org.jfree.chart.renderer.xy.StandardXYBarPainter;
//import org.jfree.chart.ui.RectangleInsets;
//import org.jfree.chart.ui.TextAnchor;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.DatasetUtils;
//import org.jfree.data.general.DefaultPieDataset;
//
///**
// * @program: poi-word
// * @description:
// * @author: sunhui
// * @create: 2020-08-25 14:04
// **/
//public class ChartUtils {
//    private static String NO_DATA_MSG = "暂无数据";
//    private static Font FONT = new Font("宋体", Font.PLAIN, 20);
//    public static Color[] CHART_COLORS = {
//            new Color(31,129,188), new Color(92,92,97), new Color(144,237,125), new Color(255,188,117),
//            new Color(153,158,255), new Color(255,117,153), new Color(253,236,109), new Color(128,133,232),
//            new Color(158,90,102),new Color(255, 204, 102) };// 颜色
//
//    static{
//        setChartTheme();
//    }
//    /**
//     * 中文主题样式 解决乱码
//     */
//    public static void setChartTheme() {
//        // 设置中文主题样式 解决乱码
//        StandardChartTheme chartTheme = new StandardChartTheme("CN");
//        // 设置标题字体
//        chartTheme.setExtraLargeFont(FONT);
//        // 设置图例的字体
//        chartTheme.setRegularFont(FONT);
//        // 设置轴向的字体
//        chartTheme.setLargeFont(FONT);
//        chartTheme.setSmallFont(FONT);
//        chartTheme.setTitlePaint(new Color(51, 51, 51));
//        chartTheme.setSubtitlePaint(new Color(85, 85, 85));
//
//        chartTheme.setLegendBackgroundPaint(Color.WHITE);// 设置标注
//        chartTheme.setLegendItemPaint(Color.BLACK);//
//        chartTheme.setChartBackgroundPaint(Color.WHITE);
//        // 绘制颜色绘制颜色.轮廓供应商
//        // paintSequence,outlinePaintSequence,strokeSequence,outlineStrokeSequence,shapeSequence
//
//        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[] { Color.WHITE };
//        // 绘制器颜色源
//        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(CHART_COLORS, CHART_COLORS, OUTLINE_PAINT_SEQUENCE,
//                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
//                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
//        chartTheme.setDrawingSupplier(drawingSupplier);
//
//        chartTheme.setPlotBackgroundPaint(Color.WHITE);// 绘制区域
//        chartTheme.setPlotOutlinePaint(Color.WHITE);// 绘制区域外边框
//        chartTheme.setLabelLinkPaint(new Color(8, 55, 114));// 链接标签颜色
//        chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);
//
//        chartTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
//        chartTheme.setDomainGridlinePaint(new Color(192, 208, 224));// X坐标轴垂直网格颜色
//        chartTheme.setRangeGridlinePaint(new Color(192, 192, 192));// Y坐标轴水平网格颜色
//
//        chartTheme.setBaselinePaint(Color.WHITE);
//        chartTheme.setCrosshairPaint(Color.BLUE);// 不确定含义
//        chartTheme.setAxisLabelPaint(new Color(51, 51, 51));// 坐标轴标题文字颜色
//        chartTheme.setTickLabelPaint(new Color(67, 67, 72));// 刻度数字
//        chartTheme.setBarPainter(new StandardBarPainter());// 设置柱状图渲染
//        chartTheme.setXYBarPainter(new StandardXYBarPainter());// XYBar 渲染
//
//        chartTheme.setItemLabelPaint(Color.black);
//        chartTheme.setThermometerPaint(Color.white);// 温度计
//
//        ChartFactory.setChartTheme(chartTheme);
//    }
//
//    public ChartUtils() {
//    }
//
//
//    /**
//     * 必须设置文本抗锯齿
//     */
//    public static void setAntiAlias(JFreeChart chart) {
//        chart.setTextAntiAlias(false);
//
//    }
//
//    /**
//     * 设置图例无边框，默认黑色边框
//     */
//    public static void setLegendEmptyBorder(JFreeChart chart) {
//        chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
//
//    }
//
//    /**
//     * 提供静态方法：获取报表图形1：饼状图
//     * @param title    标题
//     * @param datas    数据
//     * @param url    字体
//     */
//    public static void createPiePort(String title, Map<String,Double> datas, String url){
//        try {
//            // 如果不使用Font,中文将显示不出来
//            DefaultPieDataset pds = new DefaultPieDataset();
//
//            // 获取迭代器：
//            Set<Map.Entry<String, Double>> set =  datas.entrySet();
//            Iterator iterator=(Iterator) set.iterator();
//            Entry entry=null;
//            while(iterator.hasNext()){
//                entry=(Entry) iterator.next();
//                pds.setValue(entry.getKey().toString(),Double.parseDouble(entry.getValue().toString()));
//            }
//            /**
//             * 生成一个饼图的图表
//             * 分别是:显示图表的标题、需要提供对应图表的DateSet对象、是否显示图例、是否生成贴士以及是否生成URL链接
//             */
//            JFreeChart chart = ChartFactory.createPieChart(title, pds, true, true, true);
//            setPieRender((PiePlot) chart.getPlot());
//
//            //将内存中的图片写到本地硬盘
//            org.jfree.chart.ChartUtils.saveChartAsPNG(new File(url), chart,800,500);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 提供静态方法：获取报表图形1：饼状图
//     * @param title    标题
//     * @param datas    数据
//     * @param url    字体
//     */
//    public static void createBarPort(String title, Map<String,Double> datas, String url){
//        try {
//            // 如果不使用Font,中文将显示不出来
//            DefaultCategoryDataset  pds = new DefaultCategoryDataset();
//
//            // 获取迭代器：
//            Set<Map.Entry<String, Double>> set =  datas.entrySet();
//            Iterator iterator=(Iterator) set.iterator();
//            Entry entry=null;
//            while(iterator.hasNext()){
//                entry=(Entry) iterator.next();
//                pds.setValue(Double.parseDouble(entry.getValue().toString()),entry.getKey().toString(),entry.getKey().toString());
//            }
//            /**
//             * 生成一个饼图的图表
//             * 分别是:显示图表的标题、需要提供对应图表的DateSet对象、是否显示图例、是否生成贴士以及是否生成URL链接
//             */
//            JFreeChart chart = ChartFactory.createBarChart(title,"分类","数量", pds, PlotOrientation.VERTICAL, true, true, false);
//
//            //将内存中的图片写到本地硬盘
//            org.jfree.chart.ChartUtils.saveChartAsPNG(new File(url), chart,800,500);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 生成分组的柱状图
//     */
//    public static void makeBarGroupChart(String title, String[] rowKeys, String[] columnKeys, List<List<Double>> dataNums, String url) {
//        try {
//            double[][] data = new double[dataNums.size()][dataNums.get(0).size()];
//            for (int i = 0; i <dataNums.size() ; i++) {
//                for (int j = 0; j < dataNums.get(0).size(); j++) {
//                    data[i][j]=dataNums.get(i).get(j);
//                }
//            }
//            CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);
//            JFreeChart chart = ChartFactory.createBarChart(title,
//                    "水果",
//                    "销量",
//                    dataset,
//                    PlotOrientation.VERTICAL,
//                    true,
//                    true,
//                    false);
//            //将内存中的图片写到本地硬盘
//            org.jfree.chart.ChartUtils.saveChartAsPNG(new File(url), chart,800,500);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 提供静态方法：获取报表图形3：折线图
//     * @param title        标题
//     * @param datas        数据
//     * @param xName        分类（第一季，第二季.....）
//     * @param yName    柱状图的数量单位
//     * @param url        字体
//     */
//    public static void createLinePort(String title,Map<String,Double> datas,String xName,String yName,String url){
//        try {
//            //种类数据集
//            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//            //获取迭代器：
//            Set<Entry<String, Double>> set =  datas.entrySet();
//            Iterator iterator=(Iterator) set.iterator();
//            Entry entry=null;
//            while(iterator.hasNext()){
//                entry=(Entry) iterator.next();
//                dataset.setValue(Double.parseDouble(entry.getValue().toString()),//y
//                        title,                         //名称
//                        entry.getKey().toString());      //x
//            }
//            //创建折线图,折线图分水平显示和垂直显示两种
//            JFreeChart chart = ChartFactory.createLineChart(title, xName, yName, dataset,//2D折线图
//                    PlotOrientation.VERTICAL,
//                    false, // 是否显示图例(对于简单的柱状图必须是false)
//                    true, // 是否生成工具
//                    true);// 是否生成URL链接
//            //得到绘图区
//            setLineRender((CategoryPlot)chart.getPlot(),true,true);
//            org.jfree.chart.ChartUtils.saveChartAsPNG(new File(url), chart, 1000,600);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 设置折线图样式
//     *
//     * @param plot
//     * @param isShowDataLabels
//     *            是否显示数据标签
//     */
//    public static void setLineRender(CategoryPlot plot, boolean isShowDataLabels, boolean isShapesVisible) {
//        plot.setNoDataMessage(NO_DATA_MSG);
//        plot.setInsets(new RectangleInsets(10, 10, 0, 10), false);
//        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setDefaultStroke(new BasicStroke(1.5F));
//        if (isShowDataLabels) {
//            renderer.setDefaultItemLabelsVisible(true);
//            renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator(StandardCategoryItemLabelGenerator.DEFAULT_LABEL_FORMAT_STRING,
//                    NumberFormat.getInstance()));
//            renderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BOTTOM_CENTER));// weizhi
//        }
//        renderer.setDefaultShapesVisible(isShapesVisible);// 数据点绘制形状
//        setXAixs(plot);
//        setYAixs(plot);
//
//    }
//    /**
//     * 设置饼状图渲染
//     */
//    public static void setBarRender(Plot plot) {
//
////        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
////        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,12));//设置横坐标字体
//    }
//    /**
//     * 设置饼状图渲染
//     */
//    public static void setPieRender(Plot plot) {
//
//        plot.setNoDataMessage(NO_DATA_MSG);
//        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
//        PiePlot piePlot = (PiePlot) plot;
//        piePlot.setInsets(new RectangleInsets(0, 0, 0, 0));
//        piePlot.setCircular(true);// 圆形
//
//        // piePlot.setSimpleLabels(true);// 简单标签
//        piePlot.setLabelGap(0.01);
//        piePlot.setInteriorGap(0.05D);
//        piePlot.setLegendItemShape(new Rectangle(10, 10));// 图例形状
//        piePlot.setIgnoreNullValues(true);
//        piePlot.setLabelBackgroundPaint(null);// 去掉背景色
//        piePlot.setLabelShadowPaint(null);// 去掉阴影
//        piePlot.setLabelOutlinePaint(null);// 去掉边框
//        piePlot.setShadowPaint(null);
//        // 0:category 1:value:2 :percentage
//        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}"));// 显示标签数据
//    }
//
//    /**
//     * 设置类别图表(CategoryPlot) X坐标轴线条颜色和样式
//     *
//     * @param plot
//     */
//    public static void setXAixs(CategoryPlot plot) {
//        Color lineColor = new Color(31, 121, 170);
//        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
//        plot.getDomainAxis().setAxisLinePaint(lineColor);// X坐标轴颜色
//        plot.getDomainAxis().setTickMarkPaint(lineColor);// X坐标轴标记|竖线颜色
//
//    }
//
//    /**
//     * 设置类别图表(CategoryPlot) Y坐标轴线条颜色和样式 同时防止数据无法显示
//     *
//     * @param plot
//     */
//    public static void setYAixs(CategoryPlot plot) {
////      Color lineColor = new Color(192, 208, 224);
//        Color lineColor = new Color(31, 121, 170);
//        ValueAxis axis = plot.getRangeAxis();
//        axis.setAxisLinePaint(lineColor);// Y坐标轴颜色
//        axis.setTickMarkPaint(lineColor);// Y坐标轴标记|竖线颜色
//        // false隐藏Y刻度
//        axis.setAxisLineVisible(true);
//        axis.setTickMarksVisible(true);
//        // Y轴网格线条
//        plot.setRangeGridlinePaint(new Color(192, 192, 192));
//        plot.setRangeGridlineStroke(new BasicStroke(1));
//
//        plot.getRangeAxis().setUpperMargin(0.1);// 设置顶部Y坐标轴间距,防止数据无法显示
//        plot.getRangeAxis().setLowerMargin(0.1);// 设置底部Y坐标轴间距
//
//    }
//
//    /**
//     * 设置XY图表(XYPlot) X坐标轴线条颜色和样式
//     *
//     * @param plot
//     */
//    public static void setXY_XAixs(XYPlot plot) {
//        Color lineColor = new Color(31, 121, 170);
//        plot.getDomainAxis().setAxisLinePaint(lineColor);// X坐标轴颜色
//        plot.getDomainAxis().setTickMarkPaint(lineColor);// X坐标轴标记|竖线颜色
//
//    }
//
//    /**
//     * 设置XY图表(XYPlot) Y坐标轴线条颜色和样式 同时防止数据无法显示
//     *
//     * @param plot
//     */
//    public static void setXY_YAixs(XYPlot plot) {
//        Color lineColor = new Color(192, 208, 224);
//        ValueAxis axis = plot.getRangeAxis();
//        axis.setAxisLinePaint(lineColor);// X坐标轴颜色
//        axis.setTickMarkPaint(lineColor);// X坐标轴标记|竖线颜色
//        // 隐藏Y刻度
//        axis.setAxisLineVisible(false);
//        axis.setTickMarksVisible(false);
//        // Y轴网格线条
//        plot.setRangeGridlinePaint(new Color(192, 192, 192));
//        plot.setRangeGridlineStroke(new BasicStroke(1));
//        plot.setDomainGridlinesVisible(false);
//
//        plot.getRangeAxis().setUpperMargin(0.12);// 设置顶部Y坐标轴间距,防止数据无法显示
//        plot.getRangeAxis().setLowerMargin(0.12);// 设置底部Y坐标轴间距
//
//    }
//    /***
//     * 生成空心圆
//     * @param title
//     */
//    public static void createCircularChart(String title, Map<String,Double> datas, String url){
//        try {
//            // 如果不使用Font,中文将显示不出来
//            DefaultPieDataset pds = new DefaultPieDataset();
//            // 获取迭代器：
//            Set<Map.Entry<String, Double>> set =  datas.entrySet();
//            Iterator iterator=(Iterator) set.iterator();
//            Entry entry=null;
//            while(iterator.hasNext()){
//                entry=(Entry) iterator.next();
//                pds.setValue(entry.getKey().toString(),Double.parseDouble(entry.getValue().toString()));
//            }
//            StandardChartTheme mChartTheme = new StandardChartTheme("CN");
//            // Y柱标签字体（浓度(单位：ppm)）
//            mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 14));
//            //标题 （二氧化碳浓度趋势分析图）
//            mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 20));
//            //应用主题样式
//            ChartFactory.setChartTheme(mChartTheme);
//            JFreeChart chart = ChartFactory.createRingChart(title, pds, true, false, false);
//
//            // 设置显示标注,就是底部显示的文字对应颜色标注
//            chart.getLegend().setVisible(false);
//            Font font = new Font("宋体", Font.BOLD, 15);
//            chart.getLegend().setItemFont(font);
//
//            // 设置标注无边框
//            chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
//
//            // 环形图
//            RingPlot ringplot = (RingPlot) chart.getPlot();
//            ringplot.setOutlineVisible(false);
//            //{2}表示显示百分比  //{0}:key {1}:value {2}:百分比 {3}:sum
//            ringplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));
//            ringplot.setBackgroundPaint(new Color(253, 253, 253));
//            ringplot.setOutlineVisible(false);
//            ringplot.setLabelFont(new Font("宋体", Font.BOLD, 15));
//            ringplot.setSeparatorsVisible(false);
//            ringplot.setSeparatorPaint(Color.WHITE);
//            ringplot.setShadowPaint(new Color(253, 253, 253));
//            // 设置深度，即带颜⾊圆环的宽度
//            ringplot.setSectionDepth(0.4);
//            ringplot.setStartAngle(90);
//            // 指定颜色
//            ringplot.setDrawingSupplier(new DefaultDrawingSupplier(
//                    new Paint[] {
//                            new Color(46, 199, 201),
//                            new Color(182, 162, 222),
//                            new Color(90, 177, 239),
//                            new Color(255, 185, 128),
//                            new Color(226, 117, 123)
//                    },
//                    DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
//                    DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
//                    DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
//                    DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
//            //将内存中的图片写到本地硬盘
//            org.jfree.chart.ChartUtils.saveChartAsPNG(new File(url), chart,800,500);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        Map<String, Double> map=new HashMap<String, Double>();
//        map.put("冠心病", (double) 1000);
//        map.put("脑卒中", (double) 700);
//        map.put("肺结核", (double) 600);
//        map.put("糖尿病", (double) 400);
//        map.put("高血压", (double) 100);
//        map.put("精神病", (double) 2000);
//        createPiePort("慢病统计结果", map,"D://jfreechart//aa.jpg");
//
//        Map<String, Double> map1=new HashMap<String, Double>();
//        //设置第一期的投票信息
//        map1.put("2020-02-03", (double) 700);
//        map1.put("2020-02-04", (double) 1000);
//        map1.put("2020-02-05", (double) 600);
//        map1.put("2020-02-06", (double) 400);
//        map1.put("2020-02-07", (double) 4000);
//        map1.put("2020-02-08", (double) 1200);
//        map1.put("2020-02-09", (double) 800);
//        createLinePort("近7日金额(日报)",map1,"日期","金额（元）","D://jfreechart//bb.jpg");
//
//        Map<String, Double> map2=new HashMap<String, Double>();
//        map2.put("冠心病", (double) 1000);
//        map2.put("脑卒中", (double) 700);
//        map2.put("肺结核", (double) 600);
//        map2.put("糖尿病", (double) 400);
//        map2.put("高血压", (double) 100);
//        map2.put("精神病", (double) 2000);
//        createBarPort("慢病统计结果", map2,"D://jfreechart//cc.jpg");
//
//
//        double[][] data = new double[][] { { 672, 766, 223, 540, 126 },
//                { 325, 521, 210, 340, 106 }, { 332, 256, 523, 240, 526 } };
//        List<List<Double>> list = Lists.newArrayList();
//        for (int i = 0; i < data.length; i++) {
//            List<Double> d =  Lists.newArrayList();
//            for (int j = 0; j < data[i].length; j++) {
//                d.add(data[i][j]);
//            }
//            list.add(d);
//        }
//        makeBarGroupChart("这是title",new String[]{"苹果", "梨子", "葡萄"},new String[]{"北京", "上海", "广州", "成都", "深圳"},list,"D://jfreechart//dd.jpg");
//        createCircularChart("慢病统计唤醒结果", map,"D://jfreechart//ee.jpg");
//
//
//    }
//
//}