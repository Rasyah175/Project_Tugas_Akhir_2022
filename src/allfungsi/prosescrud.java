/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allfungsi;

import Singletondatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author Rahimsyah
 */
public class prosescrud {

    public PreparedStatement insertdata(String nama, String rtrw, int a, int b, int c, int d, int f, int g, int h, int i, int j, int k) {
        try {
            String sql = "INSERT INTO tb_penerima VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            java.sql.Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, a);
            ps.setInt(3, b);
            ps.setInt(4, c);
            ps.setInt(5, d);
            ps.setInt(6, f);
            ps.setInt(7, g);
            ps.setInt(8, h);
            ps.setInt(9, i);
            ps.setInt(10, j);
            ps.setInt(11, k);
            ps.setString(12, rtrw);
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN"); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DATA GAGAL DISIMPAN \n TOLONG PERIKSA KEMBALI \n INPUTAN TIDAK LENGKAP \n ADA DATA YANG KOSONG ");
        }
        return null;
    }

    public PreparedStatement Updatedata(String nama, String rtrw, int a, int b, int c, int d, int f, int g, int h, int i, int j, int k, String l) {
        try {
            String sql = "UPDATE `tb_penerima` SET "
                    + "`Nama_penerima` = ?, "
                    + "`id_pekerjaan` = ?, "
                    + "`id_sbtinggal` = ?, "
                    + "`id_sltinggal` = ?, "
                    + "`id_sumper` = ?, "
                    + "`id_sumair` = ?, "
                    + "`id_energimasak` = ?, "
                    + "`id_stm` = ?, "
                    + "`id_jumtang` = ?, "
                    + "`id_jenjangpendidikan` = ?, "
                    + "`id_bansoslain` = ?, "
                    + "`rt_rw` = ? "
                    + "WHERE `tb_penerima`.`id_penerima` = ?";
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, a);
            ps.setInt(3, b);
            ps.setInt(4, c);
            ps.setInt(5, d);
            ps.setInt(6, f);
            ps.setInt(7, g);
            ps.setInt(8, h);
            ps.setInt(9, i);
            ps.setInt(10, j);
            ps.setInt(11, k);
            ps.setString(12, rtrw);
            ps.setInt(13, Integer.parseInt(l));
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL UPDATE");
        } catch (SQLException|NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "GAGAL UPDATE TOLONG PERIKSA \n KEMBALI ADA DATA YANG TIDAK \n DIISI ATAU TIDAK ADA DATA YANG DIPILIH \n UNTUK DIPERBAHARUI");
        }
        return null;
    }

    public PreparedStatement Deletedata(String id) {
        try {
            String sql = "DELETE FROM `tb_penerima` WHERE `tb_penerima`.`id_penerima` = " + id + " ";
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DATA GAGAL DIHAPUS \n PILIH DATA TERLEBIH \n DAHULU SEBELUM MENEKAN \n TOMBOL HAPUS");
        }
        return null;
    }

    public void Kosongkandata() {
        try {
            String sql = "TRUNCATE `tb_penerima`";
            java.sql.Connection con = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "BERHASIL DIKOSONGKAN");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "GAGAL DIKOSONGKAN" + e);
        }
    }


    public JTextField semuatextfield(JTextField a, JTextField b, JTextField c) {
        a.setText("");
        b.setText("");
        c.setText("");
        return null;
    }

    public JComboBox semuacombo(JComboBox a, JComboBox b, JComboBox c, JComboBox d, JComboBox e, JComboBox f, JComboBox g, JComboBox h, JComboBox i, JComboBox j) {
        a.setSelectedIndex(0);
        b.setSelectedIndex(0);
        c.setSelectedIndex(0);
        d.setSelectedIndex(0);
        e.setSelectedIndex(0);
        f.setSelectedIndex(0);
        g.setSelectedIndex(0);
        h.setSelectedIndex(0);
        i.setSelectedIndex(0);
        j.setSelectedIndex(0);
        return null;
    }

    public JTable Tampildata(JTable a) {
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("PEKERJAAN");
            df.addColumn("STATUS BANGUNAN TINGGAL");
            df.addColumn("STATUS LAHAN TINGGAL");
            df.addColumn("SUMBER PENERANGAN");
            df.addColumn("SUMBER AIR MINUM");
            df.addColumn("SUMBER ENERGI MASAK");
            df.addColumn("STATUS MASYARAKAT");
            df.addColumn("JUMLAH TANGGUNGAN");
            df.addColumn("JENJANG PENDIDIKAN");
            df.addColumn("PROGRAM BANSOS LAIN");
            df.addColumn("RT/RW");
            a.setModel(df);

            String sql = "SELECT tb_penerima.id_penerima, "
                    + "tb_penerima.Nama_penerima, "
                    + "tb_pekerjaan.jenis_pekerjaan, "
                    + "tb_sbtinggal.jenis_sbtinggal, "
                    + "tb_sltinggal.jenis_sltinggal, "
                    + "tb_sumper.jenis_sumper, "
                    + "tb_sumair.jenis_sumair, "
                    + "tb_energimasak.jenis_energi, "
                    + "tb_stm.jenis_stm, "
                    + "tb_jumt.jenis_jumt, "
                    + "tb_jenjangpendidikan.jenis_pendidikan, "
                    + "tb_terbansos.jenis_bansos,"
                    + "tb_penerima.rt_rw FROM "
                    + "((((((((((tb_penerima LEFT JOIN tb_pekerjaan ON tb_penerima.id_pekerjaan = tb_pekerjaan.id_pekerjaan)"
                    + "LEFT JOIN tb_sbtinggal ON tb_penerima.id_sbtinggal = tb_sbtinggal.id_sbtinggal)"
                    + "LEFT JOIN tb_sltinggal ON tb_penerima.id_sltinggal = tb_sltinggal.id_sltinggal)"
                    + "LEFT JOIN tb_sumper ON tb_penerima.id_sumper = tb_sumper.id_sumper) "
                    + "LEFT JOIN tb_sumair ON tb_penerima.id_sumair = tb_sumair.id_sumair)"
                    + "LEFT JOIN tb_energimasak ON tb_penerima.id_energimasak = tb_energimasak.id_energimasak)"
                    + "LEFT JOIN tb_stm ON tb_penerima.id_stm = tb_stm.id_stm)"
                    + "LEFT JOIN tb_jumt ON tb_penerima.id_jumtang = tb_jumt.id_jumt)"
                    + "LEFT JOIN tb_jenjangpendidikan ON tb_penerima.id_jenjangpendidikan = tb_jenjangpendidikan.id_jenpend)"
                    + "LEFT JOIN tb_terbansos ON tb_penerima.id_bansoslain = tb_terbansos.id_bansos);";
            Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                df.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13)
                });
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public JTable Tampildatart(JTable a, String rt) {
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("PEKERJAAN");
            df.addColumn("STATUS BANGUNAN TINGGAL");
            df.addColumn("STATUS LAHAN TINGGAL");
            df.addColumn("SUMBER PENERANGAN");
            df.addColumn("SUMBER AIR MINUM");
            df.addColumn("SUMBER ENERGI MASAK");
            df.addColumn("STATUS MASYARAKAT");
            df.addColumn("JUMLAH TANGGUNGAN");
            df.addColumn("JENJANG PENDIDIKAN");
            df.addColumn("PROGRAM BANSOS LAIN");
            df.addColumn("RT/RW");
            a.setModel(df);

            String sql = "SELECT tb_penerima.id_penerima, "
                    + "tb_penerima.Nama_penerima, "
                    + "tb_pekerjaan.jenis_pekerjaan, "
                    + "tb_sbtinggal.jenis_sbtinggal, "
                    + "tb_sltinggal.jenis_sltinggal, "
                    + "tb_sumper.jenis_sumper, "
                    + "tb_sumair.jenis_sumair, "
                    + "tb_energimasak.jenis_energi, "
                    + "tb_stm.jenis_stm, "
                    + "tb_jumt.jenis_jumt, "
                    + "tb_jenjangpendidikan.jenis_pendidikan, "
                    + "tb_terbansos.jenis_bansos,"
                    + "tb_penerima.rt_rw FROM "
                    + "((((((((((tb_penerima LEFT JOIN tb_pekerjaan ON tb_penerima.id_pekerjaan = tb_pekerjaan.id_pekerjaan)"
                    + "LEFT JOIN tb_sbtinggal ON tb_penerima.id_sbtinggal = tb_sbtinggal.id_sbtinggal)"
                    + "LEFT JOIN tb_sltinggal ON tb_penerima.id_sltinggal = tb_sltinggal.id_sltinggal)"
                    + "LEFT JOIN tb_sumper ON tb_penerima.id_sumper = tb_sumper.id_sumper) "
                    + "LEFT JOIN tb_sumair ON tb_penerima.id_sumair = tb_sumair.id_sumair)"
                    + "LEFT JOIN tb_energimasak ON tb_penerima.id_energimasak = tb_energimasak.id_energimasak)"
                    + "LEFT JOIN tb_stm ON tb_penerima.id_stm = tb_stm.id_stm)"
                    + "LEFT JOIN tb_jumt ON tb_penerima.id_jumtang = tb_jumt.id_jumt)"
                    + "LEFT JOIN tb_jenjangpendidikan ON tb_penerima.id_jenjangpendidikan = tb_jenjangpendidikan.id_jenpend)"
                    + "LEFT JOIN tb_terbansos ON tb_penerima.id_bansoslain = tb_terbansos.id_bansos)where rt_rw = '" + rt + "';";
            Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                df.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13)
                });
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public JTable Ukurancolom(JTable a) {
        TableColumn tableColumn;
        a.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableColumn = a.getColumnModel().getColumn(0);
        tableColumn.setPreferredWidth(50);
        tableColumn = a.getColumnModel().getColumn(1);
        tableColumn.setPreferredWidth(150);
        tableColumn = a.getColumnModel().getColumn(2);
        tableColumn.setPreferredWidth(150);
        tableColumn = a.getColumnModel().getColumn(3);
        tableColumn.setPreferredWidth(200);
        tableColumn = a.getColumnModel().getColumn(4);
        tableColumn.setPreferredWidth(200);
        tableColumn = a.getColumnModel().getColumn(5);
        tableColumn.setPreferredWidth(150);
        tableColumn = a.getColumnModel().getColumn(6);
        tableColumn.setPreferredWidth(150);
        tableColumn = a.getColumnModel().getColumn(7);
        tableColumn.setPreferredWidth(170);
        tableColumn = a.getColumnModel().getColumn(8);
        tableColumn.setPreferredWidth(200);
        tableColumn = a.getColumnModel().getColumn(9);
        tableColumn.setPreferredWidth(150);
        tableColumn = a.getColumnModel().getColumn(10);
        tableColumn.setPreferredWidth(150);
        tableColumn = a.getColumnModel().getColumn(11);
        tableColumn.setPreferredWidth(160);
        tableColumn = a.getColumnModel().getColumn(12);
        tableColumn.setPreferredWidth(100);
        return null;
    }

    public JComboBox Pilihan(JComboBox a, String b) {
        try {
            Connection con = Singletondatabase.DatabaseConnection.getConnection();
            String sql = "SELECT * FROM " + b + "";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                a.addItem(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public JTable Ambildatatabel(JTable jt, MouseEvent evt, JTextField id, JTextField nama, JTextField rtrw, JComboBox a, JComboBox b, JComboBox c, JComboBox d, JComboBox e, JComboBox f, JComboBox g, JComboBox h, JComboBox i, JComboBox j) {
        int baris = jt.rowAtPoint(evt.getPoint());
        id.setText(jt.getValueAt(baris, 0).toString());
        nama.setText(jt.getValueAt(baris, 1).toString());
        a.setSelectedItem(jt.getValueAt(baris, 2).toString());
        b.setSelectedItem(jt.getValueAt(baris, 3).toString());
        c.setSelectedItem(jt.getValueAt(baris, 4).toString());
        d.setSelectedItem(jt.getValueAt(baris, 5).toString());
        e.setSelectedItem(jt.getValueAt(baris, 6).toString());
        f.setSelectedItem(jt.getValueAt(baris, 7).toString());
        g.setSelectedItem(jt.getValueAt(baris, 8).toString());
        h.setSelectedItem(jt.getValueAt(baris, 9).toString());
        i.setSelectedItem(jt.getValueAt(baris, 10).toString());
        j.setSelectedItem(jt.getValueAt(baris, 11).toString());
        rtrw.setText(jt.getValueAt(baris, 12).toString());
        return null;
    }
}
