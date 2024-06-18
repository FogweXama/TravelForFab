package com.travel.travel.Domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tblSeat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatID;
    private String seatDescription;
    private Long journeyID;
    private Boolean status;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="journeyID", nullable=false,referencedColumnName = "journeyID", insertable = false, updatable = false)
	private Journey journey;

    @OneToMany(mappedBy="seat")
    List<CustomerJourney> ticket;

    public Seat(Long seatID, String seatDescription, Long journeyID, Boolean status) {
        this.seatID = seatID;
        this.seatDescription = seatDescription;
        this.journeyID = journeyID;
        this.status = status; 
    }
    public Seat(){

    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Long getSeatID() {
        return seatID;
    }
    public void setSeatID(Long seatID) {
        this.seatID = seatID;
    }
    public String getSeatDescription() {
        return seatDescription;
    }
    public void setSeatDescription(String seatDescription) {
        this.seatDescription = seatDescription;
    }
    public Long getJourneyID() {
        return journeyID;
    }
    public void setJourneyID(Long journeyID) {
        this.journeyID = journeyID;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
