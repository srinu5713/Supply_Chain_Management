
// OrderAccessProxy to control access to order operations
package com.sc.sc.controller;

import com.sc.sc.model.Orders;
import com.sc.sc.model.Status;
import com.sc.sc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAccessProxy {
    @Autowired
    private OrdersRepository ordersRepository;

    public void updateOrderStatus(Long orderId, Status status, String userRole) {
        if ("ADMIN".equals(userRole)) {
            Orders order = ordersRepository.findById(orderId).orElse(null);
            if (order != null) {
                order.setStatus(status);
                ordersRepository.save(order);
            }
        } else {
            throw new SecurityException("Unauthorized access");
        }
    }
}