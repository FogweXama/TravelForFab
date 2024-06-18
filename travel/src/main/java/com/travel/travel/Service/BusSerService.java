package com.travel.travel.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Domain.BusSerType;
import com.travel.travel.Repository.BusRepository;
import com.travel.travel.Repository.BusSerRepository;

import jakarta.transaction.Transactional;

@Service
public class BusSerService {
    @Autowired
    private BusSerRepository serviceRepository;

    @Autowired
    private BusRepository busRepository;

    public BusSerService(BusSerRepository serviceRepository, BusRepository busRepository) {
        this.serviceRepository = serviceRepository;
        this.busRepository = busRepository;
    }
    public BusSerType createService(BusSerType service) {
        return serviceRepository.save(service);
    }
    public List<BusSerType> getAllServices() {
        return serviceRepository.findAll();
    }
    public com.travel.travel.Domain.BusSerType getServiceById(long serviceID) {
        return serviceRepository.findById(serviceID).orElse(null);
    }

    public void deleteService(Long serviceID) {
        serviceRepository.deleteById(serviceID);
    }

    public BusSerType updateService(long id, BusSerType service) {
        BusSerType _busSer=serviceRepository.findById(id).orElse(null);
        return serviceRepository
            .save(new BusSerType(_busSer.getServiceID(),service.getServiceName(), service.getServiceDescription()));
    }

    /*public List<BusSerType> getServiceByServiceName(String serviceName) {
        return serviceRepository.findByServiceName(serviceName);
    }*/
    @Transactional
    public Optional<BusSerType> addBusesToService(long serviceId, List<Long> busIds){
        return serviceRepository.findById(serviceId).map(service -> {
            service.setBuses(busRepository.findAllById(busIds));
                return serviceRepository.save(service);
        });
    }
    public Iterable<BusSerType> getServiceByServiceName(String serviceName) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getServiceByServiceName'");
    }

}
