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
		Weather m= new Weather();
		JSONArray meteoAttuale=(JSONArray)chiamata.get("weather");
		for(Object o:meteoAttuale) {
			JSONObject ob=(JSONObject)o;
			m.setMain((String)ob.get("main"));
			m.setDescription((String)ob.get("description"));
		}
		JSONObject main=(JSONObject)chiamata.get("main");
		m.setMin((double)main.get("temp_min"));
		m.setMax((double)main.get("temp_max"));
		m.setTemperature((double)main.get("temp"));
		m.setPressure((long)main.get("pressure"));
		m.setHumidity((long)main.get("humidity"));
		m.setVisibility((long)chiamata.get("visibility"));
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
		v.setDeg((long)vento.get("deg"));
		v.setSpeed((double)vento.get("speed"));
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
		x.setLat((double)coord.get("lat"));
		x.setLon((double)coord.get("lon"));
		JSONArray a =(JSONArray)chiamata.get("list");
		Vector<Weather> previsioni = new Vector<Weather>();
		for(Object o:a) {
			JSONObject x1=(JSONObject) o;
			JSONArray a1=(JSONArray)x1.get("weather");
			JSONObject x2=(JSONObject)x1.get("main");
			Weather p= new Weather();
			p.setPressure((long)x2.get("pressure"));
			p.setHumidity((long)x2.get("humidity"));
			p.setMin((double)x2.get("temp_min"));
			p.setMax((double)x2.get("temp_max"));
			p.setTemperature((double)x2.get("temp"));
			p.setVisibility((long)x1.get("visibility"));
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
			v.setSpeed((double)x2.get("speed"));
		    v.setDeg((long)x2.get("deg"));
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



