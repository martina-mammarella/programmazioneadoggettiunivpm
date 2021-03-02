package service;
import model.Wind;
import model.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Download{
	String apiKey="91f3a6c712ed1b7232015700aecf9b80";
	//metodo per salvare la chiamata
	public Città download(String cityName) {
		JSONObject chiamata=null;
		JSONParser parser= new JSONParser();
		try {
			String apikey="91f3a6c712ed1b7232015700aecf9b80";
		    String url= "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid="+apikey;
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
			p.setPressure((double)x2.get("pressure"));
			p.setHumidity((double)x2.get("pressure"));
			p.setMin((double)x2.get("temp_min"));
			p.setMax((double)x2.get("temp_max"));
			for(Object ob:a1) {
				JSONObject ob1= (JSONObject)ob;
				p.setDescription((String)ob1.get("main"));
				p.setDescription((String)ob1.get("description"));
			}
			previsioni.add(p);}
			Vector<Wind>venti = new Vector<Wind>();
			for(Object o:a) {
		    JSONObject x1=(JSONObject) o;
		    JSONObject x2=(JSONObject) x1.get("wind");
			Wind v= new Wind();
			v.setSpeed((double)x2.get("speed"));
		    v.setDeg((double)x2.get("deg"));
		    venti.add(v);
			}
		x.setWeather(previsioni);
		x.setWind(venti);
		return x;
		
	}
	public void saveDownload(String cityName) {
    String nomeFile="previsioni"+cityName+".txt";
    Download x= new Download();
	Città c=x.download(cityName);
    JSONObject o=new JSONObject();
    o.put("nome",c.getName());
    o.put("lat", c.getLat());
    o.put("lon", c.getLon());
    o.put("country",c.getCountry());
    JSONArray array= new JSONArray();
    int count=0;
    for(Object ob:array) {
    	JSONObject elem=(JSONObject) ob;
    	elem.put("temperature",c.getWeather().get(count).getTemperature());
    	elem.put("main",c.getWeather().get(count).getMain());
    	elem.put("description",c.getWeather().get(count).getDescription());
    	elem.put("min",c.getWeather().get(count).getMin());
    	elem.put("max",c.getWeather().get(count).getMax());
    	elem.put("humidity",c.getWeather().get(count).getHumidity());
    	elem.put("pressure",c.getWeather().get(count).getPressure());
    	elem.put("visibility", c.getWeather().get(count).getPressure());
    	elem.put("date", c.getWeather().get(count).getPressure());
    	count++;
    }
    count=0;
    o.put("previsioni", array);
    JSONArray array1=new JSONArray();
    for(Object ob:array1) {
    	JSONObject elem=(JSONObject) ob;
    	elem.put("speed", c.getWind().get(count).getSpeed());
    	elem.put("deg",c.getWind().get(count).getDeg());
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

	