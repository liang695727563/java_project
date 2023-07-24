//package com.example.echart.demo;
//
//public class EChartOptionUtil{
//
//// 折线图
//
//public static String getLineNumOption(String title, Listlegend,
//
//ListxAxis, Listseries) {
//
//String legendStr = "";
//
//for (int i = 0; i < legend.size(); i++) {
//
//if (i != 0) {
//
//legendStr = legendStr + ",";
//
//}
//
//legendStr = legendStr + "'" + legend.get(i) + "'";
//
//}
//
//String xAxisStr = "";
//
//for (int i = 0; i < xAxis.size(); i++) {
//
//if (i != 0) {
//
//xAxisStr = xAxisStr + ",";
//
//}
//
//xAxisStr = xAxisStr + "'" + xAxis.get(i) + "'";
//
//}
//
//String yDataStr = "";
//
//for (int i = 0; i < legend.size(); i++) {
//
//if (i != 0) {
//
//yDataStr = yDataStr + ",";
//
//}
//
//yDataStr = yDataStr
//
//+ "{name:'"
//
//+ legend.get(i)
//
//+ "',type:'line',smooth: true,itemStyle: {normal: {label : {show:true,position:'top',formatter:'{c} %'}}},data:["
//
//+ series.get(i) + "]}";
//
//}
//
//String str = "{title: {text: '"
//
//+ title
//
//+ "'},"
//
//+ "tooltip : {trigger: 'axis' },"
//
//+ "legend: {data:["
//
//+ legendStr
//
//+ "]},"
//
//+ "toolbox: {feature: { show: true,saveAsImage: {show: true}}},"
//
//+ "xAxis : [{boundaryGap : false,data : ["
//
//+ xAxisStr
//
//+ "]}],"
//
//+ "yAxis : {type : 'value',axisLabel: {show: true,interval: 'auto',formatter: '{value} %'}},"
//
//+ "series : [" + yDataStr + "]}";
//
//return str;
//
//}
//
//}