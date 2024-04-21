package com.sc.sc.controller;

import com.sc.sc.model.DSInventory;
import com.sc.sc.repository.DSInventoryRepository;
import com.sc.sc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sc.sc.model.Orders;

import java.util.List;



import com.sc.sc.model.Status;
import com.sc.sc.repository.OrdersRepository;


@Controller
public class DSInventoryController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/ds_admin")
    public String getDSDashboard(Model model) {
        // Fetch all orders from the database whose status is shipped
        List<Orders> shippedOrders = ordersRepository.findByStatus(Status.SHIPPED);
        
        // Pass the fetched orders to the Thymeleaf template for rendering
        model.addAttribute("orders", shippedOrders);
        
        return "ds_admin";
    }

    @GetMapping("/cancelled_items")
    public String getAllCancelledItems(Model model) {
        // Fetch all orders from the database whose status is cancelled
        List<Orders> cancelledOrders = ordersRepository.findByStatus(Status.CANCELLED);
        
        // Pass the fetched cancelled orders to the Thymeleaf template for rendering
        model.addAttribute("orders", cancelledOrders);
        
        return "cancelled_items";
    }

    @GetMapping("/returned_items")
    public String getAllReturnedItems(Model model) {
        // Fetch all orders from the database whose status is returned
        List<Orders> returnedOrders = ordersRepository.findByStatus(Status.RETURNED);
        
        // Pass the fetched returned orders to the Thymeleaf template for rendering
        model.addAttribute("orders", returnedOrders);
        
        return "returned_items";
    }

    @GetMapping("/senttoQA")
    public String redirecttoQA(Model model) {
        return "senttoQA";
    }
    @GetMapping("/senttoMW")
    public String redirecttoMW(Model model) {
        return "senttoMW";
    }
}

