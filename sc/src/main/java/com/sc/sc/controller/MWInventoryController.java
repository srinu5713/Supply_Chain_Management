package com.sc.sc.controller;

import com.sc.sc.model.MWInventory;
import com.sc.sc.repository.MWInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MWInventoryController {

    @Autowired
    private MWInventoryRepository mwInventoryRepository;

    @GetMapping("/mw_production_items")
    public String getMWProductionItems(Model model) {
        List<MWInventory> mwProductionItems = mwInventoryRepository.findAll(); // Example query, you may need to modify it
        model.addAttribute("mwProductionItems", mwProductionItems);
        return "mw_production_items";
    }

//     @GetMapping("/mw_home")
//     public String showMWHome(Model model) {
//         // Fetch all items from MWInventory
//         List<MWInventory> inventoryItems = mwInventoryRepository.findAll();
//         model.addAttribute("inventoryItems", inventoryItems);
//         return "mw_home";
//     }
}
