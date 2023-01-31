package com.almaz.bulbal.security.service;

import com.almaz.bulbal.security.domain.Role;

public interface RoleService {
    Role findByName(String name);
}

