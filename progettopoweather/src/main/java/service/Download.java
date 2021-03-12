package service;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.URL;
	import java.net.URLConnection;
	import java.util.Vector;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;

	import model.Città;
	import model.Weather;
	import model.Wind;

	public class Download {
		public Download() {};
		String apiKey="91f3a6c712ed1b7232015700aecf9b80";
		JSONObject chiamata=null;
		JSONParser parser= new JSONParser();
		//metodo per salvare la chiamata previsioni 5 giorni ogni 3 ore 
		//
		public Weather downloadDatiMeteoAttuale(String cityName) {
			try {
				String apikey="91f3a6c712ed1b7232015700aecf9b80";
			    String url= "api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+apikey;
	            URLConnection openConnection= new URL(url).openConnection();
			    InputStream in=openConnection.getInputStream();
		        String line="";
		        try {
		    	    InputStreamReader inR= new InputStreamReader(in);
		    	    BufferedReader buf= new BufferedReader(inR);
		    	    while((line=buf.readLine())!=null){
		    		 chiamata=(JSONObject) parser.parse(line);
				    }
				    in.close();}
		        catch(Exception e) {
		     	System.out.println("errore generico1");}}
		     catch(Exception e ) {
			    	System.out.println("errore2");}
	    		 JSONArray ob1=(JSONArray)chiamata.get("weather");
	    		 Weather m= new Weather();
	    			for(Object o:ob1) {
	    				JSONObject ob3=(JSONObject)o;
	    				m.setMain((String)ob3.get("main"));
	    				m.setDescription((String)ob3.get("description"));
	    			}
	    			JSONObject main=(JSONObject)chiamata.get("main");
	    			if(main.get("temp_min") instanceof Long) {
	    				long  tempMinApp1=(long)main.get("temp_min");
	    				Long tempMinApp=new Long(tempMinApp1);
	    				double tempMin=tempMinApp.doubleValue();
	    				m.setMin(tempMin);
	    				}
	    			else {
	    				m.setMin((double)main.get("temp_Min"));
	    			}
	    			if(main.get("temp_max") instanceof Long) {
	    				long  tempMaxApp1=(long)main.get("temp_min");
	    				Long tempMaxApp=new Long(tempMaxApp1);
	    				double tempMax=tempMaxApp.doubleValue();
	    				m.setMax(tempMax);
	    			}
	    			else {
	    				m.setMax((double)main.get("temp_max"));
	    			}
	    			if(main.get("temp") instanceof Long) {
	    				long  tempApp1=(long)main.get("temp_min");
	    				Long tempApp=new Long(tempApp1);
	    				double temp=tempApp.doubleValue();
	    				m.setTemperature(temp);
	    			}
	    			else {
	    				m.setTemperature((double)main.get("temp"));

	    			}
	    			if(main.get("pressure") instanceof Long) {
	    				long pressureApp1=(long)main.get("pressure");
	    				Long pressureApp=new Long(pressureApp1);
	    				double pressure=pressureApp.doubleValue();
	    				m.setPressure(pressure);
	    			}
	    			else {
	    				m.setPressure((double)main.get("pressure"));
	    			}
	    			if(main.get("humidity") instanceof Long) {
	    				long humidityApp1=(long)main.get("pressure");
	    				Long humidityApp=new Long(humidityApp1);
	    				double humidity=humidityApp.doubleValue();
	    				m.setPressure(humidity);
	    			}
	    			else {	m.setHumidity((long)main.get("humidity"));
	    				
	    			}
	    			if(main.get("visibility") instanceof Long) {
	    				long visibilityApp1=(long)main.get("visibility");
	    				Long visibilityApp=new Long(visibilityApp1);
	    				double visibility=visibilityApp.doubleValue();
	    				m.setVisibility(visibility);
	    			}
	    			else {	
	    				m.setVisibility((long)chiamata.get("visibility"));
	    			}
	    			return m;
	    }
		public Wind downloadDatiVentoAttuale(String cityName){
			try {
				String apikey="91f3a6c712ed1b7232015700aecf9b80";
			    String url= "api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid="+apikey;
	            URLConnection openConnection= new URL(url).openConnection();
			    InputStream in=openConnection.getInputStream();
		        String line="";
		        try {
		    	    InputStreamReader inR= new InputStreamReader(in);
		    	    BufferedReader buf= new BufferedReader(inR);
		    	    while((line=buf.readLine())!=null){
		    		 chiamata=(JSONObject) parser.parse(line);
				    }
				    in.close();}
		        catch(Exception e) {
		     	System.out.println("errore generico1");}}
		     catch(Exception e ) {
			    	System.out.println("errore2");}
			JSONObject vento=(JSONObject)chiamata.get("wind");
			Wind v= new Wind();
			if(vento.get("deg") instanceof Long) {
				long degApp1=(long)vento.get("deg");
				Long degApp=new Long(degApp1);
				double deg=degApp.doubleValue();
				v.setDeg(deg);
			}
			else {
				v.setDeg((double)vento.get("deg"));
			}
			if(vento.get("speed") instanceof Long) {
				long speedApp1=(long)vento.get("speed");
				Long degApp=new Long(speedApp1);
				double spped=degApp.doubleValue();
				v.setSpeed(spped);
			}
			else {
				v.setSpeed((double)vento.get("speed"));
			}
			return v;
			
		}
		public Città download(String cityName) {
			
			try {
			
			    String url= "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid="+apiKey;
	            URLConnection openConnection= new URL(url).openConnection();
			    InputStream in=openConnection.getInputStream();
		        String line="";
		        try {
		    	    InputStreamReader inR= new InputStreamReader(in);
		    	    BufferedReader buf= new BufferedReader(inR);
		    	    while((line=buf.readLine())!=null){
		    		 chiamata=(JSONObject) parser.parse(line);
				    }
				    in.close();}
		        catch(Exception e) {
		     	System.out.println("errore generico1");}}
		     catch(Exception e ) {
			    	System.out.println("errore2");}
			JSONObject city=(JSONObject)chiamata.get("city");
			JSONObject coord=(JSONObject)city.get("coord");
			Città x= new Città();
			x.setCountry((String)city.get("country"));
			x.setName((String)city.get("name"));
			if(coord.get("lat") instanceof Long) {
				long latApp1=(long)coord.get("lat");
				Long latApp=new Long(latApp1);
				double lat=latApp.doubleValue();
			    x.setLat(lat);
			}
			else {
				x.setLat((double)coord.get("lat"));
			}
			if(coord.get("lon") instanceof Long) {
				long lonApp1=(long)coord.get("lon");
				Long lonApp=new Long(lonApp1);
				double lon=lonApp.doubleValue();
			    x.setLon(lon);
			}
			else {
				x.setLon((double)coord.get("lon"));
			}
			JSONArray a =(JSONArray)chiamata.get("list");
			Vector<Weather> previsioni = new Vector<Weather>();
			for(Object o:a) {
				JSONObject x1=(JSONObject) o;
				JSONArray a1=(JSONArray)x1.get("weather");
				JSONObject x2=(JSONObject)x1.get("main");
				Weather p= new Weather();
				if(x2.get("pressure") instanceof Long) {
					long pressureApp1=(long)x2.get("pressure");
					Long pressureApp=new Long(pressureApp1);
					double pressure=pressureApp.doubleValue();
				    p.setPressure(pressure);
				}
				else {
					p.setPressure((long)x2.get("pressure"));
				}
				if(x2.get("humidity") instanceof Long) {
					long humidityApp1=(long)x2.get("pressure");
					Long humidityApp=new Long(humidityApp1);
					double humidity=humidityApp.doubleValue();
				    p.setHumidity(humidity);
				}
				else {
					p.setHumidity((long)x2.get("humidity"));
				}
				if(x2.get("temp_min") instanceof Long) {
					long tempMinApp1=(long)x2.get("temp_min");
					Long tempMinApp=new Long(tempMinApp1);
					double tempMin=tempMinApp.doubleValue();
				    p.setMin(tempMin);
				}
				else {
					p.setMin((double)x2.get("temp_min"));
				}
				if(x2.get("temp_max") instanceof Long) {
					long tempMaxApp1=(long)x2.get("temp_max");
					Long tempMaxApp=new Long(tempMaxApp1);
					double tempMax=tempMaxApp.doubleValue();
				    p.setMax(tempMax);
				}
				else {
					p.setMax((double)x2.get("temp_max"));
				}
				if(x2.get("temp") instanceof Long) {
					long tempApp1=(long)x2.get("temp");
					Long tempApp=new Long(tempApp1);
					double temp=tempApp.doubleValue();
				    p.setTemperature(temp);
				}
				else {
					p.setTemperature((double)x2.get("temp"));
				}
				if(x2.get("visibility") instanceof Long) {
					long visibilityApp1=(long)x2.get("visibility");
					Long visibilityApp=new Long(visibilityApp1);
					double visibility=visibilityApp.doubleValue();
				    p.setVisibility(visibility);
				}
				else {
					p.setVisibility((long)x1.get("visibility"));
				}
				p.setDate((String)x1.get("dt_txt"));
				for(Object ob:a1) {
					JSONObject ob1= (JSONObject)ob;
					p.setMain((String)ob1.get("main"));
					p.setDescription((String)ob1.get("description"));
				}
				previsioni.add(p);}
				Vector<Wind>venti = new Vector<Wind>();
				for(Object o:a) {
			    JSONObject x1=(JSONObject) o;
			    JSONObject x2=(JSONObject) x1.get("wind");
				Wind v= new Wind();
				if(x2.get("speed") instanceof Long) {
					long speedApp1=(long)x2.get("speed");
					Long speedApp=new Long(speedApp1);
					double speed=speedApp.doubleValue();
				    v.setSpeed(speed);
				}
				else {
					v.setSpeed((double)x2.get("speed"));
				}
				if(x2.get("deg") instanceof Long) {
					long degApp1=(long)x2.get("deg");
					Long degApp=new Long(degApp1);
					double deg=degApp.doubleValue();
				   v.setDeg(deg);
				}
				else {
					  v.setDeg((long)x2.get("deg"));
				}
				 venti.add(v);
				}
			x.setWeather(previsioni);
			x.setWind(venti);
			return x;
			
		}
		//metodo che uso per crearmi i file con i dati durante le settimane
		public void saveDownload(String cityName) {
	    String nomeFile="previsioni"+cityName+".txt";
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
	    try {
		PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(nomeFile)));
		file.println(o.toString());
		file.close();}
	    catch(Exception e) {
		System.out.println("errore generico scrittura su file");
	}
		 
		}
	}


