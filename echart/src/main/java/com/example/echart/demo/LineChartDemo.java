//package com.example.echart.demo;
//
//import com.github.abel533.echarts.AxisPointer;
//import com.github.abel533.echarts.Label;
//import com.github.abel533.echarts.Legend;
//import com.github.abel533.echarts.Option;
//import com.github.abel533.echarts.Tooltip;
//import com.github.abel533.echarts.axis.CategoryAxis;
//import com.github.abel533.echarts.axis.ValueAxis;
//import com.github.abel533.echarts.code.SeriesType;
//import com.github.abel533.echarts.series.Line;
//import com.github.abel533.echarts.style.LineStyle;
//import com.github.abel533.echarts.style.TextStyle;
//
//import java.awt.*;
//import java.io.File;
//
//public class LineChartDemo {
//    public static void main(String[] args) throws Exception {
//        // 创建 Option 对象
//        Option option = new Option();
//
//        // 设置图表标题
//        option.title().setText("折线图");
//
//        // 创建 Legend、Tooltip 和 AxisPointer 对象
//        Legend legend = new Legend();
//        Tooltip tooltip = new Tooltip();
//        tooltip.setTrigger(Tooltip.Trigger.axis);
//        AxisPointer axisPointer = new AxisPointer();
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
//        line.setType(SeriesType.line);
//        line.setSmooth(true);
//        line.setStack("总量");
//        line.setAreaStyle(new com.github.abel533.echarts.code.AxisLine());
//        line.setSymbolSize(8);
//        line.setLabel(new Label().setNormal(new Label.Normal().setShow(true).setPosition("top")));
//        line.setLineStyle(new LineStyle().setWidth(2));
//
//        Integer[] data = {20, 40, 60, 80, 70, 90};
//        for (Integer d : data) {
//            line.data(d);
//        }
//
//        // 将 X 轴、Y 轴和 Line 对象添加到 Option 中
//        option.legend(legend);
//        option.tooltip(tooltip);
//        option.xAxis(categoryAxis);
//        option.yAxis(valueAxis);
//        option.series(line);
//
//        // 设置 Option 样式
//        option.title().setTextStyle(new TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.getLegend().setTextStyle(new TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.xAxis().getNameTextStyle().setFontFamily("微软雅黑").setColor("#333333");
//        option.yAxis().getNameTextStyle().setFontFamily("微软雅黑").setColor("#333333");
//
//        // 使用 Toolkit 获取屏幕大小
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//        // 创建图表对象并设置宽度和高度
//        com.github.abel533.echarts.Chart chart =
//                new com.github.abel533.echarts.Chart((int) screenSize.getWidth(), (int) screenSize.getHeight());
//
//        // 将 Option 对象设置为图表的选项
//        chart.setOption(option);
//
//        // 将图表保存为文件
//        chart.toFile(new File("line-chart.png"));
//    }
//}