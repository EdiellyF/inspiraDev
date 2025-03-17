package com.InspiraDev.demo.repositories;

import com.InspiraDev.demo.models.devotional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface devotionalRepository  extends JpaRepository<devotional, Long> {
}
