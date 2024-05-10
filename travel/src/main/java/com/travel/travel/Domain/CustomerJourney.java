package com.travel.travel.Domain;

import java.security.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "tblTicket")
public class CustomerJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketID;

    private Long userID;
    private Long seatID;
    private Timestamp timepaid;
    private Boolean paymentStatus=false;

    /* 
     * 
     * @ManyToMany
    List<User> users;
    */
    
    /*@ManyToMany

    @JoinTable(
        name="tblCustomerJourney",
        joinColumns=
        @JoinColumn(name="userID"),
        inverseJoinColumns=
        @JoinColumn(name="seatID"))
        List<seat> chosenSeats;

    */

    @ManyToOne
    @JoinColumn(name="userID",insertable = false, updatable = false )
    User user;

    @ManyToOne
    @JoinColumn(name="seatID", insertable = false, updatable = false)
    Seat seat;


    public CustomerJourney(Long ticketID, Long userID, Long seatID, Timestamp timepaid, Boolean paymentStatus,
            User user, Seat seat) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.seatID = seatID;
        this.timepaid = timepaid;
        this.paymentStatus = paymentStatus;
        this.user = user;
        this.seat = seat;
    }
    public Long getTicketID() {
        return ticketID;
    }
    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public Long getSeatID() {
        return seatID;
    }
    public void setSeatID(Long seatID) {
        this.seatID = seatID;
    }
    public Timestamp getTimepaid() {
        return timepaid;
    }
    public void setTimepaid(Timestamp timepaid) {
        this.timepaid = timepaid;
    }
    public Boolean getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters
   
}