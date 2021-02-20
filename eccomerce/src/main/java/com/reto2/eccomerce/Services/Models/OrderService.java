package com.reto2.eccomerce.Services.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.orms.orms.Repositories.Entities.OrderEntity;
import com.orms.orms.Repositories.Interfaces.OrdersRepository;

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

    public List<OrderDTO> findByUserId(Long userId){
        var result = orderRepository.findByUserId(userId).stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
        return result;
    }

    public List<OrderDTO> findBySalario(float salario){
        var result = orderRepository.findBySalario(salario).stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
        return result;
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