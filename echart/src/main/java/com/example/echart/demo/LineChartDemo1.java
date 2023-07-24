//package com.example.echart.demo;
//
//import org.icepear.echarts.Option;
//import org.icepear.echarts.axis.CategoryAxis;
//import org.icepear.echarts.axis.ValueAxis;
//import org.icepear.echarts.series.Line;
//
//import java.awt.*;
//import java.io.IOException;
//
//public class LineChartDemo1 {
//    public static void main(String[] args) throws IOException {
//        // 创建 Option 对象
//        Option option = new Option();
//
//        // 设置图表标题
//        option.title().setText("折线图");
//
//        // 创建 CategoryAxis 和 ValueAxis 对象作为 X 轴和 Y 轴
//        CategoryAxis categoryAxis = new CategoryAxis();
//        categoryAxis.setName("日期");
//        categoryAxis.setBoundaryGap(false);
//
//        ValueAxis valueAxis = new ValueAxis();
//        valueAxis.setName("销售额");
//
//        // 添加数据
//        categoryAxis.setData("1月", "2月", "3月", "4月", "5月", "6月");
//        valueAxis.setMin(0);
//        valueAxis.setMax(100);
//
//        // 创建 Line 对象并设置样式和数据
//        Line line = new Line();
//        line.setName("销售额");
//        line.setSmooth(true);
//        line.setAreaStyle(new Line.AreaStyle(new Color(255, 127, 80, 50)));
//        line.setData(20, 40, 60, 80, 70, 90);
//
//        // 将 X 轴、Y 轴和 Line 对象添加到 Option 中
//        option.xAxis(categoryAxis);
//        option.yAxis(valueAxis);
//        option.series(line);
//
//        // 设置 Option 样式
//        option.title().setTextStyle(new Option.TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.getLegend().setTextStyle(new Option.TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.xAxis().getNameTextStyle().setFontFamily("微软雅黑").setColor("#333333");
//        option.yAxis().getNameTextStyle().setFontFamily("微软雅黑").setColor("#333333");
//
//        // 使用 Toolkit 获取屏幕大小
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//        // 创建图表对象并设置宽度和高度
//        org.icepear.echarts.Chart chart =
//                new org.icepear.echarts.Chart((int) screenSize.getWidth(), (int) screenSize.getHeight());
//
//        // 将 Option 对象设置为图表的选项
//        chart.setOption(option);
//
//        // 将图表保存为文件
//        chart.toFile("line-chart.png");
//    }
//}