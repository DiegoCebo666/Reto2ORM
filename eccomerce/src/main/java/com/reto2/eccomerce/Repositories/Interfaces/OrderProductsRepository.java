package com.reto2.eccomerce.Repositories.Interfaces;

import com.reto2.eccomerce.Repositories.Entities.OrderProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsRepository extends JpaRepository<OrderProductEntity, Long> {

}
