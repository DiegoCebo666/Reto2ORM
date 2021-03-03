package com.reto2.eccomerce.Web.View;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.reto2.eccomerce.Repositories.Entities.ProductEntity;
import com.reto2.eccomerce.Services.Models.OrderProductDTO;
import com.reto2.eccomerce.Services.Models.OrderService;
import com.reto2.eccomerce.Services.Models.ProductDTO;
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

    // public ArrayList<ProductEntity> productsIn(int id){
    //     ArrayList<Product> result = new ArrayList<>();
    //     OrderProduct products = OrdersController.findOrderProductById(id);
    //     for (int i = 0; i < products.getProductCantidad().size(); i++) {
    //         for (int j = 0; j < ProductsController.products.size(); j++) {
    //             if(products.getProductCantidad().get(i).getIdproduct() == ProductsController.products.get(j).getId()) 
    //                 result.add(ProductsController.findProdById(ProductsController.products.get(j).getId()));
    //         }
    //     }
    //     return result;
    // }

    // public ArrayList<Product> productsOut(int id){
    //     boolean in = true;
    //     ArrayList<Product> result = new ArrayList<>();
    //     OrderProduct products = OrdersController.findOrderProductById(id);
    //     for (int j = 0; j < ProductsController.products.size(); j++) {
    //         for (int i = 0; i < products.getProductCantidad().size(); i++) {
    //             if(products.getProductCantidad().get(i).getIdproduct() != ProductsController.products.get(j).getId()){
    //                 in = false;
    //             }else{
    //                 in = true;
    //                 break;
    //             }
    //         }
    //         if (!in) {
    //             result.add(ProductsController.findProdById(ProductsController.products.get(j).getId()));
    //         }
    //     }
    //     return result;
    // }

    // @GetMapping("productsIn/{id}")
    // public ModelAndView postProductsInOrder(@PathVariable("id") int id, @RequestParam(name = "idProd", required = true, defaultValue = "0") int idProd, 
    //                                         @RequestParam(name = "cantidad", required = true, defaultValue = "0") int cantidad) {
    //     OrdersController.findOrderProductById(id).getProductCantidad().add(new ProductQuantity(idProd, cantidad));
    //     ModelAndView mv = new ModelAndView("index");
    //     mv.addObject("productsIn", productsIn(id));
    //     mv.addObject("productsOut", productsOut(id));
    //     return mv;
    // }

    // @GetMapping("productsOut/{id}")
    // public ModelAndView postProductsOutOrder(@PathVariable("id") int id, @RequestParam(name = "idProd", required = true, defaultValue = "0") int idProd) {
    //     OrdersController.findOrderProductById(id).getProductCantidad().remove(findProdCantByProdId(id, idProd));
    //     ModelAndView mv = new ModelAndView("index");
    //     mv.addObject("productsIn", productsIn(id));
    //     mv.addObject("productsOut", productsOut(id));
    //     return mv;
    // }

    // public ProductQuantity findProdCantByProdId(int idOrder ,int idProd){
    //     ArrayList<ProductQuantity> list = OrdersController.findOrderProductById(idOrder).getProductCantidad();
    //     ProductQuantity result = null;
    //     for (int i = 0; i < list.size(); i++) {
    //         if (list.get(i).getIdproduct() == idProd) {
    //             result = list.get(i);
    //         }
    //     }
    //     if (result == null) {
    //         throw new ElementNotFoundException();
    //     }
    //     return result;
    // }
}
