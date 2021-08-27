/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author AndaryuS
 */
public class CargaDatos {

    validarDatos validarDatos;

    File archivo;
    ArrayList<String> errores = new ArrayList<>();

    public CargaDatos(File archivoRecibido) {
        archivo = archivoRecibido;
        validarDatos = new validarDatos();
    }

    public void CargaDatos() {

        String[] lineasArchivo;
        String encabezado;
        ArrayList<String> campos;
        ArrayList<String> camposLimpios;
        boolean crearObjeto;
        boolean objectoCerado;
        lineasArchivo = listarLineasArchivos(archivo.getAbsolutePath());
        for (int i = 0; i < lineasArchivo.length; i++) {
            encabezado = encabezado(lineasArchivo[i]);
            campos = extraerCampos(lineasArchivo[i]);
            camposLimpios=eliminarComillas(campos);
            crearInstanciaObjeto(encabezado, camposLimpios, i);
        }

    }

    private void crearInstanciaObjeto(String encabezado, ArrayList<String> campos, int numLinea) {
        if (encabezado.equalsIgnoreCase("USUARIO")) {
            System.out.println("se detecto un usuario");
            cargarUSUARIO(campos, numLinea);
        } else if (encabezado.equalsIgnoreCase("PIEZA")) {
            System.out.println("se detecto una pieza");
            cargarPIEZA(campos, numLinea);
            //    cargarAeropuerto(campos, errores, numLinea);
        } else if (encabezado.equalsIgnoreCase("MUEBLE")) {
            cargarMUEBLE(campos, numLinea);
            // cargarAvion(campos, errores, numLinea);
        } else if (encabezado.equalsIgnoreCase("ENSAMBLE_PIEZAS")) {
            cargarPiezaMUEBLE(campos, numLinea);
            //cargarDistancia(campos, errores, numLinea);
        } else if (encabezado.equalsIgnoreCase("ENSAMBLAR_MUEBLE")) {
            // cargarPasaporte(campos, errores, numLinea);
        } else if (encabezado.equalsIgnoreCase("CLIENTE")) {
            // System.out.println("se creo una renovacion");
            cargarCLIENTE(campos, numLinea);
        }
    }

    public void cargarUSUARIO(ArrayList<String> campos, int numeroLInea) {
        validarDatos.validarUSUAIRIO(campos, numeroLInea);
        errores = validarDatos.getErrores();
        // validarDatos.validarReservacion(campos, errores, numeroLInea);
    }

    public void cargarPIEZA(ArrayList<String> campos, int numeroLInea) {
        validarDatos.validarPIEZA(campos, numeroLInea);
        // validarDatos.validarReservacion(campos, errores, numeroLInea);
    }

    public void cargarMUEBLE(ArrayList<String> campos, int numeroLInea) {
        validarDatos.validarMUEBLE(campos, numeroLInea);
        // validarDatos.validarReservacion(campos, errores, numeroLInea);
    }

    public void cargarPiezaMUEBLE(ArrayList<String> campos, int numeroLInea) {
        validarDatos.validarEnsablePieza(campos, numeroLInea);
        // validarDatos.validarReservacion(campos, errores, numeroLInea);
    }
    
    public void cargarCLIENTE(ArrayList<String> campos, int numeroLInea){
        validarDatos.validarCLIENTE(campos, numeroLInea);
    }
    
    public String[] listarLineasArchivos(String direccionArchivo) {
        ArrayList<String> listaLineas = new ArrayList();

        try {
            FileReader archivo = new FileReader(direccionArchivo);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();
            while (linea != null) {
                listaLineas.add(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return convertirArraylistString(listaLineas);

    }

    public String[] convertirArraylistString(ArrayList<String> lista) {
        String[] listaArreglo = new String[lista.size()];
        for (int i = 0; i < listaArreglo.length; i++) {
            listaArreglo[i] = lista.get(i);

        }

        return listaArreglo;
    }

    public String encabezado(String linea) {
        String[] cadena = linea.split("\\(");
        String encabezado = cadena[0];
        return encabezado;
    }

    public ArrayList<String> extraerCampos(String linea) {
        ArrayList<String> lista;
        String encabezado;
        String[] cadena = linea.split("\\(");
        String campos = linea.substring(cadena[0].length() + 1, linea.length() - 1);
        String[] camposDivididos = campos.split(",");
        lista = convertirArregloAArrayList(camposDivididos);
        return lista;

    }

    private ArrayList<String> convertirArregloAArrayList(String[] arreglo) {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < arreglo.length; i++) {
            lista.add(arreglo[i]);
        }

        return lista;
    }
    
    public ArrayList<String> eliminarComillas(ArrayList<String> campos){
        ArrayList<String> camposLimpios = new ArrayList<>();
        for (int i = 0; i < campos.size(); i++) {
            String temp=campos.get(i);
            String tempLimpio=temp.replace("\"", "");
            camposLimpios.add(tempLimpio);
        }
        return camposLimpios;
    }
    

    public ArrayList getErrores() {

        return errores;
    }

}
