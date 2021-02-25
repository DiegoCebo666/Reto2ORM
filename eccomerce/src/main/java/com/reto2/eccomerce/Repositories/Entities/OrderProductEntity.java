package com.reto2.eccomerce.Repositories.Entities;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;

@Table(name="OrderProducts")
@Entity(name="OrderProducts")
public class OrderProductEntity {
    @Id
    @GeneratedValue
    private Long id;
    private int idorder;
    private int idproduct;
    private int quantity;

    public OrderProductEntity(){}

    public OrderProductEntity(int idorder, int idproduct, int quantity){
        this.idorder = idorder;
        this.idproduct = idproduct;
        this.quantity = quantity;
    }
    public int getIdorder() {
        return idorder;
    }
    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }
    public int getIdproduct() {
        return idproduct;
    }
    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}