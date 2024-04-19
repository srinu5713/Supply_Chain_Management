// package com.sc.sc.controller;

// import com.sc.sc.model.ReqProduction;
// import com.sc.sc.repository.ReqProductionRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// import java.util.List;

// @Controller
// public class ReqProductionController {

//     @Autowired
//     private ReqProductionRepository reqProductionRepository;

//     @GetMapping("/production_req")
//     public String getProductionRequests(Model model) {
//         List<ReqProduction> productionRequests = reqProductionRepository.findAll(); // Example query, you may need to modify it
//         model.addAttribute("productionRequests", productionRequests);
//         return "production_req";
//     }
// }
