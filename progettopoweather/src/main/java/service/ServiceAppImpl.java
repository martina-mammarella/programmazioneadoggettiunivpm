package service;
import model.Città;
import model.Weather;
import model.Wind;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import  org.springframework.web.client.RestTemplate ;
import filters.FilterDay;
import filters.FilterThreeDays;
import filters.FilterWeek;
import  org.springframework.stereotype.Service ;
import stats.*;
@Service
public class ServiceAppImpl implements ServiceApp {

		//metodo richiamato dal controller per stampa storico della città passata come argomento
		public JSONObject getDatiStorici(String cityName) {
			JSONObject o= new JSONObject ();
			 try {
					BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") +"/previsioni"+cityName));
					String line=reader.readLine();
					while(line!=null) {
					   line = reader.readLine();
				    }
					        
			        o.put("storico",line);
				    	
				    }catch(Exception e) {
				    	System.out.println("errorfile");
				    }
	     return o;
		}
		//metodo richiamato dal controller per stampare  meteo attuale
        public JSONObject  getDatiAttuali(String cityName) {
	        Download x=new Download();
            Weather m=x.downloadDatiMeteoAttuale(cityName);
			Wind v=x.downloadDatiVentoAttuale(cityName);
			JSONObject o= new JSONObject();
			o.put("main attuale", m.getMain());
			o.put("descrizione attuale", m.getDescription());
			o.put("temperatura attuale", m.getTemperature());
			o.put("minima attuale", m.getMin());
			o.put("massima attuale", m.getMax());
			o.put("umidità attuale", m.getHumidity());
			o.put("pressione attuale", m.getPressure());
			o.put("visibilità attuale", m.getVisibility());
			o.put("speed vento attuale",v.getSpeed());
			o.put("deg vento attuale",v.getDeg());
			return o;
			
			}
		//metedo richiamato dal controller per richiamare le previsioni
		public JSONObject getPrevisioni(String cityName) {
		 Download x= new Download();
			Città c=new Città(x.download(cityName));
		    JSONObject o=new JSONObject();
		    o.put("nome",c.getName());
		    o.put("lat", c.getLat());
		    o.put("lon", c.getLon());
		    o.put("country",c.getCountry());
		    JSONArray array= new JSONArray();
		    int count;
		    for(count=0;count<c.getWeather().size();count++) {
		    	JSONObject elem= new JSONObject();
		    	elem.put("temperature",c.getWeather().get(count).getTemperature());
		    	elem.put("main",c.getWeather().get(count).getMain());
		    	elem.put("description",c.getWeather().get(count).getDescription());
		    	elem.put("min",c.getWeather().get(count).getMin());
		    	elem.put("max",c.getWeather().get(count).getMax());
		    	elem.put("humidity",c.getWeather().get(count).getHumidity());
		    	elem.put("pressure",c.getWeather().get(count).getPressure());
		    	elem.put("visibility", c.getWeather().get(count).getVisibility());
		    	elem.put("date", c.getWeather().get(count).getDate());
		    	array.add(elem);
		    	
		    }
		    o.put("previsioni", array);
		    JSONArray array1=new JSONArray();
		   
		    for(count=0;count<c.getWind().size();count++) {
		    	JSONObject elem=new JSONObject();
		    	elem.put("speed", c.getWind().get(count).getSpeed());
		        elem.put("deg",c.getWind().get(count).getDeg());
		        array1.add(elem);
		    	
		    }
		    o.put("wind", array1);
		    return o;
	}
		public JSONArray getFilters(JSONObject f) {
			JSONArray res= new JSONArray();
			String p=(String)f.get("periodo");
			
			switch(p) {
			case"giornaliero":{
				
				FilterDay fd= new FilterDay(f);	
				res=fd.filtraggioDay();
			}
			case"3giorni":{
				 FilterThreeDays fd3= new  FilterThreeDays(f);
				 res=fd3.filtraggioThreeDays();
			}
			case"settimanale":{
				FilterWeek fw= new FilterWeek(f);
				res=fw.filtraggioWeek();}
			}
			return res;
		}
		public JSONArray getStats(JSONObject vettore,String periodo) {
			StatsHumidity su;
			StatsVisibility sv;
			StatsPressure sp;
			StatsTemp st;
			StatsTempMin stmin;
			StatsTempMax stmax;
			JSONArray res= new JSONArray();
			switch(periodo) {
			case"giornaliero":{
				res.add(su.statsHumidityDay(vettore));
				res.add(sp.statsPressureDay(vettore));
				res.add(sv.statsVisibilityDay(vettore));
				res.add(st.statsTemp(vettore));
				res.add(stmin.statsTempMinDay(vettore));
				res.add(stmax.statTempMaxDay(vettore));
			}
			case"duesettimane":
			{
				res.add(su.statsHumidityTwoWeeks(vettore));
				res.add(sp.statsPressureTwoWeeks(vettore));
				res.add(sv.statsVisibilityTwoWeeks(vettore));
				res.add(st.statsTempTwoWeeks(vettore));
				res.add(stmin.statsTempMinTwoWeeks(vettore));
				res.add(stmax.statTempMaxTwoWeeks(vettore));
				
			}
			case:"duegiorni":{
				res.add(su.statsHumidityTwoDays(vettore));
				res.add(sp.statsPressureTwoDays(vettore));
				res.add(sv.statsVisibilityTwoDays(vettore));
				res.add(st.statsTempTwoDays(vettore));
				res.add(stmin.statsTempMinTwoDays(vettore));
				res.add(stmax.statTempMaxTwoDays(vettore));
				
			}
			return res;
			}
		}
		
			
			
		}
		}


