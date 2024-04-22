// OrderStatusHandler for handling order status updates
package com.sc.sc.handler;

import com.sc.sc.model.Orders;
import com.sc.sc.model.Status;

public abstract class OrderStatusHandler {
    protected OrderStatusHandler successor;

    public void setSuccessor(OrderStatusHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Orders order, Status status);
}

// Specific handlers for different statuses
class ShippedStatusHandler extends OrderStatusHandler {
    @Override
    public void handleRequest(Orders order, Status status) {
        if (status == Status.SHIPPED) {
            // handle shipping logic
            order.setStatus(Status.SHIPPED);
        } else if (successor != null) {
            successor.handleRequest(order, status);
        }
    }
}

class DeliveredStatusHandler extends OrderStatusHandler {
    @Override
    public void handleRequest(Orders order, Status status) {
        if (status == Status.DELIVERED) {
            // handle delivery logic
            order.setStatus(Status.DELIVERED);
        } else if (successor != null) {
            successor.handleRequest(order, status);
        }
    }
}