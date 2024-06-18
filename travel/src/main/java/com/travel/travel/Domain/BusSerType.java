package com.travel.travel.Domain;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tblBusService")
public class BusSerType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serviceID", nullable = false)
    private Long serviceID;
    @Column(name="serviceName")
    private String serviceName;
    @Column(name="serviceDescription")
    private String serviceDescription;

    @OneToMany(mappedBy="serviceb",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bus> buses; 

    public BusSerType() {
		
	}
    public BusSerType(Long serviceID, String serviceName, String serviceDescription) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
    }
    // Getters and setters
    public Long getServiceID() {
        return serviceID;
    }
    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getServiceDescription() {
        return serviceDescription;
    }
    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    /**
     * @return List<Bus> return the buses
     */
    public List<Bus> getBuses() {
        return buses;
    }

    
    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
    public List<Bus> getAllBus() {
        return null;
    }
    public Bus getBusById(Long id) {
        return null;
    }
    public Bus createBus(Bus bus) {
        return null;
    }
    public Bus updateBus(Long id, Bus bus) {
        return null;
    }
    public void deleteBus(Long id) {
    }

}
