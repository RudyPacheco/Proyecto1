/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author AndaryuS
 */
public class run {

    private static final String USER = "system32";
    private static final String PASSWORD = "password";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/mi_muebleria";
    public static void main(String[] args) {
        
        
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            Connection conectar = DriverManager.getConnection(URL_MYSQL,USER,PASSWORD);
            Statement insert = conectar.createStatement();
            String sql = "SELECT * FROM usuario";
            ResultSet resultado = insert.executeQuery(sql);
            while (resultado.next()) {                
                System.out.println("nombre : " +resultado.getString("nombre_usuario"));
            }
            
        } catch (SQLException e) {
            System.out.println("lol");
        }

        
        
        
    }
    
    
}
