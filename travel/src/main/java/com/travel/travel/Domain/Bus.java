package com.travel.travel.Domain;


import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="tblBus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="busID")
	private Long busID;
	@Column(name="serviceID")
	private Long serviceID;
	@Column(name="busColour")
	private String busColour;
	@Column(name="busMark")
	private String busMark;
	@Column(name="numberOfPlaces")
	private Integer numberPlaces;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="serviceID", referencedColumnName = "serviceID", nullable=false, insertable = false, updatable = false)
	private BusSerType serviceb;

	@OneToMany(mappedBy = "bus")
	private List<Journey> journeys;


	public BusSerType getServiceb() {
		return serviceb;
	}

	public void setServiceb(BusSerType serviceb) {
		this.serviceb = serviceb;
	}

	public Integer getNumberPlaces() {
		return numberPlaces;
	}

	public void setNumberPlaces(Integer numberPlaces) {
		this.numberPlaces = numberPlaces;
	}

	public Bus(Long busID, String busColour, String busMark, Integer numberPlaces, Long serviceID) {
		this.busID = busID;
		this.busColour = busColour;
		this.busMark = busMark;
		this.numberPlaces = numberPlaces;
		this.serviceID = serviceID;
	}
	public Bus() {
		
	}

	public Long getServiceID() {
		return this.serviceID;
	}

	public Integer getNumberOfSeats() {
		return numberPlaces;
	}

	public Long getBusID() {
		return busID;
	}

	public void setServiceID(Long serviceID) {
		this.serviceID = serviceID;
	}

	public void setBusID(Long busID) {
		this.busID = busID;
	}

	public void setNumberOfPlaces(Integer numberOfPlaces) {
		this.numberPlaces = numberOfPlaces;
	}

	public String getBusColour() {
		return busColour;
	}

	public void setBusColour(String busColour) {
		this.busColour = busColour;
	}

	public String getBusMark() {
		return busMark;
	}

	public void setBusMark(String busMark) {
		this.busMark = busMark;
	}
}
