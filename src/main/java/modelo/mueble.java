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
public class mueble {

   private String nombre_mueble;
   private double precio;

    public mueble() {
    }

    public mueble(String nombre_mueble, double precio) {
        this.nombre_mueble = nombre_mueble;
        this.precio = precio;
    }

    public String getNombre_mueble() {
        return nombre_mueble;
    }

    public void setNombre_mueble(String nombre_mueble) {
        this.nombre_mueble = nombre_mueble;
    }

    public double isPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
   
   
    
}
