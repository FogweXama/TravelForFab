package com.travel.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travel.Domain.BusSerType;

@Repository
public interface BusSerRepository extends JpaRepository <BusSerType, Long> {

}
