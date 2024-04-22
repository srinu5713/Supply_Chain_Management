package com.sc.sc.controller;

import com.sc.sc.model.ReqProduction;
import com.sc.sc.model.Status;
import com.sc.sc.repository.OrdersRepository;
import com.sc.sc.repository.ReqProductionRepository;
import com.sc.sc.repository.logRepository;

import com.sc.sc.model.Orders;
import com.sc.sc.model.logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDateTime;


import java.util.List;

@Controller
public class MWInventoryController {

    @Autowired
    private ReqProductionRepository reqproductionrepository;

    @Autowired
    private logRepository logRepository;

    @Autowired
    private OrdersRepository ordersrepository;

    @Autowired
    private InventoryManagementFacade inventoryManagementFacade;

    @GetMapping("/mw_production_items")
    public String getMWProductionItems(Model model) {
        // Fetch MWInventory items from the database
        List<ReqProduction> mwProductionItems = reqproductionrepository.findAll();
        // Pass the fetched items to the Thymeleaf template for rendering
        model.addAttribute("ReqProdItems", mwProductionItems);
        return "mw_production_items"; // Return the name of the Thymeleaf template
    }

    @GetMapping("/mw_orders")
    public String getAllOrders(Model model) {
        // Fetch all orders from the database
        List<Orders> orders = ordersrepository.findAll();
        // Pass the fetched orders to the Thymeleaf template for rendering
        model.addAttribute("orders", orders);
        return "mw_orders";

    }


    @GetMapping("/processorders")
    public String processOrders(Model model) {
        // Fetch all orders from the uploaded csv file
        // Then after clicking on submit then it inserts into the table orders
        return "processorders";
    }


    @PostMapping("/updatestatus_a")
    public String updateStatusMW(@RequestParam("orderId") Long orderId, @RequestParam("status") String status) {
        // Find the order by its ID
        Orders orderedItem = ordersrepository.findById(orderId).orElse(null);
    
        // If the order exists, update its status
        if (orderedItem != null) {
            if(status.equals("ACCEPTED")){
                orderedItem.setStatus(Status.ACCEPTED);
            }
            else if(status.equals("SHIPPED")){
                orderedItem.setStatus(Status.SHIPPED);
            }
            ordersrepository.save(orderedItem);
            logs logEntry = new logs();
            logEntry.setOrderId(orderId);
            logEntry.setStatus(orderedItem.getStatus());
            logEntry.setTimestamp(LocalDateTime.now());
            logRepository.save(logEntry);
    
        }
      
    
        // Redirect back to the page after updating
        return "redirect:/mw_orders";

    }


    @GetMapping("/Inventory_facade")
    public String showInventoryDashboard(Model model) {
        model.addAttribute("inventoryManagementFacade", inventoryManagementFacade);
        return "Inventory_facade";
    }
}