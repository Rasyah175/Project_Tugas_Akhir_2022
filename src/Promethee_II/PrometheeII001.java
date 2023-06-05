/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promethee_II;

import PrometheeIImodel.modelbobotkriteria;
import PrometheeIImodel.modelambilpoin;
import PrometheeIImodel.modelambildatanormal;
import PrometheeIImodel.modelmaxmin;
import PrometheeIImodel.modelnormalisasimatriks;
import PrometheeIImodel.modelpreferensiagregat;
import PrometheeIImodel.modelpreferensiquasi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rahimsyah
 */
public class PrometheeII001 {

    //============================CONTROL AMBIL DATA tb_penerima========================//
    public ArrayList<modelambildatanormal> AMBILDATANORMAL() {
        Connection con = Singletondatabase.DatabaseConnection.getConnection();
        //==============MASUKKAN DATA NORMAL PENERIMA DALAM MODEL DATA NORMAL===============// 
        ArrayList<modelambildatanormal> ar = new ArrayList<>();
        //==============================================================//
        try {
            String SQL = "SELECT * FROM tb_penerima";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                String Nama = rs.getString("nama_penerima");
                int idpeker = rs.getInt("id_pekerjaan");
                int idsbt = rs.getInt("id_sbtinggal");
                int idslt = rs.getInt("id_sltinggal");
                int idsumper = rs.getInt("id_sumper");
                int idsumair = rs.getInt("id_sumair");
                int idenergi = rs.getInt("id_energimasak");
                int idstm = rs.getInt("id_stm");
                int idjum = rs.getInt("id_jumtang");
                int idterbansos = rs.getInt("id_bansoslain");
                int idjanpend = rs.getInt("id_jenjangpendidikan");
                String rtrw = rs.getString("rt_rw");
                modelambildatanormal mp = new modelambildatanormal(Nama, idpeker, idsbt, idslt, idsumper, idsumair, idenergi, idstm, idjum, idjanpend, idterbansos, rtrw);
                ar.add(mp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ar;
    }

    //===================================CONTROL AMBIL DATA POIN SETIAP KRITERIA PENERIMA================================//
    public ArrayList<modelambilpoin> AMBILDATAPOIN() {
        //=====MASUKKAN DATA PENERIMA KEDALAM MODEL AMBIL POIN// 
        ArrayList<modelambilpoin> ar = new ArrayList<>();
        String rt = "002/002";
        //=================================================
        Connection con = Singletondatabase.DatabaseConnection.getConnection();
        String sql = " SELECT tb_pekerjaan.poin_pekerjaan, "
                + "tb_sbtinggal.poin_sbtinggal, "
                + "tb_sltinggal.poin_sltinggal, "
                + "tb_sumper.poin_sumper, "
                + "tb_sumair.poin_sumair,"
                + "tb_energimasak.poin_energi,"
                + "tb_stm.poin_stm,"
                + "tb_jumt.poin_jumt, "
                + "tb_jenjangpendidikan.poin_pendidikan,"
                + "tb_terbansos.poin_bansos,"
                + "tb_penerima.Nama_penerima, tb_penerima.rt_rw from "
                + "((((((((((tb_penerima LEFT JOIN tb_pekerjaan ON tb_penerima.id_pekerjaan = tb_pekerjaan.id_pekerjaan)"
                + "LEFT JOIN tb_sbtinggal ON tb_penerima.id_sbtinggal = tb_sbtinggal.id_sbtinggal)"
                + "LEFT JOIN tb_sltinggal ON tb_penerima.id_sltinggal = tb_sltinggal.id_sltinggal)"
                + "LEFT JOIN tb_sumper ON tb_penerima.id_sumper = tb_sumper.id_sumper)"
                + "LEFT JOIN tb_sumair ON tb_penerima.id_sumair = tb_sumair.id_sumair)"
                + "LEFT JOIN tb_energimasak ON tb_penerima.id_energimasak = tb_energimasak.id_energimasak)"
                + "LEFT JOIN tb_stm ON tb_penerima.id_stm = tb_stm.id_stm)"
                + "LEFT JOIN tb_jumt ON tb_penerima.id_jumtang = tb_jumt.id_jumt)"
                + "LEFT JOIN tb_jenjangpendidikan ON tb_penerima.id_jenjangpendidikan = tb_jenjangpendidikan.id_jenpend)"
                + "LEFT JOIN tb_terbansos ON tb_penerima.id_bansoslain = tb_terbansos.id_bansos)Where rt_rw = '" + rt + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int poinpeker = rs.getInt("tb_pekerjaan.poin_pekerjaan");
                int poinsbt = rs.getInt("tb_sbtinggal.poin_sbtinggal");
                int poinslt = rs.getInt("tb_sltinggal.poin_sltinggal");
                int poinsumper = rs.getInt("tb_sumper.poin_sumper");
                int poinsumair = rs.getInt("tb_sumair.poin_sumair");
                int poinenegi = rs.getInt("tb_energimasak.poin_energi");
                int poinsm = rs.getInt("tb_stm.poin_stm");
                int poinjumt = rs.getInt("tb_jumt.poin_jumt");
                int poinjenpend = rs.getInt("tb_jenjangpendidikan.poin_pendidikan");
                int pointerbansos = rs.getInt("tb_terbansos.poin_bansos");
                String namapener = rs.getString("tb_penerima.Nama_penerima");
                String rtrw = rs.getString("tb_penerima.rt_rw");
                modelambilpoin md = new modelambilpoin(poinpeker, poinsbt, poinslt, poinsumper, poinsumair, poinenegi, poinsm, poinjumt, poinjenpend, pointerbansos, namapener, rtrw);
                ar.add(md);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ar;
    }

    //===================================CONTROL POIN (VALUE)KRITERIA DI KALI BOBOT====================================//
   public ArrayList<modelbobotkriteria> PROSESBOBOTKALIVALUE() {
        PrometheeII001 pm = new PrometheeII001();
        //====MASUKKAN DATA BOBOT X VALUE KEDALAM MODEL BOBOT KRITERIA//
        ArrayList<modelbobotkriteria> data = new ArrayList<>();
        //============================================================
        ArrayList<modelambilpoin> poin = pm.AMBILDATAPOIN();
        for (int i = 0; i < poin.size(); i++) {
            int bbtpeker = poin.get(i).getPoinpeker() * 12;
            int bbtsbt = poin.get(i).getPoinsbt() * 8;
            int bbtslt = poin.get(i).getPoinslt() * 8;
            int bbtsumper = poin.get(i).getPoinsumper() * 9;
            int bbtsumair = poin.get(i).getPoinsumair() * 9;
            int bbtenergi = poin.get(i).getPoinenergimasak() * 9;
            int bbtstm = poin.get(i).getPoinstm() * 10;
            int bbtjumt = poin.get(i).getPoinjumtang() * 12;
            int bbtjenpend = poin.get(i).getPoinjenpend() * 13;
            int bbtterbansos = poin.get(i).getPointerbansos() * 10;
            String namaper = poin.get(i).getNamapener();
            String rtrw = poin.get(i).getRtrw();
            modelbobotkriteria md = new modelbobotkriteria(bbtpeker, bbtsbt, bbtslt, bbtsumper, bbtsumair, bbtenergi, bbtstm, bbtjumt, bbtjenpend, bbtterbansos, namaper, rtrw);
            data.add(md);
        }
        return data;
    }

    //=========================CONTROL MIN DAN MAX POIN HASIL KALI BOBOT DAN VALUE=========================//
    public ArrayList<modelmaxmin> MASUKKANMAXMIN() {
        PrometheeII001 pm = new PrometheeII001();
        //=======================LANGKAH 1=======================//
        //MODEL TAMPUNG NILAI MIN DAN MAX //
        ArrayList<modelmaxmin> modelmax = new ArrayList<>();
        //====================================================//
        ArrayList<modelbobotkriteria> mm = pm.PROSESBOBOTKALIVALUE();
         if (mm.isEmpty()){
            JOptionPane.showMessageDialog(null, "DATA RT/RW 002/002 KOSONG \n input terlebih Dahulu Data calon penerima \n bantuan");
        }
        int[] datapeker = new int[mm.size()];
        int[] datapsbt = new int[mm.size()];
        int[] datapslt = new int[mm.size()];
        int[] datapsumper = new int[mm.size()];
        int[] datasumair = new int[mm.size()];
        int[] dataenergimasak = new int[mm.size()];
        int[] datapstm = new int[mm.size()];
        int[] datapjumt = new int[mm.size()];
        int[] dataterbansos = new int[mm.size()];
        int[] datajenpen = new int[mm.size()];
        //ambil data bobot kriteria//
        for (int i = 0; i < mm.size(); i++) {
            datapeker[i] = (int) mm.get(i).getBobotpekerjaan();
            datapsbt[i] = (int) mm.get(i).getBobotsbt();
            datapslt[i] = (int) mm.get(i).getBobotslt();
            datapsumper[i] = (int) mm.get(i).getBobotsumper();
            datasumair[i] = (int) mm.get(i).getBobotsumair();
            dataenergimasak[i] = (int) mm.get(i).getBobotenergimasak();
            datapstm[i] = (int) mm.get(i).getBobotstm();
            datapjumt[i] = (int) mm.get(i).getBobotjumt();
            dataterbansos[i] = (int) mm.get(i).getBobottrebansos();
            datajenpen[i] = (int) mm.get(i).getBobotjenpend();
        }
        int Maxpeker = datapeker[0], Minpeker = datapeker[0],
                Maxsbt = datapsbt[0], Minsbt = datapsbt[0],
                Maxslt = datapslt[0], Minslt = datapslt[0],
                Maxsumper = datapsumper[0], Minsumper = datapsumper[0],
                Maxsumair = datasumair[0], Minsumair = datasumair[0],
                Maxenegimasak = dataenergimasak[0], Minenergimasak = dataenergimasak[0],
                Maxstm = datapstm[0], Minstm = datapstm[0],
                Maxjumt = datapjumt[0], Minjumt = datapjumt[0],
                Maxterbansos = dataterbansos[0], Minterbansos = dataterbansos[0],
                Maxjenpen = datajenpen[0], Minjenpen = datajenpen[0];
        for (int i = 0; i < mm.size(); i++) {
            //=========================TEMPAT MEMASUKKAN NILAI MAX=======================//
            if (Maxpeker < datapeker[i]) {
                Maxpeker = datapeker[i];
            }
            if (Maxsbt < datapsbt[i]) {
                Maxsbt = datapsbt[i];
            }

            if (Maxslt < datapslt[i]) {
                Maxslt = datapslt[i];
            }

            if (Maxsumper < datapsumper[i]) {
                Maxsumper = datapsumper[i];
            }

            if (Maxsumair < datasumair[i]) {
                Maxsumair = datasumair[i];

            }

            if (Maxenegimasak < dataenergimasak[i]) {
                Maxenegimasak = dataenergimasak[i];

            }
            if (Maxstm < datapstm[i]) {
                Maxstm = datapstm[i];

            }
            if (Maxjumt < datapjumt[i]) {
                Maxjumt = datapjumt[i];
            }

            if (Maxterbansos < dataterbansos[i]) {
                Maxterbansos = dataterbansos[i];

            }
            if (Maxjenpen < datajenpen[i]) {
                Maxjenpen = datajenpen[i];
            }
            //======================TEMPAT MEMASUKKAN NILAI MIN=====================//
            if (Minpeker > datapeker[i]) {
                Minpeker = datapeker[i];
            }
            if (Minsbt > datapsbt[i]) {
                Minsbt = datapsbt[i];
            }

            if (Minslt > datapslt[i]) {
                Minslt = datapslt[i];
            }

            if (Minsumper > datapsumper[i]) {
                Minsumper = datapsumper[i];
            }
            if (Minsumair > datasumair[i]) {
                Minsumair = datasumair[i];
            }
            if (Minenergimasak > dataenergimasak[i]) {
                Minenergimasak = dataenergimasak[i];
            }
            if (Minstm > datapstm[i]) {
                Minstm = datapstm[i];

            }
            if (Minjumt > datapjumt[i]) {
                Minjumt = datapjumt[i];
            }
            if (Minterbansos > dataterbansos[i]) {
                Minterbansos = dataterbansos[i];
            }

            if (Minjenpen > datajenpen[i]) {
                Minjenpen = datajenpen[i];
            }
        }
        modelmaxmin mx = new modelmaxmin(Minpeker, Maxpeker, Minsbt, Maxsbt, Minslt, Maxslt, Minsumper, Maxsumper, Minsumair, Maxsumair, Minenergimasak, Maxenegimasak, Minstm, Maxstm, Minjumt, Maxjumt, Minterbansos, Maxterbansos, Minjenpen, Maxjenpen);
        modelmax.add(mx);
        return modelmax;
    }

    public ArrayList<modelnormalisasimatriks> PROSESNORMALISASIMATRIKS() {
        PrometheeII001 pm = new PrometheeII001();
        //===================LANGKAH 2=====================================================//
        //====PROSES MEMASUKKAN DATA NORMALISASI MATRIK KEPUTUSAN KE DALAM MODELNORMALISASI//
        ArrayList<modelnormalisasimatriks> mns = new ArrayList<>();
        //==========================================================
        ArrayList<modelbobotkriteria> mb = pm.PROSESBOBOTKALIVALUE();
        ArrayList<modelmaxmin> md = pm.MASUKKANMAXMIN();
        for (int i = 0; i < mb.size(); i++) {
            double norpeker = (mb.get(i).getBobotpekerjaan() - md.get(0).getMinpeker()) / (md.get(0).getMaxpeker() - md.get(0).getMinpeker());
            double norsbt = (mb.get(i).getBobotsbt() - md.get(0).getMinsbt()) / (md.get(0).getMaxsbt() - md.get(0).getMinsbt());
            double norslt = (mb.get(i).getBobotslt() - md.get(0).getMinslt()) / (md.get(0).getMaxslt() - md.get(0).getMinslt());
            double norsumper = (mb.get(i).getBobotsumper() - md.get(0).getMinsumper()) / (md.get(0).getMaxsumper() - md.get(0).getMinsumper());
            double norsumair = (mb.get(i).getBobotsumair() - md.get(0).getMinsumair()) / (md.get(0).getMaxsumair() - md.get(0).getMinsumair());
            double norenergimasak = (mb.get(i).getBobotenergimasak() - md.get(0).getMinenergimasak()) / (md.get(0).getMaxenergimasak() - md.get(0).getMinenergimasak());
            double norstm = (mb.get(i).getBobotstm() - md.get(0).getMinstm()) / (md.get(0).getMaxstm() - md.get(0).getMinstm());
            double norjumt = (mb.get(i).getBobotjumt() - md.get(0).getMinjumt()) / (md.get(0).getMaxjumt() - md.get(0).getMinjumt());
            double norterbansos = (mb.get(i).getBobottrebansos() - md.get(0).getMinterbansos()) / (md.get(0).getMaxterbansos() - md.get(0).getMinterbansos());
            double norjenpen = (mb.get(i).getBobotjenpend() - md.get(0).getMinjenpen()) / (md.get(0).getMaxjenpen() - md.get(0).getMinjenpen());
            String namapener = mb.get(i).getNamapener();
            String rtrw = mb.get(i).getRtrw();
            modelnormalisasimatriks mm = new modelnormalisasimatriks(norpeker, norsbt, norslt, norsumper, norsumair, norenergimasak, norstm, norjumt, norterbansos, norjenpen, namapener, rtrw);
            mns.add(mm);
        }
        return mns;
    }

    //=================================================CONTROL PREFERENSI QUASI=======================================//
    public ArrayList<modelpreferensiquasi> PROSESPREFERENSIQUASI() {
        PrometheeII001 pm = new PrometheeII001();
        fungsipreferensiquasi fp = new fungsipreferensiquasi();
        //==========================================================LANGKAH 3=============================================//
        //===MASUKKAN DATA PREFERENSI DALAM MODEL PREFERENSI USUAL;
        ArrayList<modelpreferensiquasi> pr = new ArrayList<>();
        //=======================================================================//
        ArrayList<modelnormalisasimatriks> mr = pm.PROSESNORMALISASIMATRIKS();
        double p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
        String naper, rtrw;
        for (int i = 0; i < mr.size(); i++) {
            for (int a = 0; a < mr.size(); a++) {
                p1 = fp.ambil(mr.get(i).getNorpeker(), mr.get(a).getNorpeker());
                p2 = fp.ambil(mr.get(i).getNorstb(), mr.get(a).getNorstb());
                p3 = fp.ambil(mr.get(i).getNorslt(), mr.get(a).getNorslt());
                p4 = fp.ambil(mr.get(i).getNorsumper(), mr.get(a).getNorsumper());
                p5 = fp.ambil(mr.get(i).getNorsumair(), mr.get(a).getNorsumair());
                p6 = fp.ambil(mr.get(i).getNorenergimasak(), mr.get(a).getNorenergimasak());
                p7 = fp.ambil(mr.get(i).getNorstm(), mr.get(a).getNorstm());
                p8 = fp.ambil(mr.get(i).getNorjumt(), mr.get(a).getNorjumt());
                p9 = fp.ambil(mr.get(i).getNorterbansos(), mr.get(a).getNorterbansos());
                p10 = fp.ambil(mr.get(i).getNorjenpen(), mr.get(a).getNorjenpen());
                naper = mr.get(i).getNamapener() + " " + (a + 1);
                rtrw = mr.get(i).getRtrw();
                modelpreferensiquasi ad = new modelpreferensiquasi(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, naper, rtrw);
                pr.add(ad);
            }
        }
        return pr;
    }

    //=================================================CONTROL PROSES PREFERENSI AGREGAT======================================//
    public ArrayList<modelpreferensiagregat> PROSESPREFERENSIALAGREGAT() {
        PrometheeII001 pm = new PrometheeII001();
        //MODEL TAMPUNG PREFERENSI AGREGAT//
        ArrayList<modelpreferensiagregat> pg = new ArrayList<>();
        //==================mengambil data hasil prefensi quasi===================//
        ArrayList<modelpreferensiquasi> mp = pm.PROSESPREFERENSIQUASI();
        //===================Mengambil data alternatif===========================//
        ArrayList<modelambildatanormal> mn = pm.AMBILDATANORMAL();
        //===================Proses hitung fungsi agregat========================//
        fungsipreferensiagregat fp = new fungsipreferensiagregat();
        double PA[] = new double[mp.size()];
        for (int i = 0; i < mp.size(); i++) {
            PA[i] = fp.prosesagregat(mp.get(i).getP1(), mp.get(i).getP2(), mp.get(i).getP3(), mp.get(i).getP4(), mp.get(i).getP5(), mp.get(i).getP6(), mp.get(i).getP7(), mp.get(i).getP8(), mp.get(i).getP9(), mp.get(i).getP10());
            modelpreferensiagregat mg = new modelpreferensiagregat(PA[i], mp.get(i).getNaper(), mp.get(i).getRtrw());
            pg.add(mg);
        }
        return pg;
    }

    public ArrayList<Double> Hasil() {
        PrometheeII001 PM = new PrometheeII001();
        ArrayList<Double> hasil = new ArrayList<>();
        ArrayList<modelbobotkriteria> Batas = PM.PROSESBOBOTKALIVALUE();
        ArrayList<modelpreferensiagregat> PA = PM.PROSESPREFERENSIALAGREGAT();
        ArrayList<Double> nilaiagregat = new ArrayList<>();
        for (int i = 0; i < PA.size(); i++) {
            nilaiagregat.add(PA.get(i).getPreferenagregat());
        }
        ArrayList<ArrayList<Double>> Penerima = Fungsipemisahagregat.chopped(nilaiagregat, Batas.size());
        ArrayList<ArrayList<Double>> jum = new ArrayList<>();
        //===================================================
        //Proses Entering Flow
        ArrayList<Double>enteringflow = new ArrayList<>();
        //Proses Leaving Flow
        ArrayList<Double>leavingflow = new ArrayList<>();
        //======================================================== LEAVING FLOW
        for (int i = 0;i<Penerima.size();i++){
            double rowsum = 0;
            for (int b = 0;b<Penerima.get(i).size();b++){
                rowsum += Penerima.get(i).get(b);
            }
            leavingflow.add((1.0/(10.0-1.0))*rowsum);
        }
           //===================================================== ENTERING FLOW
       for(int b = 0;b<Penerima.get(0).size();b++){
           double colsum = 0;
           for(int i = 0;i<Penerima.size();i++){
               colsum += Penerima.get(i).get(b);
           }
          enteringflow.add((1.0/(10.0-1.0))*colsum);
       }
       //========================================================= NETFLOW
       for (int g = 0 ;g<Batas.size();g++){
           hasil.add(leavingflow.get(g) - enteringflow.get(g));
       }
    return hasil;
    }

}
