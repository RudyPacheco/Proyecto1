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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AndaryuS
 */
public class facturaDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public factura buscarFactura(String idFactura) {

        factura facturaTemp = new factura();
        String sql = "SELECT * FROM factura WHERE id_factura=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idFactura);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                facturaTemp.setId(resulset.getString("id_factura"));
                facturaTemp.setFecha(resulset.getDate("fecha_compra").toLocalDate());
                facturaTemp.setNit(resulset.getString("nit"));
                facturaTemp.setNombreUsuario(resulset.getString("nombre_usuario"));
                facturaTemp.setTotal(resulset.getDouble("total"));

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return facturaTemp;
    }

    public List listarFacturaNit(String nit) {
        ArrayList<factura> facturas = new ArrayList<>();

        String sql = "SELECT * FROM factura WHERE nit=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nit);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                factura facturaTemp = new factura();
                facturaTemp.setId(resulset.getString("id_factura"));
                facturaTemp.setFecha(resulset.getDate("fecha_compra").toLocalDate());
                facturaTemp.setNit(resulset.getString("nit"));
                facturaTemp.setNombreUsuario(resulset.getString("nombre_usuario"));
                facturaTemp.setTotal(resulset.getDouble("total"));
                facturas.add(facturaTemp);

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return facturas;
    }
    
        public List listarFacturaNitFecha(String nit,LocalDate fechaInicial, LocalDate fechaFinal) {
        ArrayList<factura> facturas = new ArrayList<>();

        String sql = "SELECT * FROM factura WHERE nit=? AND fecha_compra BETWEEN ? AND ?";
          java.sql.Date fechaI = java.sql.Date.valueOf(fechaInicial);
        java.sql.Date fechaF = java.sql.Date.valueOf(fechaFinal);
        
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nit);
             statement.setDate(2, fechaI);
            statement.setDate(3, fechaF);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                factura facturaTemp = new factura();
                facturaTemp.setId(resulset.getString("id_factura"));
                facturaTemp.setFecha(resulset.getDate("fecha_compra").toLocalDate());
                facturaTemp.setNit(resulset.getString("nit"));
                facturaTemp.setNombreUsuario(resulset.getString("nombre_usuario"));
                facturaTemp.setTotal(resulset.getDouble("total"));
                facturas.add(facturaTemp);

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return facturas;
    }

    
    
    

    public List listarFactura(LocalDate fecha) {
        ArrayList<factura> facturas = new ArrayList<>();
        java.sql.Date mydate = java.sql.Date.valueOf(fecha);
        String sql = "SELECT * FROM factura where fecha_compra=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setDate(1, mydate);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                factura facturaTemp = new factura();
                facturaTemp.setId(resulset.getString("id_factura"));
                facturaTemp.setFecha(resulset.getDate("fecha_compra").toLocalDate());
                facturaTemp.setNit(resulset.getString("nit"));
                facturaTemp.setNombreUsuario(resulset.getString("nombre_usuario"));
                facturaTemp.setTotal(resulset.getDouble("total"));
                facturas.add(facturaTemp);
            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return facturas;
    }

}
