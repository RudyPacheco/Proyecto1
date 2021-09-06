/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import sun.security.util.Password;

/**
 * 
 * @author AndaryuS
 */
public class usuario {

    private String usuario;
    private String Password ;
    private int categoria;
    private boolean  bloqueado;

    public usuario() {
    }

    public usuario(String usuario, String Password, int categoria) {
        this.usuario = usuario;
        this.Password = Password;
        this.categoria = categoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    
    
    
    
}
