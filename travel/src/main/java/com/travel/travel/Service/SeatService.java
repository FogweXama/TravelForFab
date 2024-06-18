package com.travel.travel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Domain.Seat;
import com.travel.travel.Repository.SeatRepository;

@Service
public class SeatService{

    @Autowired
    private SeatRepository seatRepository;

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(Long seatID) {
        return seatRepository.findById(seatID).orElse(null);
    }

    public Seat updateSeat(Long seatID, Seat seat) {
        seat.setSeatID(seatID);
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long seatID) {
        seatRepository.deleteById(seatID);
    }


    public Iterable<Seat> getSeatByServiceName(String serviceName) {
    
        throw new UnsupportedOperationException("Unimplemented method 'getSeatByServiceName'");
    }
}
