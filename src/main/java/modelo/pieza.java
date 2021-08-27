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
public class pieza {
    private String nombre_pieza;
    private double costo;

    public pieza() {
    }

    public pieza(String nombre_pieza, double costo) {
        this.nombre_pieza = nombre_pieza;
        this.costo = costo;
    }

    public String getNombre_pieza() {
        return nombre_pieza;
    }

    public void setNombre_pieza(String nombre_pieza) {
        this.nombre_pieza = nombre_pieza;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
    
    
}
