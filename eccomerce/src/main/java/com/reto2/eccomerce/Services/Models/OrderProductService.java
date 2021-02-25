package com.reto2.eccomerce.Services.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.reto2.eccomerce.Repositories.Entities.OrderProductEntity;
import com.reto2.eccomerce.Repositories.Interfaces.OrderProductsRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderProductService {

    @Autowired
    private OrderProductsRepository orderproductRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OrderProductDTO> getAll(){
        return orderproductRepository.findAll().stream().map(x -> modelMapper.map(x, OrderProductDTO.class)).collect(Collectors.toList());
    }

    public OrderProductDTO add(OrderProductDTO orderproduct){
        OrderProductEntity entityToInsert = modelMapper.map(orderproduct, OrderProductEntity.class);
        OrderProductEntity result = orderproductRepository.save(entityToInsert);
        return modelMapper.map(result, OrderProductDTO.class);
    }

    public OrderProductDTO update(Long ID, OrderProductDTO orderproduct){
        OrderProductEntity entityToUpdate = modelMapper.map(orderproduct, OrderProductEntity.class);
        OrderProductEntity result = orderproductRepository.save(entityToUpdate);
        return modelMapper.map(result, OrderProductDTO.class);
    }

    public void delete(Long ID){
        Optional<OrderProductEntity> entityToDelete = orderproductRepository.findById(ID);
        if (entityToDelete.isPresent()){
            orderproductRepository.delete(entityToDelete.get());
        }
    }

}