package com.reto2.eccomerce.Repositories.Entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.text.SimpleDateFormat;

public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fecha;
    private String username;
    private String estado;

    public OrderEntity(){}

    public OrderEntity(String username, int estado) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = formatter.format(new Date());
        this.username = username;
        setEstado(estado);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    public void setEstado(int estado) {
        if(estado > 5 || estado < 1){
            this.estado = "Estado not found";
        }else if(estado == 1){
            this.estado = "En curso";
        }else if(estado == 2){
            this.estado = "Enviado";
        }else if(estado == 3){
            this.estado = "Aceptado";
        }else if(estado == 4){
            this.estado = "Entregado";
        }else{
            this.estado = "Cancelado";
        }
    }
}
