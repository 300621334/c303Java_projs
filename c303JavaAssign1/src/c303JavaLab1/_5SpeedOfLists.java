package c303JavaLab1;

import java.util.ArrayList;
import java.util.LinkedList;
/*
By:
Shafiq-Ur-Rehman
*/

public class _5SpeedOfLists 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		//populate lists
		for (int i = 0; i < 100; i++)
		{
			arrayList.add(1);
			linkedList.add(1);
		}
		
		//
		long startTime, deltaTime;
		//calculate time taken to find middle element for ArrayList
		startTime = System.nanoTime();
		arrayList.get(50);//look for middle element
		deltaTime = System.nanoTime() - startTime;
		System.out.println("Delta for ArrayList is: " + deltaTime);
		
		//calculate time taken to find middle element for LinkedList
		startTime = System.nanoTime();
		linkedList.get(50);
		deltaTime = System.nanoTime() - startTime;
		System.out.println("Delta for LinkedList is: " + deltaTime);
	}
}
