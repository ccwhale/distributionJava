package com.xingxi.jfree;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xingxi
 * @date 2019-04-02 22:18:13 星期二
 */
public class JfreeTest {


    /**
     * 创建JFreeChart Line Chart（折线图）
     */
    public static void main(String[] args) {
        // 步骤1：创建CategoryDataset对象（准备数据）
        CategoryDataset dataset = createDataset1();
        // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
        JFreeChart freeChart = createChart(dataset);
        // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
        saveAsFile(freeChart, "/Users/cc/Desktop/1.jpg", 2500, 800);
    }

    // 保存为文件
    public static void saveAsFile(JFreeChart chart, String outputPath,
                                  int weight, int height) {
        FileOutputStream out = null;
        try {
            File outFile = new File(outputPath);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(outputPath);
            // 保存为PNG
            // ChartUtilities.writeChartAsPNG(out, chart, 600, 400);
            // 保存为JPEG
            ChartUtilities.writeChartAsJPEG(out, chart, 2500, 800);
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

    // 根据CategoryDataset创建JFreeChart对象
    public static JFreeChart createChart(CategoryDataset categoryDataset) {
        //创建主题样式
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        //设置标题字体
        mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
        //设置轴向字体
        mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        //设置图例字体
        mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        //应用主题样式
        ChartFactory.setChartTheme(mChartTheme);
        // 创建JFreeChart对象：ChartFactory.createLineChart
        JFreeChart jfreechart = ChartFactory.createLineChart("发货量", // 标题
                "时间段", // categoryAxisLabel （category轴，横轴，X轴标签）
                "小时", // valueAxisLabel（value轴，纵轴，Y轴的标签）
                categoryDataset, // dataset
                PlotOrientation.VERTICAL, true, // legend
                false, // tooltips
                false); // URLs
        // 使用CategoryPlot设置各种参数。以下设置可以省略。
        CategoryPlot plot = (CategoryPlot) jfreechart.getPlot();
        // 背景色 透明度
        plot.setBackgroundAlpha(0.5f);
        // 前景色 透明度
        plot.setForegroundAlpha(0.5f);
        // 其他设置 参考 CategoryPlot类
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
        renderer.setUseSeriesOffset(true); // 设置偏移量
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        return jfreechart;
    }

    /**
     * 创建CategoryDataset对象
     *
     */
    public static CategoryDataset createDataset() {
//        String[] rowKeys = {"统计天:"};
//        String[] colKeys = {"0:00", "1:00", "2:00", "7:00", "8:00", "9:00",
//                "10:00", "11:00", "12:00", "13:00", "16:00", "20:00", "21:00",
//                "23:00"};
//        double[][] data = {{4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, 1, 1},};
        // 或者使用类似以下代码
        // DefaultCategoryDataset categoryDataset = new
        // DefaultCategoryDataset();
        // categoryDataset.addValue(10, "rowKey", "colKey");
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        mDataset.addValue(36, "3.31", "0:00");
        mDataset.addValue(17, "3.31", "1:00");
        mDataset.addValue(11, "3.31", "2:00");
        mDataset.addValue(8, "3.31", "3:00");
        mDataset.addValue(6, "3.31", "4:00");
        mDataset.addValue(3, "3.31", "5:00");
        mDataset.addValue(11, "3.31", "6:00");
        mDataset.addValue(42, "3.31", "7:00");
        mDataset.addValue(190, "3.31", "8:00");
        mDataset.addValue(330, "3.31", "9:00");
        mDataset.addValue(313, "3.31", "10:00");
        mDataset.addValue(268, "3.31", "11:00");
        mDataset.addValue(222, "3.31", "12:00");
        mDataset.addValue(289, "3.31", "13:00");
        mDataset.addValue(288, "3.31", "14:00");
        mDataset.addValue(242, "3.31", "15:00");
        mDataset.addValue(227, "3.31", "16:00");
        mDataset.addValue(201, "3.31", "17:00");
        mDataset.addValue(145, "3.31", "18:00");
        mDataset.addValue(108, "3.31", "19:00");
        mDataset.addValue(94, "3.31", "20:00");
        mDataset.addValue(70, "3.31", "21:00");
        mDataset.addValue(66, "3.31", "22:00");
        mDataset.addValue(56, "3.31", "23:00");



        mDataset.addValue(36, "4.1", "0:00");
        mDataset.addValue(20, "4.1", "1:00");
        mDataset.addValue(13, "4.1", "2:00");
        mDataset.addValue(8, "4.1", "3:00");
        mDataset.addValue(6, "4.1", "4:00");
        mDataset.addValue(3, "4.1", "5:00");
        mDataset.addValue(8, "4.1", "6:00");
        mDataset.addValue(41, "4.1", "7:00");
        mDataset.addValue(185, "4.1", "8:00");
        mDataset.addValue(384, "4.1", "9:00");
        mDataset.addValue(325, "4.1", "10:00");
        mDataset.addValue(245, "4.1", "11:00");
        mDataset.addValue(208, "4.1", "12:00");
        mDataset.addValue(305, "4.1", "13:00");
        mDataset.addValue(280, "4.1", "14:00");
        mDataset.addValue(247, "4.1", "15:00");
        mDataset.addValue(237, "4.1", "16:00");
        mDataset.addValue(208, "4.1", "17:00");
        mDataset.addValue(151, "4.1", "18:00");
        mDataset.addValue(107, "4.1", "19:00");
        mDataset.addValue(98, "4.1", "20:00");
        mDataset.addValue(81, "4.1", "21:00");
        mDataset.addValue(67, "4.1", "22:00");
        mDataset.addValue(59, "4.1", "23:00");

        //return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
        return mDataset;
    }


    /**
     * 创建CategoryDataset对象
     *
     */
    public static CategoryDataset createDataset1() {
//        String[] rowKeys = {"统计天:"};
//        String[] colKeys = {"0:00", "1:00", "2:00", "7:00", "8:00", "9:00",
//                "10:00", "11:00", "12:00", "13:00", "16:00", "20:00", "21:00",
//                "23:00"};
//        double[][] data = {{4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, 1, 1},};
        // 或者使用类似以下代码
        // DefaultCategoryDataset categoryDataset = new
        // DefaultCategoryDataset();
        // categoryDataset.addValue(10, "rowKey", "colKey");
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        mDataset.addValue(360107, "3.31", "0:00");
        mDataset.addValue(169726, "3.31", "1:00");
        mDataset.addValue(114543, "3.31", "2:00");
        mDataset.addValue(79419, "3.31", "3:00");
        mDataset.addValue(54537, "3.31", "4:00");
        mDataset.addValue(37816, "3.31", "5:00");
        mDataset.addValue(108759, "3.31", "6:00");
        mDataset.addValue(394724, "3.31", "7:00");
        mDataset.addValue(1854966, "3.31", "8:00");
        mDataset.addValue(3151705, "3.31", "9:00");
        mDataset.addValue(3035104, "3.31", "10:00");
        mDataset.addValue(2475302, "3.31", "11:00");
        mDataset.addValue(2165857, "3.31", "12:00");
        mDataset.addValue(2775507, "3.31", "13:00");
        mDataset.addValue(2620697, "3.31", "14:00");
        mDataset.addValue(2427749, "3.31", "15:00");
        mDataset.addValue(2320286, "3.31", "16:00");
        mDataset.addValue(1900933, "3.31", "17:00");
        mDataset.addValue(1318051, "3.31", "18:00");
        mDataset.addValue(1092583, "3.31", "19:00");
        mDataset.addValue(907216, "3.31", "20:00");
        mDataset.addValue(805279, "3.31", "21:00");
        mDataset.addValue(698683, "3.31", "22:00");
        mDataset.addValue(592224, "3.31", "23:00");



        mDataset.addValue(358880, "4.1", "0:00");
        mDataset.addValue(205524, "4.1", "1:00");
        mDataset.addValue(120747, "4.1", "2:00");
        mDataset.addValue(85131, "4.1", "3:00");
        mDataset.addValue(57906, "4.1", "4:00");
        mDataset.addValue(30326, "4.1", "5:00");
        mDataset.addValue(79347, "4.1", "6:00");
        mDataset.addValue(394724, "4.1", "7:00");
        mDataset.addValue(1812302, "4.1", "8:00");
        mDataset.addValue(3205638, "4.1", "9:00");
        mDataset.addValue(3124960, "4.1", "10:00");
        mDataset.addValue(2519160, "4.1", "11:00");
        mDataset.addValue(2202058, "4.1", "12:00");
        mDataset.addValue(2939810, "4.1", "13:00");
        mDataset.addValue(2732747, "4.1", "14:00");
        mDataset.addValue(2492125, "4.1", "15:00");
        mDataset.addValue(2443816, "4.1", "16:00");
        mDataset.addValue(1970912, "4.1", "17:00");
        mDataset.addValue(1368721, "4.1", "18:00");
        mDataset.addValue(1072726, "4.1", "19:00");
        mDataset.addValue(954849, "4.1", "20:00");
        mDataset.addValue(828056, "4.1", "21:00");
        mDataset.addValue(730985, "4.1", "22:00");
        mDataset.addValue(602905, "4.1", "23:00");

        //return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
        return mDataset;
    }
}
