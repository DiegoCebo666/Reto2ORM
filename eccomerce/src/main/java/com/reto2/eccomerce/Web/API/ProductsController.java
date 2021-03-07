package com.reto2.eccomerce.Web.API;

import java.util.List;

import com.reto2.eccomerce.Services.Models.ProductDTO;
import com.reto2.eccomerce.Services.Models.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    ProductsController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }
}
