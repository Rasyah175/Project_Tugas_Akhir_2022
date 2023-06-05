/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promethee_II;

/**
 *
 * @author Rahimsyah
 */
public class fungsipreferensiquasi {

    public double ambil(double a, double b) {
        double hasil = 0;
        for (int i = 0; i < 100; i++) {
            if (a < b) {
                hasil = 0;
            } else if (a > b){
                hasil = a - b;
            }else {
            hasil = 0;
            }
        }
        return hasil;
    }
}
