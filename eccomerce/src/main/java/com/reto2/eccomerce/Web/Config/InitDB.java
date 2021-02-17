package com.reto2.eccomerce.Web.Config;

import com.reto2.eccomerce.Repositories.Interfaces.OrdersRepository;
import com.reto2.eccomerce.Repositories.Interfaces.ProductsRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {

    @Bean
    CommandLineRunner initDatabase (OrdersRepository oRepository, ProductsRepository pRepository){
        return args -> {
            
        };
    }
}