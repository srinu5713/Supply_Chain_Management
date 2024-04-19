package com.sc.sc.controller;


import com.sc.sc.model.DSInventory;
import com.sc.sc.repository.DSInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DSInventoryController {

    @Autowired
    private DSInventoryRepository dsInventoryRepository;

    @GetMapping("/cancelled_item")
    public String getCancelledItems(Model model) {
        List<DSInventory> cancelledItems = dsInventoryRepository.findAll(); // Example query, you may need to modify it
        model.addAttribute("cancelledItems", cancelledItems);
        return "cancelled_item";
    }
}

