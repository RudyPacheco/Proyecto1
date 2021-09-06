/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 * 
 * @author AndaryuS
 */
public class muebleReceta {

    private String nombreMueble;
    private ArrayList<asignar_pieza> piezasN;

    public muebleReceta() {
    }

    public muebleReceta(String nombreMueble, ArrayList<asignar_pieza> piezasN) {
        this.nombreMueble = nombreMueble;
        this.piezasN = piezasN;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public ArrayList<asignar_pieza> getPiezasN() {
        return piezasN;
    }

    public void setPiezasN(ArrayList<asignar_pieza> piezasN) {
        this.piezasN = piezasN;
    }
    
 
    
    
    
    
}
