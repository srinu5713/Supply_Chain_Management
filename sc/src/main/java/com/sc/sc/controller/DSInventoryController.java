package com.sc.sc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/senttoQA")
    public String redirecttoQA(Model model) {
        return "senttoQA";
    }
    @PostMapping("/sendtoMW")
    public String redirecttoMW(Model model) {
        return "sendtoMW";
    }

    @PostMapping("/updatestatus")
    public String updateStatusU(@RequestParam("orderId") Long orderId, @RequestParam("status") String status) {
        // Find the production item by its ID
        Orders orderedItem = ordersRepository.findById(orderId).orElse(null);
        if (orderedItem != null) {
            if(status.equals("IN_DELIVERY_STATION")){
                orderedItem.setStatus(Status.IN_DELIVERY_STATION);
            }
            else if(status.equals("OUT_FOR_DELIVERY")){
                orderedItem.setStatus(Status.OUT_FOR_DELIVERY);
            }
            else{
                orderedItem.setStatus(Status.DELIVERED);
            }
            ordersRepository.save(orderedItem);
        }
        return "redirect:/ds_admin";
    }
}

