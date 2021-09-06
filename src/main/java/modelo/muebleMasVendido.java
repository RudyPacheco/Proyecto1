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
public class muebleMasVendido {

    String nombreMueble;
    int total;

    public muebleMasVendido() {
    }

    public muebleMasVendido(String nombreMueble, int total) {
        this.nombreMueble = nombreMueble;
        this.total = total;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
    
    
    
}
