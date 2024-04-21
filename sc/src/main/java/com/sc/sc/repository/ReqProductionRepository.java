package com.sc.sc.repository;

import com.sc.sc.model.ReqProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReqProductionRepository extends JpaRepository<ReqProduction, Long> {
    Optional<ReqProduction> findByReqId(Long reqId);
}