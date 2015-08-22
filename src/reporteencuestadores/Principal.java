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
                    + "         A.LONGITUD ,\n"
                    + "		A.LATITUD, \n"
                    + "		A.ENCUESTA_ID , \n"
                    + "        A.NOM_ENC, \n"
                    + "        A.NOM_ENT, \n"
                    + "        A.NOM_MUN, \n"
                    + "        A.NOM_LOC, \n"
                    + "        A.CVE_LOC FROM registros_eria.registros as A where A.NOM_ENT = \"CHIAPAS\" ORDER BY NOM_ENC, ENCUESTA_ID");
        
        
    }
}
