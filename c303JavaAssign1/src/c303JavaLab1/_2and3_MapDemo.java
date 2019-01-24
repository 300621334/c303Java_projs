package c303JavaLab1;

import java.util.HashMap;
import java.util.Map;
/*
By:
Shafiq-Ur-Rehman
*/

public class _2and3_MapDemo
{
   public static void main(String[] args) 
   {
	 Map<String, String> map = new HashMap<String, String>();
	 
	 map.put("a1234", "Steve Jobs");
	 map.put("a1235", "Scott McNealy");
	 map.put("a1236", "Jeff Bezos");
	 map.put("a1237", "Larry Ellison");
	 map.put("a1238", "Bill Gates");
	 
	 //find key "a1234"
	 System.out.println("Finding a value mapped to a valid key:");
	 String key = "a1234";//a valid key
	 System.out.println("Value for the key \"" + key + "\" is: " + (map.containsKey(key)?map.get(key):"Not Found!"));
	 
	 //try an invalid key
	 System.out.println("\nNow attempting to find a value with an invalid key:");
	 key = "a0000";//an invalid key
	 System.out.printf("Value mapped to the key \"%s\" is %s\n\n", key, map.containsKey(key)?map.get(key):"Not Found!");
	 
	 //find key "A1234"
	 System.out.println("Use capital 'A' in key:");
	 key = "A1234";//a valid key
	 System.out.println("Value for the key \"" + key + "\" is: " + (map.containsKey(key.toLowerCase())?map.get(key.toLowerCase()):"Not Found!"));
   }
}


