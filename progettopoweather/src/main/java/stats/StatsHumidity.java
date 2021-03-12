package stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StatsHumidity extends Stats{
	public JSONArray statsHumidityDay (JSONObject vettore) {
		JSONObject o= new JSONObject();
		JSONArray arrayPronto= new JSONArray();
		String dataIniziale="2021-03-10 00:00:00";
		String data =dataIniziale.substring(0,10);
		System.out.println(data);//vedibenedate
		if(data.substring(8,9).equals(0)) {
			String dt=data.substring(beginIndex)
		}
		String dt=data.substring(8,10);
		System.out.println(dt);
		int dataNuova=Integer.parseInt(dt);
		double media=0;
		double max=0;
		double min=5000000;
		double varianza=0;
		int c=0;
		JSONArray array1=(JSONArray)o.get("previsioni");
		
		for(Object ob1:array1) {
			JSONObject ob2= new JSONObject();
		    ob2=(JSONObject)ob1;
			if(((String)ob2.get("date")).substring(8,10).equals(Integer.toString(dataNuova))) {
			if((double)ob2.get("humidity")>max )
					max=(double)ob2.get("humidity");
			if((double)ob2.get("humidity")<min)
				min=(double)ob2.get("humidity");
		    c++;
			
			}//altroif
			else {
			    JSONObject restString=(JSONObject)array1.get(c-1);
			    String dataStats=(String)restString.get("date");
			    String sub=dataStats.substring(0,10);		  
			    JSONObject res= new JSONObject();
                res.put("date",sub);
				res.put("maxHumidityGiornaliera", max);
				res.put("minHumidityGiornaliera", min);
		        arrayPronto.add(res);
				varianza=0;
		        max=0;
		        min=500000;
			    media=0;
			    String nuovo=(String)ob2.get(("date"));
			    max=(double)ob2.get("humidity");
			    min=(double)ob2.get("humidity");
			    dataNuova++;}}
			JSONObject restString=(JSONObject)array1.get(c);
			String dataStats=(String)restString.get("date");
		    String sub=dataStats.substring(0,10);	
			JSONObject res= new JSONObject();
            res.put("date",sub);
			res.put("maxHumidityGiornaliera", max);
			res.put("minHumidityGiornaliera", min);
	        arrayPronto.add(res);
		return arrayPronto;
		}


//settimana
public JSONArray statsHumidityWeek(JSONObject vettoreVisibility) {
	JSONArray vettorePronto1=statsHumidityDay(vettoreVisibility);
	JSONArray pronto= new JSONArray();
	int g=0;
	int s=0;
	 double min=0;
	 double max=0;
	 double varianza=0;
	 double media=0;
	
		for(Object o:vettorePronto1) {
			JSONObject ob= new JSONObject();
			ob=(JSONObject)o;
		if(s<3) {
		    if(g<8) {
		if((double)ob.get("max")>max)
		    	max=(double)ob.get("max");
		    if((double)ob.get("min")<min)
		    	min=(double)ob.get("min");
		    g++;}
			else {
		        JSONObject res =new JSONObject();
	            res.put("max",max);
	            res.put("min", min);
	            pronto.add(res);
	            min=0;
	            max=0;
	            varianza=0;
	            media=0;
	          
	            s++;}}
		else {
			break;
		}
	          }
		  return pronto;}
//aggiuntivafiltriduegiorni
public JSONArray statsHumidityThreeDays(JSONObject vettoreVisibility) {

	JSONArray vettorePronto1=statsHumidityDay(vettoreVisibility);
    JSONArray pronto= new JSONArray();
    int g=0;
    double min=0;
	double max=0;
	double varianza=0;
	double media=0;
	for(Object oj:vettorePronto1) {
	JSONObject obj2= new JSONObject();
    obj2=(JSONObject)oj;
    if(g<4) {
    	       g=g+1;
               if((double)obj2.get("maxHumidityGiornaliera")>=max)
	        	max=(double)obj2.get("maxHumidityGiornaliera");
	           if((double)obj2.get("minHumidityGiornaliera")<=min)
	         	min=(double)obj2.get("minHumidityGiornaliera");
	        
	    	}
    else 
               {
	    		JSONObject restit =new JSONObject();
	 			restit.put("maxHumidity3day",max);
	 			restit.put("minHumidity3day", min);
	 			pronto.add(restit);
	 			max=(double)obj2.get("maxHumidityGiornaliera");
				min=(double)obj2.get("minHumidityGiornaliera");
	 			g=1;
	    	}

}
	return pronto;
}
public JSONArray statsHumidityTwoDays(JSONObject vettoreVisibility) {

	JSONArray vettorePronto1=statsHumidityDay(vettoreVisibility);
    JSONArray pronto= new JSONArray();
    int g=0;
    double min=0;
	double max=0;
	double varianza=0;
	double media=0;
	for(Object oj:vettorePronto1) {
	JSONObject obj2= new JSONObject();
    obj2=(JSONObject)oj;
    if(g<3) {
    	       g=g+1;
               if((double)obj2.get("maxHumidityGiornaliera")>=max)
	        	max=(double)obj2.get("maxHumidityGiornaliera");
	           if((double)obj2.get("minHumidityGiornaliera")<=min)
	         	min=(double)obj2.get("minHumidityGiornaliera");
	        
	    	}
    else 
               {
	    		JSONObject restit =new JSONObject();
	 			restit.put("maxHumidity2day",max);
	 			restit.put("minHumidity2day", min);
	 			pronto.add(restit);
	 			max=(double)obj2.get("maxHumidityGiornaliera");
				min=(double)obj2.get("minHumidityGiornaliera");
	 			g=1;
	    	}

}
	return pronto;
}
}
