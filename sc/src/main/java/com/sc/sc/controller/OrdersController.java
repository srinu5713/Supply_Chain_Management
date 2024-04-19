package com.sc.sc.controller;

import com.sc.sc.model.Orders;
import com.sc.sc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/order")
    public String getOrders(Model model) {
        List<Orders> orders = ordersRepository.findAll(); // Example query, you may need to modify it
        model.addAttribute("orders", orders);
        return "order";
    }
}
