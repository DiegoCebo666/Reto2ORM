package com.reto2.eccomerce.Web.Config;

import com.reto2.eccomerce.Services.Models.OrderProductService;
import com.reto2.eccomerce.Services.Models.OrderService;
import com.reto2.eccomerce.Services.Models.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DI {
    
    @Bean
    ProductService createProductService(){
        return new ProductService();
    }
    
    @Bean
    OrderService createOrderService(){
        return new OrderService();
    }
    
    @Bean
    OrderProductService createOrderProductService() {
        return new OrderProductService();
    }

    @Bean
    ModelMapper createModelMapper(){
        return new ModelMapper(); 
    }
    
}