package c303JavaLab1;

import java.util.HashMap;
import java.util.Map;
/*
By:
Shafiq-Ur-Rehman
*/

public class _4MapNumber 
{
	public static void main(String[] args) 
	   {
		 Map<Integer, String> map = new HashMap<Integer, String>();
		 
		 map.put(1, "One");
		 map.put(2, "Two");
		 map.put(3, "Three");
		 		 
		 //find key "1"
		 int key = 1;
		 System.out.println("Key = " + key + " Value = " + (map.containsKey(key)?map.get(key):"Not Found!"));
		 
		 key = 2;
		 System.out.printf("Key = %d Value = %s\n", key, map.containsKey(key)?map.get(key):"Not Found!");
		 
		 key = 3;
		 System.out.printf("Key = %d Value = %s\n", key, map.containsKey(key)?map.get(key):"Not Found!");
		 
		 key = 4;
		 System.out.printf("Key = %d Value = %s\n", key, map.containsKey(key)?map.get(key):"Not Found!");

	   }
}
