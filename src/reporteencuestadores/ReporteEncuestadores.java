package reporteencuestadores;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Statement;
import com.mysql.jdbc.*;
import java.sql.Date;

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
        try {
            String myUrl = "jdbc:mysql://localhost:3307/registros_eria";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(consulta);
            String nombreEncAnterior = "";
            int indice = 0;
            Encuestador encues = null;
            while (rs.next()) {
                double longitud = 0;
                double latitud = 0;
                try {
                    longitud = Double.parseDouble(rs.getString("LONGITUD"));
                    latitud = Double.parseDouble(rs.getString("LATITUD"));
                } catch (Exception e) {
                    longitud = 0;
                    latitud = 0;
                    System.err.println(e.getMessage());
                }
                String idEncuesta = rs.getString("ENCUESTA_ID");
                String nomEnc = rs.getString("NOM_ENC");
                String nomEnt = rs.getString("NOM_ENT");
                String nomMun = rs.getString("NOM_MUN");
                String nomLoc = rs.getString("NOM_LOC");
                String cveLoc = rs.getString("CVE_LOC");

                if (!nomEnc.equals(nombreEncAnterior)) {
                    System.out.println("Nuevo encuestador");
                    nombreEncAnterior = nomEnc;
                    encues = new Encuestador(nomEnc, indice);
                    encuestadores.add(encues);
                    indice++;
                } else {
                    System.out.println("Encustador conocido:" + encues.toString());
                    encues.nuevaCoordenada(longitud, latitud);
                    System.out.println("Coordenada almcenada");
                }
                System.out.format("%f, %f, %s, %s, %s, %s, %s, %s\n", longitud, latitud, idEncuesta, nomEnc, nomEnt, nomMun, nomLoc, cveLoc);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + " " + e.toString());
        }

    }

}//class
