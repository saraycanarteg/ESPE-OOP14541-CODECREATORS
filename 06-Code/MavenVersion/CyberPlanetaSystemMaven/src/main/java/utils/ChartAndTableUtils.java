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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Saray Cañarte
 */

public class ChartAndTableUtils {

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
    
    public static void customizeTableHeader(JTable table) {
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setForeground(new Color(255, 255, 255));
        header.setBackground(new Color(7, 81, 203));
        
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(7, 81, 203));
                c.setForeground(Color.WHITE);
                c.setFont(c.getFont().deriveFont(Font.BOLD));
                return c;
            }
        });
    }
    
}