package com.reto2.eccomerce.Repositories.Entities.Support;

import com.reto2.eccomerce.Repositories.Entities.OrderProductEntity;

public class EditDeleteOrdersEntity {
    private OrderProductEntity edit;
    private OrderProductEntity delete;

    public EditDeleteOrdersEntity(){}

    public EditDeleteOrdersEntity(OrderProductEntity edit, OrderProductEntity delete){
        this.edit = edit;
        this.delete = delete;
    }

    public OrderProductEntity getEdit() {
        return edit;
    }
    public void setEdit(OrderProductEntity edit) {
        this.edit = edit;
    }
    public OrderProductEntity getDelete() {
        return delete;
    }
    public void setDelete(OrderProductEntity delete) {
        this.delete = delete;
    }
}
