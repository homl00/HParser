package com.hparser.hparser.services;

import com.hparser.hparser.repositories.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.hparser.hparser.entities.Role;

@Component
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    public Role getUserRole() {
        return roleRepo.findByName("ROLE_USER").get();
    }
}
