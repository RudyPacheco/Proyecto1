/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.time.LocalDate;

/**
 * 
 * @author AndaryuS
 */
public class factura {

    private  String id;
    private LocalDate fecha;
    private String nit;
    private String nombreUsuario;
    private double total;

    public factura() {
    }

    public factura(String id, LocalDate fecha, String nit, String nombreUsuario, double total) {
        this.id = id;
        this.fecha = fecha;
        this.nit = nit;
        this.nombreUsuario = nombreUsuario;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
}
