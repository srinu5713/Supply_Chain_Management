package com.sc.sc.controller;

import com.sc.sc.model.Order;
import com.sc.sc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Create a new order.
     *
     * @param order the order to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new order
     */
    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order newOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    /**
     * Get all orders.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of orders
     */
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // You can uncomment and implement other endpoints like updating or deleting orders if needed

}
