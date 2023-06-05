/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allfungsi;

import Singletondatabase.DatabaseConnection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
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
public class Hasil_analisis {

    public JComboBox Cetak(JComboBox a) {
        String ambil = (String) a.getSelectedItem();
        String patch = "";
        if (ambil.equals("001/001")) {
            patch = ".\\src\\fileku\\laporanhasil001.jasper";
        } else if (ambil.equals("002/002")) {
            patch = ".\\src\\fileku\\laporanhasil002.jasper";
        } else if (ambil.equals("003/003")) {
            patch = ".\\src\\fileku\\laporanhasil003.jasper";
        } else if (ambil.equals("004/004")) {
            patch = ".\\src\\fileku\\laporanhassil004.jasper";
        } else if (ambil.equals("005/005")) {
            patch = ".\\src\\fileku\\laporanhasil005.jasper";
        }
        JasperReport reports;
        java.sql.Connection con = DatabaseConnection.getConnection();
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(patch);
            JasperPrint jsprint = JasperFillManager.fillReport(patch, null, con);
            JasperViewer jviwer = new JasperViewer(jsprint, false);
            jviwer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviwer.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "DATA BELUM ADA");
        }
        return null;
    }
    public JComboBox Tampildata(JComboBox a,JTable b){
        String sql = "";
        if (a.getSelectedItem().equals("001/001")){
         sql = "SELECT * FROM tb_hasilkosongsatu ORDER BY netflow DESC";
        }else if (a.getSelectedItem().equals("002/002")){
         sql = "SELECT * FROM tb_hasilkosongdua ORDER BY netflow DESC";
        }else if (a.getSelectedItem().equals("003/003")){
         sql = "SELECT * FROM tb_hasilkosongtiga ORDER BY netflow DESC";
        }else if (a.getSelectedItem().equals("004/004")){
         sql = "SELECT * FROM tb_hasilkosongempat ORDER BY netflow DESC";
        }else if (a.getSelectedItem().equals("005/005")){
         sql = "SELECT * FROM tb_hasilkosonglima ORDER BY netflow DESC";
        }else {
            System.out.println("");
        }
            DefaultTableModel df = new DefaultTableModel();
            df.addColumn("ID");
            df.addColumn("NAMA PENERIMA");
            df.addColumn("NETFLOW");
            df.addColumn("RT/RW");
            df.addColumn("RANGKING");
            b.setModel(df);
            try {
                int i = 1;
                java.sql.Connection con = DatabaseConnection.getConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet RS = st.executeQuery(sql);
                while (RS.next()) {
                    df.addRow(new Object[]{
                        RS.getString(1),
                        RS.getString(2),
                        RS.getString(3),
                        RS.getString(4),
                        i++
                    });
                }
            } catch (SQLException e) {
            }
        
    return null;
    }
    
}
