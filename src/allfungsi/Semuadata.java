/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allfungsi;

import Singletondatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rahimsyah
 */
public class Semuadata {
        public void cetakdata() {
        JasperReport reports;
        String patch = ".\\src\\fileku\\datamentahpenerima.jasper";
        java.sql.Connection con = DatabaseConnection.getConnection();
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(patch);
            JasperPrint jsprint = JasperFillManager.fillReport(patch, null, con);
            JasperViewer jviwer = new JasperViewer(jsprint, false);
            jviwer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviwer.setVisible(true);
        } catch (JRException e) {
            System.out.println(e);
        }

    }
    public JTable Tampilsemuadata(JTable a){
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
    public JTable TampilPerrt(JTable a, JComboBox b){
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
                    + "LEFT JOIN tb_terbansos ON tb_penerima.id_bansoslain = tb_terbansos.id_bansos)Where rt_rw = '" + b.getSelectedItem() + "';";
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
    
}
