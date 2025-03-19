package com.InspiraDev.demo.config;


import com.InspiraDev.demo.models.enums.ValuesRole;
import com.InspiraDev.demo.models.profiles.Role;
import com.InspiraDev.demo.repositories.IRoleRepository;
import com.InspiraDev.demo.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AdminUserConfig  implements CommandLineRunner {

    private IRoleRepository roleRepository;

    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(IRoleRepository roleRepository,
                           UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = roleRepository.findByName(ValuesRole.ADMIN.getValue().toString());

    }
}
