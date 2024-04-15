package com.sc.sc.repositories;
import com.sc.sc.model.DeliveryStation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverStationRepository extends JpaRepository<DeliveryStation, Long> {

}
