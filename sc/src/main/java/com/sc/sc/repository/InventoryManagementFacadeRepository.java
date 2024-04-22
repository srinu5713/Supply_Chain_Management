package com.sc.sc.repository;



import com.sc.sc.model.Orders;
import com.sc.sc.model.MWInventory;
import com.sc.sc.repository.OrdersRepository;
import com.sc.sc.repository.MWInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InventoryManagementFacadeRepository  {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private MWInventoryRepository mwInventoryRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public List<MWInventory> getAllMWInventory() {
        return mwInventoryRepository.findAll();
    }
}

