package com.travel.travel.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Repository.BusSerRepository;
import com.travel.travel.Domain.BusSerType;

import java.util.List;

@Service
public class BusSerService {
    @Autowired
    private BusSerRepository serviceRepository;

    public BusSerType createService(BusSerType service) {
        return serviceRepository.save(service);
    }

    public List<BusSerType> getAllServices() {
        return serviceRepository.findAll();
    }

    public com.travel.travel.Domain.BusSerType getServiceById(Long serviceID) {
        return serviceRepository.findById(serviceID).orElse(null);}

    public void deleteService(Long serviceID) {
        serviceRepository.deleteById(serviceID);
    }

    public BusSerType updateService(Long id, BusSerType service) {
        return null;
    }
}
