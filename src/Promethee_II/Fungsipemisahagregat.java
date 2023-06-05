/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promethee_II;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahimsyah
 */
public class Fungsipemisahagregat {
        static <T> ArrayList<ArrayList<T>> chopped(ArrayList<T> list, final int L) {
    ArrayList<ArrayList<T>> parts = new ArrayList<>();
    final int N = list.size();
    for (int i = 0; i < N; i += L) {
        parts.add(new ArrayList<>(
            list.subList(i, Math.min(N, i + L)))
        );
    }
    return parts;
}
}
