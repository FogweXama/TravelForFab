package com.travel.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travel.Domain.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}