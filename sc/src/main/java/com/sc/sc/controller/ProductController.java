package com.sc.sc.controller;

import com.sc.sc.model.Product;
import com.sc.sc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    // @Autowired
    // private ProductRepository productRepository;

    // // @GetMapping("/details")
    // // public String getProductDetails(Model model) {
    // //     List<Product> products = productRepository.findAll(); // Example query, you may need to modify it
    // //     model.addAttribute("products", products);
    // //     return "details";
    // // }
}
