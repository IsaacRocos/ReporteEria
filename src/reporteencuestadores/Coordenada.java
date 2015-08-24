/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

import static java.lang.Math.abs;

/**
 *
 * @author AGENTE005
 */
public class Coordenada {

    double latitud;
    double longitud;
    double rangoTolerancia;

    public Coordenada(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.rangoTolerancia = 0.0001;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        } else if (objeto instanceof Coordenada) {
            Coordenada coordenada = (Coordenada) objeto;
            if (((abs(this.latitud) - abs(coordenada.latitud)) < rangoTolerancia)  && ((abs(this.longitud) - abs(coordenada.longitud)) < rangoTolerancia)) {
                //System.out.println("NLat " + (abs(this.latitud) - abs(coordenada.latitud)) + " Nlon" + (abs(this.longitud) - abs(coordenada.longitud)));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.latitud) ^ (Double.doubleToLongBits(this.latitud) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.longitud) ^ (Double.doubleToLongBits(this.longitud) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Lon: " + this.longitud + "  " + "Lat: " + this.latitud;
    }

}
