package com.almaz.rassrochka.security.service;

import com.almaz.rassrochka.security.domain.Role;

public interface RoleService {
    Role findByName(String name);
}

