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
public class usuarioMasVenta {
    private String nombreUsuario;
    private int total;

    public usuarioMasVenta() {
    }

    public usuarioMasVenta(String nombreUsuario, int total) {
        this.nombreUsuario = nombreUsuario;
        this.total = total;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
