package com.reto2.eccomerce.Services.Models;

public class ProductDTO {
    private String nombre;
    private double precio;
    private String img;

    public ProductDTO(){}

    public ProductDTO(String nombre, double precio, String img) {
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
