package com.chendehe.util.jfreechart.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import javax.annotation.PostConstruct;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.ui.RectangleInsets;

public class DefaultTheme {

  private static final Font FONT = new Font("宋体", Font.PLAIN, 12);
  private static final Color[] CHART_COLORS = {
      new Color(31, 129, 188), new Color(92, 92, 97), new Color(144, 237, 125),
      new Color(255, 188, 117),
      new Color(153, 158, 255), new Color(255, 117, 153), new Color(253, 236, 109),
      new Color(128, 133, 232),
      new Color(158, 90, 102), new Color(255, 204, 102)};// 颜色

  private DefaultTheme() {

  }

  public static void initTheme() {
    setChartTheme();
  }

  /**
   * 中文主题样式 解决乱码
   */
  private static void setChartTheme() {
    // 设置中文主题样式 解决乱码
    StandardChartTheme chartTheme = new StandardChartTheme("CN");
    // 设置标题字体
    chartTheme.setExtraLargeFont(FONT);
    // 设置图例的字体
    chartTheme.setRegularFont(FONT);
    // 设置轴向的字体
    chartTheme.setLargeFont(FONT);
    chartTheme.setSmallFont(FONT);
    chartTheme.setTitlePaint(new Color(51, 51, 51));
    chartTheme.setSubtitlePaint(new Color(85, 85, 85));

    chartTheme.setLegendBackgroundPaint(Color.WHITE);// 设置标注
    chartTheme.setLegendItemPaint(Color.BLACK);//
    chartTheme.setChartBackgroundPaint(Color.WHITE);
    // 绘制颜色绘制颜色.轮廓供应商
    // paintSequence,outlinePaintSequence,strokeSequence,outlineStrokeSequence,shapeSequence

    Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.WHITE};
    // 绘制器颜色源
    DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(CHART_COLORS, CHART_COLORS,
        OUTLINE_PAINT_SEQUENCE,
        DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
        DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
        DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
    chartTheme.setDrawingSupplier(drawingSupplier);

    chartTheme.setPlotBackgroundPaint(Color.WHITE);// 绘制区域
    chartTheme.setPlotOutlinePaint(Color.WHITE);// 绘制区域外边框
    chartTheme.setLabelLinkPaint(new Color(8, 55, 114));// 链接标签颜色
    chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);

    chartTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
    chartTheme.setDomainGridlinePaint(new Color(192, 208, 224));// X坐标轴垂直网格颜色
    chartTheme.setRangeGridlinePaint(new Color(192, 192, 192));// Y坐标轴水平网格颜色

    chartTheme.setBaselinePaint(Color.WHITE);
    chartTheme.setCrosshairPaint(Color.BLUE);// 不确定含义
    chartTheme.setAxisLabelPaint(new Color(51, 51, 51));// 坐标轴标题文字颜色
    chartTheme.setTickLabelPaint(new Color(67, 67, 72));// 刻度数字
    chartTheme.setBarPainter(new StandardBarPainter());// 设置柱状图渲染
    chartTheme.setXYBarPainter(new StandardXYBarPainter());// XYBar 渲染

    chartTheme.setItemLabelPaint(Color.black);
    chartTheme.setThermometerPaint(Color.white);// 温度计

    ChartFactory.setChartTheme(chartTheme);
  }

}
