package ece.edu.espe.cyberplaneta.view;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        txtmonthAgoust = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(null);

        jPanelCalcuteAverageMonthly.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Seleccione el número de meses a calcular:");

        txtmonthFebruary.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("MES 2:");

        monthSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));
        monthSpinner.setAutoscrolls(true);
        monthSpinner.setRequestFocusEnabled(false);
        monthSpinner.setVerifyInputWhenFocusTarget(false);
        monthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                monthSpinnerStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("MES 1:");

        txtmonthJanuary.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("MES 3:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("MES 4:");

        txtmonthMarch.setEnabled(false);

        txtmonthApril.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("MES 5:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("MES 6:");

        txtmonthMay.setEnabled(false);

        txtmonthJune.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("MES 7:");

        txtmonthJuly.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("MES 11:");

        txtmonthNovember.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("MES 10:");

        txtmonthOctober.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("MES 9:");

        txtmonthSeptember.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("MES 8:");

        txtmonthAgoust.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setText("MES 12:");

        txtmonthDecember.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("Su promedio es:");

        txtAverage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAverage.setForeground(new java.awt.Color(0, 0, 153));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Ingrese el impuesto cobrado en:");

        javax.swing.GroupLayout jPanelCalcuteAverageMonthlyLayout = new javax.swing.GroupLayout(jPanelCalcuteAverageMonthly);
        jPanelCalcuteAverageMonthly.setLayout(jPanelCalcuteAverageMonthlyLayout);
        jPanelCalcuteAverageMonthlyLayout.setHorizontalGroup(
            jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(370, 370, 370))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtmonthJanuary, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtmonthFebruary, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtmonthMarch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtmonthMay, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtmonthApril, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtmonthJune, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmonthNovember, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmonthDecember, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtmonthAgoust, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmonthSeptember, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtmonthOctober, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtmonthJuly, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(199, 199, 199))
                    .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelCalcuteAverageMonthlyLayout.setVerticalGroup(
            jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtmonthJanuary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmonthFebruary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtmonthMarch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtmonthApril, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtmonthMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtmonthJune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanelCalcuteAverageMonthlyLayout.createSequentialGroup()
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtmonthJuly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtmonthAgoust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtmonthSeptember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtmonthOctober, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtmonthNovember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelCalcuteAverageMonthlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtmonthDecember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

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
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 81, 203));
        jLabel5.setText("Promedio de Impuestos");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 510, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2 - copia.jpg"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, -1, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanelCalcuteAverageMonthly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCalcuteAverageMonthly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        int selectedMonth = (int) monthSpinner.getValue();

        double average = calculateAverage(selectedMonth);

        txtAverage.setText(String.format("%.2f", average));

        clearFields();
    }

    private void updateTextFields(int selectedMonth) {
        txtmonthJanuary.setEnabled(selectedMonth >= 1);
        txtmonthFebruary.setEnabled(selectedMonth >= 2);
        txtmonthMarch.setEnabled(selectedMonth >= 3);
        txtmonthApril.setEnabled(selectedMonth >= 4);
        txtmonthMay.setEnabled(selectedMonth >= 5);
        txtmonthJune.setEnabled(selectedMonth >= 6);
        txtmonthJuly.setEnabled(selectedMonth >= 7);
        txtmonthAgoust.setEnabled(selectedMonth >= 8);
        txtmonthSeptember.setEnabled(selectedMonth >= 9);
        txtmonthOctober.setEnabled(selectedMonth >= 10);
        txtmonthNovember.setEnabled(selectedMonth >= 11);
        txtmonthDecember.setEnabled(selectedMonth >= 12);
    }

    private double calculateAverage(int selectedMonth) {
        double sum = 0;
        int count = 0;

        JTextField[] monthFields = {
            txtmonthJanuary, txtmonthFebruary, txtmonthMarch,
            txtmonthApril, txtmonthMay, txtmonthJune,
            txtmonthJuly, txtmonthAgoust, txtmonthSeptember,
            txtmonthOctober, txtmonthNovember, txtmonthDecember
        };

        for (int i = 0; i < selectedMonth; i++) {
            sum += getValidatedValue(monthFields[i]);
            count++;
        }

        return count == 0 ? 0 : sum / count;
    }


private double getValidatedValue(JTextField textField) {
    String text = textField.getText().replace(",", "");
    if (text.isEmpty()) {
        return 0; 
    }
    if (!text.matches("\\d+(\\.\\d+)?")) { 
        JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        textField.setText(""); 
        return 0; 
    }
    return Double.parseDouble(text);
}

private void clearFields() {
    JTextField[] monthFields = {
        txtmonthJanuary, txtmonthFebruary, txtmonthMarch, 
        txtmonthApril, txtmonthMay, txtmonthJune, 
        txtmonthJuly, txtmonthAgoust, txtmonthSeptember, 
        txtmonthOctober, txtmonthNovember, txtmonthDecember
    };

    for (JTextField field : monthFields) {
        field.setText("");
    }
}

// Método para calcular el CAGR
private double calcularCAGR(double valorInicial, double valorFinal, int años) {
    return Math.pow(valorFinal / valorInicial, 1.0 / años) - 1;
    }//GEN-LAST:event_btnCalculateCAGRActionPerformed

    private void monthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_monthSpinnerStateChanged
         int selectedMonth = (int) monthSpinner.getValue();
        updateTextFields(selectedMonth);
    }//GEN-LAST:event_monthSpinnerStateChanged

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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCalcuteAverageMonthly;
    private javax.swing.JSpinner monthSpinner;
    private javax.swing.JTextField txtAverage;
    private javax.swing.JTextField txtmonthAgoust;
    private javax.swing.JTextField txtmonthApril;
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
