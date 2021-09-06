/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.time.LocalDate;
import javax.ejb.Local;

/**
 * 
 * @author AndaryuS
 */
public class muebleRegistrado {
    
    String id_mueble;
    String nombreMueble;
    LocalDate fechaEnsamble;
    String nombreUsuario;
    double precio;
    double costo;

    public muebleRegistrado() {
    }

    public muebleRegistrado(String id_mueble, String nombreMueble, LocalDate fechaEnsamble, String nombreUsuario, double precio, double decimal) {
        this.id_mueble = id_mueble;
        this.nombreMueble = nombreMueble;
        this.fechaEnsamble = fechaEnsamble;
        this.nombreUsuario = nombreUsuario;
        this.precio = precio;
        this.costo= decimal;
    }

    public String getId_mueble() {
        return id_mueble;
    }

    public void setId_mueble(String id_mueble) {
        this.id_mueble = id_mueble;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public LocalDate getFechaEnsamble() {
        return fechaEnsamble;
    }

    public void setFechaEnsamble(LocalDate fechaEnsamble) {
        this.fechaEnsamble = fechaEnsamble;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double decimal) {
        this.costo = decimal;
    }
    
    
    
    
    
}
