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
		
		event.put("title", "All Day Event");
		event.put("start", "2023-07-01");
		gsonString = gson.toJson(event,gsonType);
		events.append(gsonString);        
		events.append(",");        
		event.clear();
		
		event.put("title", "Long Event");
		event.put("start", "2023-07-07");
		event.put("end", "2023-07-10");
		gsonString = gson.toJson(event,gsonType);
		events.append(gsonString);          
		events.append(",");         
		event.clear();
		
		event.put("title", "Click for Github");
		event.put("url", "https://github.com/augustocesarsousa");
		event.put("start", "2023-07-28");
		gsonString = gson.toJson(event,gsonType);
		events.append(gsonString);        
		event.clear();
		
		events.append("]");
		
		return events.toString();
	}
}
