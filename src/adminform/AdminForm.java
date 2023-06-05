/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminform;

import Singletondatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loginnew.login;

/**
 *
 * @author Rahimsyah
 */
public class AdminForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    public AdminForm() {
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

        jPanel2 = new javax.swing.JPanel();
        btn_pekerjaan = new javax.swing.JButton();
        btn_slt = new javax.swing.JButton();
        btn_sbt = new javax.swing.JButton();
        btn_sumper = new javax.swing.JButton();
        btn_sm = new javax.swing.JButton();
        btn_jumt = new javax.swing.JButton();
        btn_jenpend = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_sumair = new javax.swing.JButton();
        btn_terkaitbansos = new javax.swing.JButton();
        btn_sumbamasak = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jpk1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        edt_value = new javax.swing.JTextField();
        edt_kriteria = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edt_id = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btn_pekerjaan.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_pekerjaan.setText("PEKERJAAN");
        btn_pekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pekerjaanActionPerformed(evt);
            }
        });

        btn_slt.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_slt.setText("STATUS LAHAN TINGGAL");
        btn_slt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sltActionPerformed(evt);
            }
        });

        btn_sbt.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_sbt.setText("STATUS BANGUNAN TINGGAL");
        btn_sbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sbtActionPerformed(evt);
            }
        });

        btn_sumper.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_sumper.setText("SUMBER PENERANGAN");
        btn_sumper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sumperActionPerformed(evt);
            }
        });

        btn_sm.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_sm.setText("STATUS MASYARAKAT");
        btn_sm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_smActionPerformed(evt);
            }
        });

        btn_jumt.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_jumt.setText("JUMLAH TANGGUNGAN");
        btn_jumt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jumtActionPerformed(evt);
            }
        });

        btn_jenpend.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_jenpend.setText("JENJANG PENDIDIKAN");
        btn_jenpend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jenpendActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KRITERIA");

        btn_sumair.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_sumair.setText("SUMBER AIR MINUM");
        btn_sumair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sumairActionPerformed(evt);
            }
        });

        btn_terkaitbansos.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_terkaitbansos.setText("TERKAIT BANSOS LAIN");
        btn_terkaitbansos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terkaitbansosActionPerformed(evt);
            }
        });

        btn_sumbamasak.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_sumbamasak.setText("SUMBER ENERGI MASAK");
        btn_sumbamasak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sumbamasakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pekerjaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_slt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sbt, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btn_sumper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_jumt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_jenpend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sumair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_terkaitbansos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sumbamasak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(btn_pekerjaan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sbt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_slt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sumper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sumair)
                .addGap(4, 4, 4)
                .addComponent(btn_sumbamasak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_jumt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_terkaitbansos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_jenpend)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 340));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jpk1.setBackground(new java.awt.Color(255, 255, 255));
        jpk1.setRequestFocusEnabled(false);
        jpk1.setVerifyInputWhenFocusTarget(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setEnabled(false);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btn_save.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminform/Icon/Save-icon.png"))); // NOI18N
        btn_save.setText("SIMPAN");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminform/Icon/edit.png"))); // NOI18N
        btn_update.setText("UBAH");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminform/Icon/delete.png"))); // NOI18N
        btn_delete.setText("HAPUS");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("NAMA KRITERIA");

        jLabel2.setText("POINT");

        jLabel3.setText("ID");

        jLabel4.setBackground(new java.awt.Color(102, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setText("KRITERIA");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpk1Layout = new javax.swing.GroupLayout(jpk1);
        jpk1.setLayout(jpk1Layout);
        jpk1Layout.setHorizontalGroup(
            jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpk1Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpk1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(edt_value, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(edt_kriteria))
                    .addComponent(edt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(jpk1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpk1Layout.setVerticalGroup(
            jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpk1Layout.createSequentialGroup()
                .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpk1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_update)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addGap(64, 64, 64))
                    .addGroup(jpk1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(edt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_kriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jpk1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(81, 81, 81)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane2.addTab("FORM KRTERIA", jpk1);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 540, 410));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 20, 20));

        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userformicon/icons8_back_24px_1.png"))); // NOI18N
        jButton2.setText("BACK");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 120, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //===============================================DISINI BUTTON KRITERIA=================================================//

    private void btn_pekerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pekerjaanActionPerformed
        jLabel4.setText("");
        jLabel4.setText("PEKERJAAN");
        modeladmin.setSQL("tb_pekerjaan");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_pekerjaan = ?, poin_pekerjaan = ? where id_pekerjaan = ?");
        modeladmin.setId("id_pekerjaan");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_pekerjaanActionPerformed

    private void btn_sbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sbtActionPerformed
        jLabel4.setText("");
        jLabel4.setText("STATUS BANGUNAN TINGGAL");
        modeladmin.setSQL("tb_sbtinggal");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_sbtinggal = ?, poin_sbtinggal = ? where id_sbtinggal = ?");
        modeladmin.setId("id_sbtinggal");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_sbtActionPerformed

    private void btn_sltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sltActionPerformed
        jLabel4.setText("");
        jLabel4.setText("STATUS LAHAN TINGGAL");
        modeladmin.setSQL("tb_sltinggal");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_sltinggal = ?, poin_sltinggal = ? where id_sltinggal = ?");
        modeladmin.setId("id_sltinggal");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_sltActionPerformed

    private void btn_sumperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sumperActionPerformed
        jLabel4.setText("");
        jLabel4.setText("SUMBER PENERANGAN");
        modeladmin.setSQL("tb_sumper");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_sumper = ?, poin_sumper = ? where id_sumper = ?");
        modeladmin.setId("id_sumper");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_sumperActionPerformed

    private void btn_smActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_smActionPerformed
        jLabel4.setText("");
        jLabel4.setText("STATUS MASYARAKAT");
        modeladmin.setSQL("tb_stm");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_stm = ?, poin_stm = ? where id_stm = ?");
        modeladmin.setId("id_stm");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_smActionPerformed

    private void btn_jumtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jumtActionPerformed
        jLabel4.setText("");
        jLabel4.setText("STATUS JUMLAH TANGGUNGAN");
        modeladmin.setSQL("tb_jumt");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_jumt = ?, poin_jumt = ? where id_jumt = ?");
        modeladmin.setId("id_jumt");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_jumtActionPerformed

    private void btn_jenpendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jenpendActionPerformed
        jLabel4.setText("");
        jLabel4.setText("JENJANG PENDIDIKAN");
        modeladmin.setSQL("tb_jenjangpendidikan");
        modeladmin.setId("id_jenpend");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_pendidikan = ?, poin_pendidikan = ? where "+modeladmin.getID()+"= ?"); 
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_jenpendActionPerformed
    //========================================================BATAS BUTTON KRITERIA========================================//
    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            String sql = "INSERT INTO" + " " + modeladmin.getSQL() + " " + "VALUES(?,?,?)";
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, edt_id.getText());
            ps.setString(2, edt_kriteria.getText());
            ps.setString(3, edt_value.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
            kosongkanedt();
            tampildata();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "GAGAL DISIMPAN" + e);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            String sql = modeladmin.getSQLtabel();
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, edt_kriteria.getText());
            ps.setString(2, edt_value.getText());
            ps.setInt(3, Integer.parseInt(edt_id.getText()));
            ps.execute();
            JOptionPane.showMessageDialog(null, "BERHASIL DIPERBAHARUI");
            kosongkanedt();
            tampildata();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "GAGAL GAGAL DIPERBAHARUI" + e);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            String sql = "delete from" + " " + modeladmin.getSQL() + " " + "where" + " " + modeladmin.getID() + " =" + " " + edt_id.getText() + " ";
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            tampildata();
            JOptionPane.showMessageDialog(null, "BERHASIL DIHAPUS");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "GAGAL DIHAPUS" + e);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String id = jTable1.getValueAt(baris, 0).toString();
        edt_id.setText(id);
        String jenis_k = jTable1.getValueAt(baris, 1).toString();
        edt_kriteria.setText(jenis_k);
        String poin_k = jTable1.getValueAt(baris, 2).toString();
        edt_value.setText(poin_k);
    }//GEN-LAST:event_jTable1MouseClicked
