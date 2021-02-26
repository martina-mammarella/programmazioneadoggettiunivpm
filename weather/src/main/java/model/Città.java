package model;
import java.util.Vector;
public class Città {
	
	private String name;
	private double lat;
	private double lon;
	private String country;
	Vector <Weather> previsioni= new Vector<Weather>();
	public Città() {};
	public Città(int id, String name, double lat,double lon,String contry) {
		
		setName(name);
		setLat(lat);
		setLon(lon);
		setCountry(country);
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setLat(double lat) {
		this.lat=lat;
	}
	public void setLon(double lon) {
		this.lon=lon;
	}
	public void setCountry(String country) {
		this.country=country;
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
