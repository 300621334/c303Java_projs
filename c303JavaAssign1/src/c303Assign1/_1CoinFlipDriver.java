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
			//arrange 10 threads - about twice as many as tasks bcoz 5 tasks need 5 threads & then run() fn is assigned a new thread eac
			/* ExecutorService interface extends (not implements) Executor interface << Executors implements ExecutorService interface:
			 * Using "Executor" to create threads rather than doing new Thread myself
			 * has advantage that Executor assigns Runnable obj to one of available threads
			 * from pool or creates a new thread if none available in pool*/			
			
			ExecutorService tasks = Executors.newFixedThreadPool(10);
			
			//run 5 threads - remaining 5  threads are there bcoz run() fn of ea exe in its own thread
			//Method execute returns immediately from each invocation—the program does not wait for each PrintTask to finish
			//execute() fires run() fn of runnable obj in a separate thread
			//this order of exe is NOT guranteed e.g. task2 could run BEFORE task1
			tasks.execute(new _1CoinFlip());//Thread #1
			tasks.execute(new _1CoinFlip());//2
			tasks.execute(new _1CoinFlip());//3
			tasks.execute(new _1CoinFlip());//4
			tasks.execute(new _1CoinFlip());//5
			
			//shutdown notifies the ExecutorService to stop accepting new tasks, but continues executing tasks that have already been submitted
			tasks.shutdown();
			
			/*main-thread ends aft passing all tasks to bg. Now ExecutorService can run tasks in either of 3 threads:
			(1) this very thread i.e. "main-thread" that called .execute()... if main-thread has terminated by the time a task is about to start (e.g. if runnable was in waiting state => Thread.sleep())
			(2) one of the threads from the pool
			(3) if none of above available, ExecutorService will make a new thread to run task*/
		}
}
