package com.hparser.hparser.repositories;

import com.hparser.hparser.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
