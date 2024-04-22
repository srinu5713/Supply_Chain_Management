// InventoryManagementFacade simplifies interactions with different inventory subsystems
package com.sc.sc.controller;

import com.sc.sc.model.*;
import com.sc.sc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InventoryManagementFacade {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private MWInventoryRepository mwInventoryRepository;



    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public List<MWInventory> getAllMWInventory() {
        return mwInventoryRepository.findAll();
    }

    public void updateOrderStatus(Long orderId, Status status) {
        Orders order = ordersRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            ordersRepository.save(order);
        }
    }

}