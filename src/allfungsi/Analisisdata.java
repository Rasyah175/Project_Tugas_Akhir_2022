/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allfungsi;

import PrometheeIImodel.modelbobotkriteria;
import Promethee_II.PrometheeII;
import Promethee_II.PrometheeII001;
import Promethee_II.PrometheeII002;
import Promethee_II.PrometheeII003;
import Promethee_II.PrometheeII004;
import Singletondatabase.DatabaseConnection;
import adminform.form_hasil;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rahimsyah
 */
public class Analisisdata {

    public JComboBox perubahanbutton(JComboBox a, JTable b, JLabel n, JButton btn) {
        String rtrw = (String) a.getSelectedItem();
        n.setText(rtrw);
        tampildataperrt(b, a);
        ukurancollomtabel(b);
        String namatabel = "";
        if (rtrw.equals("001/001")) {
            namatabel = "tb_hasilkosongsatu";
        } else if (rtrw.equals("002/002")) {
            namatabel = "tb_hasilkosongdua";
        } else if (rtrw.equals("003/003")) {
            namatabel = "tb_hasilkosongtiga";
        } else if (rtrw.equals("004/004")) {
            namatabel = "tb_hasilkosongempat";
        } else if (rtrw.equals("005/005")) {
            namatabel = "tb_hasilkosonglima";
        }
        try {
            java.sql.Connection koneksi = DatabaseConnection.getConnection();
            java.sql.Statement st = koneksi.createStatement();
            java.sql.ResultSet rs = st.executeQuery("SELECT * FROM " + namatabel);
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                btn.setText("SIMPAN");
            } else {
                JOptionPane.showMessageDialog(null, "RT/RW YANG DIPILIH MASIH MEMILIKI \n DATA HASIL ANALISIS YANG LAMA \n KOSONGKAN TERLEBIH DAHULU LALU SIMPAN DENGAN MENEKAN TOMBOL SIMPAN");
                btn.setText("KOSONGKAN");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("");
        }
        return null;
    }

