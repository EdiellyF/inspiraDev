package com.InspiraDev.demo.repositories;

import com.InspiraDev.demo.models.profiles.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
