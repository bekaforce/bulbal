package com.almaz.bulbal.security.service.impl;

import com.almaz.bulbal.security.domain.Role;
import com.almaz.bulbal.security.domain.repo.RoleRepo;
import com.almaz.bulbal.security.service.RoleService;
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

