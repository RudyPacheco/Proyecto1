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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.cliente;
import modelo.clienteDAO;
import modelo.mueble;
import modelo.muebleDAO;
import modelo.pieza;
import modelo.piezaDAO;
import modelo.piezaRegistrada;
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

    public void validarEnsambleMueble(ArrayList<String> campos, int numLinea) {
        double costo = 0;
        mueble muebleTEMP;
        usuario usuarioTEMP;
        List listaPiezas;
        List<pieza> piezasNecesarias;
        boolean piezasSuficientes = false;
        String nombreMueble = campos.get(0);
        String nombreUsuario = campos.get(1);
        String fechaS = campos.get(2);
        LocalDate fecha = darFormatoFecha(fechaS);
        muebleTEMP = muebleDAO.validarMueble(nombreMueble, 0);
        usuarioTEMP = usrDAO.buscar(nombreUsuario);
        if (muebleTEMP.getNombre_mueble() != null) {
            if (usuarioTEMP.getUsuario() != null) {
                listaPiezas = muebleDAO.listarPiezasMueble(nombreMueble);

                for (int i = 0; i < listaPiezas.size(); i++) {
                    piezaRegistrada temp = (piezaRegistrada) listaPiezas.get(i);
                    piezaRegistrada existente = piezaDAO.verificarPieza(temp.getNombrePieza());
                    if (existente.getCantidad() >= temp.getCantidad()) {

                        piezasSuficientes = true;

//                        for (int j = 0; j < listaTemp.size(); j++) {
//                            piezasNecesarias.add((pieza) listaTemp.get(i));
//                        }
                    } else {
                        piezasSuficientes = false;
                        break;
                    }

                }

                if (piezasSuficientes == true) {

                    System.out.println("Piezas suficientes");
                    String numeroSerie = muebleDAO.genearSerie();
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        numeroSerie = numeroID(incrementar);

                    }

                    for (int i = 0; i < listaPiezas.size(); i++) {
                        piezaRegistrada temp = (piezaRegistrada) listaPiezas.get(i);
                        List listaTemp = piezaDAO.listarPiezaEspecificaDisponible(temp.getNombrePieza(), temp.getCantidad());
                        for (int j = 0; j < listaTemp.size(); j++) {
                            pieza pizaTEMP = (pieza) listaTemp.get(j);

                            System.out.println("Piezas para el mueble");
                            piezaDAO.agregarPiezaUsada(numeroSerie, pizaTEMP);
                            piezaDAO.eliminarPieza(pizaTEMP.getId());
                            piezaDAO.actualizarPieza(pizaTEMP.getNombre_pieza(), 0);
                            System.out.println(pizaTEMP.getId() + "xd " + pizaTEMP.getCosto());
                            costo = costo + pizaTEMP.getCosto();
                        }
                    }

                    muebleDAO.registrarMuble(numeroSerie, nombreMueble, fecha, nombreUsuario, costo, muebleTEMP.isPrecio());

                }

            }
        }
//        for (int i = 0; i < piezasNecesarias.size(); i++) {
//            System.out.println("piezas para el muble");
//            System.out.println(piezasNecesarias.get(i).getId() + piezasNecesarias.get(i).getCosto());
//        }
    }

    public void insertarMueble(ArrayList<String> campos, int numLinea) {
        double costo = 0;
        mueble muebleTEMP;
        usuario usuarioTEMP;
        List listaPiezas;
        List<pieza> piezasNecesarias;
        boolean piezasSuficientes = false;
        String nombreMueble = campos.get(0);
        String nombreUsuario = campos.get(1);
        String fechaS = campos.get(2);
        LocalDate fecha = darFormatoFecha(fechaS);
        muebleTEMP = muebleDAO.validarMueble(nombreMueble, 0);
        usuarioTEMP = usrDAO.buscar(nombreUsuario);
        if (muebleTEMP.getNombre_mueble() != null) {
            if (usuarioTEMP.getUsuario() != null) {
                listaPiezas = muebleDAO.listarPiezasMueble(nombreMueble);

                for (int i = 0; i < listaPiezas.size(); i++) {
                    piezaRegistrada temp = (piezaRegistrada) listaPiezas.get(i);
                    piezaRegistrada existente = piezaDAO.verificarPieza(temp.getNombrePieza());
                    if (existente.getCantidad() >= temp.getCantidad()) {

                        piezasSuficientes = true;

//                        for (int j = 0; j < listaTemp.size(); j++) {
//                            piezasNecesarias.add((pieza) listaTemp.get(i));
//                        }
                    } else {
                        piezasSuficientes = false;
                        break;
                    }

                }

                if (piezasSuficientes == true) {

                    System.out.println("Piezas suficientes");
                    String numeroSerie = muebleDAO.genearSerie();
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        numeroSerie = numeroID(incrementar);

                    }

                    for (int i = 0; i < listaPiezas.size(); i++) {
                        piezaRegistrada temp = (piezaRegistrada) listaPiezas.get(i);
                        List listaTemp = piezaDAO.listarPiezaEspecificaDisponible(temp.getNombrePieza(), temp.getCantidad());
                        for (int j = 0; j < listaTemp.size(); j++) {
                            pieza pizaTEMP = (pieza) listaTemp.get(j);

                            System.out.println("Piezas para el mueble");
                            piezaDAO.agregarPiezaUsada(numeroSerie, pizaTEMP);
                            piezaDAO.eliminarPieza(pizaTEMP.getId());
                            piezaDAO.actualizarPieza(pizaTEMP.getNombre_pieza(), 0);
                            System.out.println(pizaTEMP.getId() + "xd " + pizaTEMP.getCosto());
                            costo = costo + pizaTEMP.getCosto();
                        }
                    }

                    muebleDAO.ensamblarMueble(numeroSerie, nombreMueble, fecha, nombreUsuario, costo, muebleTEMP.isPrecio());

                }

            }
        }
//        for (int i = 0; i < piezasNecesarias.size(); i++) {
//            System.out.println("piezas para el muble");
//            System.out.println(piezasNecesarias.get(i).getId() + piezasNecesarias.get(i).getCosto());
//        }
    }

    public void validarCLIENTE(ArrayList<String> campos, int numLinea) {
        cliente clienteTemp;
        String municipio;
        String departamento;

        if (campos.size() < 5) {

            municipio = null;
            departamento = null;
        } else {
            municipio = campos.get(3);
            departamento = campos.get(4);
            if (municipio.equals("") || departamento.equals("")) {

                municipio = null;
                departamento = null;
            }

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

    public LocalDate darFormatoFecha(String fecha) {
        String[] fechaDividida = fecha.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int año = Integer.valueOf(fechaDividida[2]);

        return LocalDate.of(año, mes, dia);

    }

    public String numeroID(int datoR) {
        int dato;
        String numero = null;
        dato = datoR + 1;

        if (dato >= 10000000 && dato <= 100000000) {
            numero = "" + dato;
        }
        if (dato >= 1000000 && dato <= 10000000) {
            numero = "0" + dato;
        }
        if (dato >= 100000 && dato <= 1000000) {
            numero = "00" + dato;
        }
        if (dato >= 10000 && dato <= 100000) {
            numero = "000" + dato;
        }
        if (dato >= 1000 && dato <= 10000) {
            numero = "0000" + dato;
        }
        if (dato > 100 && dato <= 1000) {
            numero = "00000" + dato;
        }
        if (dato >= 10 && dato <= 100) {
            numero = "000000" + dato;
        }

        if (dato < 10) {
            numero = "0000000" + dato;
        }
        return numero;
    }

    public ArrayList getErrores() {

        return errores;
    }

}
