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
public class clienteDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;
    
        public cliente validarCliente(String nit) {
        cliente clienteTMP = new cliente();
        String sql = "SELECT * FROM cliente WHERE nit=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nit);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                clienteTMP.setNombreCliente(resulset.getString("nombre_cliente"));
                clienteTMP.setNit(resulset.getString("nit"));
                clienteTMP.setDireccion(resulset.getString("direccion"));
                clienteTMP.setMunicipio(resulset.getString("municipio"));
                clienteTMP.setDepartamento(resulset.getString("departamento"));
                System.out.println("temp " + clienteTMP.getNombreCliente());

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return clienteTMP;
    }
    
        
   public int registrarCliente(String nombreCliente,String nit, String direccion,String municipio,String departamento){
        String sql = "INSERT INTO cliente (nombre_cliente, nit, direccion, municipio, departamento) VALUES (?, ?, ?, ?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreCliente);
            statement.setString(2, nit);
            statement.setString(3, direccion);
            statement.setString(4, municipio);
            statement.setString(5, departamento);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar Registrar CLiente");
            e.printStackTrace(System.out);
        }
        return registros;
       
       
       
   }
    
    
    
    
}
