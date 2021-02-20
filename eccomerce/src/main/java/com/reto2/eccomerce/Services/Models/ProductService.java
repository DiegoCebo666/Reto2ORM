package com.reto2.eccomerce.Services.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.orms.orms.Repositories.Entities.ProductEntity;
import com.orms.orms.Repositories.Interfaces.ProductsRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    private ProductsRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAll(){
        return productRepository.findAll().stream().map(x -> modelMapper.map(x, ProductDTO.class)).collect(Collectors.toList());
    }

    public List<ProductDTO> findByUserId(Long userId){
        var result = productRepository.findByUserId(userId).stream().map(x -> modelMapper.map(x, ProductDTO.class)).collect(Collectors.toList());
        return result;
    }

    public List<ProductDTO> findBySalario(float salario){
        var result = productRepository.findBySalario(salario).stream().map(x -> modelMapper.map(x, ProductDTO.class)).collect(Collectors.toList());
        return result;
    }

    public ProductDTO add(ProductDTO product){
        ProductEntity entityToInsert = modelMapper.map(Product, ProductEntity.class);
        ProductEntity result = productRepository.save(entityToInsert);
        return modelMapper.map(result, ProductDTO.class);
    }

    public ProductDTO update(Long ID, ProductDTO Product){
        ProductEntity entityToUpdate = modelMapper.map(Product, ProductEntity.class);
        ProductEntity result = productRepository.save(entityToUpdate);
        return modelMapper.map(result, ProductDTO.class);
    }

    public void delete(Long ID){
        Optional<ProductEntity> entityToDelete = productRepository.findById(ID);
        if (entityToDelete.isPresent()){
            productRepository.delete(entityToDelete.get());
        }
    }

    public Optional<ProductDTO> findById(Long id){
        Optional<ProductEntity> entity = productRepository.findById(id);
        if(entity.isPresent())
            return Optional.of(modelMapper.map(entity.get(), ProductDTO.class));
        else
            return Optional.empty();
    }

}
