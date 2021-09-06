/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.MysqlType;
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
                muebleTMP.setPrecio(resulset.getDouble("precio"));
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

    public int agregarPiezaMueble(String nombreMueble, String nombrePieza, int cantidad) {
        String sql = "INSERT INTO mueble_receta (nombre_mueble, pieza_necesaria, cantidad) VALUES (?, ?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreMueble);
            statement.setString(2, nombrePieza);
            statement.setInt(3, cantidad);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar Registrar");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public List listarMuebles() {
        String sql = "SELECT * FROM mueble";
        List<mueble> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                mueble temp = new mueble();
                temp.setNombre_mueble(resulset.getString("nombre_mueble"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List listarPiezasMueble(String nombreMueble) {
        String sql = "SELECT * FROM mueble_receta WHERE nombre_mueble=?";
        List<piezaRegistrada> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombreMueble);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                piezaRegistrada temp = new piezaRegistrada();
                temp.setNombrePieza(resulset.getString("pieza_necesaria"));
                temp.setCantidad(resulset.getInt("cantidad"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public int registrarMuble(String idMueble, String nombreMueble, LocalDate fecha, String usuario, double costo, double precio) {
        String sql = "INSERT INTO muebles_registrados (id_mueble_registrado, nombre, fecha_ensamble, usuario_ensamble, costo, precio) VALUES (?, ?, ?, ?, ?, ?)";
        int registros = 0;
        java.sql.Date mydate = java.sql.Date.valueOf(fecha);
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idMueble);
            statement.setString(2, nombreMueble);
            statement.setDate(3, mydate);
            statement.setString(4, usuario);
            statement.setDouble(5, costo);
            statement.setDouble(6, precio);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al ensamblar meuble");
            e.printStackTrace(System.out);
        }
        return registros;
    }

     public int ensamblarMueble(String idMueble, String nombreMueble, LocalDate fecha, String usuario, double costo, double precio) {
        String sql = "INSERT INTO muebles_sin_registrar (id_mueble, nombre, fecha_ensamble, usuario_ensamble, costo, precio) VALUES (?, ?, ?, ?, ?, ?)";
        int registros = 0;
        java.sql.Date mydate = java.sql.Date.valueOf(fecha);
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idMueble);
            statement.setString(2, nombreMueble);
            statement.setDate(3, mydate);
            statement.setString(4, usuario);
            statement.setDouble(5, costo);
            statement.setDouble(6, precio);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al ensamblar meuble");
            e.printStackTrace(System.out);
        }
        return registros;
    }
    
    
    
    public String genearSerie() {
        String numeroSerie="";
        String sql = "SELECT MAX(id_mueble_registrado) FROM muebles_registrados";
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {                
                numeroSerie=resulset.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al generar Serie");
            e.printStackTrace(System.out);
        }

            return  numeroSerie;
    }

        public List listarMueblesEnsamblados() {
        String sql = "SELECT * FROM muebles_registrados";
        List<muebleRegistrado> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                muebleRegistrado temp = new muebleRegistrado();
                temp.setId_mueble(resulset.getString("id_mueble_registrado"));
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setFechaEnsamble(resulset.getDate("fecha_ensamble").toLocalDate());
                temp.setNombreUsuario(resulset.getString("usuario_ensamble"));
                temp.setCosto(resulset.getDouble("costo"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar muebles registrados");
            e.printStackTrace(System.out);
        }

        return lista;
    }
    
            public muebleRegistrado buscarPorId(String idMueble) {
        String sql = "SELECT * FROM muebles_registrados WHERE id_mueble_registrado=?";
        List<muebleRegistrado> lista = new ArrayList<>();
             muebleRegistrado temp = new muebleRegistrado();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
               statement.setString(1, idMueble);
            resulset = statement.executeQuery();
            while (resulset.next()) {
           
                temp.setId_mueble(resulset.getString("id_mueble_registrado"));
                temp.setNombreMueble(resulset.getString("nombre"));
                temp.setFechaEnsamble(resulset.getDate("fecha_ensamble").toLocalDate());
                temp.setNombreUsuario(resulset.getString("usuario_ensamble"));
                temp.setCosto(resulset.getDouble("costo"));
                temp.setPrecio(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar muebles registrados");
            e.printStackTrace(System.out);
        }

        return temp;
    }
    
    
    
}
