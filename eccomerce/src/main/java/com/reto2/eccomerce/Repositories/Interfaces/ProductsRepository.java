package com.reto2.eccomerce.Repositories.Interfaces;

import com.reto2.eccomerce.Repositories.Entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
    
}
