package com.reto2.eccomerce.Web.API;

import java.util.ArrayList;
import java.util.Arrays;

import com.eccomerce.diegocebollero.eccomerce.Model.Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@Controller
@RequestMapping("/apiazure")
public class ProductsController {
    @GetMapping("products")
    public ModelAndView getProducts() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("products", products);
        return mv;
    }

    public static Product findProdById(int id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id) return products.get(i);
        }
        throw new ElementNotFoundException();
    }
}
