package com.reto2.eccomerce.Web.View;

import com.reto2.eccomerce.Services.Models.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@Controller
@RequestMapping("/products/v1")
public class ProductsViewController {

    private final ProductService productService;

    ProductsViewController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public ModelAndView getProducts() {
        ModelAndView mv = new ModelAndView("prods");
        mv.addObject("products", productService.getAll());
        return mv;
    }
}
