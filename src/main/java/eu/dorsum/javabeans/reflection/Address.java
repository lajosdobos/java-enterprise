package eu.dorsum.javabeans.reflection;

public class Address {

	private String country;
	private String city;
	private int zipCode;
	private String street;
	
	public Address(String country, String city, int zipCode, String street) {
		super();
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

}
