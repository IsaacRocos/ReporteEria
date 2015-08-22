/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac
 */
public class TestReporte {

    public static void main(String[] args) {

        boolean valor = true;
        try {
            ReporteEncuestadores reporte = new ReporteEncuestadores();
            if (reporte.cargarCSV()) {
                System.out.println("CSV cargado");
//                reporte.cargarTuplas(1);
//                reporte.imprimirTabla();
                reporte.generarConsultaTable();
            }
        } catch (IOException ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        } catch(Exception e){
            System.out.println("Ocurrió un error: " + e.toString());
        }
    }

}
