/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author AndaryuS
 */
public class ventaDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public String genearSerie() {
        String numeroSerie = "";
        String sql = "SELECT MAX(id_factura) FROM factura";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                numeroSerie = resulset.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al generar Serie");
            e.printStackTrace(System.out);
        }

        return numeroSerie;
    }

    public int venderMueble(String idMueble, String nombreMueble, LocalDate fecha, LocalDate fechaVenta, String usuarioE,String usuarioV, double costo, double precio) {
        String sql = "INSERT INTO muebles_vendidos (id_mueble, nombre, fecha_ensamble, fecha_venta, usuario_ensamble, usuario_venta, costo, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int registros = 0;
        java.sql.Date mydate = java.sql.Date.valueOf(fecha);
        java.sql.Date mydate2 = java.sql.Date.valueOf(fechaVenta);
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idMueble);
            statement.setString(2, nombreMueble);
            statement.setDate(3, mydate);
            statement.setDate(4, mydate2);
            statement.setString(5, usuarioE);
            statement.setString(6, usuarioV);
            statement.setDouble(7, costo);
            statement.setDouble(8, precio);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al vender el mueble");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public int guardarFactura(String id, LocalDate fecha, String nit, String nombreUsuario, double total) {
        String sql = "INSERT INTO factura (id_factura, fecha_compra, nit, nombre_usuario, total) VALUES(?, ?, ?, ?, ?)";
        int registros = 0;
        java.sql.Date mydate = java.sql.Date.valueOf(fecha);
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setDate(2, mydate);
            statement.setString(3, nit);
            statement.setString(4, nombreUsuario);
            statement.setDouble(5, total);

            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al ensamblar meuble");
            e.printStackTrace(System.out);
        }

        return registros;
    }

    public int guardarDetalle(String idFactura, String idMueble, String nombreMueble, double precio) {
        String sql = "INSERT INTO detalle (id_factura, id_mueble, nombreMueble, precio) VALUES(?, ?, ?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idFactura);
            statement.setString(2, idMueble);
            statement.setString(3, nombreMueble);
            statement.setDouble(4, precio);

            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al ensamblar meuble");
            e.printStackTrace(System.out);
        }

        return registros;
    }

    public int eliminarMueble(String idMueble) {

        //String sql = "INSERT INTO pieza_disponible (nombre_pieza, precio) VALUES (?, ?)";
        String sql = "DELETE FROM muebles_registrados WHERE id_mueble_registrado=?";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idMueble);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al borrar pieza");
            e.printStackTrace(System.out);
        }
        return registros;
    }

        public LocalDate darFormatoFecha(String fecha) {
        String[] fechaDividida = fecha.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int año = Integer.valueOf(fechaDividida[2]);

        return LocalDate.of(año, mes, dia);

    }

    
    
}
