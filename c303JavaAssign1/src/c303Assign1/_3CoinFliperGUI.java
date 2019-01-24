package c303Assign1;

import java.util.Random;

import javax.swing.JLabel;
/*Group#3 members:
Shafiq-Ur-Rehman
Sahil Mahajan
Atul Sharma
Nirojan Jeyandhran
*/

public class _3CoinFliperGUI implements Runnable 
{
	private JLabel label;
	int taskNumber;

	public _3CoinFliperGUI(JLabel label, int taskNumber) 
	{
		this.label = label;
		this.taskNumber = taskNumber;
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
				consecutiveHeads++;//count all the HEADs
			} 
			label.setText(String.format("Task #%d has %4d HEADs", taskNumber, consecutiveHeads));
		}
	}

}
