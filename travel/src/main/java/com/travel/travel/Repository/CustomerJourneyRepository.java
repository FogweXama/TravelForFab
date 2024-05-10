package com.travel.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travel.Domain.CustomerJourney;

@Repository
public interface CustomerJourneyRepository extends JpaRepository<CustomerJourney, Long> {

}
