package com.sc.sc.controller;

import com.sc.sc.model.User;
import com.sc.sc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/user")
    public String showUserDashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
        // Use userId to fetch user-specific data from the database and pass it to the model
        return "user"; // Assuming "user.html" is the user dashboard template
    }

    // Similar methods for other dashboard endpoints
}
