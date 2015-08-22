/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author El
 */
public class Encuestador {

    ArrayList<Coordenada> coordenadas;
    String nombre;
    int indice;

    Encuestador(String nombre, int indice) {
        this.nombre = nombre;
        this.indice = indice;
        coordenadas = new ArrayList<>();
    }

    public void nuevaCoordenada(double longitud, double latitud) {
        coordenadas.add(new Coordenada(longitud, latitud));
    }

    @Override
    public String toString(){
        return nombre;
    }
    
}
