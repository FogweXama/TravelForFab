package com.travel.travel.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.BusSerType;
import com.travel.travel.Service.BusSerService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class BusSerTypeResource {
    @Autowired
    private BusSerService serviceService;

    @PostMapping
    public BusSerType createService(@RequestBody BusSerType service) {
        return serviceService.createService(service);
    }

    @GetMapping
    public List<BusSerType> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public BusSerType getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @PutMapping("/{id}")
    public BusSerType updateService(@PathVariable Long id, @RequestBody BusSerType service) {
        return serviceService.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}
