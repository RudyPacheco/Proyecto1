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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AndaryuS
 */
public class reportesDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public List listarMueblesVendidosFecha(LocalDate fechaInicial, LocalDate fechaFinal) {
        String sql = "SELECT * FROM muebles_vendidos WHERE fecha_venta BETWEEN ? AND ?";
        List<muebleVendido> lista = new ArrayList<>();
        java.sql.Date fechaI = java.sql.Date.valueOf(fechaInicial);
        java.sql.Date fechaF = java.sql.Date.valueOf(fechaFinal);

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setDate(1, fechaI);
            statement.setDate(2, fechaF);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleVendido temp = new muebleVendido();
                temp.setIdMueble(resulset.getString("id_mueble"));
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setFechaEnsamble(resulset.getDate("fecha_ensamble").toLocalDate());
                temp.setFechaVenta(resulset.getDate("fecha_venta").toLocalDate());
                temp.setUsuarioEnsamble(resulset.getString("usuario_ensamble"));
                temp.setUsuarioVenta(resulset.getString("usuario_venta"));
                temp.setCosto(resulset.getDouble("costo"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar muebles vendidos");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List listarMueblesVendidos() {
        String sql = "SELECT * FROM muebles_vendidos";
        List<muebleVendido> lista = new ArrayList<>();

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleVendido temp = new muebleVendido();
                temp.setIdMueble(resulset.getString("id_mueble"));
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setFechaEnsamble(resulset.getDate("fecha_ensamble").toLocalDate());
                temp.setFechaVenta(resulset.getDate("fecha_venta").toLocalDate());
                temp.setUsuarioEnsamble(resulset.getString("usuario_ensamble"));
                temp.setUsuarioVenta(resulset.getString("usuario_venta"));
                temp.setCosto(resulset.getDouble("costo"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar muebles vendidos");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List listarUsuarioMasVentas(LocalDate fechaInicial, LocalDate fechaFinal) {
        String sql = "SELECT usuario_venta, count(usuario_venta) AS total FROM muebles_vendidos WHERE fecha_venta BETWEEN ? AND ? GROUP BY usuario_venta ORDER BY total DESC";
        List<usuarioMasVenta> lista = new ArrayList<>();
        java.sql.Date fechaI = java.sql.Date.valueOf(fechaInicial);
        java.sql.Date fechaF = java.sql.Date.valueOf(fechaFinal);
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setDate(1, fechaI);
            statement.setDate(2, fechaF);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                usuarioMasVenta temp = new usuarioMasVenta();
                temp.setNombreUsuario(resulset.getString("usuario_venta"));
                temp.setTotal(resulset.getInt("total"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar usuario mas venta");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List listarMueblesVendidosUsuario(String nombreUsuarioVenta) {
        String sql = "SELECT * FROM muebles_vendidos WHERE usuario_venta=?";
        List<muebleVendido> lista = new ArrayList<>();

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreUsuarioVenta);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleVendido temp = new muebleVendido();
                temp.setIdMueble(resulset.getString("id_mueble"));
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setFechaEnsamble(resulset.getDate("fecha_ensamble").toLocalDate());
                temp.setFechaVenta(resulset.getDate("fecha_venta").toLocalDate());
                temp.setUsuarioEnsamble(resulset.getString("usuario_ensamble"));
                temp.setUsuarioVenta(resulset.getString("usuario_venta"));
                temp.setCosto(resulset.getDouble("costo"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar muebles vendidos");
            e.printStackTrace(System.out);
        }

        return lista;

    }

    public List listarMuebleMasVentas(LocalDate fechaInicial, LocalDate fechaFinal) {
        //  String sql = "SELECT usuario_venta, count(usuario_venta) AS total FROM muebles_vendidos WHERE fecha_venta BETWEEN ? AND ? GROUP BY usuario_venta ORDER BY total DESC";
        String sql = "SELECT nombre, count(nombre) AS total FROM muebles_vendidos WHERE fecha_venta BETWEEN ? AND ? GROUP BY nombre ORDER BY total DESC";

        List<muebleMasVendido> lista = new ArrayList<>();
        java.sql.Date fechaI = java.sql.Date.valueOf(fechaInicial);
        java.sql.Date fechaF = java.sql.Date.valueOf(fechaFinal);
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setDate(1, fechaI);
            statement.setDate(2, fechaF);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleMasVendido temp = new muebleMasVendido();
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setTotal(resulset.getInt("total"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar mueble mas venta");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List listarMueblesVendidosNombre(String nombreMueble) {
        String sql = "SELECT * FROM muebles_vendidos WHERE nombre=?";
        List<muebleVendido> lista = new ArrayList<>();

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreMueble);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleVendido temp = new muebleVendido();
                temp.setIdMueble(resulset.getString("id_mueble"));
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setFechaEnsamble(resulset.getDate("fecha_ensamble").toLocalDate());
                temp.setFechaVenta(resulset.getDate("fecha_venta").toLocalDate());
                temp.setUsuarioEnsamble(resulset.getString("usuario_ensamble"));
                temp.setUsuarioVenta(resulset.getString("usuario_venta"));
                temp.setCosto(resulset.getDouble("costo"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar muebles vendidos");
            e.printStackTrace(System.out);
        }

        return lista;

    }

    
    
    public List listarUsuaiosGanancia(LocalDate fechaInicial, LocalDate fechaFinal){
        String sql="SELECT usuario_venta, SUM(precio - costo) AS ganancia, count(usuario_venta) AS total FROM muebles_vendidos WHERE fecha_venta BETWEEN ? AND ? GROUP BY usuario_venta ORDER BY ganancia DESC";
         java.sql.Date fechaI = java.sql.Date.valueOf(fechaInicial);
        java.sql.Date fechaF = java.sql.Date.valueOf(fechaFinal);
        List<usuarioGanancia> lista = new ArrayList<>();
         try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setDate(1, fechaI);
            statement.setDate(2, fechaF);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                usuarioGanancia temp = new usuarioGanancia();
                temp.setNombreUsuario(resulset.getString("usuario_venta"));
                temp.setGanancia(resulset.getDouble("ganancia"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar usuario mas ganancia");
            e.printStackTrace(System.out);
        }

        return lista;
        
        
        
    }
    
    
    
}
