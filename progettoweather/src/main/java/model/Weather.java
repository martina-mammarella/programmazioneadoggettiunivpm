package model;

public class Weather {
    private double temperature;
	private String main;
	private String description;
	private double min;
	private double max;
	private long humidity;
	private long pressure;
	private long visibility;
	private String date;
	public Weather() {};
	public Weather (double temperature,String main, String description, double min, double max, long humidity, long pressure,long visibility,String date) {
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
	public void setHumidity(long humidity) {
		this.humidity=humidity;
	}
	public void setPressure(long pressure) {
		this.pressure=pressure;
	}
	public void setVisibility(long visibility) {
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
    public long getPressure() {
    	return pressure;
    }
    public long getVisibility() {
    	return visibility;
    }
    public String getDate() {
    	return date;
    }
   
}

