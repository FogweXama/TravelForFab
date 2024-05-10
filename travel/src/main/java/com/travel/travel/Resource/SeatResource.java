package com.travel.travel.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.Seat;
import com.travel.travel.Service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/api/journeys/{journeyID}/seats")
public class SeatResource {
    @Autowired
    private SeatService seatService;

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return seatService.createSeat(seat);
    }

    ///we get all seats that belong to a journey and the person clicks. When he clicks it joins his information with name and schedule and fills in customer journey resource
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        return seatService.updateSeat(id, seat);
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
    }
}
