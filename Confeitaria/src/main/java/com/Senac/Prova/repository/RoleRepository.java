package com.Senac.Prova.repository;

import com.Senac.Prova.entity.Role;
import com.Senac.Prova.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleName roleName);
}
