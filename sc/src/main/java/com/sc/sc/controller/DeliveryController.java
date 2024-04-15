package com.sc.sc.controller;

import com.sc.sc.model.DeliveryStation;
import com.sc.sc.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class DeliveryController {
    private final DeliveryService deliveryService;

	// @Autowired
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

    @GetMapping("/deliveryStation")
	public List<DeliveryStation> getAllDeliveryStations() {
		return deliveryService.getAllDeliveryStations();
	}

}
