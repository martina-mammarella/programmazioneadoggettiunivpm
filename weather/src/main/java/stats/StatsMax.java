package stats;
import model.Città;
import java.util.Vector;
import org.json.simple.JSONObject;
import model.Weather;
import service.Download;
public class StatsMax extends Stats{
 public JSONObject massimoGiornaliero(String cityName) {
	
		 JSONObject ob= new JSONObject();
		 Download x= new Download();
		 Città a= x.download(cityName);
			Vector<Weather> p=a.getWeather();
			double j=0;
			double max=0;
			for(Weather y:p) {
				if(y.getDate().equals(y.getDate())){
					j=y.getMin();
					max=scambiomax(max,j);
					}
	 }
			ob.put("nomecittà", cityName);
			ob.put("massimogiornaliero", max);
			return ob;
	}
	 private double scambiomax(double massimo,double x) {
		
		 if(x>massimo) {
			massimo=x;
		 }
		 return massimo;
	}
	 //massimosettimanale
	 //massimo3giorni

	
 }

