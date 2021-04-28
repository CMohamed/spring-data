package com.example.speedco.DAO.repositories;

import com.example.speedco.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaSpecificationExecutor<User> {
}
