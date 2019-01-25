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
			//arrange 10 threads - about twice as many as tasks
			ExecutorService tasks = Executors.newFixedThreadPool(10);
			
			//run 5 threads - remaining 5  threads are there bcoz run() fn of ea exe in its own thread 
			tasks.execute(new _1CoinFlip());//Thread #1
			tasks.execute(new _1CoinFlip());//2
			tasks.execute(new _1CoinFlip());//3
			tasks.execute(new _1CoinFlip());//4
			tasks.execute(new _1CoinFlip());//5
			
			//stop accepting any more tasks
			tasks.shutdown();
		}
}
