package com.reto2.eccomerce.Web.API;

import java.util.List;

import com.reto2.eccomerce.Services.Models.OrderDTO;
import com.reto2.eccomerce.Services.Models.OrderProductDTO;
import com.reto2.eccomerce.Services.Models.OrderService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return orderService.add(order, orderProducts);
    }


    // @GetMapping
    // public ArrayList<Order> getOrders() {
    //     return orders;
    // }

    // @GetMapping("/{id}")
    // public OrderOrder getOrderOrdersById(@PathVariable("id") int id) {
    //     OrderOrder result = findOrderOrderById(id);
    //     return result;
    // }

    // @PostMapping
    // public int postOrder(@RequestBody OrderOrder orders,
    //                 @RequestParam(name="username", required = true, defaultValue = "") String username){
    //     Order order = new Order(username, 1);
    //     int orderId = order.getId();
    //     orders.add(order);
    //     orders.setIdorder(orderId);
    //     orderOrders.add(orders);
    //     return orderId;
    // }

    // @PutMapping("/{id}")
    // public OrderOrder putOrder(@PathVariable("id") int id, @RequestBody EditDeleteOrders orders){
    //     OrderOrder original = findOrderOrderById(id);
    //     OrderOrder editOrders = orders.getEdit();
    //     OrderOrder deleteOrders = orders.getDelete();
    //     ArrayList<OrderQuantity> ordersOriginal = original.getOrderCantidad();
    //     ArrayList<OrderQuantity> ordersEdit = editOrders.getOrderCantidad();
    //     ArrayList<OrderQuantity> ordersDelete = deleteOrders.getOrderCantidad();
    //     ArrayList<Integer> eliminados = new ArrayList<>();
    //     if(ordersDelete.isEmpty() && ordersEdit.isEmpty()) return null;
    //     for (int i = 0; i < ordersOriginal.size(); i++) {
    //         if(!ordersDelete.isEmpty()){
    //             for (int j = 0; j < ordersDelete.size(); j++) {
    //                 if(ordersOriginal.get(i).getIdorder() == ordersDelete.get(j).getIdorder()){
    //                     eliminados.add(i);
    //                 }
    //             }
    //         }
    //         if (!ordersEdit.isEmpty()) {
    //             for (int j = 0; j < ordersEdit.size(); j++) {
    //                 if(ordersOriginal.get(i).getIdorder() == ordersEdit.get(j).getIdorder()){
    //                     ordersOriginal.get(i).setCantidad(ordersEdit.get(j).getCantidad());
    //                 }
    //             }
    //         }
    //     }
    //     if(!eliminados.isEmpty()){
    //         for (int i = eliminados.size() - 1; i >= 0; i--) {
    //             ordersOriginal.remove(eliminados.get(i).intValue());
    //         }
    //     }
    //     orderOrders.get(original.getId()).setOrderCantidad(ordersOriginal);
    //     return orderOrders.get(original.getId());
    // }

    // @DeleteMapping("/{id}")
    // public int deleteOrder(@PathVariable int id){
    //     NotFoundControl(id);
    //     Order order = findById(id);
    //     orders.remove(order);
    //     for (int i = 0; i < orderOrders.size(); i++) {
    //         if(orderOrders.get(i).getIdorder() == id) orderOrders.remove(i);
    //     }
    //     return 1;
    // }

    // public static Order findById(int id){
    //     for (int i = 0; i < orders.size(); i++) {
    //         if(orders.get(i).getId() == id) return orders.get(i);
    //     }
    //     throw new ElementNotFoundException();
    // }

    // public static OrderOrder findOrderOrderById(int id){
    //     for (int i = 0; i < orderOrders.size(); i++) {
    //         if(orders.get(i).getId() == id) return orderOrders.get(i);
    //     }
    //     throw new ElementNotFoundException();
    // }

    // public void NotFoundControl(int id){
    //     if(findById(id) == null){
    //         throw new ElementNotFoundException();
    //     }
    // }

    // public void NotFoundControlOrderOrder(int id){
    //     if(findOrderOrderById(id) == null){
    //         throw new ImATeapotException();
    //     }
    // }
}