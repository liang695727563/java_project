//package com.example.demo.chart;
//
//import java.awt.Dimension;
//
//import java.awt.Font;
//
//import java.awt.geom.GeneralPath;
//
//import java.text.SimpleDateFormat;
//
//import javax.swing.BorderFactory;
//
//import javax.swing.JPanel;
//import javax.swing.border.CompoundBorder;
//
//import x.swing.border.CompoundBorder;
//
//import org.jfree.chart.ChartFactory;
//
//import org.jfree.chart.ChartPanel;
//
//import org.jfree.chart.ChartUtilities;
//
//import org.jfree.chart.JFreeChart;
//
//import org.jfree.chart.StandardChartTheme;
//
//import org.jfree.chart.axis.DateAxis;
//
//import org.jfree.chart.axis.DateTickUnit;
//
//import org.jfree.chart.axis.DateTickUnitType;
//
//import org.jfree.chart.plot.XYPlot;
//
//import org.jfree.chart.renderer.xy.XYItemRenderer;
//
//import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
//
//import org.jfree.data.time.Month;
//
//import org.jfree.data.time.RegularTimePeriod;
//
//import org.jfree.data.time.TimeSeries;
//
//import org.jfree.data.time.TimeSeriesCollection;
//
//import org.jfree.data.xy.XYDataset;
//
//import org.jfree.ui.ApplicationFrame;
//
//import org.jfree.ui.RefineryUtilities;
//
//import lw.release.ChartBasePanel;
//
//
//
///**
//
//* 时间序列图:自定义序列线缩略图
//
//* 新增功能点：
//
//*   ① 自己手动绘制序列线的缩略图
//
//* @author 刘伟  2012-10-26
//
//* 楼主辛勤整理，无私免费提供给大家观看，体惜楼主辛苦，转载时请注明出处：http://lw2078.iteye.com/
//
//* */
//
//@SuppressWarnings("serial")
//
//public class TimeSeries07 extends ApplicationFrame {
//
//   public TimeSeries07(String title) {
//
//       super(title);
//
//       setContentPane(new TimeSeriesPanel());
//
//   }
//
//   public JPanel createDemoPanel() {
//
//       return new TimeSeriesPanel();
//
//   }
//
//   public static void main(String[] arg) {
//
//       TimeSeries07 timeSeries = new TimeSeries07("自定义序列线缩略图示例");
//
//       timeSeries.pack();
//
//       RefineryUtilities.centerFrameOnScreen(timeSeries);
//
//       timeSeries.setVisible(true);
//
//   }
//
//   /**
//
//    * 显示该Demo图表的容器
//
//    * ChartBasePanel类是Swing框架下所有例子共同使用的，这里不重复贴出
//
//    * 这个类源码在：http://lw2078.iteye.com/blog/1705637
//
//    * */
//
//   private class TimeSeriesPanel extends ChartBasePanel {
//
//       // 间隔定长时间(如年、月、日、时、分、秒等)的数据序列
//
//       private TimeSeries series;
//
//       private ChartPanel chartPanel;
//
//       // 创建一个JFreeChart时间序列图表
//
//       private JFreeChart chart = createChart();
//
//       public TimeSeriesPanel() {
//
//           super();
//
//           addChart(this.chart);   // 将此JFreeChart加入JFreeChart列表中
//
//           // 将JFreeChart放在专用的图表容器ChartPanel中
//
//           this.chartPanel = new ChartPanel(this.chart);
//
//           this.chartPanel.setPreferredSize(new Dimension(600, 250));
//
//           // 设置chartPanel容器边框
//
//           CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(
//
//                   BorderFactory.createEmptyBorder(4, 4,4, 4),
//
//                   BorderFactory.createEtchedBorder());
//
//           this.chartPanel.setBorder(compoundBorder);
//
//           // 将chartPanel加入到本容器中
//
//           add(this.chartPanel);
//
//       }
//
//       /**
//
//        * 创建jfreechart图表
//
//        * */
//
//       private JFreeChart createChart() {
//
//           // 生成图表集合
//
//           XYDataset xyDataset = createDataset();
//
//           // 增加汉字支持
//
//           //创建主题样式
//
//           StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
//
//           //设置标题字体
//
//           standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
//
//           //设置图例的字体
//
//           standardChartTheme.setRegularFont(new Font("SimSun",Font.PLAIN,15));
//
//           //设置轴向的字体
//
//           standardChartTheme.setLargeFont(new Font("宋体",Font.PLAIN,15));
//
//           ChartFactory.setChartTheme(standardChartTheme); //应用主题样式
//
//           // 创建一个时间序列图表的JFreeChart
//
//           JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart(
//
//                   "自定义序列线缩略图示例",  // 图表名
//
//                   "时间",               // 横轴标签文字
//
//                   "数值",               // 纵轴标签文字
//
//                   xyDataset,          // 图表的数据集合
//
//                   true,               // 是否显示图表中每条数据序列的说明
//
//                   false,              // 是否显示工具提示
//
//                   false);             // 是否显示图表中设置的url网络连接
//
//
//
//           // XYPlot图表区域的设置对象,用来设置图表的一些显示属性
//
//           XYPlot xyPlot = (XYPlot) jFreeChart.getPlot();
//
//           // 设置X时间轴按月显示，时间间隔为1个月
//
//           // DateAxis是X时间轴线的显示样式设置对象
//
//           DateAxis dateAxis=(DateAxis)xyPlot.getDomainAxis();
//
//           // 设置时间显示样式
//
//           SimpleDateFormat frm = new SimpleDateFormat("MM月");
//
//           // 设置显示时间间隔为1年
//
//           dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.MONTH, 1));
//
//
//
/////  新功能点 /
//
//           // 设置数据点和序列线的显示格式
//
//           XYItemRenderer r = xyPlot.getRenderer();
//
//           if (r instanceof XYLineAndShapeRenderer) {
//
//               XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
//
//               renderer.setBaseShapesVisible(false);   // 数据点不显示外框
//
//               renderer.setBaseShapesFilled(false);    // 点外框内不填充
//
//
//
//               // 自己进行绘制序列线的缩略图形
//
//               GeneralPath generalPath = new GeneralPath(); // 绘制图例
//
//               generalPath.moveTo(-6.0F, 0.0F);
//
//               generalPath.lineTo(-3.0F, 6.0F);
//
//               generalPath.lineTo(3.0F, -6.0F);
//
//               generalPath.lineTo(6.0F, 0.0F);
//
//               renderer.setLegendLine(generalPath);    // 应用自定义图例
//
//               // 让JFreeChart使用当前主题
//
//               ChartUtilities.applyCurrentTheme(jFreeChart);
//
//           }
//
//
//           return jFreeChart;
//
//       }
//
//
//
//       /**
//
//        * 创建jfreechart图表所用的数据集合
//
//        * @return
//
//        */
//
//       private XYDataset createDataset() {
//
//           // 生成数据序列
//
//           this.series = new TimeSeries("序列线");
//
//           // 以月为时间单位，从2011年1月开始，随机产生12个月的模拟数据
//
//           setSeriesData(series, 100, new Month(1,2011), 12);
//
//           // 将两条数据序列都放在一个数据集合中
//
//           TimeSeriesCollection dataset = new TimeSeriesCollection();
//
//           dataset.addSeries(this.series);
//
//           return dataset;
//
//       }
//
//
//
//       /**
//
//        * 随机生成数据,自动定位到时间序列上的下一个时间点，将新数据点加入到数据序列中
//
//        *
//
//        * @param series    数据序列对象
//
//        * @param baseData  生成的随机数据的基准值
//
//        * @param regularTime   定长的时间间隔(年、月、日、时、分、秒等)
//
//        * @param sampleNum  生成的数据点个数
//
//        */
//
//       private void setSeriesData(TimeSeries series, double baseData,
//
//               RegularTimePeriod regularTime, int sampleNum) {
//
//           // 生成随机模拟
//
//           double value = baseData;
//
//           for (int i = 0; i < sampleNum; i++) {
//
//               series.add(regularTime, value);
//
//               regularTime = regularTime.next();   //自动到下一个时间点
//
//               value *= (1.0D + (Math.random() - 0.495D) / 4.0D);
//
//           }
//
//       }
//
//   }
//
//}