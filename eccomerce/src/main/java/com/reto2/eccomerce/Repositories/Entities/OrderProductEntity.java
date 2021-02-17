package com.reto2.eccomerce.Repositories.Entities;

import java.util.ArrayList;

import com.reto2.eccomerce.Repositories.Entities.Support.ProductQuantityEntity;

public class OrderProductEntity {
    private static int idCount = 0;
    private int id;
    private int idorder;
    private ArrayList<ProductQuantityEntity> productCantidad;

    public OrderProductEntity(){}

    public OrderProductEntity(int idorder, ArrayList<ProductQuantityEntity> productCantidad){
        this.id = ++idCount;
        this.idorder = idorder;
        this.productCantidad = productCantidad;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdorder() {
        return idorder;
    }
    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }
    public ArrayList<ProductQuantityEntity> getProductCantidad() {
        return productCantidad;
    }
    public void setProductCantidad(ArrayList<ProductQuantityEntity> productCantidad) {
        this.productCantidad = productCantidad;
    }
}
