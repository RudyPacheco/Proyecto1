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
public class piezaRegistrada {

    String nombrePieza;
    int cantidad;

    public piezaRegistrada() {
    }

    public piezaRegistrada(String nombrePieza, int cantidad) {
        this.nombrePieza = nombrePieza;
        this.cantidad = cantidad;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
