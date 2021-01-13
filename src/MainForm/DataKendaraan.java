/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import Connection.konek;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rizki Eka Mawardewi (201643500556)
 */
public class DataKendaraan extends javax.swing.JFrame {

    /**
     * Creates new form DataKendaraan
     */
    
    private DefaultTableModel tabmode;
    
    public DataKendaraan() {
        initComponents();
        ImageIcon ico = new ImageIcon("src/Images/logo-astra-motor-2015 - Copy.jpg");
        setIconImage(ico.getImage());
        this.setLocationRelativeTo(null);
        non_aktif();
        tblkendaraan();
        plgmasuk();
        tblkendaraan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblkendaraan.getTableHeader().setOpaque(false);
        tblkendaraan.getTableHeader().setBackground(new Color(0,153,153));
        tblkendaraan.getTableHeader().setForeground(new Color(255,255,255));
        tblkendaraan.setRowHeight(25);
    }
    
     public void tblkendaraan(){
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("No Polisi");
        tbl.addColumn("Nama Kendaraan");
        tbl.addColumn("Nama Pelanggan");
        tblkendaraan.setModel(tbl);
        try{
            Statement statement=konek.koneksiDb().createStatement();
            ResultSet res = statement.executeQuery("select * from tb_kendaraan");
            while (res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("kd_kendaraan"),
                    res.getString("nm_kendaraan"),
                    res.getString("kd_pelanggan")
                });
                tblkendaraan.setModel(tbl);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
    }
    
    private void non_aktif() {
        txnopolis.setEnabled(false);
        txnama.setEnabled(false);
        cbplg.setEnabled(false);
        txplg.setVisible(false);
    }
    
    private void aktif() {
        txnopolis.setEnabled(true);
        txnama.setEnabled(true);
        cbplg.setEnabled(true);
        txnopolis.requestFocus();
    }
    
     private void kosong() {
        txnopolis.setText("");
        txnama.setText("");
        cbplg.setSelectedItem("");
        txplg.setText("");
        tambah.setEnabled(true);
        update.setEnabled(true);
        hapus.setEnabled(true);
    }
          
