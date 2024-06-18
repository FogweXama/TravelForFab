package com.travel.travel.Domain;



import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblJourney")

public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long journeyID;
    private String destination;
    private String origin;
    private Long scheduleID;
    private Long busID;
    private Double cost;
    private Date day;

    @OneToMany(mappedBy="journey")
    private List<Seat> seats; 
    
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "scheduleID",nullable = false, insertable = false, updatable=false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="busID", nullable = false, insertable = false, updatable = false)
    private Bus bus;

    public Long getJourneyID() {
        return journeyID;
    }
    public void setJourneyID(Long journeyID) {
        this.journeyID = journeyID;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public Long getScheduleID() {
        return scheduleID;
    }
    public void setScheduleID(Long scheduleID) {
        this.scheduleID = scheduleID;
    }
    public Long getBusID() {
        return busID;
    }
    public void setBusID(Long busID) {
        this.busID = busID;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    public Date getDay() {
        return day;
    }
    public void setDay(Date day) {
        this.day = day;
    }
    public Journey() {
		
	}
    // Getters and setters
    public Journey(Long journeyID, String destination, String origin, Long scheduleID, Long busID, Double cost,
            Date day) {
        this.journeyID = journeyID;
        this.destination = destination;
        this.origin = origin;
        this.scheduleID = scheduleID;
        this.busID = busID;
        this.cost = cost;
        this.day = day;
    }
}
