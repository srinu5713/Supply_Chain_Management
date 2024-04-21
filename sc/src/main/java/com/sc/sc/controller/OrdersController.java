package com.sc.sc.controller;

import com.sc.sc.model.Orders;
// import com.sc.sc.service.OrderService;
import com.sc.sc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import java.io.IOException;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    // @Autowired
    // private OrderService orderService;

    @GetMapping("/order")
    public String getOrders(Model model) {
        List<Orders> orders = ordersRepository.findAll(); // Example query, you may need to modify it
        model.addAttribute("orders", orders);
        return "order";
    }

   

    // @PostMapping("/upload")
    // public String uploadFile(@RequestParam("csvFile") MultipartFile file, RedirectAttributes redirectAttributes) {
    //     try {
    //         orderService.processOrdersFromCSV(file);
    //         redirectAttributes.addFlashAttribute("successMessage", "File uploaded successfully!");
    //     } catch (IOException e) {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Error uploading file: " + e.getMessage());
    //     }
    //     return "redirect:/";
    // }
}
