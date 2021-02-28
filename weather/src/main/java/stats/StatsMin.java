package stats;

import java.util.Vector;

import org.json.simple.JSONObject;

import model.Weather;
import service.Download;

public class StatsMin {
	 public JSONObject minimoGiornaliero(String cityName) {
		 JSONObject ob= new JSONObject();
		 Download x= new Download();
			Vector<Weather> p=x.downloadWeather(cityName);
			double j=0;
			double min=0;
			for(Weather y:p) {
				if(y.getDate().equals(y.getDate())){
					j=y.getMin();
					min=scambio(min,j);
					}
	 }
			ob.put("nomecittà", cityName);
			ob.put("minimo", min);
			return ob;
	}
	 private double scambio(double minimo,double x) {
		 if(x<minimo) {
			 double temp=0;
			 temp=x;
			 x=minimo;
			 minimo=x;
		 }
		 return minimo;
	}
	 //minimogiornaliero
	 //minimotregiorni

	}
}
