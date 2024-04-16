package com.sc.sc.repository;
import com.sc.sc.model.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<orders, Long>{

}
