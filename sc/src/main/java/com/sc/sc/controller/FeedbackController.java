// FeedbackController to handle user feedback submission
package com.sc.sc.controller;

import com.sc.sc.model.Status;
import com.sc.sc.model.Orders;

import com.sc.sc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {
    @Autowired
    private OrdersRepository ordersRepository;
    
        @PostMapping("/submitFeedback")
        public String submitFeedback(
                @RequestParam Long orderId,
                @RequestParam String feedback,
                @RequestParam String satisfaction
        ) {
            // Check if the order status is DELIVERED
            Orders order = ordersRepository.findById(orderId).orElse(null);
            if (order != null && order.getStatus() == Status.DELIVERED) {
                // Update order feedback based on user input
                order.setFeedback(feedback);
                order.setSatisfaction(satisfaction);
                ordersRepository.save(order);
                return "redirect:/details?id=" + orderId; // Redirect to order details page
            } else {
                return "errorPage"; // Show error page if order status is not DELIVERED
            }
        }
    }
    

