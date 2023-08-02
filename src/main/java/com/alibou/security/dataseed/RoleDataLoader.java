package com.alibou.security.dataseed;

import com.alibou.security.model.Role;
import com.alibou.security.model.RoleEnum;
import com.alibou.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class RoleDataLoader implements CommandLineRunner {
    /**
     * logger for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDataLoader.class);
    /**
     * inject role repository
     */
    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        try {
            Role admin = new Role(RoleEnum.ADMIN);
            Role user = new Role(RoleEnum.USER);
            roleRepository.save(admin);
            roleRepository.save(user);
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("roles existed!");
            }
        }
    }
}