package com.reto2.eccomerce.Web.API;

import java.util.List;

import com.reto2.eccomerce.Services.Models.OrderDTO;
import com.reto2.eccomerce.Services.Models.OrderProductDTO;
import com.reto2.eccomerce.Services.Models.OrderService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    OrdersController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping()
    public List<OrderDTO> getOrders() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public List<OrderProductDTO> getOrderById(@PathVariable(name = "id", required = true) Long id) {
        return orderService.findById(id);
    }

    @PostMapping("{name}")
    public Long postOrderWithProducts(@PathVariable(name = "name", required = true) String name, @RequestBody(required = true) List<OrderProductDTO> orderProducts) {
        OrderDTO order = new OrderDTO();
        order.setUsername(name);
        order.setEstado("En Curso");
        order.setFecha();
        return orderService.add(order, orderProducts);
    }

    @PutMapping("update/{id}")
    public void putOrder(@PathVariable(name = "id", required = true) Long id, @RequestBody(required = true) List<OrderProductDTO> orderProducts) {
        orderService.update(id, orderProducts);
    }

    @DeleteMapping("delete/{id}")
    public void deleteOrder(@PathVariable(name = "id", required = true) Long id) {
        orderService.delete(id);
    }
}