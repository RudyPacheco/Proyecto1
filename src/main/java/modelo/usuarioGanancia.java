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
public class usuarioGanancia {

    private String nombreUsuario;
    private double ganancia;

    public usuarioGanancia() {
    }

    public usuarioGanancia(String nombreUsuario, double ganancia) {
        this.nombreUsuario = nombreUsuario;
        this.ganancia = ganancia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
    
    
    
    
    
}
