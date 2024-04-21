package com.sc.sc.controller;

import com.sc.sc.model.ReqProduction;
import com.sc.sc.model.ProductionStatus;
import com.sc.sc.repository.ReqProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;



@Controller
public class ReqProductionController {

    @Autowired
    private ReqProductionRepository reqProductionRepository;

    @PostMapping("/updatestatus_p")
    public String updateStatusp(@RequestParam("reqId") Long reqId, @RequestParam("status") String status) {
        // Find the production item by its ID
        ReqProduction productionItem = reqProductionRepository.findById(reqId).orElse(null);

        // If the production item exists, update its status
        if (productionItem != null) {
            if(status.equals("DISPATCHED")){
                productionItem.setStatus(ProductionStatus.DISPATCHED);
            }
            else if(status.equals("DELIVERED")){
                productionItem.setStatus(ProductionStatus.DELIVERED);
            }
            reqProductionRepository.save(productionItem);
        }

        // Redirect back to the production page after updating
        return "redirect:/production_req";
    }

    @GetMapping("/production_req")
    public String getOrders(Model model) {
        // Retrieve all production items
        List<ReqProduction> prodItems = reqProductionRepository.findAll();
        
        // Add the list of production items to the model
        model.addAttribute("ProdItems", prodItems);

        // Return the Thymeleaf template name
        return "production_req";
    }
}
