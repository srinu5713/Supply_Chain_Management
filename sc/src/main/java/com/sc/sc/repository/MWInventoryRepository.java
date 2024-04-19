package com.sc.sc.repository;

import com.sc.sc.model.MWInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MWInventoryRepository extends JpaRepository<MWInventory, Long> {
    // Add custom query methods if needed
}