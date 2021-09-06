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
import java.util.ArrayList;
import java.util.List;

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

    public List listarPiezas() {
        String sql = "SELECT * FROM pieza_registrada";
        List<piezaRegistrada> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                piezaRegistrada temp = new piezaRegistrada();
                temp.setNombrePieza(resulset.getString("nombre_pieza"));
                temp.setCantidad(resulset.getInt("cantidad"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public piezaRegistrada verificarPieza(String nombrePieza) {
        String sql = "SELECT * FROM pieza_registrada WHERE nombre_pieza=?";
        //  List<piezaRegistrada> lista = new ArrayList<>();
        piezaRegistrada temp = new piezaRegistrada();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            resulset = statement.executeQuery();
            while (resulset.next()) {

                temp.setNombrePieza(resulset.getString("nombre_pieza"));
                temp.setCantidad(resulset.getInt("cantidad"));
                //  lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar pieza registrada");
            e.printStackTrace(System.out);
        }

        return temp;
    }

    public List listarPiezaEspecifica(String nombrePieza) {
        String sql = "SELECT * FROM pieza_disponible WHERE nombre_pieza=?";

        List<pieza> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                pieza temp = new pieza();
                temp.setId(resulset.getInt("id_pieza"));
                temp.setNombre_pieza(resulset.getString("nombre_pieza"));
                temp.setCosto(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public List listarPiezaEspecificaDisponible(String nombrePieza, int cantidad) {
        //String sql = "SELECT * FROM pieza_disponible WHERE nombre_pieza=?";
        String sql = "SELECT * FROM pieza_disponible WHERE nombre_pieza=? LIMIT ?";
        List<pieza> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            statement.setInt(2, cantidad);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                pieza temp = new pieza();
                temp.setId(resulset.getInt("id_pieza"));
                temp.setNombre_pieza(resulset.getString("nombre_pieza"));
                temp.setCosto(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public int agregarPiezaUsada(String idMueble, pieza PiezaRecibida) {
        String sql = "INSERT INTO piezas_usadas (id_mueble, id_pieza, nombre_pieza, precio) VALUES (?, ?, ?, ?)";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idMueble);
            statement.setInt(2, PiezaRecibida.getId());
            statement.setString(3, PiezaRecibida.getNombre_pieza());
            statement.setDouble(4, PiezaRecibida.getCosto());
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error Inventario piezas usadas");
            e.printStackTrace(System.out);
        }
        return registros;

    }

    public int eliminarPieza(int idPIeza) {

        //String sql = "INSERT INTO pieza_disponible (nombre_pieza, precio) VALUES (?, ?)";
        String sql = "DELETE FROM pieza_disponible WHERE id_pieza=?";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setInt(1, idPIeza);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al borrar pieza");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public int actualizarPieza(String nombrePieza, double precio) {

        String sql = "UPDATE pieza_registrada SET cantidad=cantidad-1 WHERE nombre_pieza = ?";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar stock");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public List listarPiezasUsadas(String idMueble) {
        //String sql = "SELECT * FROM pieza_disponible WHERE nombre_pieza=?";
        String sql = "SELECT * FROM piezas_usadas WHERE id_mueble=? ";
        List<pieza> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, idMueble);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                pieza temp = new pieza();
                temp.setId(resulset.getInt("id_pieza"));
                temp.setNombre_pieza(resulset.getString("nombre_pieza"));
                temp.setCosto(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return lista;
    }

    public int editarPieza(int id, String nombrePieza, double precio) {

        String sql = "UPDATE pieza_disponible SET nombre_pieza=?, precio=? WHERE id_pieza=?";
        int registros = 0;

        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setString(1, nombrePieza);
            statement.setDouble(2, precio);
            statement.setInt(3, id);
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar stock");
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public pieza buscarPieza(int idPieza) {
        String sql = "SELECT * FROM pieza_disponible WHERE id_pieza=?";
        pieza temp = null;
        List<pieza> lista = new ArrayList<>();
        try {
            conection = cn.conexion();
            statement = conection.prepareStatement(sql);
            statement.setInt(1, idPieza);
            resulset = statement.executeQuery();
            while (resulset.next()) {
                temp = new pieza();
                temp.setId(resulset.getInt("id_pieza"));
                temp.setNombre_pieza(resulset.getString("nombre_pieza"));
                temp.setCosto(resulset.getDouble("precio"));
                lista.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Error en listar");
            e.printStackTrace(System.out);
        }

        return temp;
    }

}
