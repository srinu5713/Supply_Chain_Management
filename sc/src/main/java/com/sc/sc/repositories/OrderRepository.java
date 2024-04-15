package com.sc.sc.repositories;

import com.sc.sc.model.Order;

// import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
        
}


 
