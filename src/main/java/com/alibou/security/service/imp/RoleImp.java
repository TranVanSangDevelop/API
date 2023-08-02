package com.alibou.security.service.imp;

import com.alibou.security.model.Role;
import com.alibou.security.model.RoleEnum;
import com.alibou.security.repository.RoleRepository;
import com.alibou.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleImp implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByName(RoleEnum Name) {
        Role role = roleRepository.findByName(Name);
        return role;
    }
}
