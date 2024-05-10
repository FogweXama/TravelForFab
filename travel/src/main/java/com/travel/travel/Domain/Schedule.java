package com.travel.travel.Domain;



import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tblSchedule")

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleID;
    private String scheduleName;
    //change to sqlDatetime if it disturbs
    private Date departureTime;

    public Schedule(Long scheduleID, String scheduleName, Date departureTime) {
        this.scheduleID = scheduleID;
        this.scheduleName = scheduleName;
        this.departureTime = departureTime;
    }
    
    public Long getScheduleID() {
        return scheduleID;
    }
    public void setScheduleID(Long scheduleID2) {
        this.scheduleID = scheduleID2;
    }
    public String getScheduleName() {
        return scheduleName;
    }
    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }
    public Date getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    // Getters and setters
}
