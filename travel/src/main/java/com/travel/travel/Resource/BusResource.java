package com.travel.travel.Resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travel.Domain.Bus;
import com.travel.travel.Repository.BusRepository;
import com.travel.travel.Service.BusSerService;
import com.travel.travel.Service.BusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/services/{serviceID}/buses")
public class BusResource {

    @Autowired
    private BusService busService;

    @Autowired
    private BusRepository busRepo;

    @Autowired
    private BusSerService busSerSer;

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus busRequest,
            @PathVariable(value = "serviceID") Long serviceID) {
        return new ResponseEntity<>(busRequest, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getBusesByServiceID(@PathVariable(value = "serviceID") Long serviceID) {
        if (busSerSer.getServiceById(serviceID) == null) {
            throw new ResourceNotFoundException("No buses found in this service");
        } else {
            List<Bus> buses = busService.getAllBuss();
            return new ResponseEntity<>(buses, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Bus _bus = busService.getBusById(id);
        if (_bus == null) {
            throw new ResourceNotFoundException("Bus not found");
        } else {
            return new ResponseEntity<>(_bus, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable(value = "id") Long id, @RequestBody Bus bus) {
        return busRepo.findById(id).map((Bus bust) -> {
            bust.setBusColour(bus.getBusColour());
            bust.setBusMark(bus.getBusMark());
            bust.setNumberOfPlaces(bus.getNumberPlaces());
            bust.setBusID(bus.getServiceID());
            return busService.createBus(bust);
        }).orElseThrow(() -> new ResourceNotFoundException("absent"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBusByID(@PathVariable(value = "id") Long id) {

        busService.deleteBus(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity<List<Bus>> deleteAllBusesInService(@PathVariable(value = "serviceID") Long serviceID) {
        if (busSerSer.getServiceById(serviceID) == null) {
            throw new ResourceNotFoundException("service not found");
        } else {
            busService.deleteBus(serviceID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