    public JTable tampildataperrt(JTable a, JComboBox b) {
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
                    + "LEFT JOIN tb_terbansos ON tb_penerima.id_bansoslain = tb_terbansos.id_bansos)where rt_rw = '" + b.getSelectedItem() + "';";
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
                    rs.getString(13)});
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public JComboBox savedata(JComboBox a, JButton h) {
        String ambil = (String) a.getSelectedItem();
        int batas = 0;
        if (ambil.equals("001/001")) {
            try {
                java.sql.Connection koneksi = DatabaseConnection.getConnection();
                java.sql.Statement st = koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT * FROM tb_hasilkosongsatu");
                int i = 0;
                while (rs.next()) {
                    i++;
                }
                if (i == 0) {
                    PrometheeII PM = new PrometheeII();
                    ArrayList<modelbobotkriteria> MB = PM.PROSESBOBOTKALIVALUE();
                    ArrayList<Double> MN = PM.Hasil();
                    String sql = "INSERT INTO tb_hasilkosongsatu VALUES (null,?,?,?);";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    for (int g = 0; g < MB.size(); g++) {
                        ps.setString(1, MB.get(g).getNamapener());
                        ps.setDouble(2, MN.get(g));
                        ps.setString(3, MB.get(i).getRtrw());
                        ps.execute();
                    }

                    JOptionPane.showMessageDialog(null, "PROSES SIMPAN, KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");

                } else if (i != 0) {

                    String sql = "Truncate tb_hasilkosongsatu";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "PROSES PENGOSONGAN,KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DIKOSONGKAN");
                    h.setText("SIMPAN");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + " " + e);
            }

        } else if (ambil.equals("002/002")) {
            try {
                java.sql.Connection koneksi = DatabaseConnection.getConnection();
                java.sql.Statement st = koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT * FROM tb_hasilkosongdua");
                int i = 0;
                while (rs.next()) {
                    i++;
                }
                if (i == 0) {
                    PrometheeII001 PM = new PrometheeII001();
                    ArrayList<modelbobotkriteria> MB = PM.PROSESBOBOTKALIVALUE();
                    ArrayList<Double> MN = PM.Hasil();
                    String sql = "INSERT INTO tb_hasilkosongdua VALUES (null,?,?,?);";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    for (int g = 0; g < MB.size(); g++) {
                        ps.setString(1, MB.get(g).getNamapener());
                        ps.setDouble(2, MN.get(g));
                        ps.setString(3, MB.get(i).getRtrw());
                        ps.execute();
                    }
                    JOptionPane.showMessageDialog(null, "PROSES SIMPAN, KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
                } else if (i != 0) {
                    String sql = "Truncate tb_hasilkosongdua";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "PROSES PENGOSONGAN,KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DIKOSONGKAN");
                    h.setText("SIMPAN");

                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + " " + e);
            }
        } else if (ambil.equals("003/003")) {
            try {
                java.sql.Connection koneksi = DatabaseConnection.getConnection();
                java.sql.Statement st = koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT * FROM tb_hasilkosongtiga");
                int i = 0;
                while (rs.next()) {
                    i++;
                }
                if (i == 0) {
                    PrometheeII002 PM = new PrometheeII002();
                    ArrayList<modelbobotkriteria> MB = PM.PROSESBOBOTKALIVALUE();
                    ArrayList<Double> MN = PM.Hasil();
                    String sql = "INSERT INTO tb_hasilkosongtiga VALUES (null,?,?,?);";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    for (int g = 0; g < MB.size(); g++) {
                        ps.setString(1, MB.get(g).getNamapener());
                        ps.setDouble(2, MN.get(g));
                        ps.setString(3, MB.get(i).getRtrw());
                        ps.execute();
                    }
                    JOptionPane.showMessageDialog(null, "PROSES SIMPAN, KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
                } else if (i != 0) {
                    String sql = "Truncate tb_hasilkosongtiga";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "PROSES PENGOSONGAN,KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DIKOSONGKAN");
                    h.setText("SIMPAN");

                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + " " + e);
            }
        } else if (ambil.equals("004/004")) {
            try {
                java.sql.Connection koneksi = DatabaseConnection.getConnection();
                java.sql.Statement st = koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT * FROM tb_hasilkosongempat");
                int i = 0;
                while (rs.next()) {
                    i++;
                }
                if (i == 0) {
                    PrometheeII003 PM = new PrometheeII003();
                    ArrayList<modelbobotkriteria> MB = PM.PROSESBOBOTKALIVALUE();
                    ArrayList<Double> MN = PM.Hasil();
                    String sql = "INSERT INTO tb_hasilkosongempat VALUES (null,?,?,?);";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    for (int g = 0; g < MB.size(); g++) {
                        ps.setString(1, MB.get(g).getNamapener());
                        ps.setDouble(2, MN.get(g));
                        ps.setString(3, MB.get(i).getRtrw());
                        ps.execute();
                    }

                    JOptionPane.showMessageDialog(null, "PROSES SIMPAN, KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
                } else if (i != 0) {
                    String sql = "Truncate tb_hasilkosongempat";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "PROSES PENGOSONGAN,KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DIKOSONGKAN");
                    h.setText("SIMPAN");

                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + " " + e);
            }
        } else if (ambil.equals("005/005")) {
            try {
                java.sql.Connection koneksi = DatabaseConnection.getConnection();
                java.sql.Statement st = koneksi.createStatement();
                java.sql.ResultSet rs = st.executeQuery("SELECT * FROM tb_hasilkosonglima");
                int i = 0;
                while (rs.next()) {
                    i++;
                }
                if (i == 0) {
                    PrometheeII004 PM = new PrometheeII004();
                    ArrayList<modelbobotkriteria> MB = PM.PROSESBOBOTKALIVALUE();
                    ArrayList<Double> MN = PM.Hasil();
                    String sql = "INSERT INTO tb_hasilkosonglima VALUES (null,?,?,?);";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    for (int g = 0; g < MB.size(); g++) {
                        ps.setString(1, MB.get(g).getNamapener());
                        ps.setDouble(2, MN.get(g));
                        ps.setString(3, MB.get(i).getRtrw());
                        ps.execute();
                    }
                    JOptionPane.showMessageDialog(null, "PROSES SIMPAN, KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");
                } else if (i != 0) {
                    String sql = "Truncate tb_hasilkosonglima";
                    java.sql.Connection con = DatabaseConnection.getConnection();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "PROSES PENGOSONGAN,KLIK OK");
                    JOptionPane.showMessageDialog(null, "BERHASIL DIKOSONGKAN");
                    h.setText("SIMPAN");

                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + " " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "PILIH TERLEBIH DAHULU \n HASIL RT/RW MANA YANG MASUK \n DISIMPAN");
        }
        return null;
    }

    //tempat melihat data//
    public JComboBox hasilnetfow(JTable a, JComboBox b) {
        String ambil = (String) b.getSelectedItem();
        if (ambil.equals("001/001")) {
            tampilhasilrangking001(a);
            ukurannetflow(a);
        } else if (b.getSelectedItem().equals("002/002")) {
            tampilhasilrangking002(a);
            ukurannetflow(a);
        } else if (b.getSelectedItem().equals("003/003")) {
            tampilhasilrangking003(a);
            ukurannetflow(a);
        } else if (b.getSelectedItem().equals("004/004")) {
            tampilhasilrangking004(a);
            ukurannetflow(a);
        } else if (b.getSelectedItem().equals("005/005")) {
            tampilhasilrangking005(a);
            ukurannetflow(a);
        } else {
            JOptionPane.showMessageDialog(null, "PILIH RT/RW TERLEBIH DAHULU RT/RW YANG INGIN DIPROSES \nSEBELUM MENEKAN PROSES");
        }

        return null;
    }

    public JTable tampilhasilrangking001(JTable a) {
        PrometheeII PM = new PrometheeII();
        ArrayList<modelbobotkriteria> mb = PM.PROSESBOBOTKALIVALUE();
        ArrayList<Double> hasil = PM.Hasil();
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("NETFLOW");
            df.addColumn("RTRW");
            a.setModel(df);
            for (int i = 0; i < mb.size(); i++) {
                df.addRow(new Object[]{
                    i,
                    mb.get(i).getNamapener(),
                    hasil.get(i),
                    mb.get(i).getRtrw()
                });
            }
        } catch (Exception e) {
        }
        return null;
    }

    public JTable tampilhasilrangking002(JTable a) {
        PrometheeII001 PM = new PrometheeII001();
        ArrayList<modelbobotkriteria> mb = PM.PROSESBOBOTKALIVALUE();
        ArrayList<Double> hasil = PM.Hasil();
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("NETFLOW");
            df.addColumn("RTRW");
            a.setModel(df);
            for (int i = 0; i < mb.size(); i++) {
                df.addRow(new Object[]{
                    i,
                    mb.get(i).getNamapener(),
                    hasil.get(i),
                    mb.get(i).getRtrw()
                });
            }
        } catch (Exception e) {
        }
        return null;
    }

    public JTable tampilhasilrangking003(JTable a) {
        PrometheeII002 PM = new PrometheeII002();
        ArrayList<modelbobotkriteria> mb = PM.PROSESBOBOTKALIVALUE();
        ArrayList<Double> hasil = PM.Hasil();
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("NETFLOW");
            df.addColumn("RTRW");
            a.setModel(df);
            for (int i = 0; i < mb.size(); i++) {
                df.addRow(new Object[]{
                    i,
                    mb.get(i).getNamapener(),
                    hasil.get(i),
                    mb.get(i).getRtrw()
                });
            }
        } catch (Exception e) {
        }
        return null;
    }

    public JTable tampilhasilrangking004(JTable a) {
        PrometheeII003 PM = new PrometheeII003();
        ArrayList<modelbobotkriteria> mb = PM.PROSESBOBOTKALIVALUE();
        ArrayList<Double> hasil = PM.Hasil();
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("NETFLOW");
            df.addColumn("RTRW");
            a.setModel(df);
            for (int i = 0; i < mb.size(); i++) {
                df.addRow(new Object[]{
                    i,
                    mb.get(i).getNamapener(),
                    hasil.get(i),
                    mb.get(i).getRtrw()
                });
            }
        } catch (Exception e) {
        }
        return null;
    }

    public JTable tampilhasilrangking005(JTable a) {
        PrometheeII004 PM = new PrometheeII004();
        ArrayList<modelbobotkriteria> mb = PM.PROSESBOBOTKALIVALUE();
        ArrayList<Double> hasil = PM.Hasil();
        try {
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA");
            df.addColumn("NETFLOW");
            df.addColumn("RTRW");
            a.setModel(df);
            for (int i = 0; i < mb.size(); i++) {
                df.addRow(new Object[]{
                    i,
                    mb.get(i).getNamapener(),
                    hasil.get(i),
                    mb.get(i).getRtrw()
                });
            }
        } catch (Exception e) {
        }
        return null;
    }

    public JTable ukurancollomtabel(JTable a) {
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

    public JTable ukurannetflow(JTable a) {
        TableColumn tableColumn;
        a.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableColumn = a.getColumnModel().getColumn(0);
        tableColumn.setPreferredWidth(190);
        tableColumn = a.getColumnModel().getColumn(1);
        tableColumn.setPreferredWidth(250);
        tableColumn = a.getColumnModel().getColumn(2);
        tableColumn.setPreferredWidth(250);
        tableColumn = a.getColumnModel().getColumn(3);
        tableColumn.setPreferredWidth(180);
        return null;
    }

    public JTable tampilsemuadata(JTable a) {
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
            ukurancollomtabel(a);
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

    public ArrayList<Integer> ambibatas(String sql) {
        ArrayList<Integer> batas = new ArrayList<>();
        try {
            String ambilbatas = sql;
            int i = 0;
            java.sql.Connection get = DatabaseConnection.getConnection();
            java.sql.Statement getst = get.createStatement();
            java.sql.ResultSet getrs = getst.executeQuery(ambilbatas);
            while (getrs.next()) {
                i++;
                batas.add(i);
            }
        } catch (SQLException e) {
        }
        return batas;
    }

    public JComboBox ambildatalayak(JComboBox a, JLabel b, JTable c) {
        String ambil = (String) a.getSelectedItem();
        Analisisdata dt = new Analisisdata();
        if (ambil.equals("001/001")) {
            try {
                //===================================PENGAMBILAN BATAS ============================//
                b.setText("PENERIMA YANG LAYAK RT/RT (001/001)");
                String ambilbatas = "SELECT * FROM tb_hasilkosongsatu";
                ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
                //======================MENAMPILKAN ISI=====================================================//
                String sql = "SELECT * FROM tb_hasilkosongsatu ORDER BY netflow DESC LIMIT " + batas.size() / 2;
                DefaultTableModel df = new DefaultTableModel();
                df.addColumn("NAMA PENERIMA LAYAK");
                df.addColumn("NETFLOW");
                df.addColumn("RT/RW");
                c.setModel(df);
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (ambil.equals("002/002")) {
            b.setText("PENERIMA YANG LAYAK RT/RT (002/002)");
            try {
                //===================================PENGAMBILAN BATAS ============================//
                String ambilbatas = "SELECT * FROM tb_hasilkosongdua";
                ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
                //======================MENAMPILKAN ISI=====================================================//
                String sql = "SELECT * FROM tb_hasilkosongdua ORDER BY netflow DESC LIMIT " + batas.size() / 2;
                DefaultTableModel df = new DefaultTableModel();
                df.addColumn("NAMA PENERIMA LAYAK");
                df.addColumn("NETFLOW");
                df.addColumn("RT/RW");
                c.setModel(df);
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ambil.equals("003/003")) {
            b.setText("PENERIMA YANG LAYAK RT/RT (003/003)");
            try {
                //===================================PENGAMBILAN BATAS ============================//
                String ambilbatas = "SELECT * FROM tb_hasilkosongtiga";
                ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
                //======================MENAMPILKAN ISI=====================================================//
                String sql = "SELECT * FROM tb_hasilkosongtiga ORDER BY netflow DESC LIMIT 0," + batas.size() / 2;
                DefaultTableModel df = new DefaultTableModel();
                df.addColumn("NAMA PENERIMA LAYAK");
                df.addColumn("NETFLOW");
                df.addColumn("RT/RW");
                c.setModel(df);

                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ambil.equals("004/004")) {
            b.setText("PENERIMA YANG LAYAK RT/RT (004/004)");
            try {
                //===================================PENGAMBILAN BATAS ============================//
                String ambilbatas = "SELECT * FROM tb_hasilkosongempat";
                ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
                //======================MENAMPILKAN ISI=====================================================//
                String sql = "SELECT * FROM tb_hasilkosongempat ORDER BY netflow DESC LIMIT " + batas.size() / 2;
                DefaultTableModel df = new DefaultTableModel();
                df.addColumn("NAMA PENERIMA LAYAK");
                df.addColumn("NETFLOW");
                df.addColumn("RT/RW");
                c.setModel(df);
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ambil.equals("005/005")) {
            b.setText("PENERIMA YANG LAYAK RT/RT (005/005)");
            //Ambil batas
            String ambilbatas = "SELECT * FROM tb_hasilkosonglima";
            ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
            //isi batas
            String sql = "SELECT * FROM tb_hasilkosonglima ORDER BY netflow DESC LIMIT " + batas.size() / 2;
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("NAMA PENERIMA LAYAK");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            c.setModel(df);
            try {
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "PILIH TERLEBIH DAHULU RT/RW \n SEBELUM MELIHAT DATA PENERIMA \n YANG LAYAK MAUPUN TIDAK LAYAK");
        }

        return null;
    }

    public JComboBox ambildatatidaklayak(JComboBox a, JLabel b, JTable c) {
        String ambil = (String) a.getSelectedItem();
        Analisisdata dt = new Analisisdata();
        if (ambil.equals("001/001")) {
            //Ambil batas
            String ambilbatas = "SELECT * FROM tb_hasilkosongsatu";
            ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
            //isi batas
            b.setText("PENERIMA YANG TIDAK LAYAK RT/RT (001/001)");
            String sql = "SELECT * FROM tb_hasilkosongsatu ORDER BY netflow DESC LIMIT " + batas.size() / 2 + "," + batas.size();
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("NAMA PENERIMA LAYAK");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            c.setModel(df);
            try {
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (ambil.equals("002/002")) {
            //Ambil batas
            String ambilbatas = "SELECT * FROM tb_hasilkosongdua";
            ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
            //isi batas
            b.setText("PENERIMA YANG TIDAK LAYAK RT/RT (002/002)");
            String sql = "SELECT * FROM tb_hasilkosongdua ORDER BY netflow DESC LIMIT " + batas.size() / 2 + "," + batas.size();
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("NAMA PENERIMA LAYAK");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            c.setModel(df);
            try {
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ambil.equals("003/003")) {
            //Ambil batas
            String ambilbatas = "SELECT * FROM tb_hasilkosongtiga";
            ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
            //isi batas
            b.setText("PENERIMA YANG TIDAK LAYAK RT/RT (003/003)");
            String sql = "SELECT * FROM tb_hasilkosongtiga ORDER BY netflow DESC LIMIT " + batas.size() / 2 + "," + batas.size();
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("NAMA PENERIMA LAYAK");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            c.setModel(df);
            try {
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ambil.equals("004/004")) {
            //Ambil batas
            String ambilbatas = "SELECT * FROM tb_hasilkosongempat";
            ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
            //isi batas
            b.setText("PENERIMA YANG TIDAK LAYAK RT/RT (004/004)");
            String sql = "SELECT * FROM tb_hasilkosongempat ORDER BY netflow DESC LIMIT " + batas.size() / 2 + "," + batas.size();
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("NAMA PENERIMA LAYAK");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            c.setModel(df);
            try {
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ambil.equals("005/005")) {
            //Ambil batas
            String ambilbatas = "SELECT * FROM tb_hasilkosonglima";
            ArrayList<Integer> batas = dt.ambibatas(ambilbatas);
            //isi batas
            b.setText("PENERIMA YANG TIDAK LAYAK RT/RT (005/005)");
            String sql = "SELECT * FROM tb_hasilkosonglima ORDER BY netflow DESC LIMIT " + batas.size() / 2 + "," + batas.size();
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("NAMA PENERIMA LAYAK");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            c.setModel(df);
            try {
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    df.addRow(new Object[]{
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(form_hasil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "PILIH TERLEBIH DAHULU RT/RW \n SEBELUM MELIHAT DATA PENERIMA \n YANG LAYAK MAUPUN TIDAK LAYAK");
        }
        return null;
    }
}
