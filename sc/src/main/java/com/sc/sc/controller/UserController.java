package com.sc.sc.controller;

import com.sc.sc.model.User;
import com.sc.sc.repository.UserRepository;
import com.sc.sc.repository.OrdersRepository;
import com.sc.sc.repository.MWInventoryRepository;
import com.sc.sc.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private MWInventoryRepository mwInventoryRepository;

    @RequestMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("errorMessage", null); // Initialize errorMessage as null
        return "login";
    }

    @PostMapping("/")
    public String login(User user, Model model, HttpSession session) {
        User authenticatedUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            session.setAttribute("user_id", authenticatedUser.getUserId()); // Store user_id in session
            switch (authenticatedUser.getType()) {
                case CUSTOMER:
                    return "redirect:/user";
                case ADMIN:
                    return "redirect:/mw_admin";
                case DELIVERY_STATION:
                    return "redirect:/ds_admin";
                case PRODUCTION:
                    return "redirect:/production_req";
                default:
                    return "redirect:/"; // Default redirect to login page
            }
        } else {
            model.addAttribute("errorMessage", "Invalid username or password."); // Set error message
            return "login"; // Redirect to login page with error message
        }
    }

    // User Redirections

    @GetMapping("/user")
    public String showUserDashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            // Fetch user-specific data from the database
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // Fetch orders for the user
                List<Orders> orders = ordersRepository.findByUser(user);
                model.addAttribute("username", user.getUsername());
                model.addAttribute("orders", orders);
                return "user";
            }
        }
        // Redirect to login if session does not contain valid user_id
        return "redirect:/";
    }

    @GetMapping("/details")
    public String showOrderDetails(@RequestParam Long id, Model model) {
        Orders order = ordersRepository.findById(id).orElse(null);
        if (order != null) {
            model.addAttribute("order", order);
            return "details";
        } else {
            // Handle case where order with given ID is not found
            return "redirect:/user"; // Redirect back to user dashboard
        }
    }

    @GetMapping("/mw_admin")
    public String showAdminDashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId != null) {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                List<MWInventory> inventoryItems = mwInventoryRepository.findAll();
                model.addAttribute("inventoryItems", inventoryItems);
                return "mw_admin"; // Assuming you have a view named "mw_admin"
            }
        }
        return "redirect:/"; // Redirect to login if session does not contain valid user_id
    }
    @PostMapping("/updateStatus_U")
    public String updateStatusU(@RequestParam("orderId") Long orderId, @RequestParam("status") String status) {
        // Find the production item by its ID
        Orders orderedItem = ordersRepository.findById(orderId).orElse(null);

        // If the production item exists, update its status
        if (orderedItem != null) {
            // System.out.println("Hello!");
            // System.out.println(status);
            if(status.equals("DELIVERED") || status.equals("RETURNED")){
                orderedItem.setStatus(Status.RETURNED);
            }
            else if(status.equals("SHIPPED")|| status.equals("ACCEPTED") || status.equals("IN_DELIVERY_STATION") || status.equals("CANCELLED")){
                // System.out.println("Entered block!");
                orderedItem.setStatus(Status.CANCELLED);
            }
            ordersRepository.save(orderedItem);
            System.out.println(orderedItem.getStatus());
        }
        // Redirect back to the production page after updating
        return "redirect:/user";
    }

}
