package com.sc.sc.service;

import com.sc.sc.model.Order;
import com.sc.sc.repositories.OrderRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
// import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
 
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
