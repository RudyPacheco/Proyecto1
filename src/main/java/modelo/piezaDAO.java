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

/**
 *
 * @author AndaryuS
 */
public class piezaDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public pieza validarPieza(String nombrePIeza, double precio) {
        pieza piezaTEMP = new pieza();
        String sql = "SELECT * FROM pieza_registrada WHERE nombre_pieza=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePIeza);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                piezaTEMP.setNombre_pieza(resulset.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return piezaTEMP;
    }

    public int registrarPieza(String nombrePieza, double precio) {
        String sql = "INSERT INTO pieza_registrada (nombre_pieza, cantidad) VALUES (?, 1)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar Registrar");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public int agregarPieza(String nombrePieza, double precio) {

        String sql = "UPDATE pieza_registrada SET cantidad=cantidad+1 WHERE nombre_pieza = ?";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public int agregarInventario(String nombrePieza, double precio) {

        String sql = "INSERT INTO pieza_disponible (nombre_pieza, precio) VALUES (?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            statement.setDouble(2, precio);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error Inventario");
            e.printStackTrace(System.out);
        }
        return registros;
    }

}
