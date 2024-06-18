package com.travel.travel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Domain.Bus;
import com.travel.travel.Repository.BusRepository;


@Service
public class BusService {


    @Autowired
    private BusRepository busRepository;

    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    public List<Bus> getAllBuss() {
        return busRepository.findAll();
    }

    public Bus getBusById(Long busID) {
        return busRepository.findById(busID).orElse(null);
    }

    public Bus updateBus(Long busID, Bus bus) {
        bus.setBusID(busID);
        return busRepository.save(bus);
    }

    public void deleteBus(Long busID) {
        busRepository.deleteById(busID);
    }

}
