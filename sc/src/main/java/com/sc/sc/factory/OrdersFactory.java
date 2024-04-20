// OrdersFactory.java
package com.sc.sc.factory;

import com.sc.sc.model.Orders;
import com.sc.sc.model.Product;
import com.sc.sc.model.Status;
import com.sc.sc.model.User;

import java.time.LocalDate;

public class OrdersFactory {
    public static Orders createOrder(Product product, User user, Status status, LocalDate expectedDeliveryDate) {
        return new Orders(product, user, status, expectedDeliveryDate);
    }
}
