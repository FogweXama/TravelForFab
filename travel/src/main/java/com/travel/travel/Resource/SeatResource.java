package com.travel.travel.Resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
 
import com.travel.travel.Domain.Seat; 
import com.travel.travel.Repository.SeatRepository;  
import com.travel.travel.Service.JourneyService;
import com.travel.travel.Service.SeatService;



@RestController
@RequestMapping("/api/journeys/{journeyID}/seats")
public class SeatResource {
    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatRepository seatRepo;

    @Autowired
    private JourneyService journeyService;

    

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seatRequest,
            @PathVariable(value = "journeyID") Long journeyID) {
        return new ResponseEntity<>(seatRequest, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getSeatByJourneyID(@PathVariable(value = "journeyID") Long journeyID) {
        if (journeyService.getJourneyById(journeyID) == null) {
            throw new ResourceNotFoundException("No seats found in this service");
        } else {
            List<Seat> seats = seatService.getAllSeats();
            return new ResponseEntity<>(seats, HttpStatus.OK);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Seat _seat = seatService.getSeatById(id);
        if (_seat==null) {
            throw new ResourceNotFoundException("Seat not found");
        } else {
            return new ResponseEntity<>(_seat, HttpStatus.OK);
        }
    }
    

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable(value = "id") Long id, @RequestBody Seat seat) {
        return seatRepo.findById(id).map((seatt) -> {
            seatt.setSeatDescription(seat.getSeatDescription());
            seatt.setStatus(seat.getStatus());
            seatt.setSeatID(seat.getSeatID());
            return seatService.createSeat(seatt);
        }).orElseThrow(() -> new ResourceNotFoundException("absent"));
    }
    ///we get all seats that belong to a journey and the person clicks. When he clicks it joins his information with name and schedule and fills in customer journey resource
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSeatByID(@PathVariable(value = "id") Long id) {

        Seat seat=seatService.getSeatById(id);
        if(seat.getSeatID()>=1){
            seatService.deleteSeat(seat.getSeatID());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            throw new ResourceNotFoundException("Seat not found");
        }
    }


    @DeleteMapping("")
    public ResponseEntity<List<Seat>> deleteAllSeatInService(@PathVariable(value = "journeyID") Long journeyID) {
        if (journeyService.getJourneyById(journeyID).getJourneyID()>=1) {
            seatService.deleteSeat(journeyID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new ResourceNotFoundException("Journey not found");
        }
    }
}
