package com.example.speedco.DAO.repositories;

import com.example.speedco.entities.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findById(Long id);

    List<User> findAllByEmail(String email);

    List<User> findAllByName(String name);

    // here we combine to conditions
    List<User> findAllByNameAndEmail(String name, String email);

    @Query("SELECT u FROM User u WHERE LOWER(u.name) = LOWER(:name)")
    List<User> getUserByNameJPQL(String name);

    @Query(value = "SELECT * FROM user u where u.name= ?1", nativeQuery = true)
    List<User> getUserByNameSQL(String name);

    List<User> findAll(Specification<User> specification);
}
