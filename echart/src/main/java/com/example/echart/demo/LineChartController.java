//package com.example.echart.demo;
//
//import com.github.abel533.echarts.Option;
//import com.github.abel533.echarts.axis.CategoryAxis;
//import com.github.abel533.echarts.axis.ValueAxis;
//import com.github.abel533.echarts.code.AxisType;
//import com.github.abel533.echarts.code.LineType;
//import com.github.abel533.echarts.series.Line;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//import java.awt.*;
//import java.io.IOException;
//import java.time.format.TextStyle;
//
//@Controller
//public class LineChartController {
//    @Autowired
//    private HttpServletResponse response;
//
//    @GetMapping("/line-chart")
//    @ResponseBody
//    public void generateLineChart() throws IOException {
//        // 创建 Option 对象
//        Option option = new Option();
//
//        // 设置图表标题
//        option.title().setText("折线图");
//
//        // 创建 CategoryAxis 和 ValueAxis 对象作为 X 轴和 Y 轴
//        CategoryAxis categoryAxis = new CategoryAxis();
//        categoryAxis.setName("日期");
//        categoryAxis.type(AxisType.category);
//
//        ValueAxis valueAxis = new ValueAxis();
//        valueAxis.setName("销售额");
//
//        // 添加数据
//        categoryAxis.data("1月", "2月", "3月", "4月", "5月", "6月");
//        valueAxis.min(0).max(100);
//        valueAxis.axisTick().show(false);
//
//        // 创建 Line 对象并设置样式和数据
//        Line line = new Line();
//        line.name("销售额");
//        line.type(LineType.solid);
//        line.smooth(true);
//        line.itemStyle().normal().setColor("#ff7f50");
//        line.areaStyle().normal().setColor(new Color(255, 127, 80, 50));
//        line.data(20, 40, 60, 80, 70, 90);
//
//        // 将 X 轴、Y 轴和 Line 对象添加到 Option 中
//        option.xAxis(categoryAxis);
//        option.yAxis(valueAxis);
//        option.series(line);
//
//        // 设置 Option 样式
//        option.title().setTextStyle(new TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.legend().setTextStyle(new TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.xAxis().setNameTextStyle(new TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//        option.yAxis().setNameTextStyle(new TextStyle().setFontFamily("微软雅黑").setColor("#333333"));
//
//        // 创建 ECharts 图表对象并设置宽度和高度
//        com.github.abel533.echarts.Chart chart = new com.github.abel533.echarts.Chart(800, 600);
//
//        // 将 Option 对象设置为图表的选项
//        chart.setOption(option);
//
//        // 将图表保存为文件
//        chart.exportTo(response.getOutputStream());
//    }
//}