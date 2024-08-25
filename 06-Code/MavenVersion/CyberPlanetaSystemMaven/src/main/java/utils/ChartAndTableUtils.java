package utils;

import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import javax.swing.table.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public void sortTablebyAlphabeticalOrder(DefaultTableModel model, int columnIndex, String selectedOrder) {
        if (model.getRowCount() > 1) {
            List<Object[]> rowData = new ArrayList<>();
            Object[] totalRow = model.getDataVector().lastElement().toArray();

            for (int i = 0; i < model.getRowCount() - 1; i++) {
                Object[] row = new Object[model.getColumnCount()];
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row[j] = model.getValueAt(i, j);
                }
                rowData.add(row);
            }

            rowData.sort((row1, row2) -> {
                String name1 = (String) row1[columnIndex];
                String name2 = (String) row2[columnIndex];

                if (selectedOrder.equals("A-Z")) {
                    return name1.compareTo(name2);
                } else if (selectedOrder.equals("Z-A")) {
                    return name2.compareTo(name1);
                }
                return 0;
            });

            model.setRowCount(0);
            for (Object[] row : rowData) {
                model.addRow(row);
            }
            model.addRow(totalRow);
        }
    }

    public void sortTableByNumericalOrder(DefaultTableModel model, int columnIndex, String selectedOrder) {
        if (model.getRowCount() > 1) {
            List<Object[]> rowData = new ArrayList<>();
            Object[] totalRow = new Object[model.getColumnCount()];

            if (model.getRowCount() > 0) {
                totalRow = model.getDataVector().get(model.getRowCount() - 1).toArray();
            }

            for (int i = 0; i < model.getRowCount() - 1; i++) {
                Object[] row = new Object[model.getColumnCount()];
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row[j] = model.getValueAt(i, j);
                }
                rowData.add(row);
            }
                rowData.sort((row1, row2) -> {
                Double value1 = parseDouble(row1[columnIndex]);
                Double value2 = parseDouble(row2[columnIndex]);

                if (selectedOrder.equals("Mayor a Menor")) {
                    return value2.compareTo(value1);
                } else if (selectedOrder.equals("Menor a Mayor")) {
                    return value1.compareTo(value2);
                }
                return 0;
            });

            model.setRowCount(0);
            for (Object[] row : rowData) {
                model.addRow(row);
            }
            if (totalRow != null) {
                model.addRow(totalRow);
            }
        }
    }

private Double parseDouble(Object value) {
        try {
            return Double.parseDouble(value.toString().replace(",", ""));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

}
