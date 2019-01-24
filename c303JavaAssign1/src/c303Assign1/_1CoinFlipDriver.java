package c303Assign1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*Group#3 members:
Shafiq-Ur-Rehman
Sahil Mahajan
Atul Sharma
Nirojan Jeyandhran
*/

public class _1CoinFlipDriver 
{
		public static void main(String[] args) 
		{
			//arrange 5 threads
			ExecutorService tasks = Executors.newFixedThreadPool(5);
			
			//run 5 threads
			tasks.execute(new _1CoinFlip());//Thread #1
			tasks.execute(new _1CoinFlip());//2
			tasks.execute(new _1CoinFlip());//3
			tasks.execute(new _1CoinFlip());//4
			tasks.execute(new _1CoinFlip());//5
			
			//terminate threads
			tasks.shutdown();
		}
}
