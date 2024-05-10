package com.travel.travel.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.CustomerJourney;
import com.travel.travel.Service.CustomerJourneyService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class CustomerJourneyResource {
    @Autowired
    private CustomerJourneyService ticketService;

    @PostMapping
    public CustomerJourney createCustomerJourney(@RequestBody CustomerJourney ticket) {
        return ticketService.createCustomerJourney(ticket);
    }

    @GetMapping
    public List<CustomerJourney> getAllCustomerJourneys() {
        return ticketService.getAllCustomerJourneys();
    }

    @GetMapping("/{id}")
    public CustomerJourney getCustomerJourneyById(@PathVariable Long id) {
        return ticketService.getCustomerJourneyById(id);
    }

    @PutMapping("/{id}")
    public CustomerJourney updateCustomerJourney(@PathVariable Long id, @RequestBody CustomerJourney ticket) {
        return ticketService.updateCustomerJourney(id, ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerJourney(@PathVariable Long id) {
        ticketService.deleteCustomerJourney(id);
    }
}
