package com.travel.travel.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travel.Domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository <Seat, Long> {

}