//======================================LANJUTAN BITTON KRITERIA=============================//
    private void btn_sumairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sumairActionPerformed
        jLabel4.setText("");
        jLabel4.setText("SUMBER AIR MINUM");
        modeladmin.setSQL("tb_sumair");
        modeladmin.setId("id_sumair");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_sumair = ?, poin_sumair = ? where "+modeladmin.getID()+"= ?");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_sumairActionPerformed

    private void btn_sumbamasakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sumbamasakActionPerformed
        jLabel4.setText("");
        jLabel4.setText("SUMBER ENERGI MASAK");
        modeladmin.setSQL("tb_energimasak");
        modeladmin.setId("id_energimasak");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_energi = ?, poin_energi = ? where "+modeladmin.getID()+"= ?");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_sumbamasakActionPerformed

    private void btn_terkaitbansosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terkaitbansosActionPerformed
        jLabel4.setText("");
        jLabel4.setText("TERKAIT BANSOS LAIN");
        modeladmin.setSQL("tb_terbansos");
        modeladmin.setId("id_bansos");
        modeladmin.setSQLtabel("UPDATE" + " " + modeladmin.getSQL() + " " + "set jenis_bansos = ?, poin_bansos = ? where "+modeladmin.getID()+"= ?");
        kosongkanedt();
        tampildata();
    }//GEN-LAST:event_btn_terkaitbansosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Admindashboard user = new Admindashboard();
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

//====================================================================//
    //==============================TAMPILKAN DATA=======================//
    public void tampildata() {
        try {
            Connection con = DatabaseConnection.getConnection();
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA KRITERIA");
            df.addColumn("SKOR");
            jTable1.setModel(df);
            String sql = "SELECT * FROM" + " " + modeladmin.getSQL();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                df.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void kosongkanedt() {
        edt_id.setText("");
        edt_kriteria.setText("");
        edt_value.setText("");
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
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_jenpend;
    private javax.swing.JButton btn_jumt;
    private javax.swing.JButton btn_pekerjaan;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_sbt;
    private javax.swing.JButton btn_slt;
    private javax.swing.JButton btn_sm;
    private javax.swing.JButton btn_sumair;
    private javax.swing.JButton btn_sumbamasak;
    private javax.swing.JButton btn_sumper;
    private javax.swing.JButton btn_terkaitbansos;
    private javax.swing.JButton btn_update;
    private javax.swing.JTextField edt_id;
    private javax.swing.JTextField edt_kriteria;
    private javax.swing.JTextField edt_value;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpk1;
    // End of variables declaration//GEN-END:variables
}