package com.InspiraDev.demo.repositories;

import com.InspiraDev.demo.models.Devotional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDevotionalRepository extends JpaRepository<Devotional, Long> {
}
