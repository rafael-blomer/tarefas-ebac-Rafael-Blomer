package br.com.rafaelblomer.customer;

import org.springframework.data.geo.Point;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private Point location;
	private String street;
	private String zipCode;
	
	

	public Address() {
	}

	public Address(Point location, String street, String zipCode) {
		super();
		this.location = location;
		this.street = street;
		this.zipCode = zipCode;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
