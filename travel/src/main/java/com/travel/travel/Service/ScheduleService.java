package com.travel.travel.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Domain.Schedule;
import com.travel.travel.Repository.ScheduleRepository;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long scheduleID) {
        return scheduleRepository.findById(scheduleID).orElse(null);
    }

    public Schedule updateSchedule(Long scheduleID, Schedule schedule) {
        schedule.setScheduleID(scheduleID);
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long scheduleID) {
        scheduleRepository.deleteById(scheduleID);
    }
}
