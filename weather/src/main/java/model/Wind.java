package model;

public class Wind {
	private double speed;
	private double deg;
	public Wind() {};
	public Wind(double speed, double deg) {
		setSpeed(speed);
		setDeg(deg);
	}
   public void setSpeed(double speed) {
	   this.speed=speed;
   }
   public void setDeg(double deg) {
	   this.deg=deg;
   }
   public double getSpeed() {
	   return speed;
   }
   public double getDeg() {
	   return deg;
   }
   
   
}
