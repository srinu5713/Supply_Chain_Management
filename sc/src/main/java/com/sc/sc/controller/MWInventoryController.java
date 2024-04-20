package com.sc.sc.controller;

import com.sc.sc.model.ReqProduction;
import com.sc.sc.repository.OrdersRepository;
import com.sc.sc.repository.ReqProductionRepository;
import com.sc.sc.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MWInventoryController {

    @Autowired
    private ReqProductionRepository reqproductionrepository;

    @Autowired
    private OrdersRepository ordersrepository;

    @GetMapping("/mw_production_items")
    public String getMWProductionItems(Model model) {
        // Fetch MWInventory items from the database
        List<ReqProduction> mwProductionItems = reqproductionrepository.findAll();
        // Pass the fetched items to the Thymeleaf template for rendering
        model.addAttribute("ReqProdItems", mwProductionItems);
        return "mw_production_items"; // Return the name of the Thymeleaf template
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        // Fetch all orders from the database
        List<Orders> orders = ordersrepository.findAll();
        // Pass the fetched orders to the Thymeleaf template for rendering
        model.addAttribute("orders", orders);
        return "orders";

    }


    @GetMapping("/processorders")
    public String processOrders(Model model) {
        // Fetch all orders from the uploaded csv file
        // Then after clicking on submit then it inserts into the table orders
        return "";
    }
}