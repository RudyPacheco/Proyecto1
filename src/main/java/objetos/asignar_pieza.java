/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 * 
 * @author AndaryuS
 */
public class asignar_pieza {

    private String nombreMueble;
    private String nombrePieza;
    private int cantidad;

    public asignar_pieza() {
    }

    public asignar_pieza(String nombreMueble, String nombrePieza, int cantidad) {
        this.nombreMueble = nombreMueble;
        this.nombrePieza = nombrePieza;
        this.cantidad = cantidad;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
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
