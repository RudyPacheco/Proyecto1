/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.cliente;
import modelo.clienteDAO;
import modelo.mueble;
import modelo.muebleDAO;
import modelo.pieza;
import modelo.piezaDAO;
import modelo.usuario;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
public class validarDatos {

    usuarioDAO usrDAO = new usuarioDAO();
    piezaDAO piezaDAO = new piezaDAO();
    muebleDAO muebleDAO = new muebleDAO();
    clienteDAO clienteDAO = new clienteDAO();
    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;
    ArrayList<String> errores = new ArrayList<>();

    public void validarUSUAIRIO(ArrayList<String> campos, int numLinea) {
        usuario usrtemp;
        String nombre = campos.get(0);
        // String nombreSinComillas = nombre.replace("\"", "");
        String passwrod = campos.get(1);
        // String passSincomillas = passwrod.replace("\"", "");
        int categoria = Integer.parseInt(campos.get(2));
        System.out.println(" nombre " + nombre + " pass " + passwrod + " categoria " + categoria);
        usrtemp = usrDAO.buscar(nombre);
        if (nombre == null) {
            String error = "El campo esta vacio linea :" + numLinea;
            errores.add(error);
        }
        if (passwrod.length() > 5) {
            if (usrtemp != null) {
                if (usrtemp.getUsuario() != null) {
                    System.out.println("existe");
                    String error = "El usuario ya existe linea :" + numLinea;
                    errores.add(error);
                } else {
                    System.out.println("no existe");
                    int num = usrDAO.agregar(nombre, passwrod, categoria);
                    System.out.println("reggistros modificados " + num);
                }
            }
        } else {
            String errorpass = "La contraseña tiene menos de 6 caracteres" + numLinea;
            errores.add(errorpass);
        }

//                  usrtemp=validar(nombreSinComillas);
//         if (usrtemp!=null) {
//             System.out.println("si existe");
//        }else{
//             System.out.println("no existe");
//         }
//            usrtemp=usrDAO.validar(nombreSinComillas, passSincomillas);
//            if (usrtemp!=null) {
//                if (usrtemp.getUsuario().equals(nombreSinComillas)) {
//                    System.out.println("Si existe weon");
//                }
//        }else{
//                System.out.println("no eixste jsjs");
//            }
    }

    public void validarPIEZA(ArrayList<String> campos, int numLinea) {
        pieza piezaTMP;
        String nombre = campos.get(0);
        double precio = Double.parseDouble(campos.get(1));
        //String nombreSinComillas = nombre.replace("\"", "");

        piezaTMP = piezaDAO.validarPieza(nombre.toLowerCase(), precio);
        if (piezaTMP.getNombre_pieza() != null) {
            System.out.println("Laa pieza existe");
            piezaDAO.agregarPieza(nombre.toLowerCase(), precio);
            piezaDAO.agregarInventario(nombre.toLowerCase(), precio);

        } else {
            System.out.println("La pieza no existe");
            piezaDAO.registrarPieza(nombre.toLowerCase(), precio);
            //  piezaDAO.agregarPieza(nombreSinComillas, precio);
            piezaDAO.agregarInventario(nombre.toLowerCase(), precio);
        }
    }

    public void validarMUEBLE(ArrayList<String> campos, int numLinea) {
        mueble muebleTemp;
        String nombreMueble = campos.get(0);
        double precio = Double.parseDouble(campos.get(1));
        muebleTemp = muebleDAO.validarMueble(nombreMueble, precio);
        if (muebleTemp.getNombre_mueble() != null) {
            String error = "El mueble ya existe " + numLinea;
            System.out.println(error);
            errores.add(error);
        } else {
            muebleDAO.registrarMueble(nombreMueble, precio);
        }
        //    String nombreSinComillas = nombre.replace("\"", "");
    }

    public void validarEnsablePieza(ArrayList<String> campos, int numLinea) {
        mueble muebleTemp;
        pieza piezaTMP;
        String nombreMueble = campos.get(0);
        String nombrePieza = campos.get(1);
        int cantidad = Integer.parseInt(campos.get(2));
        muebleTemp = muebleDAO.validarMueble(nombreMueble, 0.0);
        piezaTMP = piezaDAO.validarPieza(nombrePieza.toLowerCase(), 0.0);
        if (muebleTemp.getNombre_mueble() != null) {
            if (piezaTMP.getNombre_pieza() != null) {
                muebleDAO.agregarPiezaMueble(nombreMueble, nombrePieza, cantidad);
            } else {
                String errorPieza = "La pieza no existe" + numLinea;
                System.out.println(errorPieza);
                errores.add(errorPieza);
            }
        } else {
            String errorMueble = "El mueble no existe" + numLinea;
            System.out.println(errorMueble);
            errores.add(errorMueble);
        }

    }

    public void validarCLIENTE(ArrayList<String> campos, int numLinea) {
        cliente clienteTemp;
        String municipio;
        String departamento;
        if (campos.size() < 5) {
          
             municipio = null;
            departamento = null;
        }else{
            municipio = campos.get(3);
        departamento = campos.get(4);
        }
        String nombreCliente = campos.get(0);
        String nit = campos.get(1);
        String direccion = campos.get(2);
        
        clienteTemp = clienteDAO.validarCliente(nit);
        if (clienteTemp.getNit() != null) {
            String error = "El cliente ya existe" + numLinea;
            System.out.println(error);
            errores.add(error);

        } else {
            clienteDAO.registrarCliente(nombreCliente, nit, direccion, municipio, departamento);
        }

    }

    public ArrayList getErrores() {

        return errores;
    }

}
