package stats;
import model.Città;
import model.Weather;
import java.util.Vector;
import service.Download;
import java.util.Date;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;
public class StatsMedia extends Stats {
public JSONObject mediaGiornaliera(String cityName) {
	Download x= new Download();
	Vector<Weather> p=x.downloadWeather(cityName);
	double t=0;
	int i=0;
	double media=0;
	for(Weather y:p) {
		if(y.getDate().equals(y.getDate())){
			t=y.getTemperature();
			i++;
			}
	}
	media=t/i;
	JSONObject ob= new JSONObject();
	ob.put("nomecittà", cityName);
	ob.put("mediagiornaliera", media);
	return ob;
	
}
public JSONObject mediaSettimana(String cityName) {
	//accesso dati salvati
}
public JSONObject mediaTreGiorni(String cityName) {
	//accesso dati salvati
}
}
