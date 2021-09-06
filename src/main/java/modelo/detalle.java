/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 * 
 * @author AndaryuS
 */
public class detalle {

    private String idFactura;
    private String idMueble;
    private String nombreMueble;
    private double precio;

    public detalle() {
    }

    public detalle(String idFactura, String idMueble, String nombreMueble, double precio) {
        this.idFactura = idFactura;
        this.idMueble = idMueble;
        this.nombreMueble = nombreMueble;
        this.precio = precio;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
}
