package com.sc.sc.repository;

import com.sc.sc.model.logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface logRepository extends JpaRepository<logs, Long> {
    // You can add custom query methods here if needed
    List<logs> findByOrderId(Long orderId);
}