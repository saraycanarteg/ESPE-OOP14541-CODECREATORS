package ece.edu.espe.cyberplaneta.view;

import utils.MongoClientSingleton;

/**
 *
 * @author Saray Canarte, Code Creators, DCCO-ESPE
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmCyberPlanetaMain
     */
    public FrmMenu() {
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

        jMenuItem8 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCyberPlaneta = new javax.swing.JMenu();
        itmAccountSettings = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        itmLogOut = new javax.swing.JMenuItem();
        mnuTaxpayer = new javax.swing.JMenu();
        itmAddProcessTaxayer = new javax.swing.JMenuItem();
        itmTaxpayerInfo = new javax.swing.JMenu();
        itmAddTaxpayer = new javax.swing.JMenuItem();
        itmEditTaxpayer = new javax.swing.JMenuItem();
        itmDeleteTaxpayer = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnuClassificationAgenda = new javax.swing.JMenu();
        itmSearch9thDigit = new javax.swing.JMenuItem();
        itmNotifications = new javax.swing.JMenuItem();
        itmTaxesOperations = new javax.swing.JMenu();
        itmCalculateTaxAverage = new javax.swing.JMenuItem();
        itmCompare2Taxes = new javax.swing.JMenuItem();
        mnuPricingSystem = new javax.swing.JMenu();
        itmTaxProcessCosst = new javax.swing.JMenuItem();
        itmTotalIcome = new javax.swing.JMenuItem();
        itmCAGR = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 0, -1, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cyberplanetalogo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(159, 246, 70));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(65, 109, 155));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(485, 28));

        mnuCyberPlaneta.setBackground(new java.awt.Color(159, 246, 70));
        mnuCyberPlaneta.setForeground(new java.awt.Color(51, 0, 153));
        mnuCyberPlaneta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/house-chimney.png"))); // NOI18N
        mnuCyberPlaneta.setText("CyberPlaneta");
        mnuCyberPlaneta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        itmAccountSettings.setText("Configuración de Cuenta");
        itmAccountSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAccountSettingsActionPerformed(evt);
            }
        });
        mnuCyberPlaneta.add(itmAccountSettings);

        jMenuItem3.setText("Agregar Usuario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuCyberPlaneta.add(jMenuItem3);

        itmLogOut.setText("Salir");
        itmLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLogOutActionPerformed(evt);
            }
        });
        mnuCyberPlaneta.add(itmLogOut);

        jMenuBar1.add(mnuCyberPlaneta);

        mnuTaxpayer.setBackground(new java.awt.Color(159, 246, 70));
        mnuTaxpayer.setForeground(new java.awt.Color(51, 0, 153));
        mnuTaxpayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book-user.png"))); // NOI18N
        mnuTaxpayer.setText("Contribuyente");
        mnuTaxpayer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        itmAddProcessTaxayer.setText("Información General de Contribuyentes");
        itmAddProcessTaxayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddProcessTaxayerActionPerformed(evt);
            }
        });
        mnuTaxpayer.add(itmAddProcessTaxayer);

        itmTaxpayerInfo.setText("Manejo de Contribuyentes");

        itmAddTaxpayer.setText("Añadir Contribuyente");
        itmAddTaxpayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddTaxpayerActionPerformed(evt);
            }
        });
        itmTaxpayerInfo.add(itmAddTaxpayer);

        itmEditTaxpayer.setText("Editar Contribuyente");
        itmEditTaxpayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEditTaxpayerActionPerformed(evt);
            }
        });
        itmTaxpayerInfo.add(itmEditTaxpayer);

        itmDeleteTaxpayer.setText("Eliminar Contribuyente");
        itmDeleteTaxpayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmDeleteTaxpayerActionPerformed(evt);
            }
        });
        itmTaxpayerInfo.add(itmDeleteTaxpayer);

        mnuTaxpayer.add(itmTaxpayerInfo);

        jMenu1.setText("Procesos de Contribuyentes");

        jMenuItem5.setText("Añadir Proceso");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Editar Proceso");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Eliminar Proceso");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem9.setText("Buscar Proceso");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        mnuTaxpayer.add(jMenu1);

        jMenuBar1.add(mnuTaxpayer);

        mnuClassificationAgenda.setBackground(new java.awt.Color(159, 246, 70));
        mnuClassificationAgenda.setForeground(new java.awt.Color(51, 0, 153));
        mnuClassificationAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar-clock.png"))); // NOI18N
        mnuClassificationAgenda.setText("Agenda de Clasificación");
        mnuClassificationAgenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        itmSearch9thDigit.setText("Sistema de Búsqueda (9º Dígito)");
        itmSearch9thDigit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSearch9thDigitActionPerformed(evt);
            }
        });
        mnuClassificationAgenda.add(itmSearch9thDigit);

        itmNotifications.setText("Notificaciones");
        itmNotifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmNotificationsActionPerformed(evt);
            }
        });
        mnuClassificationAgenda.add(itmNotifications);

        itmTaxesOperations.setText("Operaciones con Impuestos");

        itmCalculateTaxAverage.setText("Calcular Promedio de Impuestos");
        itmCalculateTaxAverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCalculateTaxAverageActionPerformed(evt);
            }
        });
        itmTaxesOperations.add(itmCalculateTaxAverage);

        itmCompare2Taxes.setText("Comparar 2 meses de Impuestos");
        itmCompare2Taxes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCompare2TaxesActionPerformed(evt);
            }
        });
        itmTaxesOperations.add(itmCompare2Taxes);

        mnuClassificationAgenda.add(itmTaxesOperations);

        jMenuBar1.add(mnuClassificationAgenda);

        mnuPricingSystem.setBackground(new java.awt.Color(159, 246, 70));
        mnuPricingSystem.setForeground(new java.awt.Color(51, 0, 153));
        mnuPricingSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calculator.png"))); // NOI18N
        mnuPricingSystem.setText("Sistema de Precios");
        mnuPricingSystem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        itmTaxProcessCosst.setText("Calcular Costo de Proceso");
        itmTaxProcessCosst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmTaxProcessCosstActionPerformed(evt);
            }
        });
        mnuPricingSystem.add(itmTaxProcessCosst);

        itmTotalIcome.setText("Revisar Ingresos Totales");
        itmTotalIcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmTotalIcomeActionPerformed(evt);
            }
        });
        mnuPricingSystem.add(itmTotalIcome);

        itmCAGR.setText("Calcular CAGR");
        itmCAGR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCAGRActionPerformed(evt);
            }
        });
        mnuPricingSystem.add(itmCAGR);

        jMenuBar1.add(mnuPricingSystem);

        mnuHelp.setBackground(new java.awt.Color(159, 246, 70));
        mnuHelp.setForeground(new java.awt.Color(51, 0, 153));
        mnuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/interrogation.png"))); // NOI18N
        mnuHelp.setText("Ayuda");
        mnuHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem2.setText("Sobre el programa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuHelp.add(jMenuItem2);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmTaxProcessCosstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmTaxProcessCosstActionPerformed
        FrmPricingSystem frmtaxPricingSystem = new FrmPricingSystem();
        this.setVisible(true);
        frmtaxPricingSystem.setVisible(true);

    }//GEN-LAST:event_itmTaxProcessCosstActionPerformed

    private void itmLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLogOutActionPerformed
        System.exit(0);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MongoClientSingleton.close();
            System.out.println("MongoDB connection closed.");
        }));
    }//GEN-LAST:event_itmLogOutActionPerformed

    private void itmEditTaxpayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEditTaxpayerActionPerformed
        FrmEditTaxpayer frmEditTaxpayer = new FrmEditTaxpayer();
        this.setVisible(false);
        frmEditTaxpayer.setVisible(true);
    }//GEN-LAST:event_itmEditTaxpayerActionPerformed

    private void itmAddTaxpayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddTaxpayerActionPerformed
        FrmAddTaxpayer frmAddTaxpayer = new FrmAddTaxpayer();
        this.setVisible(false);
        frmAddTaxpayer.setVisible(true);
    }//GEN-LAST:event_itmAddTaxpayerActionPerformed

    private void itmTotalIcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmTotalIcomeActionPerformed
        FrmIncomes frmIncomes = new FrmIncomes();
        this.setVisible(false);
        frmIncomes.setVisible(true);
    }//GEN-LAST:event_itmTotalIcomeActionPerformed

    private void itmCAGRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCAGRActionPerformed
        FrmCalculateCAGR frmCalculateCAGR = new FrmCalculateCAGR();
        this.setVisible(false);
        frmCalculateCAGR.setVisible(true);
    }//GEN-LAST:event_itmCAGRActionPerformed

    private void itmNotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNotificationsActionPerformed
        FrmShowNotification frmShowNotification = new FrmShowNotification();
        this.setVisible(false);
        frmShowNotification.setVisible(true);
    }//GEN-LAST:event_itmNotificationsActionPerformed

    private void itmSearch9thDigitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSearch9thDigitActionPerformed
        FrmSearch9Digit frmBusqueda9noDigito = new FrmSearch9Digit();
        this.setVisible(false);
        frmBusqueda9noDigito.setVisible(true);
    }//GEN-LAST:event_itmSearch9thDigitActionPerformed

    private void itmDeleteTaxpayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmDeleteTaxpayerActionPerformed
        FrmDeleteTaxpayer frmDeleteTaxpayer = new FrmDeleteTaxpayer();
        this.setVisible(false);
        frmDeleteTaxpayer.setVisible(true);
    }//GEN-LAST:event_itmDeleteTaxpayerActionPerformed

    private void itmCalculateTaxAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCalculateTaxAverageActionPerformed
        FrmCalculateAverageMonthlyTaxes frmCalculateAverageMonthlyTaxes = new FrmCalculateAverageMonthlyTaxes();
        this.setVisible(false);
        frmCalculateAverageMonthlyTaxes.setVisible(true);
    }//GEN-LAST:event_itmCalculateTaxAverageActionPerformed

    private void itmCompare2TaxesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCompare2TaxesActionPerformed
        FrmCompareTwoMonthsTaxFinal frmCompareTwoMonthsTax = new FrmCompareTwoMonthsTaxFinal();
        this.setVisible(false);
        frmCompareTwoMonthsTax.setVisible(true);
    }//GEN-LAST:event_itmCompare2TaxesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmSplash frmSplash = new FrmSplash();
        this.setVisible(false);
        frmSplash.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itmAddProcessTaxayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddProcessTaxayerActionPerformed
        FrmSeeTaxpayer frmSeeTaxpayer = new FrmSeeTaxpayer();
        this.setVisible(false);
        frmSeeTaxpayer.setVisible(true);
    }//GEN-LAST:event_itmAddProcessTaxayerActionPerformed

    private void itmAccountSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAccountSettingsActionPerformed
        FrmAccountSetting frmAccountSetting = new FrmAccountSetting();
        this.setVisible(false);
        frmAccountSetting.setVisible(true);
    }//GEN-LAST:event_itmAccountSettingsActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       FrmAddUser frmAddUser = new FrmAddUser();
       this.setVisible(false);
       frmAddUser.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        FrmDeleteTaxProcess frmDeleteTaxProcess = new FrmDeleteTaxProcess();
        this.setVisible(false);
        frmDeleteTaxProcess.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        FrmAddTaxProcess frmAddTaxProcess = new FrmAddTaxProcess();
        this.setVisible(false);
        frmAddTaxProcess.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       FrmSearchTaxProcess frmSearchTaxProcess  = new FrmSearchTaxProcess ();
       this.setVisible(false);
       frmSearchTaxProcess .setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       FrmEditTaxProcess frmEditTaxProcess  = new FrmEditTaxProcess ();
       this.setVisible(false);
       frmEditTaxProcess .setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAccountSettings;
    private javax.swing.JMenuItem itmAddProcessTaxayer;
    private javax.swing.JMenuItem itmAddTaxpayer;
    private javax.swing.JMenuItem itmCAGR;
    private javax.swing.JMenuItem itmCalculateTaxAverage;
    private javax.swing.JMenuItem itmCompare2Taxes;
    private javax.swing.JMenuItem itmDeleteTaxpayer;
    private javax.swing.JMenuItem itmEditTaxpayer;
    private javax.swing.JMenuItem itmLogOut;
    private javax.swing.JMenuItem itmNotifications;
    private javax.swing.JMenuItem itmSearch9thDigit;
    private javax.swing.JMenuItem itmTaxProcessCosst;
    private javax.swing.JMenu itmTaxesOperations;
    private javax.swing.JMenu itmTaxpayerInfo;
    private javax.swing.JMenuItem itmTotalIcome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mnuClassificationAgenda;
    private javax.swing.JMenu mnuCyberPlaneta;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuPricingSystem;
    private javax.swing.JMenu mnuTaxpayer;
    // End of variables declaration//GEN-END:variables
}
