package model;

public class Weather {

    private double temperature;
	private String main;
	private String description;
	private double min;
	private double max;
	private double humidity;
	private double pressure;
	private int visibility;
	private String date;
	public Weather() {};
	public Weather (double temperature,String main, String description, double min, double max, double humidity, double pressure,int visibility,String date) {
		setTemperature(temperature);
		setMain(main);
		setDescription(description);
		setMin(min);
		setMax(max);
		setHumidity(humidity);
		setPressure(pressure);
		setVisibility(visibility);
		setDate(date);
		
	}
	public void setTemperature(double temperature) {
		this.temperature=temperature;
	}
	public void setMain(String main) {
		this.main=main;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public void setMin(double min) {
		this.min=min;
	}
	public void setMax(double max) {
		this.max=max;
	}
	public void setHumidity(double humidity) {
		this.humidity=humidity;
	}
	public void setPressure(double pressure) {
		this.pressure=pressure;
	}
	public void setVisibility(int visibility) {
		this.visibility=visibility;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public String getMain() {
		return main;
	}
	public double getTemperature() {
		return temperature;
	}
	public String getDescription() {
		return description;
	}
	public double getMin() {
		return min;
	}
	public double getMax() {
		return max;
	}
    public double getHumidity() {
    	return humidity;
    }
    public double getPressure() {
    	return pressure;
    }
    public int getVisibility() {
    	return visibility;
    }
    public String getDate() {
    	return date;
    }
   
}