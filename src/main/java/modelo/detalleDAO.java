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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AndaryuS
 */
public class detalleDAO {

    conexion cn = new conexion();
    Connection conection;
    PreparedStatement statement;
    ResultSet resulset;

    public List buscarFactura(String idFactura) {
        ArrayList<detalle> detalles = new ArrayList<>();

        String sql = "SELECT * FROM detalle WHERE id_factura=?";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idFactura);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                detalle detalleTEMP = new detalle();
                detalleTEMP.setIdFactura(resulset.getString("id_factura"));
                detalleTEMP.setIdMueble(resulset.getString("id_mueble"));
                detalleTEMP.setNombreMueble(resulset.getString("nombreMueble"));
                detalleTEMP.setPrecio(resulset.getDouble("precio"));
                detalles.add(detalleTEMP);

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return detalles;
    }
    
     public List listarDetalle(String idFactura) {
        ArrayList<detalle> detalles = new ArrayList<>();

        String sql = "SELECT * FROM detalle";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            //statement.setString(2, password);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                detalle detalleTEMP = new detalle();
                detalleTEMP.setIdFactura(resulset.getString("id_factura"));
                detalleTEMP.setIdMueble(resulset.getString("id_mueble"));
                detalleTEMP.setNombreMueble(resulset.getString("nombreMueble"));
                detalleTEMP.setPrecio(resulset.getDouble("precio"));
                detalles.add(detalleTEMP);

            }

        } catch (Exception e) {
            System.out.println("Erroes");
            e.printStackTrace(System.out);
            System.out.println("Ou es el top enemigo");
        }
        return detalles;
    }
    
    


}
