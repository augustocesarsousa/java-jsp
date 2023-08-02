package factories;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public abstract class EventFactory {
	
	public static String createEvents(){
		StringBuilder events = new StringBuilder();
		Map<String,String> event = new HashMap<>();
		
		Gson gson = new Gson();
        Type gsonType = new TypeToken<HashMap>(){}.getType();
        String gsonString;
        
		events.append("[");
		
		event.put("start", "2023-08-01");
		event.put("title", "All Day Event");
		gsonString = gson.toJson(event,gsonType);
		events.append(gsonString);        
		events.append(",");        
		event.clear();
		
		event.put("end", "2023-08-10");
		event.put("start", "2023-08-07");
		event.put("title", "Long Event");
		gsonString = gson.toJson(event,gsonType);
		events.append(gsonString);          
		events.append(",");         
		event.clear();
		
		event.put("start", "2023-08-28");
		event.put("url", "https://github.com/augustocesarsousa");
		event.put("title", "Click for Github");
		gsonString = gson.toJson(event,gsonType);
		events.append(gsonString);        
		event.clear();
		
		events.append("]");
		
		return events.toString();
	}
}
