/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

/**
 *
 * @author AGENTE005
 */
public class Principal {
    public static void main(String[] args) {
        ReporteEncuestadores re = new ReporteEncuestadores();
        re.ejecutarConsulta("SELECT "
                    + " A.LONGITUD ,"
                    + "	A.LATITUD,"
                    + "	A.ENCUESTA_ID, "
                    + " A.NOM_ENC, "
                    + " A.NOM_ENT, "
                    + " A.NOM_MUN, "
                    + " A.NOM_LOC, "
                    + " A.CVE_LOC FROM registros_eria.registros as A where A.NOM_ENT = \"CHIAPAS\" ORDER BY NOM_ENC, ENCUESTA_ID");
    }
}
