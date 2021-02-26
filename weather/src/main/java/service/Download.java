package service;
import model.*;
import model.Wind;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Download{
	String apiKey="91f3a6c712ed1b7232015700aecf9b80";
	//metodo per salvare la chiamata
	public JSONObject downloadDati(String cityName) {
		JSONObject stats=null;
		JSONParser parser= new JSONParser();
    try {
    	String url="http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid="+apiKey;
    	URL oracle = new URL(url);
		HttpsURLConnection yc=(HttpsURLConnection)oracle.openConnection();
		yc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1;WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		BufferedReader in= new BufferedReader( new InputStreamReader(yc.getInputStream()));
		String input;
		while((input=in.readLine())!=null) {
			 stats=(JSONObject) parser.parse(input);
		}
		in.close();
}
catch(Exception e) {
	System.out.println("errore generico");
}
    return stats;

}
	//metodo per salvare info città specificata
	public Città downloadCity(String cityName) {
		JSONObject chiamata= downloadDati(cityName);
		JSONObject city=(JSONObject)chiamata.get("city");
		JSONObject coord=(JSONObject)city.get("coord");
		Città x= new Città();
		x.setCountry((String)city.get("country"));
		x.setName((String)city.get("name"));
		x.setLat((double)coord.get("lat"));
		x.setLon((double)coord.get("lon"));
		return x;
		
		
		
	}
	//metodo per salvare venti
	public <Wind>Vector downloadWind(String cityName) {
		
		JSONObject chiamata=downloadDati(cityName);
		JSONArray a=(JSONArray)chiamata.get("list");
		Vector<Wind>venti = new Vector<Wind>();
		for(Object o:a) {
		JSONObject x=(JSONObject) o;
		Wind v= new Wind();
		v.setSpeed((double)xx.get("speed"));
		v.setDeg((double)xx.get("deg"));
		venti.add(v);
		
		
	}
		return venti; }
	//metodo per salvare previsioni
	public Vector<Weather> downloadWeather(String cityName){
		JSONObject chiamata=downloadDati(cityName);
		JSONArray a =(JSONArray)chiamata.get("list");
		Vector<Weather> previsioni = new Vector<Weather>();
		for(Object o:a) {
			JSONObject x=(JSONObject) o;
			JSONArray a1=(JSONArray)x.get("weather");
			JSONObject x2=(JSONObject)x.get("main");
			Weather p= new Weather();
			p.setPressure((double)x2.get("pressure"));
			p.setHumidity((double)x2.get("pressure"));
			p.setMin((double)x2.get("temp_min"));
			p.setMax((double)x2.get("temp_max"));
			for(Object ob:a1) {
				p.setDescription("main");
				p.setDescription("description");
			}
			previsioni.add(p);
			
		}
		
		return previsioni;
		
	}
	public void downloadOra(String cityName) {
		String path = System.getProperty("user.dir") + "/" + cityName + "Ore.txt";
		File fileDati=new File(path);
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable() {
			 public void run() {
			    	
			    	JSONArray prev = new JSONArray();
			    	//prev = downloadDati(cityName);
			    	
			    //prevsionimeteoattuali	nowJSONObject actualvisibility = new JSONObject();
			    	//actualvisibility = visibility.getJSONObject(0);

			    			try{
			    			    if(!fileDati.exists()) {
			    			        fileDati.createNewFile();
			    			    }

			    			    FileWriter fileWriter = new FileWriter(fileDati, true);
			    				
			    				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			    			    bufferedWriter.write(now.toString());
			    			    bufferedWriter.write("\n");
			    			    
			    			    bufferedWriter.close();
			    			    
			    			} catch(Exception e) {
			    			    System.out.println(e);
			    			}
			    	
			    }
			}, 0, 3, TimeUnit.HOURS);
	}
	

}
