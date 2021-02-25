package model;

public class Città {
	private int id;
	private String name;
	private double lat;
	private double lon;
	private String country;
	
	public Città(int id, String name, double lat,double lon,String contry) {
		setId(id);
		setName(name);
		setLat(lat);
		setLon(lon);
		setCountry(country);
		
	}
	private void setId(int id) {
		this.id=id;
	}
	private void setName(String name) {
		this.name=name;
	}
	private void setLat(double lat) {
		this.lat=lat;
	}
	private void setLon(double lon) {
		this.lon=lon;
	}
	private void setCountry(String country) {
		this.country=country;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getLat() {
		return lat;
	}
	public double getLon() {
		return lon;
	}
	public String getCountry() {
		return country;
	}
	
	

}
