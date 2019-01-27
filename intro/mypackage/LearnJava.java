package mypackage;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Timer;//not //import com.sun.glass.ui.Timer;
import java.util.TimerTask;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.print.PrintService;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthScrollBarUI;

import jdk.internal.dynalink.beans.StaticClass;

public class LearnJava
{
	//ma ctrl_space >> select main-method
	public static void main(String[] args) 
	{
		
		


/*
		//Sorting with natural order
		List<String> l1 = Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
		l1.sort(null);
		l1.forEach(System.out::println);
		//Sorting with comparison using lamba
		List<String> l2 = new ArrayList<String>();
		l2.addAll(Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X"));//bulk op=addAll
		l2.sort((s1,s2)->s1.compareToIgnoreCase(s2));
		l2.forEach(System.out::println);
		//same as above but w method reference
		List<String> l3 = Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
		l3.sort(String::compareToIgnoreCase);
		l3.forEach(System.out::println);
		//reverse & sort w Collections
		Collections.reverse(l3);
		l3.forEach(System.out::println);
		Collections.sort(l3);//Caps 1st then small letters. To ignore case, use a 2nd arg Comparator (see below)
		l3.forEach(System.out::println);
		Collections.sort(l3, (s1,s2)->s1.compareToIgnoreCase(s2));//returns -1,0,1 if lt,eq,gt resp
		l3.forEach(System.out::println);
		//remove ele on condition
		//NOTE: Certain implementations of List don't support any structural modification (i.e. removing or adding elements) e.g. List returned by Arrays.asList() Returns a fixed-size list
		List<String> l4 = new ArrayList<String>(l3);//make a copy that IS modifiable
		//or//l4.addAll(Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X"));//l4 = Arrays.asList(...); ERROR bcoz cannot .add() or .remove() fixed-size list
		l4.removeIf(s->s.toLowerCase().contains("i"));
		l4.forEach(System.out::println);
*/


		
/*
			Timer timer = new Timer();
		Testing outerClass=new Testing();//init outer class
		MyTimerTask timersTask = outerClass.new MyTimerTask();//inner class only init when qualified w outer's obj
		timer.schedule(timersTask, 1000, 2000);//1st 1sec then ev 2 sec

		//3 init at a time
//		for (int i = 0; i < 3; i++) {
//			timer.schedule(outerClass.new MyTimerTask(), 1000, 2000);
//
//		}
		
		}
	//inner class can be init only when qualified w outer class instance	
	class MyTimerTask extends TimerTask{
				int count = 1;
				@Override
				public void run() {
					System.out.printf("task Done %d times\n", count++);				
	}
*/
		
/*
			System.out.printf("%s\n%s\n%s\n%s\n",
				System.getProperty("path.separator")//PrintService ';' 
				,System.getProperty("line.separator")
				,System.getProperty("user.dir")
				,System.getProperty("user.home")
				);
*/
		
/*
	String s1 = null;
		Optional<String> mayBeStr = Optional.ofNullable(s1);
		System.out.println( mayBeStr.map(String::length).orElse(-1) );//-1
		//
		s1 = "Hello";
		mayBeStr = Optional.ofNullable(s1);
		System.out.println( mayBeStr.map(String::length).orElse(-1) );//-1
		//
		System.out.println( mayBeStr.map(String::length).orElseGet(()->"Hello".length()) );//5
*/
			
/*
	//http://www.vogella.com/tutorials/JavaIntroduction/article.html#streams
		List<String> aList = Arrays.asList("aaa", "aaa", "bbb", "apple", "bulb");
		String aStr = aList.stream().filter(s->s.contains("a"))//filter takes a Predicate=returns bool
		.map(s->s.toUpperCase())//map takes a fn w returns sth
		.reduce("", (a,b)->a+" "+b);//takes init value of 'b' as "" & then accumulator
		System.out.println(aStr);
		//
		aList.stream().filter(s->s.contains("a"))
		.distinct()
		.collect(Collectors.toList())
		.forEach(System.out::println);
		//
		System.out.println("Joining w delimiter: " +
		aList.stream().filter(s->s.contains("a"))
		.distinct()
		.collect(Collectors.joining(" - "))
		);
*/

/*//http://www.vogella.com/tutorials/JavaIntroduction/article.html#lambdas_methodreferences	
		List<Integer> aList = new  ArrayList<Integer>();
		IntStream.range(1,  101).forEach(aList::add);//(s -> aList.ad(s))
		aList.forEach(System.out::println);
		System.out.println("Size of list is: " + aList.size());
		

		List<String> bList = Arrays.asList("aaa", "bbb");
		//bList.forEach(s -> System.out.println(s));
		bList.forEach(System.out::println);
*/
		
		
/*
		//Scanner input = new Scanner(System.in);
	
		//JOptionPane.showMessageDialog(null, "ddsd");
//		String x = JOptionPane.showInputDialog("enter name: ");
//		float y = Float.parseFloat(x);
//		JOptionPane.showMessageDialog(null, y>9?"more than 9":"less than 10");
		
		int c = 1;
		Scanner input = new Scanner(System.in); 
		
		boolean hasNext = false;
		
		do
		{

			hasNext = input.hasNext();
			System.out.println(input.next());
		//int x = input.nextInt();	
			//c++;
			
			//throw new IllegalArgumentException();
		}
		while(hasNext);
		// Creating an empty HashMap 
		
       
	Map<Integer, String> hash_map = new HashMap<Integer, String>();
		// Mapping string values to int keys 
        hash_map.put(20, "Geeks");
		hash_map.put(15, "4");
		hash_map.put(20, "Geeks");
		hash_map.put(25, "Welcomes");
		hash_map.put(30, "You");
		// Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map);
		// Using entrySet() to get the set view 
        System.out.println("The set is: " + hash_map.entrySet());
*/
	}

}
