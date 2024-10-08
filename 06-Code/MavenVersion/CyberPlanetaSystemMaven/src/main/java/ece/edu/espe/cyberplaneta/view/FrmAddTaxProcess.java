package ece.edu.espe.cyberplaneta.view;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.controller.C_PricingSystem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.ChartAndTableUtils;
import utils.MongoDBUtil;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class FrmAddTaxProcess extends javax.swing.JFrame {

    private C_PricingSystem controller = new C_PricingSystem();
    private static final ImageIcon WARNING_ICON = new ImageIcon(FrmAddTaxProcess.class.getResource("/images/triangle-warning.png"));

    /**
     * Creates new form FrmPriceSystem
     */
    public FrmAddTaxProcess() {
        this.controller = new C_PricingSystem();
        initComponents();
        loadPriceListTable();
        ChartAndTableUtils.customizeTableHeader(tblPriceList);
        txtId.setEnabled(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPriceList = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtProcessIdCalc = new javax.swing.JTextField();
        txtIdTaxpayer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 81, 203));
        jLabel1.setText("Agregar Proceso");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 510, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2 - copia.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, -1, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 910, 100));

        jPanel3.setBackground(new java.awt.Color(159, 246, 70));

        tblPriceList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPriceList.setForeground(new java.awt.Color(65, 109, 155));
        tblPriceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre del Proceso", "Precio Base ($)", "Impuesto (%)"
            }
        ));
        tblPriceList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblPriceList.setGridColor(new java.awt.Color(65, 109, 155));
        tblPriceList.setRowHeight(25);
        tblPriceList.setSelectionBackground(new java.awt.Color(159, 246, 70));
        tblPriceList.setSelectionForeground(new java.awt.Color(7, 81, 203));
        tblPriceList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPriceList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 910, 170));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("ID general:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        txtProcessIdCalc.setToolTipText("Ingrese un ID de la tabla");
        txtProcessIdCalc.setEnabled(false);
        txtProcessIdCalc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProcessIdCalcKeyTyped(evt);
            }
        });
        jPanel4.add(txtProcessIdCalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 130, -1));

        txtIdTaxpayer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdTaxpayerKeyTyped(evt);
            }
        });
        jPanel4.add(txtIdTaxpayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 130, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("ID del contribuyente:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        btnSearch.setBackground(new java.awt.Color(159, 246, 70));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(65, 109, 155));
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel4.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("ID del proceso:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));
        jPanel4.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 130, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 910, 140));

        jPanel5.setBackground(new java.awt.Color(7, 81, 203));

        btnCancel.setBackground(new java.awt.Color(255, 101, 98));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(159, 246, 70));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 153));
        btnAdd.setText("Agregar Proceso");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 910, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        utils.Validation.goToMenu(this);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtIdTaxpayerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdTaxpayerKeyTyped
        utils.Validation.restrictInputToDigits(evt);
    }//GEN-LAST:event_txtIdTaxpayerKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        handleSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        handleAdd();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtProcessIdCalcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcessIdCalcKeyTyped
        utils.Validation.restrictInputToProcessId(evt, txtProcessIdCalc.getText());
    }//GEN-LAST:event_txtProcessIdCalcKeyTyped

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
            java.util.logging.Logger.getLogger(FrmAddTaxProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddTaxProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddTaxProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddTaxProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddTaxProcess().setVisible(true);
            }
        });
    }

    private void loadPriceListTable() {
        DefaultTableModel model = (DefaultTableModel) tblPriceList.getModel();
        model.setRowCount(0);

        for (PriceList price : C_PricingSystem.getPriceListArray()) {
            model.addRow(new Object[]{
                price.getProcessId(),
                price.getProcessName(),
                String.format("%.2f", price.getPrice()),
                String.format("%.2f", price.getTaxRate())
            });
        }
    }

    private void handleSearch() {
        String id = txtIdTaxpayer.getText().trim();
        if (!utils.Validation.isIdValid(id)) {
            utils.Validation.showMessage(this, "El ID debe tener 13 dígitos y terminar en '001'", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (utils.MongoDBUtil.verificationIdTaxpayer(id)) {
            utils.Validation.showMessage(this, "El contribuyente no existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            txtProcessIdCalc.setEnabled(true);
            txtId.setEnabled(true);
            btnAdd.setEnabled(true);
        }
    }

    private void handleAdd() {
        String nameCollection = txtIdTaxpayer.getText().trim() + "_process";
        String processIdText = txtProcessIdCalc.getText();
        String id = txtId.getText();

        if (!processIdText.isEmpty()) {
            int processId = Integer.parseInt(processIdText);
            PriceList selectedProcess = findSelectedProcess(processId);

            if (selectedProcess != null) {
                if (MongoDBUtil.generalIdExists(nameCollection, id)) {
                    utils.Validation.showMessage(this, "El ID general ya existe. Por favor, ingrese un ID diferente.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nameProcess = selectedProcess.getProcessName();
                float priceProcess = selectedProcess.getPrice();
                float rateTax = selectedProcess.getTaxRate();

                MongoDBUtil.createCollection(nameCollection, id, processId, nameProcess, priceProcess, rateTax);
                utils.Validation.showMessage(this, "Datos guardados en la nube.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                utils.Validation.showMessage(this, "Proceso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            utils.Validation.showMessage(this, "Complete los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private PriceList findSelectedProcess(int processId) {
        for (PriceList process : C_PricingSystem.getPriceListArray()) {
            if (process.getProcessId() == processId) {
                return process;
            }
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPriceList;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdTaxpayer;
    private javax.swing.JTextField txtProcessIdCalc;
    // End of variables declaration//GEN-END:variables
}
