package com.sc.sc.controller;

import com.sc.sc.model.User;

import com.sc.sc.model.Order;
import com.sc.sc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session; // Autowire HttpSession for session management

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/details")
    public String detailspage() {
        return "details";
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        // Retrieve email from session
        String userEmail = (String) session.getAttribute("userEmail");

        // Fetch user details based on email
        // login user = userRepository.findByEmail(userEmail);

        // Fetch orders associated with the user (assuming you have a method in
        // UserRepository to do this)
        // List<Order> userOrders = userRepository.findOrdersByUserId(user.getuser_Id());

        // model.addAttribute("user", user);
        model.addAttribute("orders", userOrders);
        return "user";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        // Perform authentication logic
        // login user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            // Store email in session
            session.setAttribute("userEmail", email);
            // Redirect to user dashboard
            return "redirect:/user";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

}
