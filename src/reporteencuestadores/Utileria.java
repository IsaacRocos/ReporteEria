/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteencuestadores;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author AGENTE005
 */
public class Utileria {

    FileReader csv;
    ArrayList<String[]> tabla;

    // Cargar CSV desde especificación en properties
    public boolean cargarCSV() {
        Properties prop = new Properties();
        FileInputStream inProp;
        try {
            String basepath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "resources" + System.getProperty("file.separator");
            inProp = new FileInputStream(basepath + "config.properties");
            prop.load(inProp);
            FileReader csv = new FileReader(prop.getProperty("csvPath"));
            this.csv = csv;
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar archivo " + ex.getMessage());
            return false;
        } catch (IOException ex) {
            System.out.println("Error en flujo " + ex.getMessage());
            return false;
        }
    }

    // Cargar CSV con ruta especificada por el usuario
    public boolean cargarCSV(String ruta) {
        try {
            FileReader csv = new FileReader(ruta);
            this.csv = csv;
            return true;
        }catch (IOException ex) {
            System.out.println("Error en flujo " + ex.getMessage());
            return false;
        } 
    }

    // Almacena un numero de tuplas dado en tabla.
    public void cargarTuplas(int numTuplasCrear) throws IOException {
        System.out.println("Cargando tuplas en nueva tabla...");
        BufferedReader csv = new BufferedReader(this.csv);
        int indice = 0;
        String tupla = "";
        String cabecera = csv.readLine();
        System.out.println(cabecera);
        while (indice <= numTuplasCrear && (tupla = csv.readLine()) != null) {
            tabla.add(tupla.split("|"));
        }
    }

    // Almacena un numero de tuplas dado en tabla. Las tuplas contienen sólo los valores de las columnas indicadas.
    public void cargarTuplas(int numTuplasCrear, int... indicesDeColumnas) throws IOException {
        System.out.println("Cargando tuplas en nueva tabla...");
        BufferedReader csv = new BufferedReader(this.csv);
        int indice = 0;
        String tupla = "";
        String[] tuplaSpliteada;
        String cabecera = csv.readLine();
        while (indice <= numTuplasCrear && (tupla = csv.readLine()) != null) {
            tuplaSpliteada = tupla.split("|");
            ArrayList<String> tuplaCorta = new ArrayList<>();
            for (int i : indicesDeColumnas) {
                tuplaCorta.add(tuplaSpliteada[i]);
            }
            tabla.add((String[]) tuplaCorta.toArray());
        }
    }

// Im
    public void imprimirTabla(String cadenaOpcional) {
        System.out.println("Imprimiendo tabla...");
        for (String[] tupla : tabla) {
            for (String valor : tupla) {
                System.out.print(valor + cadenaOpcional);
            }
        }
    }

    public void generarConsultaTable() throws IOException {
        System.out.println("Cargando tuplas en nueva tabla...");
        BufferedReader csv = new BufferedReader(this.csv);
        int indice = 0;
        String tupla = "";
        String cabecera = csv.readLine();
        System.out.println(cabecera);
        cabecera = cabecera.replace("\"", "");
        cabecera = cabecera.replace("|", ",");
        String[] nuevaCabecera = cabecera.split(",");
        tabla.add(nuevaCabecera);
        imprimirTabla("           varchar(50),\n");
    }
}
