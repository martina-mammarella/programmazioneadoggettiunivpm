package model;

public class Wind {
	private double speed;
	private double deg;
	public Wind(double speed, double deg) {
		setSpeed(speed);
		setDeg(deg);
	}
   private void setSpeed(double speed) {
	   this.speed=speed;
   }
   private void setDeg(double deg) {
	   this.deg=deg;
   }
   
   
}
