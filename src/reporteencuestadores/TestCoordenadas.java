/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

/**
 *
 * @author Isaac
 */
public class TestCoordenadas {
    
    public static void main(String[] args) {
        Encuestador encuestador = new Encuestador("Encuestador 1", 1);
        encuestador.nuevaCoordenada(1000.4870566, 2000.1484758);
        encuestador.nuevaCoordenada(1000.4870566, 2000.1484758);
        encuestador.nuevaCoordenada(1000.4870566, 2000.1484758);
    }
}
