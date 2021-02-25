package com.reto2.eccomerce.Web.Config;

import com.reto2.eccomerce.Repositories.Entities.OrderEntity;
import com.reto2.eccomerce.Repositories.Entities.ProductEntity;
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
            oRepository.save(new OrderEntity("PIPO", "Enviado"));
            pRepository.save(new ProductEntity("PIPELUCHE", 14.99, "https://cdn1.peluchilandia.es/3304-home_default/peluche-perrito-melancolico.jpg"));
            pRepository.save(new ProductEntity("PIPOYOYO", 16.99, "https://www.jugarijugar.com/1057-large_default/yo-yo-de-madera-natural.jpg"));
            pRepository.save(new ProductEntity("PIPOCAMELLO", 9.99, "https://www.oasysparquetematico.com/wp-content/uploads/2019/04/shutterstock_199591094.jpg"));
            pRepository.save(new ProductEntity("PIPOSAURIO", 6.66, "https://www.mrbooks.com/mrbooks/portadas/9789506031718.jpg"));
            pRepository.save(new ProductEntity("PIPOKIMON", 69.69, "https://images-na.ssl-images-amazon.com/images/I/81wESosz9eL._AC_SY355_.jpg"));
        };
    }
}