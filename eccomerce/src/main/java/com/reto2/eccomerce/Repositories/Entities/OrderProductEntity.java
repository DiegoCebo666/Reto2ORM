package com.reto2.eccomerce.Repositories.Entities;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="OrderProducts")
@Entity(name="OrderProducts")
public class OrderProductEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long idorder;
    private Long idproduct;
    private int quantity;

    public OrderProductEntity(){}

    public OrderProductEntity(Long idorder, Long idproduct, int quantity){
        this.idorder = idorder;
        this.idproduct = idproduct;
        this.quantity = quantity;
    }
    public Long getIdorder() {
        return idorder;
    }
    public void setIdorder(Long idorder) {
        this.idorder = idorder;
    }
    public Long getIdproduct() {
        return idproduct;
    }
    public void setIdproduct(Long idproduct) {
        this.idproduct = idproduct;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
