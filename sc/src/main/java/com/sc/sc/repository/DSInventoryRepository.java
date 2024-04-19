package com.sc.sc.repository;
import com.sc.sc.model.DSInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DSInventoryRepository extends JpaRepository<DSInventory, Long> {
    // Add custom query methods if needed
}
