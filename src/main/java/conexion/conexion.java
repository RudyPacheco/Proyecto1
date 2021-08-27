/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AndaryuS
 */
public class conexion {

    private static final String USER = "system32";
    private static final String PASSWORD = "password";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/mi_muebleria";
    Connection conectar;

    public Connection conexion() {

        try {
             Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            //Statement insert = conectar.createStatement();
            //String sql = "SELECT nombre_usuario FROM usuario";
           // ResultSet resultado = insert.executeQuery(sql);
            //System.out.println("nombre : " + resultado.getInt("nombre_usuario"));
        } catch (Exception e) {
            System.out.println("Error en la clase conexion");
        }

        return conectar;
    }

}
