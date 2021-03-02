package com.reto2.eccomerce.Services.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDTO {
    private String fecha;
    private String username;
    private String estado;

    public String getFecha() {
        return fecha;
    }
    public void setFecha() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = formatter.format(new Date());
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
