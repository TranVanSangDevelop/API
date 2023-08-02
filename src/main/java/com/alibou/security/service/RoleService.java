package com.alibou.security.service;

import com.alibou.security.model.Role;
import com.alibou.security.model.RoleEnum;

public interface RoleService {
     Role getRoleByName(RoleEnum Name);
}
