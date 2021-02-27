package model;
import java.util.Vector;
public class Città {
	
	private String name;
	private double lat;
	private double lon;
	private String country;
	private Vector <Wind> vento= new Vector<Wind>();
	private Vector <Weather> previsioni= new Vector<Weather>();
	public Città() {};
	public Città(Città x) {
		name=x.getName();
		lat=x.getLat();
		lon=x.getLon();
		country=x.getCountry();
		vento=x.getWind();
		previsioni=x.getWeather();
	}
	public Città(int id, String name, double lat,double lon,String contry,Vector<Weather>previsioni, Vector<Wind>vento) {
		
		setName(name);
		setLat(lat);
		setLon(lon);
		setCountry(country);
		setWeather(previsioni);
		setWind(vento);
		
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
	public void setWeather(Vector<Weather>prev) {
		
		for(int i=0;i<prev.size();i++) {
			previsioni.add(prev.get(i));
			
		}
	}
	public void setWind(Vector<Wind>venti) {
		for(int i=0;i<venti.size();i++) {
			vento.add(venti.get(i));
		}
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
	public Vector<Weather> getWeather(){
		return previsioni;
	}
	public Vector<Wind>getWind(){
		return vento;
	}
	

}
