package com.sc.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.sc.sc.model.User;
import com.sc.sc.model.login;
import com.sc.sc.model.Order; // Import the Order entity class
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<login, Integer> {
    login findByEmailAndPassword(String email, String password);
    login findByEmail(String email);
    List<Order> findOrdersByUserId(int userId); // Corrected return type to List<Order>
    List<Order> findOrdersByUserEmail(String userEmail); // Corrected return type to List<Order>
}
