package com.almaz.rassrochka.security.service.impl;

import com.almaz.rassrochka.security.domain.Role;
import com.almaz.rassrochka.security.domain.repo.RoleRepo;
import com.almaz.rassrochka.security.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}

