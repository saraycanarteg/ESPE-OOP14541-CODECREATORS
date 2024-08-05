package ece.edu.espe.cyberplaneta.view;

import ec.edu.espe.cyberplaneta.controller.PricingSystemManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class FrmCalculateCAGR extends javax.swing.JFrame {
    private static final ImageIcon WARNING_ICON = new ImageIcon(FrmCalculateCAGR.class.getResource("/images/triangle-warning.png"));
    /**
     * Creates new form FrmCalculateCAGR
     */
    public FrmCalculateCAGR() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnCalculateCAGR = new javax.swing.JButton();
        btnCancelCAGRCalc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sldCAGRYears = new javax.swing.JSlider();
        txtInitialIncome = new javax.swing.JTextField();
        txtFinalIncome = new javax.swing.JTextField();
        lblNumberOfYears = new javax.swing.JLabel();
        lblInvalidIncome1 = new javax.swing.JLabel();
        lblInvalidIncome2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlGraph = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 490));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(880, 190));

        jPanel5.setBackground(new java.awt.Color(7, 81, 203));

        btnCalculateCAGR.setBackground(new java.awt.Color(159, 246, 70));
        btnCalculateCAGR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalculateCAGR.setForeground(new java.awt.Color(7, 81, 203));
        btnCalculateCAGR.setText("Calcular");
        btnCalculateCAGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateCAGRActionPerformed(evt);
            }
        });

        btnCancelCAGRCalc.setBackground(new java.awt.Color(255, 101, 98));
        btnCancelCAGRCalc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelCAGRCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelCAGRCalc.setText("Cancelar");
        btnCancelCAGRCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCAGRCalcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnCancelCAGRCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalculateCAGR, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelCAGRCalc)
                    .addComponent(btnCalculateCAGR))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 81, 203));
        jLabel2.setText("Número de Años a Proyectar:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(7, 81, 203));
        jLabel3.setText("Ingresos año inicial:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(7, 81, 203));
        jLabel4.setText("Ingresos año final:");

        sldCAGRYears.setMaximum(10);
        sldCAGRYears.setMinimum(1);
        sldCAGRYears.setToolTipText("");
        sldCAGRYears.setValue(1);
        sldCAGRYears.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldCAGRYearsStateChanged(evt);
            }
        });

        txtInitialIncome.setToolTipText("Ingrese valor de dinero. Ejemplo: 100.34");
        txtInitialIncome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInitialIncomeFocusLost(evt);
            }
        });
        txtInitialIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInitialIncomeActionPerformed(evt);
            }
        });

        txtFinalIncome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFinalIncomeFocusLost(evt);
            }
        });
        txtFinalIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalIncomeActionPerformed(evt);
            }
        });

        lblNumberOfYears.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumberOfYears.setForeground(new java.awt.Color(7, 81, 203));
        lblNumberOfYears.setText("1");

        lblInvalidIncome1.setForeground(new java.awt.Color(255, 0, 0));

        lblInvalidIncome2.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(7, 81, 203));
        jLabel8.setText("$");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(7, 81, 203));
        jLabel9.setText("$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(sldCAGRYears, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumberOfYears))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(111, 111, 111)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtInitialIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInvalidIncome1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(121, 121, 121)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtFinalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInvalidIncome2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumberOfYears)
                            .addComponent(sldCAGRYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtInitialIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblInvalidIncome1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInvalidIncome2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtFinalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 880, 200));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 81, 203));
        jLabel1.setText("Cálculo de CAGR ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 290, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 81, 203));
        jLabel7.setText("Proyección de Ingresos");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2 - copia.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, -1, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 920, 100));

        pnlGraph.setBackground(new java.awt.Color(159, 246, 70));

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        jPanel1.add(pnlGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 880, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelCAGRCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCAGRCalcActionPerformed
            FrmMenu frmMenu= new FrmMenu();
            this.setVisible(false);
            frmMenu.setVisible(true);
    }//GEN-LAST:event_btnCancelCAGRCalcActionPerformed

    private void txtInitialIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInitialIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInitialIncomeActionPerformed

    private void txtFinalIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalIncomeActionPerformed

    private void sldCAGRYearsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldCAGRYearsStateChanged
        lblNumberOfYears.setText(String.valueOf(sldCAGRYears.getValue()));
    }//GEN-LAST:event_sldCAGRYearsStateChanged

    private void txtInitialIncomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInitialIncomeFocusLost
        try {
            String text = txtInitialIncome.getText();
            if (!text.matches("\\d+(\\.\\d{1,2})?")) {
                lblInvalidIncome1.setIcon(WARNING_ICON);
                lblInvalidIncome1.setText("<html>Error: El ingreso no puede ser negativo");
            }

            float initialIncome = Float.parseFloat(text);

            if (initialIncome < 0) {
                lblInvalidIncome1.setIcon(WARNING_ICON);
                lblInvalidIncome1.setText("<html>Error: El ingreso no puede ser negativo");
            } else {
                lblInvalidIncome1.setIcon(null);
                lblInvalidIncome1.setText(null);
            }
        } catch (NumberFormatException e) {
            lblInvalidIncome1.setIcon(WARNING_ICON);
            lblInvalidIncome1.setText("<html>Error: Ingrese un número válido en formato de dinero (ejemplo: 123.45)");
        }
    }//GEN-LAST:event_txtInitialIncomeFocusLost

    private void txtFinalIncomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFinalIncomeFocusLost
        try {
            String text = txtInitialIncome.getText();
            if (!text.matches("\\d+(\\.\\d{1,2})?")) {
                lblInvalidIncome2.setIcon(WARNING_ICON);
                lblInvalidIncome2.setText("<html>Error: El ingreso no puede ser negativo");
            }

            float initialIncome = Float.parseFloat(text);

            if (initialIncome < 0) {
                lblInvalidIncome2.setIcon(WARNING_ICON);
                lblInvalidIncome2.setText("<html>Error: El ingreso no puede ser negativo");
            } else {
                lblInvalidIncome2.setIcon(null);
                lblInvalidIncome2.setText(null);
            }
        } catch (NumberFormatException e) {
            lblInvalidIncome2.setIcon(WARNING_ICON);
            lblInvalidIncome2.setText("<html>Error: Ingrese un número válido en formato de dinero (ejemplo: 123.45)");
        }
    }//GEN-LAST:event_txtFinalIncomeFocusLost

    private void btnCalculateCAGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateCAGRActionPerformed
        if (lblInvalidIncome1.getText() != null && !lblInvalidIncome1.getText().isEmpty()
                || lblInvalidIncome2.getText() != null && !lblInvalidIncome2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: No se puede continuar con el cálculo hasta corregir los campos señalados", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            float initialIncome = Float.parseFloat(txtInitialIncome.getText());
            float finalIncome = Float.parseFloat(txtFinalIncome.getText());
            int years = sldCAGRYears.getValue();

            if (initialIncome < 0 || finalIncome < 0) {
                JOptionPane.showMessageDialog(this, "Error: Los valores de ingreso no pueden ser negativos", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double cagr = PricingSystemManager.calculateCAGR(initialIncome, finalIncome, years);
            double projectedIncome = PricingSystemManager.calculateFutureValue(finalIncome, cagr, years);

            generateChart(initialIncome, finalIncome, projectedIncome);

            String resultMessage = String.format(
                    "Resultado del cálculo CAGR:\n\n"
                    + "Ingreso Inicial: $%.2f\n"
                    + "Ingreso Final: $%.2f\n"
                    + "Años de Proyección: %d\n"
                    + "Ingreso Proyectado: $%.2f\n"
                    + "Porcentaje de CAGR: %.2f%%",
                    initialIncome, finalIncome, years, projectedIncome, cagr
            );

            JOptionPane.showMessageDialog(this, resultMessage, "Resultado CAGR", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Asegúrese de ingresar valores numéricos válidos", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCalculateCAGRActionPerformed
private void generateChart(double initialIncome, double finalIncome, double projectedIncome) {
    DefaultCategoryDataset data = new DefaultCategoryDataset();
    data.setValue(initialIncome, "Ingreso Inicial", "Inicial");
    data.setValue(finalIncome, "Ingreso Final", "Final");
    data.setValue(projectedIncome, "Ingreso Proyectado", "Proyectado");
    
    JFreeChart barChart = ChartFactory.createBarChart3D(
            "Proyección de Ingresos",
            "Tipo de Ingreso",
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
    panel.setPreferredSize(new Dimension(100, 500));
    
    pnlGraph.removeAll();
    pnlGraph.setLayout(new BorderLayout());
    pnlGraph.add(panel, BorderLayout.CENTER);
    
    pnlGraph.revalidate();
    pnlGraph.repaint();
}
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
            java.util.logging.Logger.getLogger(FrmCalculateCAGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateCAGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateCAGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCalculateCAGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCalculateCAGR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateCAGR;
    private javax.swing.JButton btnCancelCAGRCalc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblInvalidIncome1;
    private javax.swing.JLabel lblInvalidIncome2;
    private javax.swing.JLabel lblNumberOfYears;
    private javax.swing.JPanel pnlGraph;
    private javax.swing.JSlider sldCAGRYears;
    private javax.swing.JTextField txtFinalIncome;
    private javax.swing.JTextField txtInitialIncome;
    // End of variables declaration//GEN-END:variables
}
