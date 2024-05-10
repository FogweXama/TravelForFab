package com.travel.travel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travel.Domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}


