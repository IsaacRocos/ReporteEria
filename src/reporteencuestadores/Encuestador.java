
package reporteencuestadores;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Isaac
 */
public class Encuestador {

    private int indice;
    private String nombre;
    private Set entidadesF;
    private ArrayList<Coordenada> listaCoordenadas;
    private int numLocalizRepetidas;

    Encuestador(String nombre, int indice) {
        this.nombre = nombre;
        this.indice = indice;
        listaCoordenadas = new ArrayList<>();
        numLocalizRepetidas = 0;
    }

    public void nuevaCoordenada(double longitud, double latitud) {
        Coordenada nCoor = new Coordenada(longitud, latitud);
        if(listaCoordenadas.contains(nCoor)){
            incLocalizRepetidas();
            System.out.println("Coordenada repetida para: " + this.toString());
        }else{
            listaCoordenadas.add(nCoor);
            System.out.println("Nueva coordenada para: " + this.toString());
        }
        
    }

    public void nuevaEntidad(String entidad) {
        
    }

    public void incLocalizRepetidas() {
        numLocalizRepetidas++;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
