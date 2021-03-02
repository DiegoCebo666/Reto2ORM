package com.reto2.eccomerce.Services.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.reto2.eccomerce.Repositories.Entities.OrderEntity;
import com.reto2.eccomerce.Repositories.Entities.OrderProductEntity;
import com.reto2.eccomerce.Repositories.Interfaces.OrderProductsRepository;
import com.reto2.eccomerce.Repositories.Interfaces.OrdersRepository;
import com.reto2.eccomerce.Web.API.ElementNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private OrdersRepository orderRepository;
    @Autowired
    private OrderProductsRepository orderProductRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getAll(){
        return orderRepository.findAll().stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
    }

    public Long add(OrderDTO order, List<OrderProductDTO> orderProducts){
        OrderEntity entityToInsert = modelMapper.map(order, OrderEntity.class);
        OrderEntity result = orderRepository.save(entityToInsert);
        OrderProductEntity entityOPToInsert;
        for (OrderProductDTO orderProduct : orderProducts) {
            entityOPToInsert = modelMapper.map(orderProduct, OrderProductEntity.class);
            entityOPToInsert.setIdorder(entityToInsert.getId());
            orderProductRepository.save(entityOPToInsert);
        }
        return result.getId();
    }

    public void update(Long id, List<OrderProductDTO> orderProducts){
        List<OrderProductEntity> orders = modelMapper.map(findById(id), List.class);
        for (OrderProductEntity orderProductEntity : orders) {
            orderProductRepository.delete(orderProductEntity);
        }
        OrderProductEntity entityOPToInsert;
        for (OrderProductDTO orderProduct : orderProducts) {
            entityOPToInsert = modelMapper.map(orderProduct, OrderProductEntity.class);
            entityOPToInsert.setIdorder(id);
            orderProductRepository.save(entityOPToInsert);
        }
    }

    public void delete(Long id){
        List<OrderProductEntity> orders = modelMapper.map(findById(id), List.class);
        for (OrderProductEntity orderProductEntity : orders) {
            orderProductRepository.delete(orderProductEntity);
        }
        Optional<OrderEntity> entityToDelete = orderRepository.findById(id);
        if (entityToDelete.isPresent()){
            orderRepository.delete(entityToDelete.get());
        }
    }

    public List<OrderProductDTO> findById(Long id){
        List<OrderProductDTO> list = orderProductRepository.findOrderProductsById(id).stream().map(x -> modelMapper.map(x, OrderProductDTO.class)).collect(Collectors.toList());
        if(list.isEmpty()){
            throw new ElementNotFoundException();
        }else{
            return list;
        }
    }

}