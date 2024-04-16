package com.sc.sc.repository;
import com.sc.sc.model.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepository extends JpaRepository<login, Long>{

}
