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
public class muebleDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public mueble validarMueble(String nombreMueble, double precio) {

        mueble muebleTMP = new mueble();
        String sql = "SELECT * FROM mueble WHERE nombre_mueble=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreMueble);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleTMP.setNombre_mueble(resulset.getString("nombre_mueble"));

                System.out.println("temp " + muebleTMP.getNombre_mueble());

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return muebleTMP;
    }

    public int registrarMueble(String nombreMueble, double precio) {
        String sql = "INSERT INTO mueble (nombre_mueble, precio) VALUES (?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreMueble);
            statement.setDouble(2, precio);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar Registrar");
            e.printStackTrace(System.out);
        }
        return registros;
    }
    
    public int agregarPiezaMueble(String nombreMueble,String nombrePieza, int cantidad) {
        String sql = "INSERT INTO mueble_receta (nombre_mueble, pieza_necesaria, cantidad) VALUES (?, ?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreMueble);
            statement.setString(2, nombrePieza);
            statement.setInt(3 , cantidad);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar Registrar");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    
    
    
    
    
}
