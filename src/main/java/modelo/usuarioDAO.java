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
public class usuarioDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public usuario validar(String user, String password) {
        usuario usrTEMP = new usuario();
        String sql = "SELECT * FROM usuario WHERE nombre_usuario=? and contraseña=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                usrTEMP.setUsuario(resulset.getString("nombre_usuario"));
                usrTEMP.setPassword(resulset.getString("contraseña"));
                usrTEMP.setCategoria(resulset.getInt("codigo_area"));
                System.out.println("temp " + usrTEMP.getUsuario() + usrTEMP.getPassword());

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return usrTEMP;
    }

    public usuario buscar(String user) {
        usuario usuarioB = new usuario();
        String sql = "SELECT * FROM usuario WHERE nombre_usuario='" + user + "'";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                usuarioB.setUsuario(resulset.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error en la busqueda");
            e.printStackTrace(System.out);
        }
        return usuarioB;
    }

    public int agregar(String nombre, String password, int categoria) {
        String sql = "INSERT INTO usuario (nombre_usuario, contraseña, codigo_area) VALUES (?, ?, ?)";
        int registros = 0;
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, password);
            statement.setInt(3, categoria);
            registros= statement.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        }
        return registros;
    }

}
