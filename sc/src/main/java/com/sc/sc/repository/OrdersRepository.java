package com.sc.sc.repository;
import com.sc.sc.model.Orders;
import com.sc.sc.model.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // Add custom query methods if needed
    List<Orders> findByUser(User user);
}
