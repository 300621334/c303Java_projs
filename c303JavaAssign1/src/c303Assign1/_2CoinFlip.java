package c303Assign1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*Group#3 members:
Shafiq-Ur-Rehman
Sahil Mahajan
Atul Sharma
Nirojan Jeyandhran
*/

public class _2CoinFlip implements Runnable
{
	//constructor will create 5 threads
	public _2CoinFlip()
	{
		//arrange 5 threads
		ExecutorService tasks = Executors.newFixedThreadPool(5);
		
		//execute 5 threads inside constructor
		for (int i = 0; i < 5; i++) 
		{
			tasks.execute(this);
		}
		tasks.shutdown();
	}

	@Override
	public void run() 
	{
		int consecutiveHeads = 0;
		int head_0_tail_1 = 0;
		Random random = new Random();
		
		//1000 coin flips
		for (int i = 0; i < 1000; i++) 
		{
			//generate HEAD=0 or TAIL=1 randomly
			head_0_tail_1 = random.nextInt(2);
			
			//check if HEADs come in a row
			if (head_0_tail_1 == 0)//head 
			{
				consecutiveHeads++;//if consecutive heads, keep adding
			} else//tail 
			{
				consecutiveHeads = 0;//if no consecutive heads, make it zero
			}
			if (consecutiveHeads >= 3)
				System.out.printf("%s receives %d consecutive HEADs\n", Thread.currentThread().getName(),
						consecutiveHeads);
		}		
	}
	
	
}
