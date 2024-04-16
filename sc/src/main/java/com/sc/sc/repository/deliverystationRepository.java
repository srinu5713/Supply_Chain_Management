package com.sc.sc.repository;
import com.sc.sc.model.deliverystation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface deliverystationRepository extends JpaRepository<deliverystation, Long>{

}
