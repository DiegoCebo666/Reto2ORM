package com.reto2.eccomerce.Web.View;

import java.util.ArrayList;
import java.util.List;

import com.reto2.eccomerce.Repositories.Entities.ProductEntity;
import com.reto2.eccomerce.Services.Models.OrderProductDTO;
import com.reto2.eccomerce.Services.Models.OrderService;
import com.reto2.eccomerce.Services.Models.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@Controller
@RequestMapping("/orders/v1")
public class OrdersViewController {

    private final OrderService orderService;
    private final ProductService productService;

    OrdersViewController(OrderService orderService, ProductService productService){
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ModelAndView getProductsInOrder(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("index");
        List<ProductEntity> products = new ArrayList();
        for (OrderProductDTO orderProduct : orderService.findById(id)) {
            for (ProductEntity product : productService.getAllEntities()) {
                if(orderProduct.getIdproduct() == product.getId()){
                    products.add(product);
                }
            }
        }
        mv.addObject("products", products);
        return mv;
    }
}
