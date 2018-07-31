/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelapi;

/**
 *
 * @author erquier
 */
public class Cliente {
    
    public int IDcliente;
    public String nombre;
    public String email;
    public String password;
    public String telefono;
    public String direccion;
    public int estado;

    public Cliente(String nombre, String email, String password, String telefono, String direccion, int estado) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }



    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", email=" + email + ", password=" + password + ", telefono=" + telefono + ", direccion=" + direccion + ", estado=" + estado + '}';
    }
    
    
    
}