    private void plgmasuk() {
          
        try {
            Connection c = konek.koneksiDb();
            Statement s = c.createStatement();

            String sql = "SELECT nm_pelanggan FROM tb_pelanggan WHERE kd_pelanggan !=''";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                cbplg.addItem(r.getString("nm_pelanggan"));
            }

            r.last();
            int jumlahdata = r.getRow();
            r.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txnama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txnopolis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbplg = new javax.swing.JComboBox<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkendaraan = new javax.swing.JTable();
        txplg = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        update = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Kendaraan");
        setMinimumSize(new java.awt.Dimension(1185, 656));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setPreferredSize(new java.awt.Dimension(1381, 776));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NAMA PELANGGAN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NO POLISI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NAMA KENDARAAN");

        cbplg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Nama Pelanggan:" }));
        cbplg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbplgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(73, 73, 73)
                            .addComponent(txnopolis))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(28, 28, 28)
                            .addComponent(cbplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txnopolis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 115, Short.MAX_VALUE))
        );

        tblkendaraan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblkendaraan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkendaraanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblkendaraan);

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gtk-save-as.png"))); // NOI18N
        tambah.setText("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gtk-edit.png"))); // NOI18N
        update.setText("EDIT");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/document_delete.png"))); // NOI18N
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit_20px.png"))); // NOI18N
        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search_20px.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(hapus)
                        .addGap(18, 18, 18)
                        .addComponent(keluar)
                        .addGap(18, 18, 18)
                        .addComponent(batal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(update)
                                .addComponent(hapus)
                                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tambah))))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txplg, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 1380, 670));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1381, 100));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-astra-motor-2015 - Copy.jpg"))); // NOI18N

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setFont(new java.awt.Font("Californian FB", 1, 24)); // NOI18N
        jLabel6.setText("DATA KENDARAAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addContainerGap(528, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator4)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblkendaraanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkendaraanMouseClicked
        update.setEnabled(true);
        update.setText("EDIT");
        hapus.setEnabled(true);
        int bar = tblkendaraan.getSelectedRow();
        String a = tblkendaraan.getValueAt(bar, 0).toString();
        String b = tblkendaraan.getValueAt(bar, 1).toString();
        String c = tblkendaraan.getValueAt(bar, 2).toString();
        txnopolis.setText(a);
        txnama.setText(b);
        cbplg.setSelectedItem(c);
    }//GEN-LAST:event_tblkendaraanMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
 
        String tombol = tambah.getText();
        String kd_kendaraan = txnopolis.getText();
        String nm_kendaraan = txnama.getText();
        Object kd_pelanggan = cbplg.getSelectedItem();
               
        if (tombol.equals("TAMBAH") || txnopolis.getText().equals("NO POLISI") || txnama.getText().equals("NAMA KENDARAAN") 
                || cbplg.getSelectedItem().equals("NAMA PELANGGAN")) {
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data ","Data Belum Lengkap",JOptionPane.WARNING_MESSAGE);
            aktif();
            kosong();
            tambah.setText("SIMPAN");
            update.setEnabled(false);
            hapus.setEnabled(false);
            }else {
                if(txnopolis.getText().equals("NO POLISI") || txnama.getText().equals("NAMA KENDARAAN") || cbplg.getSelectedItem().equals("NAMA PELANGGAN")){
                JOptionPane.showMessageDialog(null, "Harap Lengkapi Data ","Data Belum Lengkap",JOptionPane.WARNING_MESSAGE);
            }else{
            JOptionPane.showConfirmDialog(null, "Apakah Data anda sudah benar?", "INFORMASI",JOptionPane.YES_NO_OPTION);
                        try {
                            Connection c = konek.koneksiDb();
                            String sql = "INSERT INTO tb_kendaraan VALUES (?, ?, ?)";
                            PreparedStatement p = c.prepareStatement(sql);
                            p.setString(1, kd_kendaraan);
                            p.setString(2, nm_kendaraan);
                            p.setString(3, (String) kd_pelanggan);
                            p.executeUpdate();
                            p.close();
                            txnopolis.requestFocus();
                            } catch (SQLException e) {
                            System.out.println("Terjadi Error");
                            }finally{
                                String   msg="<html>No Polisi           = " +txnopolis.getText()+" <br>"
                                                 + "Nama Kendaraan      = " +txnama.getText()+"<br>"
                                                 + "Nama Kendaraan      = " +cbplg.getSelectedItem()+"<br>"+"<html>";
                                JOptionPane optionPane=new JOptionPane();
                                optionPane.setMessage(msg);
                                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                                JDialog dialog=optionPane.createDialog(null, "DATA DISIMPAN");
                                dialog.setVisible(true);
                            }
                            new DataKendaraan().setVisible(true);
                            this.dispose();
                            tblkendaraan();
                            tambah.setText("TAMBAH");
                            non_aktif();
                }
            }
    }//GEN-LAST:event_tambahActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        if (update.getText()=="EDIT") {
            aktif();
            txnopolis.setEnabled(false);
            update.setText("UPDATE");
            hapus.setEnabled(false);
            tambah.setEnabled(false);
        } else {
            String sql = "update tb_kendaraan set nm_kendaraan=?, kd_pelanggan=? where kd_kendaraan='"+txnopolis.getText()+"'";
            try {
                PreparedStatement stat = konek.koneksiDb().prepareStatement(sql);
                stat.setString(1, txnama.getText());
                stat.setString(2, (String) cbplg.getSelectedItem());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Kendaraan Berhasil Di Update");
                update.setText("EDIT");
                tblkendaraan();
                kosong();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Kendaraan Gagal Di Update" + e);
            }
            new DataKendaraan().setVisible(true);
                this.dispose();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed

        String kd_kendaraan = txnopolis.getText();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ingin Menghapus Data Ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0){
            try {
                Statement Statement =(Statement)konek.koneksiDb().createStatement();
                Statement.executeUpdate(" Delete from tb_kendaraan where kd_kendaraan=('" +  kd_kendaraan + "');");
                JOptionPane.showMessageDialog(null, "Data Kendaraan Berhasil Dihapus");
                kosong();
                txnopolis.requestFocus();
                tblkendaraan();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Kendaraan Gagal Di Hapus" + e);
            }
            new DataKendaraan().setVisible(true);
                            this.dispose();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        dispose();
        FormUtamaSA fa = new FormUtamaSA();
        fa.show();
    }//GEN-LAST:event_keluarActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        kosong();
        tambah.setText("TAMBAH");
        non_aktif();
    }//GEN-LAST:event_batalActionPerformed

    private void cbplgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbplgActionPerformed
        // TODO add your handling code here:
            if (cbplg.getSelectedItem().equals("- Nama Pelanggan -")){
            txplg.setText("");
        }else{
            try {
                Connection c = konek.koneksiDb();
                Statement s = c.createStatement();

                String sql = "SELECT kd_pelanggan FROM tb_pelanggan WHERE nm_pelanggan ='" + cbplg.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    txplg.setText(r.getString("kd_pelanggan"));
                    txplg.setForeground(Color.BLACK);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cbplgActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String tombol = btnCari.getText();
        if (tombol.equals("Cari")){
            Object[] Baris = {"No Polisi", "Nama Kendaraan", "Nama Pelanggan"};
            tabmode = new DefaultTableModel(null, Baris);
            tblkendaraan.setModel(tabmode);
            String sql = "Select * from tb_kendaraan where kd_kendaraan like '%" + txtCari.getText() + "%'" +
            "or nm_kendaraan like '%" + txtCari.getText() + "%'";
            try {
                Statement stat = konek.koneksiDb().createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()) {
                    String kd_kendaraan = hasil.getString("kd_kendaraan");
                    String nm_kendaraan = hasil.getString("nm_kendaraan");
                    String kd_pelanggan = hasil.getString("kd_pelanggan");
                    String[] data = {kd_kendaraan,nm_kendaraan,kd_pelanggan};
                    tabmode.addRow(data);
                }
            } catch (Exception e) {
            }
            btnCari.setText("Batal");
        }else{
            tblkendaraan();
            btnCari.setText("Cari");
            txtCari.setText("");
            tambah.setEnabled(true);
        }
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataKendaraan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JButton btnCari;
    private javax.swing.JComboBox<String> cbplg;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton keluar;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tblkendaraan;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txnopolis;
    private javax.swing.JTextField txplg;
    private javax.swing.JTextField txtCari;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}