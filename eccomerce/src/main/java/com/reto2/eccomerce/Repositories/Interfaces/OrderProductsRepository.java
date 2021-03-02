package com.reto2.eccomerce.Repositories.Interfaces;

import java.util.Collection;

import com.reto2.eccomerce.Repositories.Entities.OrderProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderProductsRepository extends JpaRepository<OrderProductEntity, Long> {
    
    @Query("SELECT op FROM OrderProducts op WHERE op.idorder = :id")
    Collection<OrderProductEntity> findOrderProductsById(@Param("id") Long id);
}
