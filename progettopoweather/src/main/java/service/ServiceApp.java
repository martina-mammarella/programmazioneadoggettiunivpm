package service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
	public interface ServiceApp {
		public JSONObject  getDatiAttuali(String cityName);
		public JSONObject  getPrevisioni(String cityName);
		public JSONObject  getDatiStorici(String cityName);
		public JSONArray   getFilters(JSONObject filtro);
		public JSONArray  getStats(JSONObject vettore,String periodo);
		//stats
		//filtri

	}

