package ece.edu.espe.cyberplaneta.view;

import com.itextpdf.text.DocumentException;
import ec.edu.espe.cyberplaneta.controller.PdfReport;
import ec.edu.espe.cyberplaneta.controller.TaxesAverageController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
 */
public class FrmCalculateAverageMonthlyTaxes extends javax.swing.JFrame {

    /**
     * Creates new form FrmCalculateAverageMonthlyTaxes
     */
    public FrmCalculateAverageMonthlyTaxes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCalcuteAverageMonthly = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmonthFebruary = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        monthSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtmonthJanuary = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmonthMarch = new javax.swing.JTextField();
        txtmonthApril = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtmonthMay = new javax.swing.JTextField();
        txtmonthJune = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtmonthJuly = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtmonthNovember = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtmonthOctober = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtmonthSeptember = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtmonthAugust = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtmonthDecember = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAverage = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelCAGRCalc = new javax.swing.JButton();
        btnCalculateCAGR = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlGraph = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnGenerateReportPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(null);

        jPanelCalcuteAverageMonthly.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCalcuteAverageMonthly.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Seleccione el número de meses a calcular:");
        jPanelCalcuteAverageMonthly.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txtmonthFebruary.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthFebruary, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 142, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("MES 2:");
        jPanelCalcuteAverageMonthly.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 142, -1, -1));

        monthSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));
        monthSpinner.setAutoscrolls(true);
        monthSpinner.setRequestFocusEnabled(false);
        monthSpinner.setVerifyInputWhenFocusTarget(false);
        monthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monthSpinnerStateChanged(evt);
            }
        });
        jPanelCalcuteAverageMonthly.add(monthSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 98, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("MES 1:");
        jPanelCalcuteAverageMonthly.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 108, -1, -1));

        txtmonthJanuary.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthJanuary, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 108, 100, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("MES 3:");
        jPanelCalcuteAverageMonthly.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 176, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("MES 4:");
        jPanelCalcuteAverageMonthly.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 210, -1, -1));

        txtmonthMarch.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthMarch, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 176, 100, -1));

        txtmonthApril.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthApril, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 210, 100, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("MES 5:");
        jPanelCalcuteAverageMonthly.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 244, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("MES 6:");
        jPanelCalcuteAverageMonthly.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 278, -1, -1));

        txtmonthMay.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthMay, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 244, 100, -1));

        txtmonthJune.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthJune, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 278, 100, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("MES 7:");
        jPanelCalcuteAverageMonthly.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 108, -1, -1));

        txtmonthJuly.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthJuly, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 108, 100, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("MES 11:");
        jPanelCalcuteAverageMonthly.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 244, -1, -1));

        txtmonthNovember.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthNovember, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 244, 100, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("MES 10:");
        jPanelCalcuteAverageMonthly.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 210, -1, -1));

        txtmonthOctober.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthOctober, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 210, 100, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("MES 9:");
        jPanelCalcuteAverageMonthly.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 176, -1, -1));

        txtmonthSeptember.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthSeptember, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 176, 100, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("MES 8:");
        jPanelCalcuteAverageMonthly.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 142, -1, -1));

        txtmonthAugust.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthAugust, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 142, 100, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setText("MES 12:");
        jPanelCalcuteAverageMonthly.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 278, -1, -1));

        txtmonthDecember.setEnabled(false);
        jPanelCalcuteAverageMonthly.add(txtmonthDecember, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 278, 100, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("Su promedio es:");
        jPanelCalcuteAverageMonthly.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        txtAverage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAverage.setForeground(new java.awt.Color(0, 0, 153));
        jPanelCalcuteAverageMonthly.add(txtAverage, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 134, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Ingrese el impuesto cobrado en:");
        jPanelCalcuteAverageMonthly.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 76, -1, -1));

        jPanel3.setBackground(new java.awt.Color(7, 81, 203));

        btnCancelCAGRCalc.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelCAGRCalc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelCAGRCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelCAGRCalc.setText("Cancelar");
        btnCancelCAGRCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCAGRCalcActionPerformed(evt);
            }
        });

        btnCalculateCAGR.setBackground(new java.awt.Color(159, 246, 70));
        btnCalculateCAGR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalculateCAGR.setForeground(new java.awt.Color(65, 109, 155));
        btnCalculateCAGR.setText("Calcular");
        btnCalculateCAGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateCAGRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnCancelCAGRCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalculateCAGR, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelCAGRCalc)
                    .addComponent(btnCalculateCAGR))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 81, 203));
        jLabel5.setText("Promedio de Impuestos");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 510, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2 - copia.jpg"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, -1, 100));

        pnlGraph.setBackground(new java.awt.Color(255, 255, 255));
        pnlGraph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 246, 70)));

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerateReportPdf.setBackground(new java.awt.Color(159, 246, 70));
        btnGenerateReportPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateReportPdf.setForeground(new java.awt.Color(7, 81, 203));
        btnGenerateReportPdf.setText("Exportar a PDF");
        btnGenerateReportPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportPdfActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerateReportPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCalcuteAverageMonthly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(pnlGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelCalcuteAverageMonthly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelCAGRCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCAGRCalcActionPerformed
        FrmMenu frmMenu= new FrmMenu();
        this.setVisible(false);
        frmMenu.setVisible(true);
    }//GEN-LAST:event_btnCancelCAGRCalcActionPerformed

    private void btnCalculateCAGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateCAGRActionPerformed
 JTextField[] monthFields = {
            txtmonthJanuary, txtmonthFebruary, txtmonthMarch,
            txtmonthApril, txtmonthMay, txtmonthJune,
            txtmonthJuly, txtmonthAugust, txtmonthSeptember,
            txtmonthOctober, txtmonthNovember, txtmonthDecember
    };
    int selectedMonth = (int) monthSpinner.getValue();
          
    String[] values = new String[selectedMonth];
    for (int i = 0; i < selectedMonth; i++) {
        values[i] = monthFields[i].getText();
    }
    
    try {
        TaxesAverageController taxesAverageController = new TaxesAverageController();    
        double average = taxesAverageController.calculateAverage(values);
        DecimalFormat df = new DecimalFormat("#.##");
        txtAverage.setText(df.format(average));
        createAndDisplayChart(selectedMonth, monthFields, average);
        clearFields();
        } catch (TaxesAverageController.InvalidInputException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de entrada", JOptionPane.ERROR_MESSAGE);
            monthFields[e.getErrorIndex()].setText("");
            monthFields[e.getErrorIndex()].requestFocus();
        }
          
    }
 private void createAndDisplayChart(int selectedMonth, JTextField[] monthFields, double average) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 1; i <= selectedMonth; i++) {
            String label = "Impuesto " + i;
            double impuestoValue = Double.parseDouble(monthFields[i - 1].getText());
            data.setValue(impuestoValue, label, "Impuesto " + i);
        }
        data.setValue(average, "Promedio", "Promedio");

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Promedio de Impuestos",
                "Impuestos",
                "Valor en dólares ($)",
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

        pnlGraph.removeAll();
        pnlGraph.setLayout(new BorderLayout());
        pnlGraph.add(panel, BorderLayout.CENTER);
        pnlGraph.revalidate();
        pnlGraph.repaint();
    }

 private void updateTextFields(int selectedMonth) {
        txtmonthJanuary.setEnabled(selectedMonth >= 1);
        txtmonthFebruary.setEnabled(selectedMonth >= 2);
        txtmonthMarch.setEnabled(selectedMonth >= 3);
        txtmonthApril.setEnabled(selectedMonth >= 4);
        txtmonthMay.setEnabled(selectedMonth >= 5);
        txtmonthJune.setEnabled(selectedMonth >= 6);
        txtmonthJuly.setEnabled(selectedMonth >= 7);
        txtmonthAugust.setEnabled(selectedMonth >= 8);
        txtmonthSeptember.setEnabled(selectedMonth >= 9);
        txtmonthOctober.setEnabled(selectedMonth >= 10);
        txtmonthNovember.setEnabled(selectedMonth >= 11);
        txtmonthDecember.setEnabled(selectedMonth >= 12);
}

