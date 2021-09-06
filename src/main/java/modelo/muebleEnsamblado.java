/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.time.LocalDate;

/**
 * 
 * @author AndaryuS
 */
public class muebleEnsamblado {

    private int id;
    private String nombreMueble;
    private LocalDate fechaEnsamble;
    private String nombreUsuario;
    private double costo;
    private double precio;

    public muebleEnsamblado() {
    }

    public muebleEnsamblado(int id, String nombreMueble, LocalDate fechaEnsamble, String nombreUsuario, double costo, double precio) {
        this.id = id;
        this.nombreMueble = nombreMueble;
        this.fechaEnsamble = fechaEnsamble;
        this.nombreUsuario = nombreUsuario;
        this.costo = costo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
    
    
}
