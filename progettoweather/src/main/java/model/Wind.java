package model;

public class Wind {
	private double speed;
	private long deg;
	public Wind() {};
	public Wind(double speed, long deg) {
		setSpeed(speed);
		setDeg(deg);
	}
   public void setSpeed(double speed) {
	   this.speed=speed;
   }
   public void setDeg(long deg) {
	   this.deg=deg;
   }
   public double getSpeed() {
	   return speed;
   }
   public long getDeg() {
	   return deg;
   }
   
   
}



