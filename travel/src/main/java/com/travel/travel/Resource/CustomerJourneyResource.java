package com.travel.travel.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.CustomerJourney; 
import com.travel.travel.Repository.CustomerJourneyRepository; 
import com.travel.travel.Service.CustomerJourneyService;
//import com.travel.travel.Service.JourneyService;
import com.travel.travel.Service.SeatService; 
 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/journeys/{journeyID}/seats/{seatID}/tickets")
public class CustomerJourneyResource {
    @Autowired
    private CustomerJourneyService ticketService;

    @Autowired
    private CustomerJourneyRepository ticketRepo;

    @Autowired
    private SeatService seatService;

    /*@Autowired
    private JourneyService journeyService;*/

    @PostMapping
    public ResponseEntity<CustomerJourney> createCustomerJourney(@RequestBody CustomerJourney ticketRequest,
            @PathVariable(value = "seatID") Long seatID) {
        return new ResponseEntity<>(ticketRequest, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerJourney>> getTicketsByServiceID(@PathVariable(value = "seatID") Long seatID) {
        if (seatService.getSeatById(seatID) == null) {
            throw new ResourceNotFoundException("No tickets found in this journey");
        } else {
            List<CustomerJourney> ticketes = ticketService.getAllCustomerJourneys();
            return new ResponseEntity<>(ticketes, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerJourney> getCustomerJourneyById(@PathVariable(value = "id") Long id) {
        CustomerJourney _ticket = ticketService.getCustomerJourneyById(id);
        if (_ticket == null) {
            throw new ResourceNotFoundException("Ticket not found");
        } else {
            return new ResponseEntity<>(_ticket, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public CustomerJourney updateCustomerJourney(@PathVariable(value = "id") Long id, @RequestBody CustomerJourney ticket) {
        
        return ticketRepo.findById(id).map((CustomerJourney tickett) -> {
            tickett.setPaymentStatus(ticket.getPaymentStatus()); 
            tickett.setSeatID(ticket.getSeatID());
            tickett.setTimepaid(ticket.getTimepaid());
            tickett.setUserID(ticket.getUserID());
            tickett.setTicketID(ticket.getTicketID()); 
            return ticketService.createCustomerJourney(tickett);
        }).orElseThrow(() -> new ResourceNotFoundException("absent"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomerJourneyByID(@PathVariable(value = "id") Long id) {

        ticketService.deleteCustomerJourney(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity<List<CustomerJourney>> deleteAllCustomerJourneyesInSeat(@PathVariable(value = "seatID") Long seatID) {
        if (seatService.getSeatById(seatID) == null) {
            throw new ResourceNotFoundException("service not found");
        } else {
            ticketService.deleteCustomerJourney(seatID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
