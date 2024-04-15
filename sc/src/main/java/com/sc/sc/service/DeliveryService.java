package com.sc.sc.service;

import com.sc.sc.model.DeliveryStation;
import com.sc.sc.repositories.DeliverStationRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;

@Service
public class DeliveryService {
    private final DeliverStationRepository deliveryRepository;
 
    public DeliveryService(DeliverStationRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryStation saveDeliveryStation(DeliveryStation deliveryStation) {
        return deliveryRepository.save(deliveryStation);
    }

    public List<DeliveryStation> getAllDeliveryStations() {
        return deliveryRepository.findAll();
    }


}