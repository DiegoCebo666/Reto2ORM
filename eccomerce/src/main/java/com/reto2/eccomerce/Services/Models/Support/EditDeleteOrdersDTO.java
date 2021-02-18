package com.reto2.eccomerce.Services.Models.Support;

import com.reto2.eccomerce.Services.Models.OrderProductDTO;

public class EditDeleteOrdersDTO {
    private OrderProductDTO edit;
    private OrderProductDTO delete;

    public EditDeleteOrdersDTO(){}

    public EditDeleteOrdersDTO(OrderProductDTO edit, OrderProductDTO delete){
        this.edit = edit;
        this.delete = delete;
    }

    public OrderProductDTO getEdit() {
        return edit;
    }
    public void setEdit(OrderProductDTO edit) {
        this.edit = edit;
    }
    public OrderProductDTO getDelete() {
        return delete;
    }
    public void setDelete(OrderProductDTO delete) {
        this.delete = delete;
    }
}
