package com.travel.travel.Domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tblUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy="user")
    List<CustomerJourney> ticket;

    public User(Long userID, String name, String email, String phoneNumber, List<CustomerJourney> ticket) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ticket = ticket;
    }
    public List<CustomerJourney> getTicket() {
        return ticket;
    }
    public void setTicket(List<CustomerJourney> ticket) {
        this.ticket = ticket;
    }
    // Getters and setters
    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
