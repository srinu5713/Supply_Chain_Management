package com.sc.sc.repository;
import com.sc.sc.model.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<products, Long>{

}
