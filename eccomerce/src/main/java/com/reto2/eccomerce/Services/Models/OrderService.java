package com.reto2.eccomerce.Services.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.reto2.eccomerce.Repositories.Entities.OrderEntity;
import com.reto2.eccomerce.Repositories.Interfaces.OrdersRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private OrdersRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getAll(){
        return orderRepository.findAll().stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
    }

    public OrderDTO add(OrderDTO order){
        OrderEntity entityToInsert = modelMapper.map(order, OrderEntity.class);
        OrderEntity result = orderRepository.save(entityToInsert);
        return modelMapper.map(result, OrderDTO.class);
    }

    public OrderDTO update(Long ID, OrderDTO order){
        OrderEntity entityToUpdate = modelMapper.map(order, OrderEntity.class);
        OrderEntity result = orderRepository.save(entityToUpdate);
        return modelMapper.map(result, OrderDTO.class);
    }

    public void delete(Long ID){
        Optional<OrderEntity> entityToDelete = orderRepository.findById(ID);
        if (entityToDelete.isPresent()){
            orderRepository.delete(entityToDelete.get());
        }
    }

    public Optional<OrderDTO> findById(Long id){
        Optional<OrderEntity> entity = orderRepository.findById(id);
        if(entity.isPresent())
            return Optional.of(modelMapper.map(entity.get(), OrderDTO.class));
        else
            return Optional.empty();
    }

}