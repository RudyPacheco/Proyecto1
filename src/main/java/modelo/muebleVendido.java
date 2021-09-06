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
public class muebleVendido {

    private  String idMueble;
    private String nombreMueble;
    private LocalDate fechaEnsamble;
    private LocalDate fechaVenta;
    private String usuarioEnsamble;
    private String usuarioVenta;
    private double costo;
    private double precio;

    public muebleVendido() {
    }

    public muebleVendido(String idMueble, String nombreMueble, LocalDate fechaEnsamble, LocalDate fechaVenta, String usuarioEnsamble, String usuarioVenta, double costo, double precio) {
        this.idMueble = idMueble;
        this.nombreMueble = nombreMueble;
        this.fechaEnsamble = fechaEnsamble;
        this.fechaVenta = fechaVenta;
        this.usuarioEnsamble = usuarioEnsamble;
        this.usuarioVenta = usuarioVenta;
        this.costo = costo;
        this.precio = precio;
    }

 

    public String getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(String idMueble) {
        this.idMueble = idMueble;
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

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getUsuarioEnsamble() {
        return usuarioEnsamble;
    }

    public void setUsuarioEnsamble(String usuarioEnsamble) {
        this.usuarioEnsamble = usuarioEnsamble;
    }

    public String getUsuarioVenta() {
        return usuarioVenta;
    }

    public void setUsuarioVenta(String usuarioVenta) {
        this.usuarioVenta = usuarioVenta;
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
