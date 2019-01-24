package c303Assign1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*Group#3 members:
Shafiq-Ur-Rehman
Sahil Mahajan
Atul Sharma
Nirojan Jeyandhran
*/

public class _2CoinFlipDriver
{
	public static void main(String[] args) 
	{
		//only 1 object created this time, instead of 5
		//Constructor will take care of thread generation
		new _2CoinFlip();
	}
}
