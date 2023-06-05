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
public class modelpreferensiagregat {
    double preferenagregat;
    String naper,rtrw;

    public modelpreferensiagregat(double preferenagregat, String naper, String rtrw) {
        this.preferenagregat = preferenagregat;
        this.naper = naper;
        this.rtrw = rtrw;
    }

    public double getPreferenagregat() {
        return preferenagregat;
    }

    public String getNaper() {
        return naper;
    }

    public String getRtrw() {
        return rtrw;
    }
}
