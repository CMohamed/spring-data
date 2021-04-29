package com.example.speedco.DAO.repositories;

import com.example.speedco.entities.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findById(Long id);

    List<User> findAllByEmail(String email);

    List<User> findAllByName(String name);

    // here we combine to conditions
    List<User> findAllByNameAndEmail(String name, String email);

    List<User> findAllBy(Specification<User> specification);
}
