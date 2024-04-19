package com.sc.sc.repository;

import com.sc.sc.model.ReqProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReqProductionRepository extends JpaRepository<ReqProduction, Long> {
    // Add custom query methods if needed
}