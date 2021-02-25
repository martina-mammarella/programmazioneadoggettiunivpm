package model;

public class Weather {


	private String main;
	private String description;
	private double min;
	private double max;
	private double humidity;
	private double pressure;
	public Weather (String main, String description, double min, double max, double humidity, double pressure) {
		setMain(main);
		setDescription(description);
		setMin(min);
		setMax(max);
		setHumidity(humidity);
		setPressure(pressure);
		
	}
	private void setMain(String main) {
		this.main=main;
	}
	private void setDescription(String descrption) {
		this.description=description;
	}
	private void setMin(double min) {
		this.min=min;
	}
	private void setMax(double max) {
		this.max=max;
	}
	private void setHumidity(double humidity) {
		this.humidity=humidity;
	}
	private void setPressure(double pressure) {
		this.pressure=pressure;
	}
	public String getMain() {
		return main;
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
}