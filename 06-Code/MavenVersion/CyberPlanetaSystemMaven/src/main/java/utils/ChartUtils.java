package utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Saray Cañarte
 */

public class ChartUtils {

    public static void createAndDisplayChart(JPanel targetPanel, DefaultCategoryDataset data, String title, String xAxisLabel, String yAxisLabel) {
        JFreeChart barChart = ChartFactory.createBarChart3D(
                title,
                xAxisLabel,
                yAxisLabel,
                data,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false);

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setItemLabelAnchorOffset(10.0);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));

        ChartPanel panel = new ChartPanel(barChart);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(new Dimension(420, 355));

        targetPanel.removeAll();
        targetPanel.setLayout(new BorderLayout());
        targetPanel.add(panel, BorderLayout.CENTER);
        targetPanel.revalidate();
        targetPanel.repaint();
    }
}