/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import Connection.konek;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import sun.util.calendar.LocalGregorianCalendar.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rizki Eka Mawardewi (201643500556).
 */
public class FormUtamaPartman extends javax.swing.JFrame {
    
    //Connection conn;
    JasperReport JasReport;
    JasperPrint JasPrint;
    Map param = new HashMap();
    JasperDesign JasDes;

    /**
     * Creates new form FormAdmin
     */
    public FormUtamaPartman() {
        initComponents();
        ImageIcon ico = new ImageIcon("src/Images/logo-astra-motor-2015 - Copy.jpg");
        setIconImage(ico.getImage());
        this.setLocationRelativeTo(null);
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
        new Thread(){
            public void run(){
                while(true){
                Calendar kal = new GregorianCalendar();
                int tahun = kal.get(Calendar.YEAR);
                int bulan = kal.get(Calendar.MONTH)+1;
                int hari = kal.get(Calendar.DAY_OF_MONTH);
                int jam = kal.get(Calendar.HOUR_OF_DAY);
                int menit = kal.get(Calendar.MINUTE);
                int detik = kal.get(Calendar.SECOND);
                String tanggal = hari + "-"+bulan+"-"+tahun;
                String waktu1 = jam + ":"+menit+":"+detik;
                String waktu2 = jam + ":"+menit+":"+detik;
                jLabel2.setText(tanggal);
                jLabel3.setText(waktu1);
                }
            }
        }.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_pemasok = new javax.swing.JMenu();
        dt_pemasok = new javax.swing.JMenuItem();
        menu_part = new javax.swing.JMenu();
        dt_part = new javax.swing.JMenuItem();
        tambahstokpart = new javax.swing.JMenuItem();
        ts_jualpart = new javax.swing.JMenuItem();
        menu_rpt = new javax.swing.JMenu();
        rpt_dtpemasok = new javax.swing.JMenuItem();
        rpt_dtsparepart = new javax.swing.JMenuItem();
        rpt_tspesanbrg = new javax.swing.JMenuItem();
        rpt_tsjualsparepart = new javax.swing.JMenuItem();
        menu_logout = new javax.swing.JMenu();

        jMenuItem6.setText("jMenuItem6");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Admin");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1381, 776));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1381, 776));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TANGGAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 710, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("JAM");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 730, 72, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 700, 80, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/partman2.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1300, 776));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, -1));

        menu_pemasok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/procurement_20px.png"))); // NOI18N
        menu_pemasok.setText("Data Pemasok");
        menu_pemasok.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        dt_pemasok.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        dt_pemasok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/procurement_20px.png"))); // NOI18N
        dt_pemasok.setText("Data Pemasok");
        dt_pemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dt_pemasokActionPerformed(evt);
            }
        });
        menu_pemasok.add(dt_pemasok);

        jMenuBar1.add(menu_pemasok);

        menu_part.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/toolbox_20px.png"))); // NOI18N
        menu_part.setText("Data Sparepart");
        menu_part.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        dt_part.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        dt_part.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/toolbox_20px.png"))); // NOI18N
        dt_part.setText("Data Sparepart");
        dt_part.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dt_partActionPerformed(evt);
            }
        });
        menu_part.add(dt_part);

        tambahstokpart.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        tambahstokpart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/transaction_approved_20px.png"))); // NOI18N
        tambahstokpart.setText("Tambah Stok Sparepart");
        tambahstokpart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahstokpartActionPerformed(evt);
            }
        });
        menu_part.add(tambahstokpart);

        ts_jualpart.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        ts_jualpart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/transaction_approved_20px.png"))); // NOI18N
        ts_jualpart.setText("Transaksi Penjualan Sparepart");
        ts_jualpart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ts_jualpartActionPerformed(evt);
            }
        });
        menu_part.add(ts_jualpart);

        jMenuBar1.add(menu_part);

        menu_rpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/graph_report_20px.png"))); // NOI18N
        menu_rpt.setText("Report");
        menu_rpt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        rpt_dtpemasok.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        rpt_dtpemasok.setText("Report Data Pemasok");
        rpt_dtpemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_dtpemasokActionPerformed(evt);
            }
        });
        menu_rpt.add(rpt_dtpemasok);

        rpt_dtsparepart.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        rpt_dtsparepart.setText("Report Data Sparepart");
        rpt_dtsparepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_dtsparepartActionPerformed(evt);
            }
        });
        menu_rpt.add(rpt_dtsparepart);

        rpt_tspesanbrg.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        rpt_tspesanbrg.setText("Report Tambah Stok Sparepart");
        rpt_tspesanbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_tspesanbrgActionPerformed(evt);
            }
        });
        menu_rpt.add(rpt_tspesanbrg);

        rpt_tsjualsparepart.setFont(new java.awt.Font("Vrinda", 1, 12)); // NOI18N
        rpt_tsjualsparepart.setText("Report Penjualan Sparepart");
        rpt_tsjualsparepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_tsjualsparepartActionPerformed(evt);
            }
        });
        menu_rpt.add(rpt_tsjualsparepart);

        jMenuBar1.add(menu_rpt);

        menu_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shutdown_20px.png"))); // NOI18N
        menu_logout.setText("Logout");
        menu_logout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        menu_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dt_partActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dt_partActionPerformed
        // TODO add your handling code here:
        DataSparepart ds = new DataSparepart();
        ds.show();
        this.dispose();
    }//GEN-LAST:event_dt_partActionPerformed

    private void menu_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_logoutMouseClicked
        // TODO add your handling code here:
        FormLogin fl = new FormLogin();
        fl.show();
        this.dispose();
        JOptionPane.showMessageDialog(null, "Anda Berhasil Logout");
    }//GEN-LAST:event_menu_logoutMouseClicked

    private void rpt_dtpemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_dtpemasokActionPerformed
        // TODO add your handling code here:
        try {
            //File file = new File("src/Laporan/Lap_Pemasok.jrxml");
            InputStream file = getClass().getResourceAsStream("/Laporan/Lap_Pemasok.jrxml");
            JasDes = JRXmlLoader.load(file);
            param.clear();
            JasReport = JasperCompileManager.compileReport(JasDes);
            JasPrint = JasperFillManager.fillReport(JasReport, param, konek.koneksiDb());
            JasperViewer.viewReport(JasPrint, false);
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_rpt_dtpemasokActionPerformed

    private void rpt_dtsparepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_dtsparepartActionPerformed
        // TODO add your handling code here:
        try {
            //File file = new File("src/Laporan/Lap_Sparepart.jrxml");
            InputStream file = getClass().getResourceAsStream("/Laporan/Lap_Sparepart.jrxml");
            JasDes = JRXmlLoader.load(file);
            param.clear();
            JasReport = JasperCompileManager.compileReport(JasDes);
            JasPrint = JasperFillManager.fillReport(JasReport, param, konek.koneksiDb());
            JasperViewer.viewReport(JasPrint, false);
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_rpt_dtsparepartActionPerformed

    private void rpt_tspesanbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_tspesanbrgActionPerformed
        // TODO add your handling code here:
        try {
            //File file = new File("src/Laporan/Lap_PemesananSparepart.jrxml");
            InputStream file = getClass().getResourceAsStream("/Laporan/Lap_PemesananSparepart.jrxml");
            JasDes = JRXmlLoader.load(file);
            param.clear();
            JasReport = JasperCompileManager.compileReport(JasDes);
            JasPrint = JasperFillManager.fillReport(JasReport, param, konek.koneksiDb());
            JasperViewer.viewReport(JasPrint, false);
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_rpt_tspesanbrgActionPerformed

    private void rpt_tsjualsparepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_tsjualsparepartActionPerformed
        // TODO add your handling code here:
        try {
            //File file = new File("src/Laporan/Lap_PenjualanSparepart.jrxml");
            InputStream file = getClass().getResourceAsStream("/Laporan/Lap_PenjualanSparepart.jrxml");
            JasDes = JRXmlLoader.load(file);
            param.clear();
            JasReport = JasperCompileManager.compileReport(JasDes);
            JasPrint = JasperFillManager.fillReport(JasReport, param, konek.koneksiDb());
            JasperViewer.viewReport(JasPrint, false);
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_rpt_tsjualsparepartActionPerformed

    private void ts_jualpartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ts_jualpartActionPerformed
        // TODO add your handling code here:
        TransaksiPenjualanSparepart tps = new TransaksiPenjualanSparepart();
        tps.show();
        this.dispose();
    }//GEN-LAST:event_ts_jualpartActionPerformed

    private void tambahstokpartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahstokpartActionPerformed
        // TODO add your handling code here:
        TambahStokSparepart tss = new TambahStokSparepart();
        tss.show();
        this.dispose();
    }//GEN-LAST:event_tambahstokpartActionPerformed

    private void dt_pemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dt_pemasokActionPerformed
        // TODO add your handling code here:
        DataPemasok dp = new DataPemasok();
        dp.show();
        this.dispose();
    }//GEN-LAST:event_dt_pemasokActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormUtamaSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtamaSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtamaSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtamaSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtamaPartman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dt_part;
    private javax.swing.JMenuItem dt_pemasok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu menu_logout;
    private javax.swing.JMenu menu_part;
    private javax.swing.JMenu menu_pemasok;
    private javax.swing.JMenu menu_rpt;
    private javax.swing.JMenuItem rpt_dtpemasok;
    private javax.swing.JMenuItem rpt_dtsparepart;
    private javax.swing.JMenuItem rpt_tsjualsparepart;
    private javax.swing.JMenuItem rpt_tspesanbrg;
    private javax.swing.JMenuItem tambahstokpart;
    private javax.swing.JMenuItem ts_jualpart;
    // End of variables declaration//GEN-END:variables
}
