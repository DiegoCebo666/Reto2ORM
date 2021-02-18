package com.reto2.eccomerce.Repositories.Interfaces;

import com.reto2.eccomerce.Repositories.Entities.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrderEntity, Long> {
    
}
