package com.sc.sc.repository;

import com.sc.sc.model.MWInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository
public interface MWInventoryRepository extends JpaRepository<MWInventory, Long> {
    // Add custom query methods if needed
    @NonNull
    List<MWInventory> findAll();
}