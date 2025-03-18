package com.InspiraDev.demo.services;

import com.InspiraDev.demo.repositories.IDevotionalRepository;
import org.springframework.stereotype.Service;

@Service
public class devotionalService {

    private IDevotionalRepository devotionalRepository;

    public devotionalService(IDevotionalRepository devotionalRepository) {
        this.devotionalRepository = devotionalRepository;
    }


}
