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
public class modelnormalisasimatriks {
    double norpeker,norstb,norslt,norsumper,norsumair,norenergimasak,norstm,norjumt,norterbansos,norjenpen;
    String namapener,rtrw;

    public modelnormalisasimatriks(double norpeker, double norstb, double norslt, double norsumper, double norsumair, double norenergimasak, double norstm, double norjumt, double norterbansos, double norjenpen, String namapener, String rtrw) {
        this.norpeker = norpeker;
        this.norstb = norstb;
        this.norslt = norslt;
        this.norsumper = norsumper;
        this.norsumair = norsumair;
        this.norenergimasak = norenergimasak;
        this.norstm = norstm;
        this.norjumt = norjumt;
        this.norterbansos = norterbansos;
        this.norjenpen = norjenpen;
        this.namapener = namapener;
        this.rtrw = rtrw;
    }

    public double getNorpeker() {
        return norpeker;
    }

    public double getNorstb() {
        return norstb;
    }

    public double getNorslt() {
        return norslt;
    }

    public double getNorsumper() {
        return norsumper;
    }

    public double getNorsumair() {
        return norsumair;
    }

    public double getNorenergimasak() {
        return norenergimasak;
    }

    public double getNorstm() {
        return norstm;
    }

    public double getNorjumt() {
        return norjumt;
    }

    public double getNorterbansos() {
        return norterbansos;
    }

    public double getNorjenpen() {
        return norjenpen;
    }

    public String getNamapener() {
        return namapener;
    }

    public String getRtrw() {
        return rtrw;
    }
   
}
