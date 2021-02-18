package com.reto2.eccomerce.Services.Models;

import java.util.ArrayList;

import com.reto2.eccomerce.Services.Models.Support.ProductQuantityDTO;

public class OrderProductDTO {
    private static int idCount = 0;
    private int id;
    private int idorder;
    private ArrayList<ProductQuantityDTO> productCantidad;

    public OrderProductDTO(){}

    public OrderProductDTO(int idorder, ArrayList<ProductQuantityDTO> productCantidad){
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
    public ArrayList<ProductQuantityDTO> getProductCantidad() {
        return productCantidad;
    }
    public void setProductCantidad(ArrayList<ProductQuantityDTO> productCantidad) {
        this.productCantidad = productCantidad;
    }
}
