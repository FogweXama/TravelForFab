package com.travel.travel.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.BusSerType;
import com.travel.travel.Service.BusSerService;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/services")
public class BusSerTypeResource {
    
    @Autowired
    private BusSerService serviceService;
    

    @PostMapping
    public ResponseEntity<BusSerType> createService(@RequestBody BusSerType service) {
        BusSerType _service= serviceService.createService(new BusSerType(service.getServiceID(), service.getServiceName(), service.getServiceDescription()));

        return new ResponseEntity<>(_service, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusSerType>> getAllServices(@RequestParam(required = false) String serviceName) {
        List<BusSerType> services= new java.util.ArrayList<BusSerType>();

        if(serviceName==null){
            serviceService.getAllServices().forEach(services::add);
        }
        else{
            serviceService.getServiceByServiceName(serviceName).forEach(services::add);
        }
        if(services.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusSerType> getServiceById(@PathVariable(value = "id") Long id) {
        BusSerType service=serviceService.getServiceById(id);
        if(service==null){
            throw new ResourceNotFoundException("Service not found");
        }
        else{
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusSerType> updateService(@PathVariable Long id, @RequestBody BusSerType service) {
        BusSerType _busSert=serviceService.getServiceById(id);
        if(_busSert.getBusById(id).getNumberOfSeats()==0){
            throw new ResourceNotFoundException("Service not found");
        }
        else{
            _busSert.setServiceDescription(service.getServiceDescription());
            _busSert.setServiceName(service.getServiceName());

            return new ResponseEntity<>(serviceService.createService(_busSert), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
