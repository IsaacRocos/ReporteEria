package reporteencuestadores;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author Isaac
 */
public class ReporteEncuestadores {

    FileReader csv;
    ArrayList<String[]> tabla;
    ArrayList<Encuestador> encuestadores;

    public ReporteEncuestadores() {
        csv = null;
        tabla = new ArrayList<>();
        encuestadores = new ArrayList<>();
    }

    // Ejecuta una consulta sql en la base de datos
    public void ejecutarConsulta(String consulta) {
        System.out.println("Ejecutando consulta: ");
        System.out.println(consulta);
        System.out.println("Espere por favor...");
        try {
            String myUrl = "jdbc:mysql://localhost:3307/registros_eria";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(consulta);
            String nombreEncAnterior = "";
            int indice = 0;
            Encuestador encues = null;
            String idEncuesta = "";
            String nomEnc = "";
            String nomEnt = "";
            String nomMun = "";
            String nomLoc = "";
            String cveLoc = "";
            System.out.println("Analizando datos...");
            while (rs.next()) {
                double longitud = 0;
                double latitud = 0;
                try {
                    longitud = Double.parseDouble(rs.getString("LONGITUD"));
                    latitud = Double.parseDouble(rs.getString("LATITUD"));
                } catch (Exception e) {
                    longitud = 0;
                    latitud = 0;
                }
                idEncuesta = rs.getString("ENCUESTA_ID");
                nomEnc = rs.getString("NOM_ENC");
                nomEnt = rs.getString("NOM_ENT");
                nomMun = rs.getString("NOM_MUN");
                nomLoc = rs.getString("NOM_LOC");
                cveLoc = rs.getString("CVE_LOC");

                if (!nomEnc.equals(nombreEncAnterior)) {
                    //System.out.println("Nuevo encuestador");
                    nombreEncAnterior = nomEnc;
                    encues = new Encuestador(nomEnc, indice);
                    encuestadores.add(encues);
                    indice++;
                }
                encues.updtNEncustas();
                if (longitud != 0 && latitud != 0) {
                    encues.nuevaCoordenada(longitud, latitud);
                } else {
                    encues.updtEncuestasNulas();
                }
                //System.out.format("%f, %f, %s, %s, %s, %s, %s, %s\n", longitud, latitud, idEncuesta, nomEnc, nomEnt, nomMun, nomLoc, cveLoc);
            }

            System.out.println("\n\n\n");
            System.out.println("Generando Reporte...");
            imprimirReporte("REP_"+nomEnt);
            st.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + " " + e.toString());
        }
    }

    private void imprimirReporte(String nombreReporte) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter reporte = new PrintWriter(nombreReporte + ".csv", "UTF-8");
        System.out.println("-----------------------------------------------");
        System.out.println("|ENCUESTADOR \t\t | |Coordenadas repetidas: |");
        reporte.println("ENCUESTADOR,TotalEncuestas,EncuestasCoordenadasRepetidas,EncuestasSinCoordenadas");
        for (Encuestador encuestdor : encuestadores) {
            //System.out.println(encuestdor + " , " + encuestdor.getLocalizRepetidas());
            reporte.println(encuestdor + "," + encuestdor.getTotalEncuestas() + "," + encuestdor.getLocalizRepetidas() + "," + encuestdor.getEncuestasNulas());
        }
        reporte.close();
    }

}//class