private void clearFields() {
    JTextField[] monthFields = {
        txtmonthJanuary, txtmonthFebruary, txtmonthMarch, 
        txtmonthApril, txtmonthMay, txtmonthJune, 
        txtmonthJuly, txtmonthAugust, txtmonthSeptember, 
        txtmonthOctober, txtmonthNovember, txtmonthDecember
    };

    for (JTextField field : monthFields) {
        field.setText("");
    }
}

private double calcularCAGR(double valorInicial, double valorFinal, int años) {
    return Math.pow(valorFinal / valorInicial, 1.0 / años) - 1;
    }//GEN-LAST:event_btnCalculateCAGRActionPerformed

    private void monthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monthSpinnerStateChanged
         int selectedMonth = (int) monthSpinner.getValue();
        updateTextFields(selectedMonth);
    }//GEN-LAST:event_monthSpinnerStateChanged

    private void btnGenerateReportPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportPdfActionPerformed
        JFreeChart currentChart = (JFreeChart) ((ChartPanel) pnlGraph.getComponent(0)).getChart();

        PdfReport pdfReport = new PdfReport();
        try {
            pdfReport.exportChartToPDF(currentChart);
        } catch (IOException | DocumentException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerateReportPdfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateAverageMonthlyTaxes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateAverageMonthlyTaxes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateAverageMonthlyTaxes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateAverageMonthlyTaxes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCalculateAverageMonthlyTaxes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateCAGR;
    private javax.swing.JButton btnCancelCAGRCalc;
    private javax.swing.JButton btnGenerateReportPdf;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCalcuteAverageMonthly;
    private javax.swing.JSpinner monthSpinner;
    private javax.swing.JPanel pnlGraph;
    private javax.swing.JTextField txtAverage;
    private javax.swing.JTextField txtmonthApril;
    private javax.swing.JTextField txtmonthAugust;
    private javax.swing.JTextField txtmonthDecember;
    private javax.swing.JTextField txtmonthFebruary;
    private javax.swing.JTextField txtmonthJanuary;
    private javax.swing.JTextField txtmonthJuly;
    private javax.swing.JTextField txtmonthJune;
    private javax.swing.JTextField txtmonthMarch;
    private javax.swing.JTextField txtmonthMay;
    private javax.swing.JTextField txtmonthNovember;
    private javax.swing.JTextField txtmonthOctober;
    private javax.swing.JTextField txtmonthSeptember;
    // End of variables declaration//GEN-END:variables

}
