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
public class TestReporte {

    public static void main(String[] args) {

        boolean valor = true;
        try {
            ReporteEncuestadores reporte = new ReporteEncuestadores();
//            if (reporte.cargarCSV()) {
//                System.out.println("CSV cargado");
////                reporte.cargarTuplas(1);
////                reporte.imprimirTabla();
//                reporte.generarConsultaTable();
//            }
        } catch(Exception e){
            System.out.println("Ocurrió un error: " + e.toString());
        }
    }

}
