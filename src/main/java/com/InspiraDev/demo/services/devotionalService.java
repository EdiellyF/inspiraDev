package com.InspiraDev.demo.services;

import com.InspiraDev.demo.repositories.devotionalRepository;
import org.springframework.stereotype.Service;

@Service
public class devotionalService {

    private devotionalRepository devotionalRepository;

    public devotionalService(devotionalRepository devotionalRepository) {
        this.devotionalRepository = devotionalRepository;
    }


}
