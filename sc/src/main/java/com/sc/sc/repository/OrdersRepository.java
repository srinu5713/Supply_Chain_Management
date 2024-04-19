package com.sc.sc.repository;
import com.sc.sc.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // Add custom query methods if needed
}
