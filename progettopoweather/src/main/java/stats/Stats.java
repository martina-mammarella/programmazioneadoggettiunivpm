package stats;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Stats {
public JSONArray ordinamentoStats(JSONArray vettoreDaOrdinare,String tipo,String periodo) {
	JSONArray ordinato= new JSONArray();
	 int max=0;
	 switch(periodo) {
	 case"giornaliera":{
		 for(int k=0;k<vettoreDaOrdinare.size();k++) {
			 JSONObject ob= new JSONObject();
			 ob=(JSONObject)vettoreDaOrdinare.get(k);
			 double primo=(double)ob.get("maxHumidityGiornaliera");
			 for(int count=1;count<vettoreDaOrdinare.size();count++) {
				  {
					  double secondo=(double)ob.get("maxHumidityGiornaliera");
					  if(primo>secondo) {
						 max=count;
					  }
				 }
			 }
			 ordinato.add(vettoreDaOrdinare.get(max));

		 }
	 }
	 case"duegiorni":{
		 for(int k=0;k<vettoreDaOrdinare.size();k++) {
			 JSONObject ob= new JSONObject();
			 ob=(JSONObject)vettoreDaOrdinare.get(k);
			 double primo=(double)ob.get("maxHumidity2day");
			 for(int count=1;count<vettoreDaOrdinare.size();count++) {
				  {
					  double secondo=(double)ob.get("maxHumidity2day");
					  if(primo>secondo) {
						 max=count;
					  }
				 }
			 }
			 ordinato.add(vettoreDaOrdinare.get(max));
	 }
	 }
	 case"tregiorni":{
		 for(int k=0;k<vettoreDaOrdinare.size();k++) {
			 JSONObject ob= new JSONObject();
			 ob=(JSONObject)vettoreDaOrdinare.get(k);
			 double primo=(double)ob.get("maxHumidity3day");
			 for(int count=1;count<vettoreDaOrdinare.size();count++) {
				  {
					  double secondo=(double)ob.get("maxHumidity3day");
					  if(primo>secondo) {
						 max=count;
					  }
				 }
			 }
			 ordinato.add(vettoreDaOrdinare.get(max));
	 }
	 }
	 case"settimanale":{
		 for(int k=0;k<vettoreDaOrdinare.size();k++) {
			 JSONObject ob= new JSONObject();
			 ob=(JSONObject)vettoreDaOrdinare.get(k);
			 double primo=(double)ob.get("maxHumidityweek");
			 max=primo;
			 for(int count=1;count<vettoreDaOrdinare.size();count++) {
				  {
					  double secondo=(double)ob.get("maxHumidity1week");
					  if(primo>secondo) {
						 max=count;
					  }
				 }
			 }
			 ordinato.add(vettoreDaOrdinare.get(max));
	 }
	 }
	 case"duesettimane":{
		 for(int k=0;k<vettoreDaOrdinare.size();k++) {
			 JSONObject ob= new JSONObject();
			 ob=(JSONObject)vettoreDaOrdinare.get(k);
			 double primo=(double)ob.get("maxHumidity2week");
			 for(int count=1;count<vettoreDaOrdinare.size();count++) {
				  {
					  double secondo=(double)ob.get("maxHumidity2week");
					  if(primo>secondo) {
						 max=count;
					  }
				 }
			 }
			 ordinato.add(vettoreDaOrdinare.get(max));
	 }
	 }
		 
	 }
	 return ordinato;
}
	 
}