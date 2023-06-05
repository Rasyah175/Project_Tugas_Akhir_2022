/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrometheeIImodel;
/**
 *
 * @author Rahimsyah
 */
public class modelambildatanormal {
    private int idpeker,idsbt,idslt,idsumper,idsumair,idenergi,idstm,idjumt,idjenpend,idterbansos;
    private String nama,rtrw;

    public modelambildatanormal(String nama,int idpeker, int idsbt, int idslt, int idsumper, int idsumair, int idenergi, int idstm, int idjumt, int idjenpend, int idterbansos, String rtrw) {
        this.nama = nama;
        this.idpeker = idpeker;
        this.idsbt = idsbt;
        this.idslt = idslt;
        this.idsumper = idsumper;
        this.idsumair = idsumair;
        this.idenergi = idenergi;
        this.idstm = idstm;
        this.idjumt = idjumt;
        this.idjenpend = idjenpend;
        this.idterbansos = idterbansos;
        this.rtrw = rtrw;
    }

    public int getIdpeker() {
        return idpeker;
    }

    public int getIdsbt() {
        return idsbt;
    }

    public int getIdslt() {
        return idslt;
    }

    public int getIdsumper() {
        return idsumper;
    }

    public int getIdsumair() {
        return idsumair;
    }

    public int getIdenergi() {
        return idenergi;
    }

    public int getIdstm() {
        return idstm;
    }

    public int getIdjumt() {
        return idjumt;
    }

    public int getIdterbansos() {
        return idterbansos;
    }

    public int getIdjenpend() {
        return idjenpend;
    }

    public String getNama() {
        return nama;
    }

    public String getRtrw() {
        return rtrw;
    }


    
}
