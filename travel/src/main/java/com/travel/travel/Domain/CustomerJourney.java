package com.travel.travel.Domain;
 
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tblTicket")
public class CustomerJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="ticketID")
    private Long ticketID;
    //@Column(name="userID")
    private Long userID;
    //@Column(name = "seatID")
    private Long seatID;
    //@Column(name = "timepaid")
    private Date timepaid;
    //@Column(name = "paymentStatus")
    private Boolean paymentStatus;

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
     
   

    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name="userID",insertable = false, updatable = false )
    private User user;

    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name="seatID", insertable = false, updatable = false)
    private Seat seat;


    public CustomerJourney(Long ticketID, Long userID, Long seatID, Date timepaid, Boolean paymentStatus) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.seatID = seatID;
        this.timepaid = timepaid;
        this.paymentStatus = paymentStatus;
    }
    public CustomerJourney() {
		
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
    public Date getTimepaid() {
        return timepaid;
    }
    public void setTimepaid(Date timepaid) {
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