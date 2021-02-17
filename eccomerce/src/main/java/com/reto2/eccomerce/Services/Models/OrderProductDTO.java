package com.reto2.eccomerce.Services.Models;

import java.util.ArrayList;

import com.eccomerce.diegocebollero.eccomerce.Model.Support.ProductQuantity;

public class OrderProductDTO {
    private static int idCount = 0;
    private int id;
    private int idorder;
    private ArrayList<ProductQuantity> productCantidad;

    public OrderProduct(){}

    public OrderProduct(int idorder, ArrayList<ProductQuantity> productCantidad){
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
    public ArrayList<ProductQuantity> getProductCantidad() {
        return productCantidad;
    }
    public void setProductCantidad(ArrayList<ProductQuantity> productCantidad) {
        this.productCantidad = productCantidad;
    }
}
