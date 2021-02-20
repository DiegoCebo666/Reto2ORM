package com.reto2.eccomerce.Services.Models;

import java.util.ArrayList;

import com.reto2.eccomerce.Services.Models.Support.ProductQuantityDTO;

public class OrderProductDTO {
    private Long idorder;
    private Long idproduct;
    private int quantity;

    public OrderProductDTO(){}

    public OrderProductDTO(Long idorder, Long idproduct, int quantity){
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
