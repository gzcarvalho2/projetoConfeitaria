package com.Senac.Prova.service;

import com.Senac.Prova.entity.Role;
import com.Senac.Prova.entity.RoleName;
import com.Senac.Prova.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role getRoleByName(RoleName roleName){
       return roleRepository.findByName(roleName).orElse(null);
    }
}
