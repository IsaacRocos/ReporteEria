/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author AGENTE005
 */
public class Principal {

    public static void main(String[] args) {
        String entidades[] = {"ZACATECAS",
            "YUCATÁN",
            "VERACRUZ DE IGNACIO DE LA LLAVE",
            "TLAXCALA",
            "TAMAULIPAS",
            "TABASCO",
            "SONORA",
            "SINALOA",
            "SAN LUIS POTOSÍ",
            "QUINTANA ROO",
            "QUERÉTARO",
            "PUEBLA",
            "OAXACA",
            "NUEVO LEÓN",
            "NAYARIT",
            "MÉXICO",
            "MORELOS",
            "MICHOACÁN DE OCAMPO",
            "JALISCO",
            "HIDALGO",
            "GUERRERO",
            "GUANAJUATO",
            "DURANGO",
            "DISTRITO FEDERAL",
            "COLIMA",
            "COAHUILA DE ZARAGOZA",
            "CHIHUAHUA",
            "CHIAPAS",
            "CAMPECHE",
            "BAJA CALIFORNIA SUR",
            "BAJA CALIFORNIA",
            "AGUASCALIENTES"};

        for (String estado : entidades) {
            ReporteEncuestadores re = new ReporteEncuestadores();
            System.out.println("Generando reporte para " + estado);
            re.ejecutarConsulta("SELECT "
                    + " A.LONGITUD ,"
                    + "	A.LATITUD,"
                    + "	A.ENCUESTA_ID, "
                    + " A.NOM_ENC, "
                    + " A.NOM_ENT, "
                    + " A.NOM_MUN, "
                    + " A.NOM_LOC, "
                    + " A.CVE_LOC FROM registros_eria.registros as A where A.NOM_ENT = \"" + estado + " \" ORDER BY NOM_ENC, ENCUESTA_ID");
            System.out.println(estado + ": Reporte creado.\n");
        }
    }
}
