package com.reto2.eccomerce.Repositories.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.text.SimpleDateFormat;

@Table(name="Orders")
@Entity(name="Orders")
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fecha;
    private String username;
    private String estado;

    public OrderEntity(){}

    public OrderEntity(String username, String estado) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = formatter.format(new Date());
        this.username = username;
        this.estado = estado;
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
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
